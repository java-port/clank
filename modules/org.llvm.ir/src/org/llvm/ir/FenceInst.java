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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                                FenceInst Class
//===----------------------------------------------------------------------===//

/// FenceInst - an instruction for ordering other memory operations
///
//<editor-fold defaultstate="collapsed" desc="llvm::FenceInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 437,
 FQN="llvm::FenceInst", NM="_ZN4llvm9FenceInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInstE")
//</editor-fold>
public class FenceInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 438,
   FQN="llvm::FenceInst::operator new", NM="_ZN4llvm9FenceInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_FenceInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::Init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 439,
   FQN="llvm::FenceInst::Init", NM="_ZN4llvm9FenceInst4InitENS_14AtomicOrderingENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInst4InitENS_14AtomicOrderingENS_20SynchronizationScopeE")
  //</editor-fold>
  private void Init(AtomicOrdering Ordering, SynchronizationScope SynchScope) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3951,
   FQN="llvm::FenceInst::cloneImpl", NM="_ZNK4llvm9FenceInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9FenceInst9cloneImplEv")
  //</editor-fold>
  protected FenceInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [FenceInst::new]*/FenceInst.$new_FenceInst((type$ptr<?> New$Mem)->{
        return new FenceInst(getContext(), getOrdering(), getSynchScope());
     });
  }

/*public:*/
  // allocate space for exactly zero operands
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 448,
   FQN="llvm::FenceInst::operator new", NM="_ZN4llvm9FenceInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInstnwEj")
  //</editor-fold>
  public static <T extends FenceInst> T/*void P*/ $new_FenceInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */0, $Ctor);
  }


  // Ordering may only be Acquire, Release, AcquireRelease, or
  // SequentiallyConsistent.

  //===----------------------------------------------------------------------===//
  //                       FenceInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::FenceInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1619,
   FQN="llvm::FenceInst::FenceInst", NM="_ZN4llvm9FenceInstC1ERNS_11LLVMContextENS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInstC1ERNS_11LLVMContextENS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE")
  //</editor-fold>
  public FenceInst(final LLVMContext /*&*/ C, AtomicOrdering Ordering) {
    this(C, Ordering,
      SynchronizationScope.CrossThread,
      (Instruction /*P*/ )null);
  }
  public FenceInst(final LLVMContext /*&*/ C, AtomicOrdering Ordering,
      SynchronizationScope SynchScope/*= CrossThread*/) {
    this(C, Ordering,
      SynchScope,
      (Instruction /*P*/ )null);
  }
  public FenceInst(final LLVMContext /*&*/ C, AtomicOrdering Ordering,
      SynchronizationScope SynchScope/*= CrossThread*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(Type::getVoidTy(C), Fence, null, 0, InsertBefore)
    //START JInit
    super(Type.getVoidTy(C), MemoryOps.Fence, (type$ptr<Use /*P*/> )null, 0, InsertBefore);
    //END JInit
    setOrdering(Ordering);
    setSynchScope(SynchScope);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::FenceInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1627,
   FQN="llvm::FenceInst::FenceInst", NM="_ZN4llvm9FenceInstC1ERNS_11LLVMContextENS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInstC1ERNS_11LLVMContextENS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE")
  //</editor-fold>
  public FenceInst(final LLVMContext /*&*/ C, AtomicOrdering Ordering,
      SynchronizationScope SynchScope,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Type::getVoidTy(C), Fence, null, 0, InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(C), MemoryOps.Fence, (type$ptr<Use /*P*/> )null, 0, InsertAtEnd);
    //END JInit
    setOrdering(Ordering);
    setSynchScope(SynchScope);
  }


  /// Returns the ordering effect of this fence.
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::getOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 462,
   FQN="llvm::FenceInst::getOrdering", NM="_ZNK4llvm9FenceInst11getOrderingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9FenceInst11getOrderingEv")
  //</editor-fold>
  public AtomicOrdering getOrdering() /*const*/ {
    return AtomicOrdering.valueOf(getSubclassDataFromInstruction() >>> 1);
  }


  /// Set the ordering constraint on this fence.  May only be Acquire, Release,
  /// AcquireRelease, or SequentiallyConsistent.
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::setOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 468,
   FQN="llvm::FenceInst::setOrdering", NM="_ZN4llvm9FenceInst11setOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInst11setOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public void setOrdering(AtomicOrdering Ordering) {
    setInstructionSubclassData_FenceInst($uint2ushort((getSubclassDataFromInstruction() & 1)
           | (((/*uint*/int)Ordering.getValue()) << 1)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::getSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 473,
   FQN="llvm::FenceInst::getSynchScope", NM="_ZNK4llvm9FenceInst13getSynchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm9FenceInst13getSynchScopeEv")
  //</editor-fold>
  public SynchronizationScope getSynchScope() /*const*/ {
    return SynchronizationScope.valueOf(getSubclassDataFromInstruction() & 1);
  }


  /// Specify whether this fence orders other operations with respect to all
  /// concurrently executing threads, or only with respect to signal handlers
  /// executing in the same thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::setSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 480,
   FQN="llvm::FenceInst::setSynchScope", NM="_ZN4llvm9FenceInst13setSynchScopeENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInst13setSynchScopeENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setSynchScope(SynchronizationScope xthread) {
    setInstructionSubclassData_FenceInst($uint2ushort((getSubclassDataFromInstruction() & ~1)
           | xthread.getValue()));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 486,
   FQN="llvm::FenceInst::classof", NM="_ZN4llvm9FenceInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.MemoryOps.Fence;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 489,
   FQN="llvm::FenceInst::classof", NM="_ZN4llvm9FenceInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && FenceInst.classof(cast_Instruction(V));
  }

/*private:*/
  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 496,
   FQN="llvm::FenceInst::setInstructionSubclassData", NM="_ZN4llvm9FenceInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_FenceInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FenceInst::~FenceInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 437,
   FQN="llvm::FenceInst::~FenceInst", NM="_ZN4llvm9FenceInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm9FenceInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
