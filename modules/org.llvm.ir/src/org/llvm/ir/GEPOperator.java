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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import static org.llvm.pass.IrLlvmGlobals.gep_type_begin_User$C$P;
import static org.llvm.pass.IrLlvmGlobals.gep_type_end_User$C$P;

//<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 364,
 FQN="llvm::GEPOperator", NM="_ZN4llvm11GEPOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperatorE")
//</editor-fold>
public class GEPOperator extends /*public*/ ConcreteOperatorOperator/*Instruction.MemoryOps.GetElementPtr.getValue()*/ implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 366,
   FQN="llvm::GEPOperator::(anonymous)", NM="_ZN4llvm11GEPOperatorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperatorE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int IsInBounds = (1 << 0);
  /*}*/;

  public GEPOperator() {
  }

  /*friend  class GetElementPtrInst*/
  /*friend  class ConstantExpr*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::setIsInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 372,
   FQN="llvm::GEPOperator::setIsInBounds", NM="_ZN4llvm11GEPOperator13setIsInBoundsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperator13setIsInBoundsEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setIsInBounds(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~IsInBounds) | ((B ? 1 : 0) * IsInBounds)));
  }

/*public:*/
  /// Test whether this is an inbounds GEP, as defined by LangRef.html.
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::isInBounds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 379,
   FQN="llvm::GEPOperator::isInBounds", NM="_ZNK4llvm11GEPOperator10isInBoundsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator10isInBoundsEv")
  //</editor-fold>
  public boolean isInBounds() /*const*/ {
    return (($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & IsInBounds) != 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::idx_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 383,
   FQN="llvm::GEPOperator::idx_begin", NM="_ZN4llvm11GEPOperator9idx_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperator9idx_beginEv")
  //</editor-fold>
  public /*inline*/ type$ptr<Use /*P*/> idx_begin() {
    return op_begin().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::idx_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 384,
   FQN="llvm::GEPOperator::idx_begin", NM="_ZNK4llvm11GEPOperator9idx_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator9idx_beginEv")
  //</editor-fold>
  public /*inline*/ /*const*/type$ptr<Use /*P*/> idx_begin$Const() /*const*/ {
    return op_begin$Const().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::idx_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 385,
   FQN="llvm::GEPOperator::idx_end", NM="_ZN4llvm11GEPOperator7idx_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperator7idx_endEv")
  //</editor-fold>
  public /*inline*/ type$ptr<Use /*P*/> idx_end() {
    return op_end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::idx_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 386,
   FQN="llvm::GEPOperator::idx_end", NM="_ZNK4llvm11GEPOperator7idx_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator7idx_endEv")
  //</editor-fold>
  public /*inline*/ /*const*/type$ptr<Use /*P*/> idx_end$Const() /*const*/ {
    return op_end$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 388,
   FQN="llvm::GEPOperator::getPointerOperand", NM="_ZN4llvm11GEPOperator17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperator17getPointerOperandEv")
  //</editor-fold>
  public Value /*P*/ getPointerOperand() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getPointerOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 391,
   FQN="llvm::GEPOperator::getPointerOperand", NM="_ZNK4llvm11GEPOperator17getPointerOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator17getPointerOperandEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getPointerOperand$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getPointerOperandIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 394,
   FQN="llvm::GEPOperator::getPointerOperandIndex", NM="_ZN4llvm11GEPOperator22getPointerOperandIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperator22getPointerOperandIndexEv")
  //</editor-fold>
  public static /*uint*/int getPointerOperandIndex() {
    return 0/*U*/; // get index for modifying correct operand
  }


  /// Method to return the pointer operand as a PointerType.
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getPointerOperandType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 399,
   FQN="llvm::GEPOperator::getPointerOperandType", NM="_ZNK4llvm11GEPOperator21getPointerOperandTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator21getPointerOperandTypeEv")
  //</editor-fold>
  public Type /*P*/ getPointerOperandType() /*const*/ {
    return getPointerOperand$Const().getType();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getSourceElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Operator.cpp", line = 9,
   FQN="llvm::GEPOperator::getSourceElementType", NM="_ZNK4llvm11GEPOperator20getSourceElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator20getSourceElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getSourceElementType() /*const*/ {
    {
      /*const*/ GetElementPtrInst /*P*/ I = dyn_cast_GetElementPtrInst(this);
      if ((I != null)) {
        return I.getSourceElementType();
      }
    }
    return cast_GetElementPtrConstantExpr(this).getSourceElementType();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getResultElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Operator.cpp", line = 15,
   FQN="llvm::GEPOperator::getResultElementType", NM="_ZNK4llvm11GEPOperator20getResultElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator20getResultElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getResultElementType() /*const*/ {
    {
      /*const*/ GetElementPtrInst /*P*/ I = dyn_cast_GetElementPtrInst(this);
      if ((I != null)) {
        return I.getResultElementType();
      }
    }
    return cast_GetElementPtrConstantExpr(this).getResultElementType();
  }


  /// Method to return the address space of the pointer operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getPointerAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 407,
   FQN="llvm::GEPOperator::getPointerAddressSpace", NM="_ZNK4llvm11GEPOperator22getPointerAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator22getPointerAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getPointerAddressSpace() /*const*/ {
    return getPointerOperandType().getPointerAddressSpace();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::getNumIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 411,
   FQN="llvm::GEPOperator::getNumIndices", NM="_ZNK4llvm11GEPOperator13getNumIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator13getNumIndicesEv")
  //</editor-fold>
  public /*uint*/int getNumIndices() /*const*/ {
    // Note: always non-negative
    return getNumOperands() - 1;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::hasIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 415,
   FQN="llvm::GEPOperator::hasIndices", NM="_ZNK4llvm11GEPOperator10hasIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator10hasIndicesEv")
  //</editor-fold>
  public boolean hasIndices() /*const*/ {
    return $greater_uint(getNumOperands(), 1);
  }


  /// Return true if all of the indices of this GEP are zeros.
  /// If so, the result pointer and the first operand have the same
  /// value, just potentially different types.
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::hasAllZeroIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 422,
   FQN="llvm::GEPOperator::hasAllZeroIndices", NM="_ZNK4llvm11GEPOperator17hasAllZeroIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator17hasAllZeroIndicesEv")
  //</editor-fold>
  public boolean hasAllZeroIndices() /*const*/ {
    for (/*const*/type$ptr<Use /*P*/> I = $tryClone(idx_begin$Const()), /*P*/ E = $tryClone(idx_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      {
        ConstantInt /*P*/ C = dyn_cast_ConstantInt(I);
        if ((C != null)) {
          if (C.isZero()) {
            continue;
          }
        }
      }
      return false;
    }
    return true;
  }


  /// Return true if all of the indices of this GEP are constant integers.
  /// If so, the result pointer and the first operand have
  /// a constant offset between them.
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::hasAllConstantIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 435,
   FQN="llvm::GEPOperator::hasAllConstantIndices", NM="_ZNK4llvm11GEPOperator21hasAllConstantIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator21hasAllConstantIndicesEv")
  //</editor-fold>
  public boolean hasAllConstantIndices() /*const*/ {
    for (/*const*/type$ptr<Use /*P*/> I = $tryClone(idx_begin$Const()), /*P*/ E = $tryClone(idx_end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      if (!isa_ConstantInt(I)) {
        return false;
      }
    }
    return true;
  }


  /// \brief Accumulate the constant address offset of this GEP if possible.
  ///
  /// This routine accepts an APInt into which it will accumulate the constant
  /// offset of this GEP if the GEP is in fact constant. If the GEP is not
  /// all-constant, it returns false and the value of the offset APInt is
  /// undefined (it is *not* preserved!). The APInt passed into this routine
  /// must be at exactly as wide as the IntPtr type for the address space of the
  /// base GEP pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::accumulateConstantOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Operator.cpp", line = 21,
   FQN="llvm::GEPOperator::accumulateConstantOffset", NM="_ZNK4llvm11GEPOperator24accumulateConstantOffsetERKNS_10DataLayoutERNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm11GEPOperator24accumulateConstantOffsetERKNS_10DataLayoutERNS_5APIntE")
  //</editor-fold>
  public boolean accumulateConstantOffset(final /*const*/ DataLayout /*&*/ DL,
                          final APInt /*&*/ Offset) /*const*/ {
    assert (Offset.getBitWidth() == DL.getPointerSizeInBits(getPointerAddressSpace())) : "The offset must have exactly as many bits as our pointer.";

    for (generic_gep_type_iterator GTI = gep_type_begin_User$C$P(this), GTE = gep_type_end_User$C$P(this);
         GTI.$noteq(GTE); GTI.$preInc()) {
      ConstantInt /*P*/ OpC = dyn_cast_ConstantInt(GTI.getOperand());
      if (!(OpC != null)) {
        return false;
      }
      if (OpC.isZero()) {
        continue;
      }
      {

        // Handle a struct index, which adds its field offset to the pointer.
        StructType /*P*/ STy = dyn_cast_StructType(GTI.$star());
        if ((STy != null)) {
          /*uint*/int ElementIdx = $ulong2uint(OpC.getZExtValue());
          /*const*/ StructLayout /*P*/ SL = DL.getStructLayout(STy);
          Offset.$addassign(new APInt(JD$UInt_ULong.INSTANCE, Offset.getBitWidth(), SL.getElementOffset(ElementIdx)));
          continue;
        }
      }

      // For array or vector indices, scale the index by the size of the type.
      APInt Index = OpC.getValue().sextOrTrunc(Offset.getBitWidth());
      Offset.$addassign(Index.$star(new APInt(JD$UInt_ULong.INSTANCE, Offset.getBitWidth(),
                  DL.getTypeAllocSize(GTI.getIndexedType()))));
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GEPOperator::~GEPOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 364,
   FQN="llvm::GEPOperator::~GEPOperator", NM="_ZN4llvm11GEPOperatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm11GEPOperatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static /*inline*/ boolean classof(/*const*/Instruction /*P*/ From) {
    return ConcreteOperator.classof(From, Instruction.MemoryOps.GetElementPtr);
  }

  public static /*inline*/ boolean classof(/*const*/ConstantExpr /*P*/ From) {
    return ConcreteOperator.classof(From, Instruction.MemoryOps.GetElementPtr);
  }

  public static boolean classof(Value From) {
    return ConcreteOperator.classof(From, Instruction.MemoryOps.GetElementPtr);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
