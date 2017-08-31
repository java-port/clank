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
//                               FCmpInst Class
//===----------------------------------------------------------------------===//

/// This instruction compares its operands according to the predicate given
/// to the constructor. It only operates on floating point values or packed
/// vectors of floating point values. The operands must be identical types.
/// \brief Represents a floating point comparison operator.
//<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1240,
 FQN="llvm::FCmpInst", NM="_ZN4llvm8FCmpInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInstE")
//</editor-fold>
public class FCmpInst extends /*public*/ CmpInst implements Destructors.ClassWithDestructor {
/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  /// \brief Clone an identical FCmpInst
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3898,
   FQN="llvm::FCmpInst::cloneImpl", NM="_ZNK4llvm8FCmpInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8FCmpInst9cloneImplEv")
  //</editor-fold>
  protected FCmpInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
        return new FCmpInst(getPredicate(), this./*<0>*/Op$Const(0).$Value$P(), this./*<1>*/Op$Const(1).$Value$P());
     });
  }

/*public:*/
  /// \brief Constructor with insert-before-instruction semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::FCmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1249,
   FQN="llvm::FCmpInst::FCmpInst", NM="_ZN4llvm8FCmpInstC1EPNS_11InstructionENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInstC1EPNS_11InstructionENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE")
  //</editor-fold>
  public FCmpInst(Instruction /*P*/ InsertBefore,  ///< Where to insert
      CmpInst.Predicate pred,  ///< The predicate to use for the comparison
      Value /*P*/ LHS,  ///< The left-hand-side of the expression
      Value /*P*/ RHS) {
    this(InsertBefore,
      pred,
      LHS,
      RHS,  ///< The right-hand-side of the expression
      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public FCmpInst(Instruction /*P*/ InsertBefore,
      CmpInst.Predicate pred,
      Value /*P*/ LHS,
      Value /*P*/ RHS,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    // : CmpInst(makeCmpResultType(LHS->getType()), Instruction::FCmp, pred, LHS, RHS, NameStr, InsertBefore)
    //START JInit
    ///< Name of the instruction
    super(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P.INSTANCE, CmpInst.makeCmpResultType(LHS.getType()),
        Instruction.OtherOps.FCmp, pred, LHS, RHS, NameStr,
        InsertBefore);    //END JInit
    assert (pred.getValue() <= FCmpInst.Predicate.LAST_FCMP_PREDICATE.getValue()) : "Invalid FCmp predicate value";
    assert (getOperand(0).getType() == getOperand(1).getType()) : "Both operands to FCmp instruction are not of the same type!";
    // Check that the operands are the right type
    assert (getOperand(0).getType().isFPOrFPVectorTy()) : "Invalid operand types for FCmp instruction";
  }


  /// \brief Constructor with insert-at-end semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::FCmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1268,
   FQN="llvm::FCmpInst::FCmpInst", NM="_ZN4llvm8FCmpInstC1ERNS_10BasicBlockENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInstC1ERNS_10BasicBlockENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE")
  //</editor-fold>
  public FCmpInst(final BasicBlock /*&*/ InsertAtEnd,  ///< Block to insert into.
      CmpInst.Predicate pred,  ///< The predicate to use for the comparison
      Value /*P*/ LHS,  ///< The left-hand-side of the expression
      Value /*P*/ RHS) {
    this(InsertAtEnd,
      pred,
      LHS,
      RHS,  ///< The right-hand-side of the expression
      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public FCmpInst(final BasicBlock /*&*/ InsertAtEnd,
      CmpInst.Predicate pred,
      Value /*P*/ LHS,
      Value /*P*/ RHS,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    // : CmpInst(makeCmpResultType(LHS->getType()), Instruction::FCmp, pred, LHS, RHS, NameStr, &InsertAtEnd)
    //START JInit
    ///< Name of the instruction
    super(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_BasicBlock$P.INSTANCE, CmpInst.makeCmpResultType(LHS.getType()),
        Instruction.OtherOps.FCmp, pred, LHS, RHS, NameStr,
        $AddrOf(InsertAtEnd));
    //END JInit
    assert (pred.getValue() <= FCmpInst.Predicate.LAST_FCMP_PREDICATE.getValue()) : "Invalid FCmp predicate value";
    assert (getOperand(0).getType() == getOperand(1).getType()) : "Both operands to FCmp instruction are not of the same type!";
    // Check that the operands are the right type
    assert (getOperand(0).getType().isFPOrFPVectorTy()) : "Invalid operand types for FCmp instruction";
  }


  /// \brief Constructor with no-insertion semantics
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::FCmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1287,
   FQN="llvm::FCmpInst::FCmpInst", NM="_ZN4llvm8FCmpInstC1ENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInstC1ENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public FCmpInst(CmpInst.Predicate pred,  ///< The predicate to use for the comparison
      Value /*P*/ LHS,  ///< The left-hand-side of the expression
      Value /*P*/ RHS) {
    this(pred,
      LHS,
      RHS,  ///< The right-hand-side of the expression
      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public FCmpInst(CmpInst.Predicate pred,
      Value /*P*/ LHS,
      Value /*P*/ RHS,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    // : CmpInst(makeCmpResultType(LHS->getType()), Instruction::FCmp, pred, LHS, RHS, NameStr)
    //START JInit
    ///< Name of the instruction
    super(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P.INSTANCE, CmpInst.makeCmpResultType(LHS.getType()),
        Instruction.OtherOps.FCmp, pred, LHS, RHS, NameStr);
    //END JInit
    assert (pred.getValue() <= FCmpInst.Predicate.LAST_FCMP_PREDICATE.getValue()) : "Invalid FCmp predicate value";
    assert (getOperand(0).getType() == getOperand(1).getType()) : "Both operands to FCmp instruction are not of the same type!";
    // Check that the operands are the right type
    assert (getOperand(0).getType().isFPOrFPVectorTy()) : "Invalid operand types for FCmp instruction";
  }


  /// @returns true if the predicate of this instruction is EQ or NE.
  /// \brief Determine if this is an equality predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::isEquality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1305,
   FQN="llvm::FCmpInst::isEquality", NM="_ZN4llvm8FCmpInst10isEqualityENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInst10isEqualityENS_7CmpInst9PredicateE")
  //</editor-fold>
  public static boolean isEquality(CmpInst.Predicate Pred) {
    return Pred == Predicate.FCMP_OEQ || Pred == Predicate.FCMP_ONE || Pred == Predicate.FCMP_UEQ
       || Pred == Predicate.FCMP_UNE;
  }


  /// @returns true if the predicate of this instruction is EQ or NE.
  /// \brief Determine if this is an equality predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::isEquality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1312,
   FQN="llvm::FCmpInst::isEquality", NM="_ZNK4llvm8FCmpInst10isEqualityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8FCmpInst10isEqualityEv")
  //</editor-fold>
  public boolean isEquality() /*const*/ {
    return FCmpInst.isEquality(getPredicate());
  }


  /// @returns true if the predicate of this instruction is commutative.
  /// \brief Determine if this is a commutative predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::isCommutative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1316,
   FQN="llvm::FCmpInst::isCommutative", NM="_ZNK4llvm8FCmpInst13isCommutativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8FCmpInst13isCommutativeEv")
  //</editor-fold>
  public boolean isCommutative() /*const*/ {
    return isEquality()
       || getPredicate() == Predicate.FCMP_FALSE
       || getPredicate() == Predicate.FCMP_TRUE
       || getPredicate() == Predicate.FCMP_ORD
       || getPredicate() == Predicate.FCMP_UNO;
  }


  /// @returns true if the predicate is relational (not EQ or NE).
  /// \brief Determine if this a relational predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::isRelational">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1326,
   FQN="llvm::FCmpInst::isRelational", NM="_ZNK4llvm8FCmpInst12isRelationalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8FCmpInst12isRelationalEv")
  //</editor-fold>
  public boolean isRelational() /*const*/ {
    return !isEquality();
  }


  /// Exchange the two operands to this instruction in such a way that it does
  /// not modify the semantics of the instruction. The predicate value may be
  /// changed to retain the same result if the predicate is order dependent
  /// (e.g. ult).
  /// \brief Swap operands and adjust predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::swapOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1333,
   FQN="llvm::FCmpInst::swapOperands", NM="_ZN4llvm8FCmpInst12swapOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInst12swapOperandsEv")
  //</editor-fold>
  public void swapOperands() {
    setPredicate(getSwappedPredicate());
    this./*<0>*/Op(0).swap(this./*<1>*/Op(1));
  }


  /// \brief Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1339,
   FQN="llvm::FCmpInst::classof", NM="_ZN4llvm8FCmpInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.FCmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1342,
   FQN="llvm::FCmpInst::classof", NM="_ZN4llvm8FCmpInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && FCmpInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FCmpInst::~FCmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1240,
   FQN="llvm::FCmpInst::~FCmpInst", NM="_ZN4llvm8FCmpInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8FCmpInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
