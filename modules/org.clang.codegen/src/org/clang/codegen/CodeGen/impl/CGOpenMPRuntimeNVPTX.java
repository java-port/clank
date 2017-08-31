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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.h", line = 26,
 FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTXE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTXE")
//</editor-fold>
public class CGOpenMPRuntimeNVPTX extends /*public*/ CGOpenMPRuntime implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::EntryFunctionState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.h", line = 28,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::EntryFunctionState", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18EntryFunctionStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18EntryFunctionStateE")
  //</editor-fold>
  public static class EntryFunctionState {
  /*public:*/
    public BasicBlock /*P*/ ExitBB;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::EntryFunctionState::EntryFunctionState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.h", line = 32,
     FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::EntryFunctionState::EntryFunctionState", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18EntryFunctionStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18EntryFunctionStateC1Ev")
    //</editor-fold>
    public EntryFunctionState() {
      // : ExitBB(null) 
      //START JInit
      this.ExitBB = null;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "ExitBB=" + ExitBB; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::WorkerFunctionState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.h", line = 35,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::WorkerFunctionState", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX19WorkerFunctionStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX19WorkerFunctionStateE")
  //</editor-fold>
  public static class WorkerFunctionState {
  /*public:*/
    public Function /*P*/ WorkerFn;
    public /*const*/ CGFunctionInfo /*P*/ CGFI;
    
    // namespace
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::WorkerFunctionState::WorkerFunctionState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 93,
     FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::WorkerFunctionState::WorkerFunctionState", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX19WorkerFunctionStateC1ERNS0_13CodeGenModuleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX19WorkerFunctionStateC1ERNS0_13CodeGenModuleE")
    //</editor-fold>
    public WorkerFunctionState(final CodeGenModule /*&*/ CGM) {
      // : WorkerFn(null), CGFI(null) 
      //START JInit
      this.WorkerFn = null;
      this.CGFI = null;
      //END JInit
      createWorkerFunction(CGM);
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::WorkerFunctionState::createWorkerFunction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 99,
     FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::WorkerFunctionState::createWorkerFunction", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX19WorkerFunctionState20createWorkerFunctionERNS0_13CodeGenModuleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX19WorkerFunctionState20createWorkerFunctionERNS0_13CodeGenModuleE")
    //</editor-fold>
    private void createWorkerFunction(final CodeGenModule /*&*/ CGM) {
      // Create an worker function with no arguments.
      CGFI = $AddrOf(CGM.getTypes().arrangeNullaryFunction());
      
      WorkerFn = Function.Create(CGM.getTypes().GetFunctionType($Deref(CGFI)), GlobalValue.LinkageTypes.InternalLinkage, 
          /* placeholder */ new Twine(/*KEEP_STR*/"_worker"), $AddrOf(CGM.getModule()));
      CGM.SetInternalFunctionAttributes(/*D=*/ (/*const*/ Decl /*P*/ )null, WorkerFn, $Deref(CGFI));
      WorkerFn.setLinkage(GlobalValue.LinkageTypes.InternalLinkage);
      WorkerFn.addFnAttr(Attribute.AttrKind.NoInline);
    }

    
    @Override public String toString() {
      return "" + "WorkerFn=" + WorkerFn // NOI18N
                + ", CGFI=" + CGFI; // NOI18N
    }
  };
  
  /// \brief Helper for target entry function. Guide the master and worker
  /// threads to their respective locations.
  
  // Setup NVPTX threads for master-worker OpenMP scheme.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitEntryHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 203,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitEntryHeader", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX15emitEntryHeaderERNS0_15CodeGenFunctionERNS1_18EntryFunctionStateERNS1_19WorkerFunctionStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX15emitEntryHeaderERNS0_15CodeGenFunctionERNS1_18EntryFunctionStateERNS1_19WorkerFunctionStateE")
  //</editor-fold>
  public void emitEntryHeader(final CodeGenFunction /*&*/ CGF, 
                 final EntryFunctionState /*&*/ EST, 
                 final WorkerFunctionState /*&*/ WST) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    
    // Get the master thread id.
    Value /*P*/ MasterID = getMasterThreadID(CGF);
    // Current thread's identifier.
    Value /*P*/ ThreadID = getNVPTXThreadID(CGF);
    
    // Setup BBs in entry function.
    BasicBlock /*P*/ WorkerCheckBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".check.for.worker"));
    BasicBlock /*P*/ WorkerBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".worker"));
    BasicBlock /*P*/ MasterBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".master"));
    EST.ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".exit"));
    
    // The head (master thread) marches on while its body of companion threads in
    // the warp go to sleep.
    Value /*P*/ ShouldDie = Bld.CreateICmpUGT(ThreadID, MasterID, new Twine(/*KEEP_STR*/"excess_in_master_warp"));
    Bld.CreateCondBr(ShouldDie, EST.ExitBB, WorkerCheckBB);
    
    // Select worker threads...
    CGF.EmitBlock(WorkerCheckBB);
    Value /*P*/ IsWorker = Bld.CreateICmpULT(ThreadID, MasterID, new Twine(/*KEEP_STR*/"is_worker"));
    Bld.CreateCondBr(IsWorker, WorkerBB, MasterBB);
    
    // ... and send to worker loop, awaiting parallel invocation.
    CGF.EmitBlock(WorkerBB);
    CGF.EmitCallOrInvoke(WST.WorkerFn, new ArrayRef<Value /*P*/ >(llvm.None, true));
    CGF.EmitBranch(EST.ExitBB);
    
    // Only master thread executes subsequent serial code.
    CGF.EmitBlock(MasterBB);
    
    // First action in sequential region:
    // Initialize the state of the OpenMP runtime library on the GPU.
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {Bld.getInt32(/*OmpHandle=*/ 0), getNVPTXThreadID(CGF)};
    CGF.EmitRuntimeCall(createNVPTXRuntimeFunction(OpenMPRTLFunctionNVPTX.OMPRTL_NVPTX__kmpc_kernel_init.getValue()), 
        new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Signal termination of OMP execution.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitEntryFooter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 245,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitEntryFooter", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX15emitEntryFooterERNS0_15CodeGenFunctionERNS1_18EntryFunctionStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX15emitEntryFooterERNS0_15CodeGenFunctionERNS1_18EntryFunctionStateE")
  //</editor-fold>
  public void emitEntryFooter(final CodeGenFunction /*&*/ CGF, 
                 final EntryFunctionState /*&*/ EST) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    BasicBlock /*P*/ TerminateBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".termination.notifier"));
    CGF.EmitBranch(TerminateBB);
    
    CGF.EmitBlock(TerminateBB);
    // Signal termination condition.
    Bld.CreateAlignedStore(Constant.getNullValue(WorkID.getType().getElementType()), WorkID, 
        WorkID.getAlignment());
    // Barrier to terminate worker threads.
    syncCTAThreads(CGF);
    // Master thread jumps to exit point.
    CGF.EmitBranch(EST.ExitBB);
    
    CGF.EmitBlock(EST.ExitBB);
  }

/*private:*/
  //
  // NVPTX calls.
  //
  
  /// \brief Get the GPU warp size.
  
  /// \brief Get the GPU warp size.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXWarpSize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 24,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXWarpSize", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX16getNVPTXWarpSizeERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX16getNVPTXWarpSizeERNS0_15CodeGenFunctionE")
  //</editor-fold>
  private Value /*P*/ getNVPTXWarpSize(final CodeGenFunction /*&*/ CGF) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    return Bld.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(getDeclaration(/*AddrOf*/CGM.getModule(), ID.nvvm_read_ptx_sreg_warpsize), 
        new ArrayRef<Value /*P*/ >(llvm.None, true), new Twine(/*KEEP_STR*/"nvptx_warp_size"));
  }

  
  /// \brief Get the id of the current thread on the GPU.
  
  /// \brief Get the id of the current thread on the GPU.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXThreadID">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 33,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXThreadID", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX16getNVPTXThreadIDERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX16getNVPTXThreadIDERNS0_15CodeGenFunctionE")
  //</editor-fold>
  private Value /*P*/ getNVPTXThreadID(final CodeGenFunction /*&*/ CGF) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    return Bld.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(getDeclaration(/*AddrOf*/CGM.getModule(), ID.nvvm_read_ptx_sreg_tid_x), 
        new ArrayRef<Value /*P*/ >(llvm.None, true), new Twine(/*KEEP_STR*/"nvptx_tid"));
  }

  
  // \brief Get the maximum number of threads in a block of the GPU.
  
  // \brief Get the maximum number of threads in a block of the GPU.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXNumThreads">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 42,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXNumThreads", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18getNVPTXNumThreadsERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18getNVPTXNumThreadsERNS0_15CodeGenFunctionE")
  //</editor-fold>
  private Value /*P*/ getNVPTXNumThreads(final CodeGenFunction /*&*/ CGF) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    return Bld.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(getDeclaration(/*AddrOf*/CGM.getModule(), ID.nvvm_read_ptx_sreg_ntid_x), 
        new ArrayRef<Value /*P*/ >(llvm.None, true), new Twine(/*KEEP_STR*/"nvptx_num_threads"));
  }

  
  /// \brief Get barrier to synchronize all threads in a block.
  
  /// \brief Get barrier to synchronize all threads in a block.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXCTABarrier">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 51,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::getNVPTXCTABarrier", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18getNVPTXCTABarrierERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18getNVPTXCTABarrierERNS0_15CodeGenFunctionE")
  //</editor-fold>
  private void getNVPTXCTABarrier(final CodeGenFunction /*&*/ CGF) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    Bld.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(getDeclaration(/*AddrOf*/CGM.getModule(), ID.nvvm_barrier0));
  }

  
  // \brief Synchronize all GPU threads in a block.
  
  // \brief Synchronize all GPU threads in a block.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::syncCTAThreads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 58,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::syncCTAThreads", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX14syncCTAThreadsERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX14syncCTAThreadsERNS0_15CodeGenFunctionE")
  //</editor-fold>
  private void syncCTAThreads(final CodeGenFunction /*&*/ CGF) {
    getNVPTXCTABarrier(CGF);
  }

  
  //
  // OMP calls.
  //
  
  /// \brief Get the thread id of the OMP master thread.
  /// The master thread id is the first thread (lane) of the last warp in the
  /// GPU block.  Warp size is assumed to be some power of 2.
  /// Thread id is 0 indexed.
  /// E.g: If NumThreads is 33, master id is 32.
  ///      If NumThreads is 64, master id is 32.
  ///      If NumThreads is 1024, master id is 992.
  
  /// \brief Get the thread id of the OMP master thread.
  /// The master thread id is the first thread (lane) of the last warp in the
  /// GPU block.  Warp size is assumed to be some power of 2.
  /// Thread id is 0 indexed.
  /// E.g: If NumThreads is 33, master id is 32.
  ///      If NumThreads is 64, master id is 32.
  ///      If NumThreads is 1024, master id is 992.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::getMasterThreadID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 69,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::getMasterThreadID", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX17getMasterThreadIDERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX17getMasterThreadIDERNS0_15CodeGenFunctionE")
  //</editor-fold>
  private Value /*P*/ getMasterThreadID(final CodeGenFunction /*&*/ CGF) {
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    Value /*P*/ NumThreads = getNVPTXNumThreads(CGF);
    
    // We assume that the warp size is a power of 2.
    Value /*P*/ Mask = Bld.CreateSub(getNVPTXWarpSize(CGF), Bld.getInt32(1));
    
    return Bld.CreateAnd(Bld.CreateSub(NumThreads, Bld.getInt32(1)), 
        Bld.CreateNot(Mask), new Twine(/*KEEP_STR*/"master_tid"));
  }

  
  //
  // Private state and methods.
  //
  
  // Master-worker control state.
  // Number of requested OMP threads in parallel region.
  private GlobalVariable /*P*/ ActiveWorkers;
  // Outlined function for the workers to execute.
  private GlobalVariable /*P*/ WorkID;
  
  /// \brief Initialize master-worker control state.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::initializeEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 112,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::initializeEnvironment", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX21initializeEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX21initializeEnvironmentEv")
  //</editor-fold>
  private void initializeEnvironment() {
    DataLayout DL = null;
    try {
      //
      // Initialize master-worker control state in shared memory.
      //
      DL = new DataLayout(CGM.getDataLayout());
      ActiveWorkers = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), CGM.Int32Ty, /*isConstant=*/ false, 
                  GlobalValue.LinkageTypes.CommonLinkage, 
                  Constant.getNullValue(CGM.Int32Ty), new Twine(/*KEEP_STR*/"__omp_num_threads"), (GlobalVariable /*P*/ )null, 
                  GlobalVariable.ThreadLocalMode.NotThreadLocal, ADDRESS_SPACE.ADDRESS_SPACE_SHARED.getValue());
       });
      ActiveWorkers.setAlignment(DL.getPrefTypeAlignment(CGM.Int32Ty));
      
      WorkID = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), CGM.Int64Ty, /*isConstant=*/ false, 
                  GlobalValue.LinkageTypes.CommonLinkage, 
                  Constant.getNullValue(CGM.Int64Ty), new Twine(/*KEEP_STR*/"__tgt_work_id"), (GlobalVariable /*P*/ )null, 
                  GlobalVariable.ThreadLocalMode.NotThreadLocal, ADDRESS_SPACE.ADDRESS_SPACE_SHARED.getValue());
       });
      WorkID.setAlignment(DL.getPrefTypeAlignment(CGM.Int64Ty));
    } finally {
      if (DL != null) { DL.$destroy(); }
    }
  }

  
  /// \brief Emit the worker function for the current target region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitWorkerFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 133,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitWorkerFunction", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18emitWorkerFunctionERNS1_19WorkerFunctionStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18emitWorkerFunctionERNS1_19WorkerFunctionStateE")
  //</editor-fold>
  private void emitWorkerFunction(final WorkerFunctionState /*&*/ WST) {
    CodeGenFunction CGF = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final ASTContext /*&*/ Ctx = CGM.getContext();
      
      CGF/*J*/= new CodeGenFunction(CGM, /*suppressNewContext=*/ true);
      CGF.StartFunction(new GlobalDecl(), Ctx.VoidTy.$QualType(), WST.WorkerFn, $Deref(WST.CGFI), $c$.track(/*{ */new FunctionArgList()/* }*/)); $c$.clean();
      emitWorkerLoop(CGF, WST);
      CGF.FinishFunction();
    } finally {
      if (CGF != null) { CGF.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Helper for worker function. Emit body of worker loop.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitWorkerLoop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 142,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitWorkerLoop", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX14emitWorkerLoopERNS0_15CodeGenFunctionERNS1_19WorkerFunctionStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX14emitWorkerLoopERNS0_15CodeGenFunctionERNS1_19WorkerFunctionStateE")
  //</editor-fold>
  private void emitWorkerLoop(final CodeGenFunction /*&*/ CGF, 
                final WorkerFunctionState /*&*/ WST) {
    //
    // The workers enter this loop and wait for parallel work from the master.
    // When the master encounters a parallel region it sets up the work + variable
    // arguments, and wakes up the workers.  The workers first check to see if
    // they are required for the parallel region, i.e., within the # of requested
    // parallel threads.  The activated workers load the variable arguments and
    // execute the parallel work.
    //
    final CGBuilderTy /*&*/ Bld = CGF.Builder;
    
    BasicBlock /*P*/ AwaitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".await.work"));
    BasicBlock /*P*/ SelectWorkersBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".select.workers"));
    BasicBlock /*P*/ ExecuteBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".execute.parallel"));
    BasicBlock /*P*/ TerminateBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".terminate.parallel"));
    BasicBlock /*P*/ BarrierBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".barrier.parallel"));
    BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".exit"));
    
    CGF.EmitBranch(AwaitBB);
    
    // Workers wait for work from master.
    CGF.EmitBlock(AwaitBB);
    // Wait for parallel work
    syncCTAThreads(CGF);
    // On termination condition (workid == 0), exit loop.
    Value /*P*/ ShouldTerminate = Bld.CreateICmpEQ(Bld.CreateAlignedLoad(WorkID, WorkID.getAlignment()), 
        Constant.getNullValue(WorkID.getType().getElementType()), 
        new Twine(/*KEEP_STR*/"should_terminate"));
    Bld.CreateCondBr(ShouldTerminate, ExitBB, SelectWorkersBB);
    
    // Activate requested workers.
    CGF.EmitBlock(SelectWorkersBB);
    Value /*P*/ ThreadID = getNVPTXThreadID(CGF);
    Value /*P*/ ActiveThread = Bld.CreateICmpSLT(ThreadID, 
        Bld.CreateAlignedLoad(ActiveWorkers, ActiveWorkers.getAlignment()), 
        new Twine(/*KEEP_STR*/"active_thread"));
    Bld.CreateCondBr(ActiveThread, ExecuteBB, BarrierBB);
    
    // Signal start of parallel region.
    CGF.EmitBlock(ExecuteBB);
    // TODO: Add parallel work.
    
    // Signal end of parallel region.
    CGF.EmitBlock(TerminateBB);
    CGF.EmitBranch(BarrierBB);
    
    // All active and inactive workers wait at a barrier after parallel region.
    CGF.EmitBlock(BarrierBB);
    // Barrier after parallel region.
    syncCTAThreads(CGF);
    CGF.EmitBranch(AwaitBB);
    
    // Exit target region.
    CGF.EmitBlock(ExitBB);
  }

  
  /// \brief Returns specified OpenMP runtime function for the current OpenMP
  /// implementation.  Specialized for the NVPTX device.
  /// \param Function OpenMP runtime function.
  /// \return Specified function.
  
  /// \brief Returns specified OpenMP runtime function for the current OpenMP
  /// implementation.  Specialized for the NVPTX device.
  /// \param Function OpenMP runtime function.
  /// \return Specified function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::createNVPTXRuntimeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 268,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::createNVPTXRuntimeFunction", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26createNVPTXRuntimeFunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26createNVPTXRuntimeFunctionEj")
  //</editor-fold>
  private Constant /*P*/ createNVPTXRuntimeFunction(/*uint*/int Function) {
    Constant /*P*/ RTLFn = null;
    switch (/*static_cast*/OpenMPRTLFunctionNVPTX.valueOf(Function)) {
     case OMPRTL_NVPTX__kmpc_kernel_init:
      {
        // Build void __kmpc_kernel_init(kmp_int32 omp_handle,
        // kmp_int32 thread_limit);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Int32Ty, CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_kernel_init"));
        break;
      }
    }
    return RTLFn;
  }

  
  //
  // Base class overrides.
  //
  
  /// \brief Creates offloading entry for the provided entry ID \a ID,
  /// address \a Addr and size \a Size.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::createOffloadEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 285,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::createOffloadEntry", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18createOffloadEntryEPN4llvm8ConstantES4_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18createOffloadEntryEPN4llvm8ConstantES4_y")
  //</editor-fold>
  @Override protected/*private*/ void createOffloadEntry(Constant /*P*/ ID, 
                    Constant /*P*/ Addr, 
                    long/*uint64_t*/ Size)/* override*/ {
    Function /*P*/ F = dyn_cast_Function(Addr);
    // TODO: Add support for global variables on the device after declare target
    // support.
    if (!(F != null)) {
      return;
    }
    org.llvm.ir.Module /*P*/ M = F.getParent();
    final LLVMContext /*&*/ Ctx = M.getContext();
    
    // Get "nvvm.annotations" metadata node
    NamedMDNode /*P*/ MD = M.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"nvvm.annotations"));
    
    Metadata /*P*/ MDVals[/*3*/] = new Metadata /*P*/  [/*3*/] {
      ConstantAsMetadata.get(F), MDString.get(Ctx, $kernel), 
      ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(Ctx), $int2ulong(1)))
    };
    // Append metadata to nvvm.annotations
    MD.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(MDVals, true)));
  }

  
  /// \brief Emit outlined function for 'target' directive on the NVPTX
  /// device.
  /// \param D Directive to emit.
  /// \param ParentName Name of the function that encloses the target region.
  /// \param OutlinedFn Outlined function value to be defined by this call.
  /// \param OutlinedFnID Outlined function ID value to be defined by this call.
  /// \param IsOffloadEntry True if the outlined function is an offload entry.
  /// An outlined function may not be an entry if, e.g. the if clause always
  /// evaluates to false.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 307,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyE")
  //</editor-fold>
  @Override public/*private*/ void emitTargetOutlinedFunction(final /*const*/ OMPExecutableDirective /*&*/ D, StringRef ParentName, 
                            final type$ref<Function /*P*/ /*&*/> OutlinedFn, final type$ref<Constant /*P*/ /*&*/> OutlinedFnID, 
                            boolean IsOffloadEntry, final /*const*/ RegionCodeGenTy /*&*/ CodeGen)/* override*/ {
     emitTargetOutlinedFunction$$.NVPTXPrePostActionTy Action = null;
    try {
      if (!IsOffloadEntry) { // Nothing to do.
        return;
      }
      assert (!ParentName.empty()) : "Invalid target region parent name!";
      
      EntryFunctionState EST/*J*/= new EntryFunctionState();
      WorkerFunctionState WST/*J*/= new WorkerFunctionState(CGM);
      
      // Emit target region as a standalone region.
      Action/*J*/= new  emitTargetOutlinedFunction$$.NVPTXPrePostActionTy(/*Deref*/this, EST, WST);
      CodeGen.setAction(Action);
      emitTargetOutlinedFunctionHelper(D, new StringRef(ParentName), OutlinedFn, OutlinedFnID, 
          IsOffloadEntry, CodeGen);
      
      // Create the worker function
      emitWorkerFunction(WST);
      
      // Now change the name of the worker function to correspond to this target
      // region's entry function.
      WST.WorkerFn.setName($add_StringRef$C_char$ptr$C(OutlinedFn.$deref().getName(), /*KEEP_STR*/"_worker"));
    } finally {
      if (Action != null) { Action.$destroy(); }
    }
  }
  private static final class emitTargetOutlinedFunction$$ {
    static //<editor-fold defaultstate="collapsed" desc="NVPTXPrePostActionTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 320,
     FQN="NVPTXPrePostActionTy", NM="_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEE20NVPTXPrePostActionTy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEE20NVPTXPrePostActionTy")
    //</editor-fold>
     class NVPTXPrePostActionTy extends /*public*/ PrePostActionTy implements Destructors.ClassWithDestructor {
      private final CGOpenMPRuntimeNVPTX /*&*/ RT;
      private final CGOpenMPRuntimeNVPTX.EntryFunctionState /*&*/ EST;
      private final CGOpenMPRuntimeNVPTX.WorkerFunctionState /*&*/ WST;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::NVPTXPrePostActionTy">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 326,
       FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::NVPTXPrePostActionTy", NM="_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTyC1ERS1_RNS1_18EntryFunctionStateERNS1_19WorkerFunctionStateE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTyC1ERS1_RNS1_18EntryFunctionStateERNS1_19WorkerFunctionStateE")
      //</editor-fold>
      public NVPTXPrePostActionTy(final CGOpenMPRuntimeNVPTX /*&*/ RT, 
          final CGOpenMPRuntimeNVPTX.EntryFunctionState /*&*/ EST, 
          final CGOpenMPRuntimeNVPTX.WorkerFunctionState /*&*/ WST) {
        // : PrePostActionTy(), RT(RT), EST(EST), WST(WST) 
        //START JInit
        super();
        this./*&*/RT=/*&*/RT;
        this./*&*/EST=/*&*/EST;
        this./*&*/WST=/*&*/WST;
        //END JInit
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::Enter">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 330,
       FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::Enter", NM="_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTy5EnterERNS0_15CodeGenFunctionE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTy5EnterERNS0_15CodeGenFunctionE")
      //</editor-fold>
      @Override public void Enter(final CodeGenFunction /*&*/ CGF)/* override*/ {
        RT.emitEntryHeader(CGF, EST, WST);
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::Exit">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 333,
       FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::Exit", NM="_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTy4ExitERNS0_15CodeGenFunctionE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTy4ExitERNS0_15CodeGenFunctionE")
      //</editor-fold>
      @Override public void Exit(final CodeGenFunction /*&*/ CGF)/* override*/ {
        RT.emitEntryFooter(CGF, EST);
      }
    
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::~NVPTXPrePostActionTy">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 320,
       FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTargetOutlinedFunction(const OMPExecutableDirective & , StringRef, Function * & , Constant * & , bool, const RegionCodeGenTy & )::NVPTXPrePostActionTy::~NVPTXPrePostActionTy", NM="_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTyD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZZN5clang7CodeGen20CGOpenMPRuntimeNVPTX26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyEEN20NVPTXPrePostActionTyD0Ev")
      //</editor-fold>
      @Override public /*inline*/ void $destroy() {
        super.$destroy();
      }
    
      
      @Override public String toString() {
        return "" + "RT=" + RT // NOI18N
                  + ", EST=" + EST // NOI18N
                  + ", WST=" + WST // NOI18N
                  + super.toString(); // NOI18N
      }
    };
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::CGOpenMPRuntimeNVPTX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 347,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::CGOpenMPRuntimeNVPTX", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTXC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTXC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CGOpenMPRuntimeNVPTX(final CodeGenModule /*&*/ CGM) {
    // : CGOpenMPRuntime(CGM), ActiveWorkers(null), WorkID(null) 
    //START JInit
    super(CGM);
    this.ActiveWorkers = null;
    this.WorkID = null;
    //END JInit
    if (!CGM.getLangOpts().OpenMPIsDevice) {
      throw new llvm_unreachable("OpenMP NVPTX can only handle device code.");
    }
    
    // Called once per module during initialization.
    initializeEnvironment();
  }

  
  /// \brief This function ought to emit, in the general case, a call to
  // the openmp runtime kmpc_push_num_teams. In NVPTX backend it is not needed
  // as these numbers are obtained through the PTX grid and block configuration.
  /// \param NumTeams An integer expression of teams.
  /// \param ThreadLimit An integer expression of threads.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 356,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitNumTeamsClause", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18emitNumTeamsClauseERNS0_15CodeGenFunctionEPKNS_4ExprES6_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX18emitNumTeamsClauseERNS0_15CodeGenFunctionEPKNS_4ExprES6_NS_14SourceLocationE")
  //</editor-fold>
  @Override public void emitNumTeamsClause(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ Expr /*P*/ NumTeams, 
                    /*const*/ Expr /*P*/ ThreadLimit, 
                    SourceLocation Loc)/* override*/ {
  }

  
  /// \brief Emits inlined function for the specified OpenMP parallel
  //  directive but an inlined function for teams.
  /// \a D. This outlined function has type void(*)(kmp_int32 *ThreadID,
  /// kmp_int32 BoundID, struct context_vars*).
  /// \param D OpenMP directive.
  /// \param ThreadIDVar Variable for thread id in the current OpenMP region.
  /// \param InnermostKind Kind of innermost directive (for simple directives it
  /// is a directive itself, for combined - its innermost directive).
  /// \param CodeGen Code generation sequence for the \a D directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitParallelOrTeamsOutlinedFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 361,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitParallelOrTeamsOutlinedFunction", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX35emitParallelOrTeamsOutlinedFunctionERKNS_22OMPExecutableDirectiveEPKNS_7VarDeclENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX35emitParallelOrTeamsOutlinedFunctionERKNS_22OMPExecutableDirectiveEPKNS_7VarDeclENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE")
  //</editor-fold>
  @Override public Value /*P*/ emitParallelOrTeamsOutlinedFunction(final /*const*/ OMPExecutableDirective /*&*/ D, /*const*/ VarDecl /*P*/ ThreadIDVar, 
                                     OpenMPDirectiveKind InnermostKind, final /*const*/ RegionCodeGenTy /*&*/ CodeGen)/* override*/ {
    
    Function /*P*/ OutlinedFun = null;
    if (isa_OMPTeamsDirective(D)) {
      Value /*P*/ OutlinedFunVal = super.emitParallelOrTeamsOutlinedFunction(D, ThreadIDVar, InnermostKind, CodeGen);
      OutlinedFun = cast_Function(OutlinedFunVal);
      OutlinedFun.addFnAttr(Attribute.AttrKind.AlwaysInline);
    } else {
      throw new llvm_unreachable("parallel directive is not yet supported for nvptx backend.");
    }
    
    return OutlinedFun;
  }

  
  /// \brief Emits code for teams call of the \a OutlinedFn with
  /// variables captured in a record which address is stored in \a
  /// CapturedStruct.
  /// \param OutlinedFn Outlined function to be run by team masters. Type of
  /// this function is void(*)(kmp_int32 *, kmp_int32, struct context_vars*).
  /// \param CapturedVars A pointer to the record with the references to
  /// variables used in \a OutlinedFn function.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTeamsCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp", line = 379,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::emitTeamsCall", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX13emitTeamsCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_14SourceLocationEPN4llvm5ValueENS8_8ArrayRefISA_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTX13emitTeamsCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_14SourceLocationEPN4llvm5ValueENS8_8ArrayRefISA_EE")
  //</editor-fold>
  @Override public void emitTeamsCall(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ OMPExecutableDirective /*&*/ D, 
               SourceLocation Loc, 
               Value /*P*/ OutlinedFn, 
               ArrayRef<Value /*P*/ > CapturedVars)/* override*/ {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    
    Address ZeroAddr = CGF.CreateTempAlloca(CGF.Int32Ty, CharUnits.fromQuantity(4), 
        /*Name*/ new Twine(/*KEEP_STR*/".zero.addr"));
    CGF.InitTempAlloca(new Address(ZeroAddr), CGF.Builder.getInt32(/*C*/ 0));
    SmallVector<Value /*P*/ > OutlinedFnArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
    OutlinedFnArgs.push_back(ZeroAddr.getPointer());
    OutlinedFnArgs.push_back(ZeroAddr.getPointer());
    OutlinedFnArgs.append_T(CapturedVars.begin(), CapturedVars.end());
    CGF.EmitCallOrInvoke(OutlinedFn, new ArrayRef<Value /*P*/ >(OutlinedFnArgs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntimeNVPTX::~CGOpenMPRuntimeNVPTX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.h", line = 26,
   FQN="clang::CodeGen::CGOpenMPRuntimeNVPTX::~CGOpenMPRuntimeNVPTX", NM="_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTXD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntimeNVPTX.cpp -nm=_ZN5clang7CodeGen20CGOpenMPRuntimeNVPTXD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ActiveWorkers=" + ActiveWorkers // NOI18N
              + ", WorkID=" + WorkID // NOI18N
              + super.toString(); // NOI18N
  }
}
