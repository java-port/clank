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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGObjCMacStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3762,
 FQN="(anonymous namespace)::FragileHazards", NM="_ZN12_GLOBAL__N_114FragileHazardsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazardsE")
//</editor-fold>
public class FragileHazards implements Destructors.ClassWithDestructor {
  private final CodeGenFunction /*&*/ CGF;
  private SmallVector<Value /*P*/ > Locals;
  private DenseSet<BasicBlock /*P*/ > BlocksBeforeTry;
  
  private InlineAsm /*P*/ ReadHazard;
  private InlineAsm /*P*/ WriteHazard;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::GetAsmFnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3907,
   FQN="(anonymous namespace)::FragileHazards::GetAsmFnType", NM="_ZN12_GLOBAL__N_114FragileHazards12GetAsmFnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazards12GetAsmFnTypeEv")
  //</editor-fold>
  private FunctionType /*P*/ GetAsmFnType() {
    SmallVector<Type /*P*/ > tys/*J*/= new SmallVector<Type /*P*/ >(JD$UInt_T$C$R.INSTANCE, 16, Locals.size(), (Type /*P*/ )null);
    for (/*uint*/int i = 0, e = Locals.size(); i != e; ++i)  {
      tys.$set(i, Locals.$at(i).getType());
    }
    return FunctionType.get(CGF.VoidTy, new ArrayRef<Type /*P*/ >(tys, true), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::collectLocals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3892,
   FQN="(anonymous namespace)::FragileHazards::collectLocals", NM="_ZN12_GLOBAL__N_114FragileHazards13collectLocalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazards13collectLocalsEv")
  //</editor-fold>
  private void collectLocals() {
    // Compute a set of allocas to ignore.
    DenseSet<Value /*P*/ > AllocasToIgnore/*J*/= new DenseSet<Value /*P*/ >(DenseMapInfo$LikePtr.$Info());
    addIfPresent(AllocasToIgnore, new Address(CGF.ReturnValue));
    addIfPresent(AllocasToIgnore, CGF.NormalCleanupDest);
    
    // Collect all the allocas currently in the function.  This is
    // probably way too aggressive.
    final BasicBlock /*&*/ Entry = CGF.CurFn.getEntryBlock();
    for (ilist_iterator<Instruction> I = Entry.begin(), E = Entry.end(); I.$noteq(E); I.$preInc())  {
      if (isa_AllocaInst(I.$star()) && !(AllocasToIgnore.count(/*AddrOf*/I.$star()) != 0)) {
        Locals.push_back(/*AddrOf*/I.$star());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::emitReadHazard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3837,
   FQN="(anonymous namespace)::FragileHazards::emitReadHazard", NM="_ZN12_GLOBAL__N_114FragileHazards14emitReadHazardERN5clang7CodeGen11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazards14emitReadHazardERN5clang7CodeGen11CGBuilderTyE")
  //</editor-fold>
  private void emitReadHazard(final CGBuilderTy /*&*/ Builder) {
    assert (!Locals.empty());
    CallInst /*P*/ call = Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(ReadHazard, new ArrayRef<Value /*P*/ >(Locals, true));
    call.setDoesNotThrow();
    call.setCallingConv(CGF.getRuntimeCC());
  }

/*public:*/
  // end anonymous namespace
  
  /// Create the fragile-ABI read and write hazards based on the current
  /// state of the function, which is presumed to be immediately prior
  /// to a @try block.  These hazards are used to maintain correct
  /// semantics in the face of optimization and the fragile ABI's
  /// cavalier use of setjmp/longjmp.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::FragileHazards">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3788,
   FQN="(anonymous namespace)::FragileHazards::FragileHazards", NM="_ZN12_GLOBAL__N_114FragileHazardsC1ERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazardsC1ERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public FragileHazards(final CodeGenFunction /*&*/ CGF) {
    // : CGF(CGF), Locals(), BlocksBeforeTry() 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    this.Locals = new SmallVector<Value /*P*/ >(20, (Value /*P*/ )null);
    this.BlocksBeforeTry = new DenseSet<BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info());
    //END JInit
    collectLocals();
    if (Locals.empty()) {
      return;
    }
    
    // Collect all the blocks in the function.
    for (ilist_iterator<BasicBlock> I = CGF.CurFn.begin(), E = CGF.CurFn.end(); I.$noteq(E); I.$preInc())  {
      BlocksBeforeTry.insert(/*AddrOf*/I.$star());
    }
    
    FunctionType /*P*/ AsmFnTy = GetAsmFnType();
    {
      std.string Constraint/*J*/= new std.string();
      for (/*uint*/int I = 0, E = Locals.size(); I != E; ++I) {
        if ((I != 0)) {
          Constraint.$addassign_T($$COMMA);
        }
        Constraint.$addassign_T$C$P(/*KEEP_STR*/"*m");
      }
      
      ReadHazard = InlineAsm.get(AsmFnTy, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(Constraint), true, false);
    }
    {
      std.string Constraint/*J*/= new std.string();
      for (/*uint*/int I = 0, E = Locals.size(); I != E; ++I) {
        if ((I != 0)) {
          Constraint.$addassign_T($$COMMA);
        }
        Constraint.$addassign_T$C$P(/*KEEP_STR*/"=*m");
      }
      
      WriteHazard = InlineAsm.get(AsmFnTy, new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(Constraint), true, false);
    }
  }

  
  
  /// Emit a write hazard at the current location.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::emitWriteHazard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3831,
   FQN="(anonymous namespace)::FragileHazards::emitWriteHazard", NM="_ZN12_GLOBAL__N_114FragileHazards15emitWriteHazardEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazards15emitWriteHazardEv")
  //</editor-fold>
  public void emitWriteHazard() {
    if (Locals.empty()) {
      return;
    }
    
    CGF.EmitNounwindRuntimeCall(WriteHazard, new ArrayRef<Value /*P*/ >(Locals, true));
  }

  
  /// Emit read hazards in all the protected blocks, i.e. all the blocks
  /// which have been inserted since the beginning of the try.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::emitHazardsInNewBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3846,
   FQN="(anonymous namespace)::FragileHazards::emitHazardsInNewBlocks", NM="_ZN12_GLOBAL__N_114FragileHazards22emitHazardsInNewBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazards22emitHazardsInNewBlocksEv")
  //</editor-fold>
  public void emitHazardsInNewBlocks() {
    CGBuilderTy Builder = null;
    try {
      if (Locals.empty()) {
        return;
      }
      
      Builder/*J*/= new CGBuilderTy(CGF, CGF.getLLVMContext());
      
      // Iterate through all blocks, skipping those prior to the try.
      for (ilist_iterator<BasicBlock> FI = CGF.CurFn.begin(), FE = CGF.CurFn.end(); FI.$noteq(FE); FI.$preInc()) {
        final BasicBlock /*&*/ BB = FI.$star();
        if ((BlocksBeforeTry.count(/*AddrOf*/BB) != 0)) {
          continue;
        }
        
        // Walk through all the calls in the block.
        for (ilist_iterator<Instruction> BI = BB.begin(), BE = BB.end(); BI.$noteq(BE); BI.$preInc()) {
          final Instruction /*&*/ I = BI.$star();
          
          // Ignore instructions that aren't non-intrinsic calls.
          // These are the only calls that can possibly call longjmp.
          if (!isa_CallInst(I) && !isa_InvokeInst(I)) {
            continue;
          }
          if (isa_IntrinsicInst(I)) {
            continue;
          }
          
          // Ignore call sites marked nounwind.  This may be questionable,
          // since 'nounwind' doesn't necessarily mean 'does not call longjmp'.
          CallSite CS/*J*/= new CallSite(/*AddrOf*/I);
          if (CS.doesNotThrow()) {
            continue;
          }
          
          // Insert a read hazard before the call.  This will ensure that
          // any writes to the locals are performed before making the
          // call.  If the call throws, then this is sufficient to
          // guarantee correctness as long as it doesn't also write to any
          // locals.
          Builder.SetInsertPoint(/*AddrOf*/BB, new ilist_iterator<Instruction>(BI));
          emitReadHazard(Builder);
        }
      }
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FragileHazards::~FragileHazards">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3762,
   FQN="(anonymous namespace)::FragileHazards::~FragileHazards", NM="_ZN12_GLOBAL__N_114FragileHazardsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_114FragileHazardsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BlocksBeforeTry.$destroy();
    Locals.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", Locals=" + Locals // NOI18N
              + ", BlocksBeforeTry=" + BlocksBeforeTry // NOI18N
              + ", ReadHazard=" + ReadHazard // NOI18N
              + ", WriteHazard=" + WriteHazard; // NOI18N
  }
}
