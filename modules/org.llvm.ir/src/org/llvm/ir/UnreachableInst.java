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
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                           UnreachableInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// UnreachableInst - This function has undefined behavior.  In particular, the
/// presence of this instruction indicates some higher level knowledge that the
/// end of the block cannot be reached.
///
//<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4378,
 FQN="llvm::UnreachableInst", NM="_ZN4llvm15UnreachableInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInstE")
//</editor-fold>
public class UnreachableInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4379,
   FQN="llvm::UnreachableInst::operator new", NM="_ZN4llvm15UnreachableInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4081,
   FQN="llvm::UnreachableInst::cloneImpl", NM="_ZNK4llvm15UnreachableInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15UnreachableInst9cloneImplEv")
  //</editor-fold>
  protected UnreachableInst /*P*/ cloneImpl() /*const*/ {
    final LLVMContext /*&*/ Context = getContext();
    return /*NEW_EXPR [UnreachableInst::new]*/UnreachableInst.$new_UnreachableInst((type$ptr<?> New$Mem)->{
        return new UnreachableInst(Context);
     });
  }

/*public:*/
  // allocate space for exactly zero operands
  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4388,
   FQN="llvm::UnreachableInst::operator new", NM="_ZN4llvm15UnreachableInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInstnwEj")
  //</editor-fold>
  public static <T extends UnreachableInst> T/*void P*/ $new_UnreachableInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */0, $Ctor);
  }
  

  //===----------------------------------------------------------------------===//
  //                      UnreachableInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::UnreachableInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1118,
   FQN="llvm::UnreachableInst::UnreachableInst", NM="_ZN4llvm15UnreachableInstC1ERNS_11LLVMContextEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInstC1ERNS_11LLVMContextEPNS_11InstructionE")
  //</editor-fold>
  public UnreachableInst(final LLVMContext /*&*/ Context) {
    this(Context,
      (Instruction /*P*/ )null);
  }
  public UnreachableInst(final LLVMContext /*&*/ Context,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : TerminatorInst(Type::getVoidTy(Context), Instruction::Unreachable, null, 0, InsertBefore)
    //START JInit
    super(Type.getVoidTy(Context), Instruction.TermOps.Unreachable,
        (type$ptr<Use /*P*/> )null, 0, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::UnreachableInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1123,
   FQN="llvm::UnreachableInst::UnreachableInst", NM="_ZN4llvm15UnreachableInstC1ERNS_11LLVMContextEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInstC1ERNS_11LLVMContextEPNS_10BasicBlockE")
  //</editor-fold>
  public UnreachableInst(final LLVMContext /*&*/ Context, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(Context), Instruction::Unreachable, null, 0, InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(Context), Instruction.TermOps.Unreachable,
        (type$ptr<Use /*P*/> )null, 0, InsertAtEnd);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4394,
   FQN="llvm::UnreachableInst::getNumSuccessors", NM="_ZNK4llvm15UnreachableInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15UnreachableInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return 0;
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4397,
   FQN="llvm::UnreachableInst::classof", NM="_ZN4llvm15UnreachableInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.TermOps.Unreachable;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4400,
   FQN="llvm::UnreachableInst::classof", NM="_ZN4llvm15UnreachableInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && UnreachableInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1136,
   FQN="llvm::UnreachableInst::getSuccessorV", NM="_ZNK4llvm15UnreachableInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15UnreachableInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    throw new llvm_unreachable("UnreachableInst has no successors!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1128,
   FQN="llvm::UnreachableInst::getNumSuccessorsV", NM="_ZNK4llvm15UnreachableInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm15UnreachableInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 1132,
   FQN="llvm::UnreachableInst::setSuccessorV", NM="_ZN4llvm15UnreachableInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ NewSucc)/* override*/ {
    throw new llvm_unreachable("UnreachableInst has no successors!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UnreachableInst::~UnreachableInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4378,
   FQN="llvm::UnreachableInst::~UnreachableInst", NM="_ZN4llvm15UnreachableInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm15UnreachableInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
