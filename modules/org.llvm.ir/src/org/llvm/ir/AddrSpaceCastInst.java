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
import org.clank.support.aliases.type$ptr;
import static org.clank.support.literal_constants.$EMPTY;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                          AddrSpaceCastInst Class
//===----------------------------------------------------------------------===//

/// \brief This class represents a conversion between pointers from
/// one address space to another.
//<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4888,
 FQN="llvm::AddrSpaceCastInst", NM="_ZN4llvm17AddrSpaceCastInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInstE")
//</editor-fold>
public class AddrSpaceCastInst extends /*public*/ CastInst implements Destructors.ClassWithDestructor {
/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  /// \brief Clone an identical AddrSpaceCastInst
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4003,
   FQN="llvm::AddrSpaceCastInst::cloneImpl", NM="_ZNK4llvm17AddrSpaceCastInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AddrSpaceCastInst9cloneImplEv")
  //</editor-fold>
  protected AddrSpaceCastInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
        return new AddrSpaceCastInst(getOperand(0), getType());
     });
  }

/*public:*/
  /// \brief Constructor with insert-before-instruction semantics
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::AddrSpaceCastInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3342,
   FQN="llvm::AddrSpaceCastInst::AddrSpaceCastInst", NM="_ZN4llvm17AddrSpaceCastInstC1EPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInstC1EPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public AddrSpaceCastInst(Value /*P*/ S, Type /*P*/ Ty) {
    this(S, Ty, new Twine(///< The type to casted to
      /*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  public AddrSpaceCastInst(Value /*P*/ S, Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(S, Ty, Name, (Instruction /*P*/ )null);
  }
  public AddrSpaceCastInst(Value /*P*/ S, Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name/*= ""*/, Instruction /*P*/ InsertBefore/*= null*/) {
    // : CastInst(Ty, AddrSpaceCast, S, Name, InsertBefore) 
    //START JInit
    super(Ty, CastOps.AddrSpaceCast, S, Name, InsertBefore);
    //END JInit
    assert (castIsValid(getOpcode(), S, Ty)) : "Illegal AddrSpaceCast";
  }

  
  /// \brief Constructor with insert-at-end-of-block semantics
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::AddrSpaceCastInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3348,
   FQN="llvm::AddrSpaceCastInst::AddrSpaceCastInst", NM="_ZN4llvm17AddrSpaceCastInstC1EPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInstC1EPNS_5ValueEPNS_4TypeERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public AddrSpaceCastInst(Value /*P*/ S, Type /*P*/ Ty, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAtEnd) {
    // : CastInst(Ty, AddrSpaceCast, S, Name, InsertAtEnd) 
    //START JInit
    super(Ty, CastOps.AddrSpaceCast, S, Name, InsertAtEnd);
    //END JInit
    assert (castIsValid(getOpcode(), S, Ty)) : "Illegal AddrSpaceCast";
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4913,
   FQN="llvm::AddrSpaceCastInst::classof", NM="_ZN4llvm17AddrSpaceCastInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == CastOps.AddrSpaceCast;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4916,
   FQN="llvm::AddrSpaceCastInst::classof", NM="_ZN4llvm17AddrSpaceCastInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && AddrSpaceCastInst.classof(cast_Instruction(V));
  }

  
  /// \brief Gets the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4921,
   FQN="llvm::AddrSpaceCastInst::getPointerOperand", NM="_ZN4llvm17AddrSpaceCastInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInst17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(0);
  }

  
  /// \brief Gets the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4926,
   FQN="llvm::AddrSpaceCastInst::getPointerOperand", NM="_ZNK4llvm17AddrSpaceCastInst17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AddrSpaceCastInst17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(0);
  }

  
  /// \brief Gets the operand index of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4931,
   FQN="llvm::AddrSpaceCastInst::getPointerOperandIndex", NM="_ZN4llvm17AddrSpaceCastInst22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInst22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 0/*U*/;
  }

  
  /// \brief Returns the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::getSrcAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4936,
   FQN="llvm::AddrSpaceCastInst::getSrcAddressSpace", NM="_ZNK4llvm17AddrSpaceCastInst18getSrcAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AddrSpaceCastInst18getSrcAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getSrcAddressSpace() /*const*/ {
    return getPointerOperand$Const().getType().getPointerAddressSpace();
  }

  
  /// \brief Returns the address space of the result.
  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::getDestAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4941,
   FQN="llvm::AddrSpaceCastInst::getDestAddressSpace", NM="_ZNK4llvm17AddrSpaceCastInst19getDestAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm17AddrSpaceCastInst19getDestAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getDestAddressSpace() /*const*/ {
    return getType().getPointerAddressSpace();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AddrSpaceCastInst::~AddrSpaceCastInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4888,
   FQN="llvm::AddrSpaceCastInst::~AddrSpaceCastInst", NM="_ZN4llvm17AddrSpaceCastInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm17AddrSpaceCastInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
