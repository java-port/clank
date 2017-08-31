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
//                               ICmpInst Class
//===----------------------------------------------------------------------===//

/// This instruction compares its operands according to the predicate given
/// to the constructor. It only operates on integers or pointers. The operands
/// must be identical types.
/// \brief Represent an integer comparison operator.
//<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1092,
 FQN="llvm::ICmpInst", NM="_ZN4llvm8ICmpInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInstE")
//</editor-fold>
public class ICmpInst extends /*public*/ CmpInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3468,
   FQN="llvm::ICmpInst::anchor", NM="_ZN4llvm8ICmpInst6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::AssertOK">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1095,
   FQN="llvm::ICmpInst::AssertOK", NM="_ZN4llvm8ICmpInst8AssertOKEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst8AssertOKEv")
  //</editor-fold>
  private void AssertOK() {
    assert (getPredicate().getValue() >= CmpInst.Predicate.FIRST_ICMP_PREDICATE.getValue() && getPredicate().getValue() <= CmpInst.Predicate.LAST_ICMP_PREDICATE.getValue()) : "Invalid ICmp predicate value";
    assert (getOperand(0).getType() == getOperand(1).getType()) : "Both operands to ICmp instruction are not of the same type!";
    // Check that the operands are the right type
    assert ((getOperand(0).getType().isIntOrIntVectorTy() || getOperand(0).getType().isPtrOrPtrVectorTy())) : "Invalid operand types for ICmp instruction";
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  /// \brief Clone an identical ICmpInst
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3902,
   FQN="llvm::ICmpInst::cloneImpl", NM="_ZNK4llvm8ICmpInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8ICmpInst9cloneImplEv")
  //</editor-fold>
  protected ICmpInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
        return new ICmpInst(getPredicate(), this./*<0>*/Op$Const(0).$Value$P(), this./*<1>*/Op$Const(1).$Value$P());
     });
  }

/*public:*/
  /// \brief Constructor with insert-before-instruction semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::ICmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1115,
   FQN="llvm::ICmpInst::ICmpInst", NM="_ZN4llvm8ICmpInstC1EPNS_11InstructionENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInstC1EPNS_11InstructionENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE")
  //</editor-fold>
  public ICmpInst(Instruction /*P*/ InsertBefore,  ///< Where to insert
      CmpInst.Predicate pred,  ///< The predicate to use for the comparison
      Value /*P*/ LHS,  ///< The left-hand-side of the expression
      Value /*P*/ RHS) {
    this(InsertBefore,
      pred,
      LHS,
      RHS,  ///< The right-hand-side of the expression
      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public ICmpInst(Instruction /*P*/ InsertBefore,
      CmpInst.Predicate pred,
      Value /*P*/ LHS,
      Value /*P*/ RHS,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    // : CmpInst(makeCmpResultType(LHS->getType()), Instruction::ICmp, pred, LHS, RHS, NameStr, InsertBefore)
    //START JInit
    ///< Name of the instruction
    super(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P.INSTANCE, CmpInst.makeCmpResultType(LHS.getType()),
        Instruction.OtherOps.ICmp, pred, LHS, RHS, NameStr,
        InsertBefore);
    //END JInit
    AssertOK();
  }


  /// \brief Constructor with insert-at-end semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::ICmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1130,
   FQN="llvm::ICmpInst::ICmpInst", NM="_ZN4llvm8ICmpInstC1ERNS_10BasicBlockENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInstC1ERNS_10BasicBlockENS_7CmpInst9PredicateEPNS_5ValueES6_RKNS_5TwineE")
  //</editor-fold>
  public ICmpInst(final BasicBlock /*&*/ InsertAtEnd,  ///< Block to insert into.
      CmpInst.Predicate pred,  ///< The predicate to use for the comparison
      Value /*P*/ LHS,  ///< The left-hand-side of the expression
      Value /*P*/ RHS) {
    this(InsertAtEnd,
      pred,
      LHS,
      RHS,  ///< The right-hand-side of the expression
      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public ICmpInst(final BasicBlock /*&*/ InsertAtEnd,
      CmpInst.Predicate pred,
      Value /*P*/ LHS,
      Value /*P*/ RHS,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    // : CmpInst(makeCmpResultType(LHS->getType()), Instruction::ICmp, pred, LHS, RHS, NameStr, &InsertAtEnd)
    //START JInit
    ///< Name of the instruction
    super(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_BasicBlock$P.INSTANCE, CmpInst.makeCmpResultType(LHS.getType()),
        Instruction.OtherOps.ICmp, pred, LHS, RHS, NameStr,
        $AddrOf(InsertAtEnd));
    //END JInit
    AssertOK();
  }


  /// \brief Constructor with no-insertion semantics
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::ICmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1145,
   FQN="llvm::ICmpInst::ICmpInst", NM="_ZN4llvm8ICmpInstC1ENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInstC1ENS_7CmpInst9PredicateEPNS_5ValueES4_RKNS_5TwineE")
  //</editor-fold>
  public ICmpInst(CmpInst.Predicate pred,  ///< The predicate to use for the comparison
      Value /*P*/ LHS,  ///< The left-hand-side of the expression
      Value /*P*/ RHS) {
    this(pred,
      LHS,
      RHS,  ///< The right-hand-side of the expression
      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public ICmpInst(CmpInst.Predicate pred,
      Value /*P*/ LHS,
      Value /*P*/ RHS,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    // : CmpInst(makeCmpResultType(LHS->getType()), Instruction::ICmp, pred, LHS, RHS, NameStr)
    //START JInit
    ///< Name of the instruction
    super(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P.INSTANCE, CmpInst.makeCmpResultType(LHS.getType()),
        Instruction.OtherOps.ICmp, pred, LHS, RHS, NameStr);
    //END JInit
    AssertOK();
  }


  /// For example, EQ->EQ, SLE->SLE, UGT->SGT, etc.
  /// @returns the predicate that would be the result if the operand were
  /// regarded as signed.
  /// \brief Return the signed version of the predicate
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::getSignedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1161,
   FQN="llvm::ICmpInst::getSignedPredicate", NM="_ZNK4llvm8ICmpInst18getSignedPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8ICmpInst18getSignedPredicateEv")
  //</editor-fold>
  public CmpInst.Predicate getSignedPredicate() /*const*/ {
    return getSignedPredicate(getPredicate());
  }


  /// This is a static version that you can use without an instruction.
  /// \brief Return the signed version of the predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::getSignedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3470,
   FQN="llvm::ICmpInst::getSignedPredicate", NM="_ZN4llvm8ICmpInst18getSignedPredicateENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst18getSignedPredicateENS_7CmpInst9PredicateE")
  //</editor-fold>
  public static ICmpInst.Predicate getSignedPredicate(CmpInst.Predicate pred) {
    switch (pred) {
     default:
      throw new llvm_unreachable("Unknown icmp predicate!");
     case ICMP_EQ:
     case ICMP_NE:
     case ICMP_SGT:
     case ICMP_SLT:
     case ICMP_SGE:
     case ICMP_SLE:
      return pred;
     case ICMP_UGT:
      return Predicate.ICMP_SGT;
     case ICMP_ULT:
      return Predicate.ICMP_SLT;
     case ICMP_UGE:
      return Predicate.ICMP_SGE;
     case ICMP_ULE:
      return Predicate.ICMP_SLE;
    }
  }


  /// For example, EQ->EQ, SLE->ULE, UGT->UGT, etc.
  /// @returns the predicate that would be the result if the operand were
  /// regarded as unsigned.
  /// \brief Return the unsigned version of the predicate
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::getUnsignedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1173,
   FQN="llvm::ICmpInst::getUnsignedPredicate", NM="_ZNK4llvm8ICmpInst20getUnsignedPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8ICmpInst20getUnsignedPredicateEv")
  //</editor-fold>
  public CmpInst.Predicate getUnsignedPredicate() /*const*/ {
    return getUnsignedPredicate(getPredicate());
  }


  /// This is a static version that you can use without an instruction.
  /// \brief Return the unsigned version of the predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::getUnsignedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3483,
   FQN="llvm::ICmpInst::getUnsignedPredicate", NM="_ZN4llvm8ICmpInst20getUnsignedPredicateENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst20getUnsignedPredicateENS_7CmpInst9PredicateE")
  //</editor-fold>
  public static ICmpInst.Predicate getUnsignedPredicate(CmpInst.Predicate pred) {
    switch (pred) {
     default:
      throw new llvm_unreachable("Unknown icmp predicate!");
     case ICMP_EQ:
     case ICMP_NE:
     case ICMP_UGT:
     case ICMP_ULT:
     case ICMP_UGE:
     case ICMP_ULE:
      return pred;
     case ICMP_SGT:
      return Predicate.ICMP_UGT;
     case ICMP_SLT:
      return Predicate.ICMP_ULT;
     case ICMP_SGE:
      return Predicate.ICMP_UGE;
     case ICMP_SLE:
      return Predicate.ICMP_ULE;
    }
  }


  /// isEquality - Return true if this predicate is either EQ or NE.  This also
  /// tests for commutativity.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::isEquality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1183,
   FQN="llvm::ICmpInst::isEquality", NM="_ZN4llvm8ICmpInst10isEqualityENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst10isEqualityENS_7CmpInst9PredicateE")
  //</editor-fold>
  public static boolean isEquality(CmpInst.Predicate P) {
    return P == Predicate.ICMP_EQ || P == Predicate.ICMP_NE;
  }


  /// isEquality - Return true if this predicate is either EQ or NE.  This also
  /// tests for commutativity.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::isEquality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1189,
   FQN="llvm::ICmpInst::isEquality", NM="_ZNK4llvm8ICmpInst10isEqualityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8ICmpInst10isEqualityEv")
  //</editor-fold>
  public boolean isEquality() /*const*/ {
    return ICmpInst.isEquality(getPredicate());
  }


  /// @returns true if the predicate of this ICmpInst is commutative
  /// \brief Determine if this relation is commutative.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::isCommutative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1195,
   FQN="llvm::ICmpInst::isCommutative", NM="_ZNK4llvm8ICmpInst13isCommutativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8ICmpInst13isCommutativeEv")
  //</editor-fold>
  public boolean isCommutative() /*const*/ {
    return isEquality();
  }


  /// isRelational - Return true if the predicate is relational (not EQ or NE).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::isRelational">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1199,
   FQN="llvm::ICmpInst::isRelational", NM="_ZNK4llvm8ICmpInst12isRelationalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8ICmpInst12isRelationalEv")
  //</editor-fold>
  public boolean isRelational() /*const*/ {
    return !isEquality();
  }


  /// isRelational - Return true if the predicate is relational (not EQ or NE).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::isRelational">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1205,
   FQN="llvm::ICmpInst::isRelational", NM="_ZN4llvm8ICmpInst12isRelationalENS_7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst12isRelationalENS_7CmpInst9PredicateE")
  //</editor-fold>
  public static boolean isRelational(CmpInst.Predicate P) {
    return !ICmpInst.isEquality(P);
  }


  /// Initialize a set of values that all satisfy the predicate with C.
  /// \brief Make a ConstantRange for a relation with a constant value.

  /// Initialize a set of values that all satisfy the condition with C.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::makeConstantRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3498,
   FQN="llvm::ICmpInst::makeConstantRange", NM="_ZN4llvm8ICmpInst17makeConstantRangeENS_7CmpInst9PredicateERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst17makeConstantRangeENS_7CmpInst9PredicateERKNS_5APIntE")
  //</editor-fold>
  public static ConstantRange makeConstantRange(CmpInst.Predicate pred, final /*const*/ APInt /*&*/ C) {
    APInt Lower/*J*/= new APInt(C);
    APInt Upper/*J*/= new APInt(C);
    /*uint32_t*/int BitWidth = C.getBitWidth();
    switch (pred) {
     default:
      throw new llvm_unreachable("Invalid ICmp opcode to ConstantRange ctor!");
     case ICMP_EQ:
      Upper.$preInc();
      break;
     case ICMP_NE:
      Lower.$preInc();
      break;
     case ICMP_ULT:
      Lower.$assignMove(APInt.getMinValue(BitWidth));
      // Check for an empty-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ false);
      }
      break;
     case ICMP_SLT:
      Lower.$assignMove(APInt.getSignedMinValue(BitWidth));
      // Check for an empty-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ false);
      }
      break;
     case ICMP_UGT:
      Lower.$preInc();
      Upper.$assignMove(APInt.getMinValue(BitWidth)); // Min = Next(Max)
      // Check for an empty-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ false);
      }
      break;
     case ICMP_SGT:
      Lower.$preInc();
      Upper.$assignMove(APInt.getSignedMinValue(BitWidth)); // Min = Next(Max)
      // Check for an empty-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ false);
      }
      break;
     case ICMP_ULE:
      Lower.$assignMove(APInt.getMinValue(BitWidth));
      Upper.$preInc();
      // Check for a full-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ true);
      }
      break;
     case ICMP_SLE:
      Lower.$assignMove(APInt.getSignedMinValue(BitWidth));
      Upper.$preInc();
      // Check for a full-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ true);
      }
      break;
     case ICMP_UGE:
      Upper.$assignMove(APInt.getMinValue(BitWidth)); // Min = Next(Max)
      // Check for a full-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ true);
      }
      break;
     case ICMP_SGE:
      Upper.$assignMove(APInt.getSignedMinValue(BitWidth)); // Min = Next(Max)
      // Check for a full-set condition.
      if (Lower.$eq(Upper)) {
        return new ConstantRange(BitWidth, /*isFullSet=*/ true);
      }
      break;
    }
    return new ConstantRange(new APInt(Lower), new APInt(Upper));
  }


  /// Exchange the two operands to this instruction in such a way that it does
  /// not modify the semantics of the instruction. The predicate value may be
  /// changed to retain the same result if the predicate is order dependent
  /// (e.g. ult).
  /// \brief Swap operands and adjust predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::swapOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1218,
   FQN="llvm::ICmpInst::swapOperands", NM="_ZN4llvm8ICmpInst12swapOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst12swapOperandsEv")
  //</editor-fold>
  public void swapOperands() {
    setPredicate(getSwappedPredicate());
    this./*<0>*/Op(0).swap(this./*<1>*/Op(1));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1224,
   FQN="llvm::ICmpInst::classof", NM="_ZN4llvm8ICmpInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.ICmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1227,
   FQN="llvm::ICmpInst::classof", NM="_ZN4llvm8ICmpInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && ICmpInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ICmpInst::~ICmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1092,
   FQN="llvm::ICmpInst::~ICmpInst", NM="_ZN4llvm8ICmpInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8ICmpInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
