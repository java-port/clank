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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


//===----------------------------------------------------------------------===//
//                                LoadInst Class
//===----------------------------------------------------------------------===//

/// LoadInst - an instruction for reading from memory.  This uses the
/// SubclassData field in Value to store whether or not the load is volatile.
///
//<editor-fold defaultstate="collapsed" desc="llvm::LoadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 164,
 FQN="llvm::LoadInst", NM="_ZN4llvm8LoadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstE")
//</editor-fold>
public class LoadInst extends /*public*/ UnaryInstruction implements Destructors.ClassWithDestructor {

  //===----------------------------------------------------------------------===//
  //                           LoadInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::AssertOK">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1319,
   FQN="llvm::LoadInst::AssertOK", NM="_ZN4llvm8LoadInst8AssertOKEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst8AssertOKEv")
  //</editor-fold>
  private void AssertOK() {
    assert (getOperand(0).getType().isPointerTy()) : "Ptr must have pointer type.";
    assert (!(isAtomic() && getAlignment() == 0)) : "Alignment required for atomic load";
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3922,
   FQN="llvm::LoadInst::cloneImpl", NM="_ZNK4llvm8LoadInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst9cloneImplEv")
  //</editor-fold>
  protected LoadInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
        return new LoadInst(getOperand(0), new Twine(), isVolatile(),
                getAlignment(), getOrdering(), getSynchScope());
     });
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1326,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, Instruction /*P*/ InsertBef) {
    // : LoadInst(Ptr, Name, /*isVolatile=*/ false, InsertBef)
    //START JInit
    this(Ptr, Name, false, InsertBef);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1329,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAE) {
    // : LoadInst(Ptr, Name, /*isVolatile=*/ false, InsertAE)
    //START JInit
    this(Ptr, Name, false, InsertAE);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1332,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEbPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEbPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name) {
    this(Ty, Ptr, Name, false,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile/*= false*/) {
    this(Ty, Ptr, Name, isVolatile,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile/*= false*/,
      Instruction /*P*/ InsertBef/*= null*/) {
    // : LoadInst(Ty, Ptr, Name, isVolatile, /*Align=*/ 0, InsertBef)
    //START JInit
    this(Ty, Ptr, Name, isVolatile, 0, InsertBef);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 177,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr) {
    this(Ptr, NameStr, false,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile/*= false*/) {
    this(Ptr, NameStr, isVolatile,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile/*= false*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : LoadInst(cast<PointerType>(Ptr->getType())->getElementType(), Ptr, NameStr, isVolatile, InsertBefore)
    //START JInit
    this(cast_PointerType(Ptr.getType()).getElementType(), Ptr,
        NameStr, isVolatile, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1336,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbPNS_10BasicBlockE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      BasicBlock /*P*/ InsertAE) {
    // : LoadInst(Ptr, Name, isVolatile, /*Align=*/ 0, InsertAE)
    //START JInit
    this(Ptr, Name, isVolatile, 0, InsertAE);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 183,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile, /*uint*/int Align) {
    this(Ptr, NameStr, isVolatile, Align,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile, /*uint*/int Align,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : LoadInst(cast<PointerType>(Ptr->getType())->getElementType(), Ptr, NameStr, isVolatile, Align, InsertBefore)
    //START JInit
    this(cast_PointerType(Ptr.getType()).getElementType(), Ptr,
        NameStr, isVolatile, Align, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1340,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEbjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEbjPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align) {
    this(Ty, Ptr, Name, isVolatile,
      Align, (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align, Instruction /*P*/ InsertBef/*= null*/) {
    // : LoadInst(Ty, Ptr, Name, isVolatile, Align, AtomicOrdering::NotAtomic, CrossThread, InsertBef)
    //START JInit
    this(Ty, Ptr, Name, isVolatile, Align, AtomicOrdering.NotAtomic,
        SynchronizationScope.CrossThread, InsertBef);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1345,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjPNS_10BasicBlockE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align, BasicBlock /*P*/ InsertAE) {
    // : LoadInst(Ptr, Name, isVolatile, Align, AtomicOrdering::NotAtomic, CrossThread, InsertAE)
    //START JInit
    this(Ptr, Name, isVolatile, Align, AtomicOrdering.NotAtomic,
        SynchronizationScope.CrossThread, InsertAE);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 191,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile, /*uint*/int Align,
      AtomicOrdering Order) {
    this(Ptr, NameStr, isVolatile, Align,
      Order, SynchronizationScope.CrossThread,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile, /*uint*/int Align,
      AtomicOrdering Order, SynchronizationScope SynchScope/*= CrossThread*/) {
    this(Ptr, NameStr, isVolatile, Align,
      Order, SynchScope,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ NameStr, boolean isVolatile, /*uint*/int Align,
      AtomicOrdering Order, SynchronizationScope SynchScope/*= CrossThread*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : LoadInst(cast<PointerType>(Ptr->getType())->getElementType(), Ptr, NameStr, isVolatile, Align, Order, SynchScope, InsertBefore)
    //START JInit
    this(cast_PointerType(Ptr.getType()).getElementType(), Ptr,
        NameStr, isVolatile, Align, Order, SynchScope, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1350,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEbjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueERKNS_5TwineEbjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order) {
    this(Ty, Ptr, Name, isVolatile,
      Align, Order,
      SynchronizationScope.CrossThread, (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order,
      SynchronizationScope SynchScope/*= CrossThread*/) {
    this(Ty, Ptr, Name, isVolatile,
      Align, Order,
      SynchScope, (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order,
      SynchronizationScope SynchScope/*= CrossThread*/, Instruction /*P*/ InsertBef/*= null*/) {
    // : UnaryInstruction(Ty, Load, Ptr, InsertBef)
    //START JInit
    super(Ty, MemoryOps.Load, Ptr, InsertBef);
    //END JInit
    assert (Ty == cast_PointerType(Ptr.getType()).getElementType());
    setVolatile(isVolatile);
    setAlignment(Align);
    setAtomic(Order, SynchScope);
    AssertOK();
    setName(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1362,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueERKNS_5TwineEbjNS_14AtomicOrderingENS_20SynchronizationScopeEPNS_10BasicBlockE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, final /*const*/ Twine /*&*/ Name, boolean isVolatile,
      /*uint*/int Align, AtomicOrdering Order,
      SynchronizationScope SynchScope,
      BasicBlock /*P*/ InsertAE) {
    // : UnaryInstruction(cast<PointerType>(Ptr->getType())->getElementType(), Load, Ptr, InsertAE)
    //START JInit
    super(cast_PointerType(Ptr.getType()).getElementType(),
        MemoryOps.Load, Ptr, InsertAE);
    //END JInit
    setVolatile(isVolatile);
    setAlignment(Align);
    setAtomic(Order, SynchScope);
    AssertOK();
    setName(Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1375,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueEPKcPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueEPKcPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name, Instruction /*P*/ InsertBef) {
    // : UnaryInstruction(cast<PointerType>(Ptr->getType())->getElementType(), Load, Ptr, InsertBef)
    //START JInit
    super(cast_PointerType(Ptr.getType()).getElementType(),
        MemoryOps.Load, Ptr, InsertBef);
    //END JInit
    setVolatile(false);
    setAlignment(0);
    setAtomic(AtomicOrdering.NotAtomic);
    AssertOK();
    if (Native.$bool(Name) && (Name.$at(0) != 0)) {
      setName(new Twine(Name));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1385,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueEPKcPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueEPKcPNS_10BasicBlockE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name, BasicBlock /*P*/ InsertAE) {
    // : UnaryInstruction(cast<PointerType>(Ptr->getType())->getElementType(), Load, Ptr, InsertAE)
    //START JInit
    super(cast_PointerType(Ptr.getType()).getElementType(),
        MemoryOps.Load, Ptr, InsertAE);
    //END JInit
    setVolatile(false);
    setAlignment(0);
    setAtomic(AtomicOrdering.NotAtomic);
    AssertOK();
    if (Native.$bool(Name) && (Name.$at(0) != 0)) {
      setName(new Twine(Name));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1395,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueEPKcbPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_4TypeEPNS_5ValueEPKcbPNS_11InstructionE")
  //</editor-fold>
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr) {
    this(Ty, Ptr, (/*const*/char$ptr/*char P*/ )null, false,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name/*= null*/) {
    this(Ty, Ptr, Name, false,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name/*= null*/, boolean isVolatile/*= false*/) {
    this(Ty, Ptr, Name, isVolatile,
      (Instruction /*P*/ )null);
  }
  public LoadInst(Type /*P*/ Ty, Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name/*= null*/, boolean isVolatile/*= false*/,
      Instruction /*P*/ InsertBef/*= null*/) {
    // : UnaryInstruction(Ty, Load, Ptr, InsertBef)
    //START JInit
    super(Ty, MemoryOps.Load, Ptr, InsertBef);
    //END JInit
    assert (Ty == cast_PointerType(Ptr.getType()).getElementType());
    setVolatile(isVolatile);
    setAlignment(0);
    setAtomic(AtomicOrdering.NotAtomic);
    AssertOK();
    if (Native.$bool(Name) && (Name.$at(0) != 0)) {
      setName(new Twine(Name));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 209,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueEPKcbPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueEPKcbPNS_11InstructionE")
  //</editor-fold>
  public /*explicit*/ LoadInst(Value /*P*/ Ptr) {
    this(Ptr, (/*const*/char$ptr/*char P*/ )null,
      false,
      (Instruction /*P*/ )null);
  }
  public /*explicit*/ LoadInst(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ NameStr/*= null*/) {
    this(Ptr, NameStr,
      false,
      (Instruction /*P*/ )null);
  }
  public /*explicit*/ LoadInst(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ NameStr/*= null*/,
      boolean isVolatile/*= false*/) {
    this(Ptr, NameStr,
      isVolatile,
      (Instruction /*P*/ )null);
  }
  public /*explicit*/ LoadInst(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ NameStr/*= null*/,
      boolean isVolatile/*= false*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : LoadInst(cast<PointerType>(Ptr->getType())->getElementType(), Ptr, NameStr, isVolatile, InsertBefore)
    //START JInit
    this(cast_PointerType(Ptr.getType()).getElementType(), Ptr,
        NameStr, isVolatile, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1406,
   FQN="llvm::LoadInst::LoadInst", NM="_ZN4llvm8LoadInstC1EPNS_5ValueEPKcbPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstC1EPNS_5ValueEPKcbPNS_10BasicBlockE")
  //</editor-fold>
  public LoadInst(Value /*P*/ Ptr, /*const*/char$ptr/*char P*/ Name, boolean isVolatile,
      BasicBlock /*P*/ InsertAE) {
    // : UnaryInstruction(cast<PointerType>(Ptr->getType())->getElementType(), Load, Ptr, InsertAE)
    //START JInit
    super(cast_PointerType(Ptr.getType()).getElementType(),
        MemoryOps.Load, Ptr, InsertAE);
    //END JInit
    setVolatile(isVolatile);
    setAlignment(0);
    setAtomic(AtomicOrdering.NotAtomic);
    AssertOK();
    if (Native.$bool(Name) && (Name.$at(0) != 0)) {
      setName(new Twine(Name));
    }
  }


  /// isVolatile - Return true if this is a load from a volatile memory
  /// location.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 220,
   FQN="llvm::LoadInst::isVolatile", NM="_ZNK4llvm8LoadInst10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }


  /// setVolatile - Specify whether this is a volatile load or not.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 224,
   FQN="llvm::LoadInst::setVolatile", NM="_ZN4llvm8LoadInst11setVolatileEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst11setVolatileEb")
  //</editor-fold>
  public void setVolatile(boolean V) {
    setInstructionSubclassData_LoadInst($uint2ushort((getSubclassDataFromInstruction() & ~1)
           | (V ? 1 : 0)));
  }


  /// getAlignment - Return the alignment of the access that is being performed
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 231,
   FQN="llvm::LoadInst::getAlignment", NM="_ZNK4llvm8LoadInst12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    return (1 << ((getSubclassDataFromInstruction() >>> 1) & 31)) >> 1;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1417,
   FQN="llvm::LoadInst::setAlignment", NM="_ZN4llvm8LoadInst12setAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst12setAlignmentEj")
  //</editor-fold>
  public void setAlignment(/*uint*/int Align) {
    assert ((Align & (Align - 1)) == 0) : "Alignment is not a power of 2!";
    assert ($lesseq_uint(Align, Value.MaximumAlignment)) : "Alignment is greater than MaximumAlignment!";
    setInstructionSubclassData_LoadInst($uint2ushort((getSubclassDataFromInstruction() & ~(31 << 1))
           | ((Log2_32(Align) + 1) << 1)));
    assert (getAlignment() == Align) : "Alignment representation error!";
  }


  /// Returns the ordering effect of this fence.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 238,
   FQN="llvm::LoadInst::getOrdering", NM="_ZNK4llvm8LoadInst11getOrderingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst11getOrderingEv")
  //</editor-fold>
  public AtomicOrdering getOrdering() /*const*/ {
    return AtomicOrdering.valueOf((getSubclassDataFromInstruction() >>> 7) & 7);
  }


  /// Set the ordering constraint on this load. May not be Release or
  /// AcquireRelease.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::setOrdering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 244,
   FQN="llvm::LoadInst::setOrdering", NM="_ZN4llvm8LoadInst11setOrderingENS_14AtomicOrderingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst11setOrderingENS_14AtomicOrderingE")
  //</editor-fold>
  public void setOrdering(AtomicOrdering Ordering) {
    setInstructionSubclassData_LoadInst($uint2ushort((getSubclassDataFromInstruction() & ~(7 << 7))
           | (((/*uint*/int)Ordering.getValue()) << 7)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 249,
   FQN="llvm::LoadInst::getSynchScope", NM="_ZNK4llvm8LoadInst13getSynchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst13getSynchScopeEv")
  //</editor-fold>
  public SynchronizationScope getSynchScope() /*const*/ {
    return SynchronizationScope.valueOf((getSubclassDataFromInstruction() >>> 6) & 1);
  }


  /// Specify whether this load is ordered with respect to all
  /// concurrently executing threads, or only with respect to signal handlers
  /// executing in the same thread.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::setSynchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 256,
   FQN="llvm::LoadInst::setSynchScope", NM="_ZN4llvm8LoadInst13setSynchScopeENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst13setSynchScopeENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setSynchScope(SynchronizationScope xthread) {
    setInstructionSubclassData_LoadInst($uint2ushort((getSubclassDataFromInstruction() & ~(1 << 6))
           | (xthread.getValue() << 6)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::setAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 261,
   FQN="llvm::LoadInst::setAtomic", NM="_ZN4llvm8LoadInst9setAtomicENS_14AtomicOrderingENS_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst9setAtomicENS_14AtomicOrderingENS_20SynchronizationScopeE")
  //</editor-fold>
  public void setAtomic(AtomicOrdering Ordering) {
    setAtomic(Ordering,
           SynchronizationScope.CrossThread);
  }
  public void setAtomic(AtomicOrdering Ordering,
           SynchronizationScope SynchScope/*= CrossThread*/) {
    setOrdering(Ordering);
    setSynchScope(SynchScope);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::isSimple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 267,
   FQN="llvm::LoadInst::isSimple", NM="_ZNK4llvm8LoadInst8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    return !isAtomic() && !isVolatile();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::isUnordered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 268,
   FQN="llvm::LoadInst::isUnordered", NM="_ZNK4llvm8LoadInst11isUnorderedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst11isUnorderedEv")
  //</editor-fold>
  public boolean isUnordered() /*const*/ {
    return (getOrdering() == AtomicOrdering.NotAtomic
       || getOrdering() == AtomicOrdering.Unordered)
       && !isVolatile();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 274,
   FQN="llvm::LoadInst::getPointerOperand", NM="_ZN4llvm8LoadInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 275,
   FQN="llvm::LoadInst::getPointerOperand", NM="_ZNK4llvm8LoadInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 276,
   FQN="llvm::LoadInst::getPointerOperandIndex", NM="_ZN4llvm8LoadInst22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 0/*U*/;
  }


  /// \brief Returns the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 279,
   FQN="llvm::LoadInst::getPointerAddressSpace", NM="_ZNK4llvm8LoadInst22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8LoadInst22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return getPointerOperand$Const().getType().getPointerAddressSpace();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 284,
   FQN="llvm::LoadInst::classof", NM="_ZN4llvm8LoadInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.MemoryOps.Load;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 287,
   FQN="llvm::LoadInst::classof", NM="_ZN4llvm8LoadInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && LoadInst.classof(cast_Instruction(V));
  }

/*private:*/
  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 294,
   FQN="llvm::LoadInst::setInstructionSubclassData", NM="_ZN4llvm8LoadInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_LoadInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoadInst::~LoadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 164,
   FQN="llvm::LoadInst::~LoadInst", NM="_ZN4llvm8LoadInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8LoadInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
