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
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.type$ptr;
import static org.clank.support.literal_constants.$EMPTY;
import org.llvm.adt.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.llvm.*;


//===----------------------------------------------------------------------===//
//                                AllocaInst Class
//===----------------------------------------------------------------------===//

/// AllocaInst - an instruction to allocate memory on the stack
///
//<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 51,
 FQN="llvm::AllocaInst", NM="_ZN4llvm10AllocaInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstE")
//</editor-fold>
public class AllocaInst extends /*public*/ UnaryInstruction implements Destructors.ClassWithDestructor {
  private Type /*P*/ AllocatedType;
/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3914,
   FQN="llvm::AllocaInst::cloneImpl", NM="_ZNK4llvm10AllocaInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst9cloneImplEv")
  //</editor-fold>
  protected AllocaInst /*P*/ cloneImpl() /*const*/ {
    AllocaInst /*P*/ Result = /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
        return new AllocaInst(getAllocatedType(), 
                (Value /*P*/ )getOperand(0), getAlignment());
     });
    Result.setUsedWithInAlloca(isUsedWithInAlloca());
    Result.setSwiftError(isSwiftError());
    return Result;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::AllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1256,
   FQN="llvm::AllocaInst::AllocaInst", NM="_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public AllocaInst(Type /*P*/ Ty) {
    this(Ty, (Value /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY), 
      (Instruction /*P*/ )null);
  }
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize/*= null*/) {
    this(Ty, ArraySize, new Twine(/*KEEP_STR*/$EMPTY), 
      (Instruction /*P*/ )null);
  }
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(Ty, ArraySize, Name, 
      (Instruction /*P*/ )null);
  }
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/, 
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : AllocaInst(Ty, ArraySize, /*Align=*/ 0, Name, InsertBefore) 
    //START JInit
    this(Ty, ArraySize, 0, Name, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::AllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1260,
   FQN="llvm::AllocaInst::AllocaInst", NM="_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize, final /*const*/ Twine /*&*/ Name, 
      BasicBlock /*P*/ InsertAtEnd) {
    // : AllocaInst(Ty, ArraySize, /*Align=*/ 0, Name, InsertAtEnd) 
    //START JInit
    this(Ty, ArraySize, 0, Name, InsertAtEnd);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::AllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1250,
   FQN="llvm::AllocaInst::AllocaInst", NM="_ZN4llvm10AllocaInstC1EPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstC1EPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public AllocaInst(Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name) {
    this(Ty, Name, (Instruction /*P*/ )null);
  }
  public AllocaInst(Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ InsertBefore/*= null*/) {
    // : AllocaInst(Ty, /*ArraySize=*/ null, Name, InsertBefore) 
    //START JInit
    this(Ty, (Value /*P*/ )null, Name, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::AllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1253,
   FQN="llvm::AllocaInst::AllocaInst", NM="_ZN4llvm10AllocaInstC1EPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstC1EPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public AllocaInst(Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAtEnd) {
    // : AllocaInst(Ty, /*ArraySize=*/ null, Name, InsertAtEnd) 
    //START JInit
    this(Ty, (Value /*P*/ )null, Name, InsertAtEnd);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::AllocaInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1264,
   FQN="llvm::AllocaInst::AllocaInst", NM="_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize, /*uint*/int Align) {
    this(Ty, ArraySize, Align, 
      new Twine(/*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize, /*uint*/int Align, 
      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(Ty, ArraySize, Align, 
      Name, (Instruction /*P*/ )null);
  }
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize, /*uint*/int Align, 
      final /*const*/ Twine /*&*/ Name/*= ""*/, Instruction /*P*/ InsertBefore/*= null*/) {
    // : UnaryInstruction(PointerType::getUnqual(Ty), Alloca, getAISize(Ty->getContext(), ArraySize), InsertBefore), AllocatedType(Ty) 
    //START JInit
    super(PointerType.getUnqual(Ty), MemoryOps.Alloca, 
        InstructionsStatics.getAISize(Ty.getContext(), ArraySize), InsertBefore);
    this.AllocatedType = Ty;
    //END JInit
    setAlignment(Align);
    assert (!Ty.isVoidTy()) : "Cannot allocate void!";
    setName(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::AllocaInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1274,
   FQN="llvm::AllocaInst::AllocaInst", NM="_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstC1EPNS_4TypeEPNS_5ValueEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public AllocaInst(Type /*P*/ Ty, Value /*P*/ ArraySize, /*uint*/int Align, 
      final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAtEnd) {
    // : UnaryInstruction(PointerType::getUnqual(Ty), Alloca, getAISize(Ty->getContext(), ArraySize), InsertAtEnd), AllocatedType(Ty) 
    //START JInit
    super(PointerType.getUnqual(Ty), MemoryOps.Alloca, 
        InstructionsStatics.getAISize(Ty.getContext(), ArraySize), InsertAtEnd);
    this.AllocatedType = Ty;
    //END JInit
    setAlignment(Align);
    assert (!Ty.isVoidTy()) : "Cannot allocate void!";
    setName(Name);
  }

  
  // Out of line virtual method, so the vtable, etc. has a home.
  
  // Out of line virtual method, so the vtable, etc has a home.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::~AllocaInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1285,
   FQN="llvm::AllocaInst::~AllocaInst", NM="_ZN4llvm10AllocaInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInstD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  /// isArrayAllocation - Return true if there is an allocation size parameter
  /// to the allocation instruction that is not 1.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::isArrayAllocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1297,
   FQN="llvm::AllocaInst::isArrayAllocation", NM="_ZNK4llvm10AllocaInst17isArrayAllocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst17isArrayAllocationEv")
  //</editor-fold>
  public boolean isArrayAllocation() /*const*/ {
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(getOperand(0));
      if ((CI != null)) {
        return !CI.isOne();
      }
    }
    return true;
  }

  
  /// getArraySize - Get the number of elements allocated. For a simple
  /// allocation of a single element, this will return a constant 1 value.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::getArraySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 85,
   FQN="llvm::AllocaInst::getArraySize", NM="_ZNK4llvm10AllocaInst12getArraySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst12getArraySizeEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getArraySize$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::getArraySize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 86,
   FQN="llvm::AllocaInst::getArraySize", NM="_ZN4llvm10AllocaInst12getArraySizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst12getArraySizeEv")
  //</editor-fold>
  public Value /*P*/ getArraySize() {
    return getOperand(0);
  }

  
  /// getType - Overload to return most specific pointer type
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 90,
   FQN="llvm::AllocaInst::getType", NM="_ZNK4llvm10AllocaInst7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst7getTypeEv")
  //</editor-fold>
  public PointerType /*P*/ getType() /*const*/ {
    return cast_PointerType(super.getType());
  }

  
  /// getAllocatedType - Return the type that is being allocated by the
  /// instruction.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::getAllocatedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 97,
   FQN="llvm::AllocaInst::getAllocatedType", NM="_ZNK4llvm10AllocaInst16getAllocatedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst16getAllocatedTypeEv")
  //</editor-fold>
  public Type /*P*/ getAllocatedType() /*const*/ {
    return AllocatedType;
  }

  /// \brief for use only in special circumstances that need to generically
  /// transform a whole instruction (eg: IR linking and vectorization).
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::setAllocatedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 100,
   FQN="llvm::AllocaInst::setAllocatedType", NM="_ZN4llvm10AllocaInst16setAllocatedTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst16setAllocatedTypeEPNS_4TypeE")
  //</editor-fold>
  public void setAllocatedType(Type /*P*/ Ty) {
    AllocatedType = Ty;
  }

  
  /// getAlignment - Return the alignment of the memory that is being allocated
  /// by the instruction.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 105,
   FQN="llvm::AllocaInst::getAlignment", NM="_ZNK4llvm10AllocaInst12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return (1/*U*/ << (getSubclassDataFromInstruction() & 31)) >>> 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1288,
   FQN="llvm::AllocaInst::setAlignment", NM="_ZN4llvm10AllocaInst12setAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst12setAlignmentEj")
  //</editor-fold>
  public void setAlignment(/*uint*/int Align) {
    assert ((Align & (Align - 1)) == 0) : "Alignment is not a power of 2!";
    assert ($lesseq_uint(Align, MaximumAlignment)) : "Alignment is greater than MaximumAlignment!";
    setInstructionSubclassData_AllocaInst($uint2ushort((getSubclassDataFromInstruction() & ~31)
           | (Log2_32(Align) + 1)));
    assert (getAlignment() == Align) : "Alignment representation error!";
  }

  
  /// isStaticAlloca - Return true if this alloca is in the entry block of the
  /// function and is a constant size.  If so, the code generator will fold it
  /// into the prolog/epilog code, so it is basically free.
  
  /// isStaticAlloca - Return true if this alloca is in the entry block of the
  /// function and is a constant size.  If so, the code generator will fold it
  /// into the prolog/epilog code, so it is basically free.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::isStaticAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1306,
   FQN="llvm::AllocaInst::isStaticAlloca", NM="_ZNK4llvm10AllocaInst14isStaticAllocaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst14isStaticAllocaEv")
  //</editor-fold>
  public boolean isStaticAlloca() /*const*/ {
    // Must be constant size.
    if (!isa_ConstantInt(getArraySize$Const())) {
      return false;
    }
    
    // Must be in the entry block.
    /*const*/ BasicBlock /*P*/ Parent = getParent$Const();
    return Parent == /*AddrOf*/Parent.getParent$Const().front$Const() && !isUsedWithInAlloca();
  }

  
  /// \brief Return true if this alloca is used as an inalloca argument to a
  /// call.  Such allocas are never considered static even if they are in the
  /// entry block.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::isUsedWithInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 118,
   FQN="llvm::AllocaInst::isUsedWithInAlloca", NM="_ZNK4llvm10AllocaInst18isUsedWithInAllocaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst18isUsedWithInAllocaEv")
  //</editor-fold>
  public boolean isUsedWithInAlloca() /*const*/ {
    return ((getSubclassDataFromInstruction() & 32) != 0);
  }

  
  /// \brief Specify whether this alloca is used to represent the arguments to
  /// a call.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::setUsedWithInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 124,
   FQN="llvm::AllocaInst::setUsedWithInAlloca", NM="_ZN4llvm10AllocaInst19setUsedWithInAllocaEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst19setUsedWithInAllocaEb")
  //</editor-fold>
  public void setUsedWithInAlloca(boolean V) {
    setInstructionSubclassData_AllocaInst($uint2ushort((getSubclassDataFromInstruction() & ~32)
           | (V ? 32 : 0)));
  }

  
  /// \brief Return true if this alloca is used as a swifterror argument to a
  /// call.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::isSwiftError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 131,
   FQN="llvm::AllocaInst::isSwiftError", NM="_ZNK4llvm10AllocaInst12isSwiftErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10AllocaInst12isSwiftErrorEv")
  //</editor-fold>
  public boolean isSwiftError() /*const*/ {
    return ((getSubclassDataFromInstruction() & 64) != 0);
  }

  
  /// \brief Specify whether this alloca is used to represent a swifterror.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::setSwiftError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 136,
   FQN="llvm::AllocaInst::setSwiftError", NM="_ZN4llvm10AllocaInst13setSwiftErrorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst13setSwiftErrorEb")
  //</editor-fold>
  public void setSwiftError(boolean V) {
    setInstructionSubclassData_AllocaInst($uint2ushort((getSubclassDataFromInstruction() & ~64)
           | (V ? 64 : 0)));
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 142,
   FQN="llvm::AllocaInst::classof", NM="_ZN4llvm10AllocaInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode()== Instruction.MemoryOps.Alloca);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 145,
   FQN="llvm::AllocaInst::classof", NM="_ZN4llvm10AllocaInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && AllocaInst.classof(cast_Instruction(V));
  }

/*private:*/
  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::AllocaInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 152,
   FQN="llvm::AllocaInst::setInstructionSubclassData", NM="_ZN4llvm10AllocaInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10AllocaInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_AllocaInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  
  @Override public String toString() {
    return "" + "AllocatedType=" + AllocatedType // NOI18N
              + super.toString(); // NOI18N
  }
}
