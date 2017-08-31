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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;


//===----------------------------------------------------------------------===//
//                               CmpInst Class
//===----------------------------------------------------------------------===//

/// This class is the base class for the comparison instructions.
/// @brief Abstract base class of comparison instructions.
//<editor-fold defaultstate="collapsed" desc="llvm::CmpInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 856,
 FQN="llvm::CmpInst", NM="_ZN4llvm7CmpInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstE")
//</editor-fold>
public class CmpInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
/*public:*/
  /// This enumeration lists the possible predicates for CmpInst subclasses.
  /// Values in the range 0-31 are reserved for FCmpInst, while values in the
  /// range 32-64 are reserved for ICmpInst. This is necessary to ensure the
  /// predicate values are not overlapping between the classes.
  ///
  /// Some passes (e.g. InstCombine) depend on the bit-wise characteristics of
  /// FCMP_* values. Changing the bit patterns requires a potential change to
  /// those passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::Predicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 866,
   FQN="llvm::CmpInst::Predicate", NM="_ZN4llvm7CmpInst9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst9PredicateE")
  //</editor-fold>
  public enum Predicate implements Native.NativeUShortEnum {
    // Opcode              U L G E    Intuitive operation
    FCMP_FALSE(0), ///< 0 0 0 0    Always false (always folded)
    FCMP_OEQ(1), ///< 0 0 0 1    True if ordered and equal
    FCMP_OGT(2), ///< 0 0 1 0    True if ordered and greater than
    FCMP_OGE(3), ///< 0 0 1 1    True if ordered and greater than or equal
    FCMP_OLT(4), ///< 0 1 0 0    True if ordered and less than
    FCMP_OLE(5), ///< 0 1 0 1    True if ordered and less than or equal
    FCMP_ONE(6), ///< 0 1 1 0    True if ordered and operands are unequal
    FCMP_ORD(7), ///< 0 1 1 1    True if ordered (no nans)
    FCMP_UNO(8), ///< 1 0 0 0    True if unordered: isnan(X) | isnan(Y)
    FCMP_UEQ(9), ///< 1 0 0 1    True if unordered or equal
    FCMP_UGT(10), ///< 1 0 1 0    True if unordered or greater than
    FCMP_UGE(11), ///< 1 0 1 1    True if unordered, greater than, or equal
    FCMP_ULT(12), ///< 1 1 0 0    True if unordered or less than
    FCMP_ULE(13), ///< 1 1 0 1    True if unordered, less than, or equal
    FCMP_UNE(14), ///< 1 1 1 0    True if unordered or not equal
    FCMP_TRUE(15), ///< 1 1 1 1    Always true (always folded)
    FIRST_FCMP_PREDICATE(Predicate.FCMP_FALSE.getValue()),
    LAST_FCMP_PREDICATE(Predicate.FCMP_TRUE.getValue()),
    BAD_FCMP_PREDICATE(Predicate.FCMP_TRUE.getValue() + 1),
    ICMP_EQ(32), ///< equal
    ICMP_NE(33), ///< not equal
    ICMP_UGT(34), ///< unsigned greater than
    ICMP_UGE(35), ///< unsigned greater or equal
    ICMP_ULT(36), ///< unsigned less than
    ICMP_ULE(37), ///< unsigned less or equal
    ICMP_SGT(38), ///< signed greater than
    ICMP_SGE(39), ///< signed greater or equal
    ICMP_SLT(40), ///< signed less than
    ICMP_SLE(41), ///< signed less or equal
    FIRST_ICMP_PREDICATE(Predicate.ICMP_EQ.getValue()),
    LAST_ICMP_PREDICATE(Predicate.ICMP_SLE.getValue()),
    BAD_ICMP_PREDICATE(Predicate.ICMP_SLE.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Predicate valueOf(int val) {
      Predicate out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Predicate[] VALUES;
      private static final Predicate[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Predicate kind : Predicate.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Predicate[min < 0 ? (1-min) : 0];
        VALUES = new Predicate[max >= 0 ? (1+max) : 0];
        for (Predicate kind : Predicate.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/char value;
    private Predicate(int val) { this.value = $uint2ushort(val);}
    @Override public final /*ushort*/char getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 903,
   FQN="llvm::CmpInst::operator new", NM="_ZN4llvm7CmpInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_CmpInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::CmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 904,
   FQN="llvm::CmpInst::CmpInst", NM="_ZN4llvm7CmpInstC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstC1Ev")
  //</editor-fold>
  protected/*private*/ CmpInst() { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::CmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3360,
   FQN="llvm::CmpInst::CmpInst", NM="_ZN4llvm7CmpInstC1EPNS_4TypeENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES7_RKNS_5TwineEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstC1EPNS_4TypeENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES7_RKNS_5TwineEPS3_")
  //</editor-fold>
  protected/*protected*/ CmpInst(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P _dparam, Type /*P*/ ty, /*OtherOps*/int op, Predicate predicate, Value /*P*/ LHS, 
      Value /*P*/ RHS) {
    this(_dparam, ty, op, predicate, LHS, 
      RHS, new Twine(/*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  protected/*protected*/ CmpInst(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P _dparam, Type /*P*/ ty, /*OtherOps*/int op, Predicate predicate, Value /*P*/ LHS, 
      Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    this(_dparam, ty, op, predicate, LHS, 
      RHS, Name, (Instruction /*P*/ )null);
  }
  protected/*protected*/ CmpInst(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_Instruction$P _dparam, Type /*P*/ ty, /*OtherOps*/int op, Predicate predicate, Value /*P*/ LHS, 
      Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name/*= ""*/, Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(ty, op, OperandTraits<CmpInst>::op_begin(this), OperandTraits<CmpInst>::operands(this), InsertBefore) 
    //START JInit
    super(ty, op, 
        OperandTraitsCmpInst.<CmpInst>op_begin(User.$BEING_CREATED()),
        OperandTraitsCmpInst.<CmpInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertBefore);
    //END JInit
    this./*<0>*/Op(0).$assign(LHS);
    this./*<1>*/Op(1).$assign(RHS);
    setPredicate((Predicate)predicate);
    setName(Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::CmpInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3372,
   FQN="llvm::CmpInst::CmpInst", NM="_ZN4llvm7CmpInstC1EPNS_4TypeENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES7_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstC1EPNS_4TypeENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES7_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  protected/*protected*/ CmpInst(JD$Type$P_OtherOps_Predicate_Value$P_Twine$C_BasicBlock$P _dparam, Type /*P*/ ty, /*OtherOps*/int op, Predicate predicate, Value /*P*/ LHS, 
      Value /*P*/ RHS, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(ty, op, OperandTraits<CmpInst>::op_begin(this), OperandTraits<CmpInst>::operands(this), InsertAtEnd) 
    //START JInit
    super(ty, op, 
        OperandTraitsCmpInst.<CmpInst>op_begin(User.$BEING_CREATED()),
        OperandTraitsCmpInst.<CmpInst>operands$FixedNumOperandTraits(User.$BEING_CREATED()),
        InsertAtEnd);
    //END JInit
    this./*<0>*/Op(0).$assign(LHS);
    this./*<1>*/Op(1).$assign(RHS);
    setPredicate(((Predicate)predicate));
    setName(Name);
  }

  
  
  //===----------------------------------------------------------------------===//
  //                               CmpInst Classes
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3358,
   FQN="llvm::CmpInst::anchor", NM="_ZN4llvm7CmpInst6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst6anchorEv")
  //</editor-fold>
  @Override protected void anchor()/* override*/ {
  }
 // Out of line virtual method.
/*public:*/
  // allocate space for exactly two operands
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 919,
   FQN="llvm::CmpInst::operator new", NM="_ZN4llvm7CmpInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstnwEj")
  //</editor-fold>
  public static <T extends CmpInst> T/*void P*/ $new_CmpInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */2, $Ctor);
  }

  /// Construct a compare instruction, given the opcode, the predicate and
  /// the two operands.  Optionally (if InstBefore is specified) ins  ert the
  /// instruction into a BasicBlock right before the specified instruction.
  /// The specified Instruction is allowed to be a dereferenced end iterator.
  /// @brief Create a CmpInst
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3384,
   FQN="llvm::CmpInst::Create", NM="_ZN4llvm7CmpInst6CreateENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES5_RKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst6CreateENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES5_RKNS_5TwineEPS1_")
  //</editor-fold>
  public static CmpInst /*P*/ Create(/*OtherOps*/int Op, Predicate predicate, Value /*P*/ S1, Value /*P*/ S2) {
    return Create(Op, predicate, S1, S2, 
        new Twine(/*KEEP_STR*/$EMPTY), (Instruction /*P*/ )null);
  }
  public static CmpInst /*P*/ Create(/*OtherOps*/int Op, Predicate predicate, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return Create(Op, predicate, S1, S2, 
        Name, (Instruction /*P*/ )null);
  }
  public static CmpInst /*P*/ Create(/*OtherOps*/int Op, Predicate predicate, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ Name/*= ""*/, Instruction /*P*/ InsertBefore/*= null*/) {
    if (Op == Instruction.OtherOps.ICmp) {
      if ((InsertBefore != null)) {
        return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
            return new ICmpInst(InsertBefore, ((CmpInst.Predicate)(predicate)), 
                    S1, S2, Name);
         });
      } else {
        return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
            return new ICmpInst(((CmpInst.Predicate)(predicate)), 
                    S1, S2, Name);
         });
      }
    }
    if ((InsertBefore != null)) {
      return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
          return new FCmpInst(InsertBefore, ((CmpInst.Predicate)(predicate)), 
                  S1, S2, Name);
       });
    } else {
      return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
          return new FCmpInst(((CmpInst.Predicate)(predicate)), 
                  S1, S2, Name);
       });
    }
  }

  
  /// Construct a compare instruction, given the opcode, the predicate and the
  /// two operands.  Also automatically insert this instruction to the end of
  /// the BasicBlock specified.
  /// @brief Create a CmpInst
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3404,
   FQN="llvm::CmpInst::Create", NM="_ZN4llvm7CmpInst6CreateENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES5_RKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst6CreateENS_11Instruction8OtherOpsENS0_9PredicateEPNS_5ValueES5_RKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CmpInst /*P*/ Create(/*OtherOps*/int Op, Predicate predicate, Value /*P*/ S1, Value /*P*/ S2, 
        final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ InsertAtEnd) {
    if (Op == Instruction.OtherOps.ICmp) {
      return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
          return new ICmpInst($Deref(InsertAtEnd), ((CmpInst.Predicate)(predicate)), 
                  S1, S2, Name);
       });
    }
    return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
        return new FCmpInst($Deref(InsertAtEnd), ((CmpInst.Predicate)(predicate)), 
                S1, S2, Name);
     });
  }

  
  /// @brief Get the opcode casted to the right type
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 940,
   FQN="llvm::CmpInst::getOpcode", NM="_ZNK4llvm7CmpInst9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst9getOpcodeEv")
  //</editor-fold>
  public /*OtherOps*/int getOpcode() /*const*/ {
    return /*static_cast*/super.getOpcode();
  }

  
  /// @brief Return the predicate for this instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 945,
   FQN="llvm::CmpInst::getPredicate", NM="_ZNK4llvm7CmpInst12getPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst12getPredicateEv")
  //</editor-fold>
  public Predicate getPredicate() /*const*/ {
    return Predicate.valueOf(getSubclassDataFromInstruction());
  }

  
  /// @brief Set the predicate for this instruction to the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::setPredicate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 950,
   FQN="llvm::CmpInst::setPredicate", NM="_ZN4llvm7CmpInst12setPredicateENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst12setPredicateENS0_9PredicateE")
  //</editor-fold>
  public void setPredicate(Predicate P) {
    setInstructionSubclassData((char) P.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isFPPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 952,
   FQN="llvm::CmpInst::isFPPredicate", NM="_ZN4llvm7CmpInst13isFPPredicateENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst13isFPPredicateENS0_9PredicateE")
  //</editor-fold>
  public static boolean isFPPredicate(Predicate P) {
    return P.getValue() >= Predicate.FIRST_FCMP_PREDICATE.getValue() && P.getValue() <= Predicate.LAST_FCMP_PREDICATE.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isIntPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 956,
   FQN="llvm::CmpInst::isIntPredicate", NM="_ZN4llvm7CmpInst14isIntPredicateENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst14isIntPredicateENS0_9PredicateE")
  //</editor-fold>
  public static boolean isIntPredicate(Predicate P) {
    return P.getValue() >= Predicate.FIRST_ICMP_PREDICATE.getValue() && P.getValue() <= Predicate.LAST_ICMP_PREDICATE.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isFPPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 960,
   FQN="llvm::CmpInst::isFPPredicate", NM="_ZNK4llvm7CmpInst13isFPPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst13isFPPredicateEv")
  //</editor-fold>
  public boolean isFPPredicate() /*const*/ {
    return CmpInst.isFPPredicate(getPredicate());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isIntPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 961,
   FQN="llvm::CmpInst::isIntPredicate", NM="_ZNK4llvm7CmpInst14isIntPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst14isIntPredicateEv")
  //</editor-fold>
  public boolean isIntPredicate() /*const*/ {
    return CmpInst.isIntPredicate(getPredicate());
  }

  
  /// For example, EQ -> NE, UGT -> ULE, SLT -> SGE,
  ///              OEQ -> UNE, UGT -> OLE, OLT -> UGE, etc.
  /// @returns the inverse predicate for the instruction's current predicate.
  /// @brief Return the inverse of the instruction's predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getInversePredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 967,
   FQN="llvm::CmpInst::getInversePredicate", NM="_ZNK4llvm7CmpInst19getInversePredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst19getInversePredicateEv")
  //</editor-fold>
  public Predicate getInversePredicate() /*const*/ {
    return CmpInst.getInversePredicate(getPredicate());
  }

  
  /// For example, EQ -> NE, UGT -> ULE, SLT -> SGE,
  ///              OEQ -> UNE, UGT -> OLE, OLT -> UGE, etc.
  /// @returns the inverse predicate for predicate provided in \p pred.
  /// @brief Return the inverse of a given predicate
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getInversePredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3435,
   FQN="llvm::CmpInst::getInversePredicate", NM="_ZN4llvm7CmpInst19getInversePredicateENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst19getInversePredicateENS0_9PredicateE")
  //</editor-fold>
  public static CmpInst.Predicate getInversePredicate(Predicate pred) {
    switch (pred) {
     default:
      throw new llvm_unreachable("Unknown cmp predicate!");
     case ICMP_EQ:
      return Predicate.ICMP_NE;
     case ICMP_NE:
      return Predicate.ICMP_EQ;
     case ICMP_UGT:
      return Predicate.ICMP_ULE;
     case ICMP_ULT:
      return Predicate.ICMP_UGE;
     case ICMP_UGE:
      return Predicate.ICMP_ULT;
     case ICMP_ULE:
      return Predicate.ICMP_UGT;
     case ICMP_SGT:
      return Predicate.ICMP_SLE;
     case ICMP_SLT:
      return Predicate.ICMP_SGE;
     case ICMP_SGE:
      return Predicate.ICMP_SLT;
     case ICMP_SLE:
      return Predicate.ICMP_SGT;
     case FCMP_OEQ:
      return Predicate.FCMP_UNE;
     case FCMP_ONE:
      return Predicate.FCMP_UEQ;
     case FCMP_OGT:
      return Predicate.FCMP_ULE;
     case FCMP_OLT:
      return Predicate.FCMP_UGE;
     case FCMP_OGE:
      return Predicate.FCMP_ULT;
     case FCMP_OLE:
      return Predicate.FCMP_UGT;
     case FCMP_UEQ:
      return Predicate.FCMP_ONE;
     case FCMP_UNE:
      return Predicate.FCMP_OEQ;
     case FCMP_UGT:
      return Predicate.FCMP_OLE;
     case FCMP_ULT:
      return Predicate.FCMP_OGE;
     case FCMP_UGE:
      return Predicate.FCMP_OLT;
     case FCMP_ULE:
      return Predicate.FCMP_OGT;
     case FCMP_ORD:
      return Predicate.FCMP_UNO;
     case FCMP_UNO:
      return Predicate.FCMP_ORD;
     case FCMP_TRUE:
      return Predicate.FCMP_FALSE;
     case FCMP_FALSE:
      return Predicate.FCMP_TRUE;
    }
  }

  
  /// For example, EQ->EQ, SLE->SGE, ULT->UGT,
  ///              OEQ->OEQ, ULE->UGE, OLT->OGT, etc.
  /// @returns the predicate that would be the result of exchanging the two
  /// operands of the CmpInst instruction without changing the result
  /// produced.
  /// @brief Return the predicate as if the operands were swapped
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getSwappedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 983,
   FQN="llvm::CmpInst::getSwappedPredicate", NM="_ZNK4llvm7CmpInst19getSwappedPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst19getSwappedPredicateEv")
  //</editor-fold>
  public Predicate getSwappedPredicate() /*const*/ {
    return CmpInst.getSwappedPredicate(getPredicate());
  }

  
  /// This is a static version that you can use without an instruction
  /// available.
  /// @brief Return the predicate as if the operands were swapped.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getSwappedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3559,
   FQN="llvm::CmpInst::getSwappedPredicate", NM="_ZN4llvm7CmpInst19getSwappedPredicateENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst19getSwappedPredicateENS0_9PredicateE")
  //</editor-fold>
  public static CmpInst.Predicate getSwappedPredicate(Predicate pred) {
    switch (pred) {
     default:
      throw new llvm_unreachable("Unknown cmp predicate!");
     case ICMP_EQ:
     case ICMP_NE:
      return pred;
     case ICMP_SGT:
      return Predicate.ICMP_SLT;
     case ICMP_SLT:
      return Predicate.ICMP_SGT;
     case ICMP_SGE:
      return Predicate.ICMP_SLE;
     case ICMP_SLE:
      return Predicate.ICMP_SGE;
     case ICMP_UGT:
      return Predicate.ICMP_ULT;
     case ICMP_ULT:
      return Predicate.ICMP_UGT;
     case ICMP_UGE:
      return Predicate.ICMP_ULE;
     case ICMP_ULE:
      return Predicate.ICMP_UGE;
     case FCMP_FALSE:
     case FCMP_TRUE:
     case FCMP_OEQ:
     case FCMP_ONE:
     case FCMP_UEQ:
     case FCMP_UNE:
     case FCMP_ORD:
     case FCMP_UNO:
      return pred;
     case FCMP_OGT:
      return Predicate.FCMP_OLT;
     case FCMP_OLT:
      return Predicate.FCMP_OGT;
     case FCMP_OGE:
      return Predicate.FCMP_OLE;
     case FCMP_OLE:
      return Predicate.FCMP_OGE;
     case FCMP_UGT:
      return Predicate.FCMP_ULT;
     case FCMP_ULT:
      return Predicate.FCMP_UGT;
     case FCMP_UGE:
      return Predicate.FCMP_ULE;
     case FCMP_ULE:
      return Predicate.FCMP_UGE;
    }
  }


  /// @brief Provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::getOperand", NM="_ZNK4llvm7CmpInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsCmpInst.<CmpInst>operands$FixedNumOperandTraits(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsCmpInst.<CmpInst>op_begin(((/*const_cast*/CmpInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::setOperand", NM="_ZN4llvm7CmpInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsCmpInst.<CmpInst>operands$FixedNumOperandTraits(this))) : "setOperand() out of range!";
    OperandTraitsCmpInst.<CmpInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::op_begin", NM="_ZN4llvm7CmpInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsCmpInst.<CmpInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::op_begin", NM="_ZNK4llvm7CmpInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsCmpInst.<CmpInst>op_begin(((/*const_cast*/CmpInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::op_end", NM="_ZN4llvm7CmpInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsCmpInst.<CmpInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::op_end", NM="_ZNK4llvm7CmpInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsCmpInst.<CmpInst>op_end(((/*const_cast*/CmpInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::Op", NM="Tpl__ZN4llvm7CmpInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm7CmpInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::Op", NM="Tpl__ZNK4llvm7CmpInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm7CmpInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1116,
   FQN="llvm::CmpInst::getNumOperands", NM="_ZNK4llvm7CmpInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsCmpInst.<CmpInst>operands$FixedNumOperandTraits(this);
  }

  
  /// This is just a convenience that dispatches to the subclasses.
  /// @brief Swap the operands and adjust predicate accordingly to retain
  /// the same comparison.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::swapOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3415,
   FQN="llvm::CmpInst::swapOperands", NM="_ZN4llvm7CmpInst12swapOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst12swapOperandsEv")
  //</editor-fold>
  public void swapOperands() {
    {
      ICmpInst /*P*/ IC = dyn_cast_ICmpInst(this);
      if ((IC != null)) {
        IC.swapOperands();
      } else {
        cast_FCmpInst(this).swapOperands();
      }
    }
  }

  
  /// This is just a convenience that dispatches to the subclasses.
  /// @brief Determine if this CmpInst is commutative.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isCommutative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3422,
   FQN="llvm::CmpInst::isCommutative", NM="_ZNK4llvm7CmpInst13isCommutativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst13isCommutativeEv")
  //</editor-fold>
  public boolean isCommutative() /*const*/ {
    {
      /*const*/ ICmpInst /*P*/ IC = dyn_cast_ICmpInst(this);
      if ((IC != null)) {
        return IC.isCommutative();
      }
    }
    return cast_FCmpInst(this).isCommutative();
  }

  
  /// This is just a convenience that dispatches to the subclasses.
  /// @brief Determine if this is an equals/not equals predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isEquality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3428,
   FQN="llvm::CmpInst::isEquality", NM="_ZNK4llvm7CmpInst10isEqualityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst10isEqualityEv")
  //</editor-fold>
  public boolean isEquality() /*const*/ {
    {
      /*const*/ ICmpInst /*P*/ IC = dyn_cast_ICmpInst(this);
      if ((IC != null)) {
        return IC.isEquality();
      }
    }
    return cast_FCmpInst(this).isEquality();
  }

  
  /// @returns true if the comparison is signed, false otherwise.
  /// @brief Determine if this instruction is using a signed comparison.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1010,
   FQN="llvm::CmpInst::isSigned", NM="_ZNK4llvm7CmpInst8isSignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst8isSignedEv")
  //</editor-fold>
  public boolean isSigned() /*const*/ {
    return CmpInst.isSigned(getPredicate());
  }

  
  /// @returns true if the comparison is unsigned, false otherwise.
  /// @brief Determine if this instruction is using an unsigned comparison.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1016,
   FQN="llvm::CmpInst::isUnsigned", NM="_ZNK4llvm7CmpInst10isUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst10isUnsignedEv")
  //</editor-fold>
  public boolean isUnsigned() /*const*/ {
    return CmpInst.isUnsigned(getPredicate());
  }

  
  /// For example, ULT->SLT, ULE->SLE, UGT->SGT, UGE->SGE, SLT->Failed assert
  /// @returns the signed version of the unsigned predicate pred.
  /// @brief return the signed version of a predicate
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getSignedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3589,
   FQN="llvm::CmpInst::getSignedPredicate", NM="_ZN4llvm7CmpInst18getSignedPredicateENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst18getSignedPredicateENS0_9PredicateE")
  //</editor-fold>
  public static CmpInst.Predicate getSignedPredicate(Predicate pred) {
    assert (CmpInst.isUnsigned(pred)) : "Call only with signed predicates!";
    switch (pred) {
     default:
      throw new llvm_unreachable("Unknown predicate!");
     case ICMP_ULT:
      return CmpInst.Predicate.ICMP_SLT;
     case ICMP_ULE:
      return CmpInst.Predicate.ICMP_SLE;
     case ICMP_UGT:
      return CmpInst.Predicate.ICMP_SGT;
     case ICMP_UGE:
      return CmpInst.Predicate.ICMP_SGE;
    }
  }

  
  /// For example, ULT->SLT, ULE->SLE, UGT->SGT, UGE->SGE, SLT->Failed assert
  /// @returns the signed version of the predicate for this instruction (which
  /// has to be an unsigned predicate).
  /// @brief return the signed version of a predicate
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::getSignedPredicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1029,
   FQN="llvm::CmpInst::getSignedPredicate", NM="_ZN4llvm7CmpInst18getSignedPredicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst18getSignedPredicateEv")
  //</editor-fold>
  public Predicate getSignedPredicate() {
    return CmpInst.getSignedPredicate(getPredicate());
  }

  
  /// This is just a convenience.
  /// @brief Determine if this is true when both operands are the same.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isTrueWhenEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1035,
   FQN="llvm::CmpInst::isTrueWhenEqual", NM="_ZNK4llvm7CmpInst15isTrueWhenEqualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst15isTrueWhenEqualEv")
  //</editor-fold>
  public boolean isTrueWhenEqual() /*const*/ {
    return CmpInst.isTrueWhenEqual(getPredicate());
  }

  
  /// This is just a convenience.
  /// @brief Determine if this is false when both operands are the same.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isFalseWhenEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1041,
   FQN="llvm::CmpInst::isFalseWhenEqual", NM="_ZNK4llvm7CmpInst16isFalseWhenEqualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7CmpInst16isFalseWhenEqualEv")
  //</editor-fold>
  public boolean isFalseWhenEqual() /*const*/ {
    return CmpInst.isFalseWhenEqual(getPredicate());
  }

  
  /// @brief Determine if Pred1 implies Pred2 is true when two compares have
  /// matching operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isImpliedTrueByMatchingCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1047,
   FQN="llvm::CmpInst::isImpliedTrueByMatchingCmp", NM="_ZN4llvm7CmpInst26isImpliedTrueByMatchingCmpENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst26isImpliedTrueByMatchingCmpENS0_9PredicateE")
  //</editor-fold>
  public boolean isImpliedTrueByMatchingCmp(Predicate Pred2) {
    return CmpInst.isImpliedTrueByMatchingCmp(getPredicate(), Pred2);
  }

  
  /// @brief Determine if Pred1 implies Pred2 is false when two compares have
  /// matching operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isImpliedFalseByMatchingCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1053,
   FQN="llvm::CmpInst::isImpliedFalseByMatchingCmp", NM="_ZN4llvm7CmpInst27isImpliedFalseByMatchingCmpENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst27isImpliedFalseByMatchingCmpENS0_9PredicateE")
  //</editor-fold>
  public boolean isImpliedFalseByMatchingCmp(Predicate Pred2) {
    return CmpInst.isImpliedFalseByMatchingCmp(getPredicate(), Pred2);
  }

  
  /// @returns true if the predicate is unsigned, false otherwise.
  /// @brief Determine if the predicate is an unsigned operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3606,
   FQN="llvm::CmpInst::isUnsigned", NM="_ZN4llvm7CmpInst10isUnsignedENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst10isUnsignedENS0_9PredicateE")
  //</editor-fold>
  public static boolean isUnsigned(Predicate predicate) {
    switch (predicate) {
     default:
      return false;
     case ICMP_ULT:
     case ICMP_ULE:
     case ICMP_UGT:
     case ICMP_UGE:
      return true;
    }
  }

  
  /// @returns true if the predicate is signed, false otherwise.
  /// @brief Determine if the predicate is an signed operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isSigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3614,
   FQN="llvm::CmpInst::isSigned", NM="_ZN4llvm7CmpInst8isSignedENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst8isSignedENS0_9PredicateE")
  //</editor-fold>
  public static boolean isSigned(Predicate predicate) {
    switch (predicate) {
     default:
      return false;
     case ICMP_SLT:
     case ICMP_SLE:
     case ICMP_SGT:
     case ICMP_SGE:
      return true;
    }
  }

  
  /// @brief Determine if the predicate is an ordered operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isOrdered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3622,
   FQN="llvm::CmpInst::isOrdered", NM="_ZN4llvm7CmpInst9isOrderedENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst9isOrderedENS0_9PredicateE")
  //</editor-fold>
  public static boolean isOrdered(Predicate predicate) {
    switch (predicate) {
     default:
      return false;
     case FCMP_OEQ:
     case FCMP_ONE:
     case FCMP_OGT:
     case FCMP_OLT:
     case FCMP_OGE:
     case FCMP_OLE:
     case FCMP_ORD:
      return true;
    }
  }

  
  /// @brief Determine if the predicate is an unordered operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isUnordered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3631,
   FQN="llvm::CmpInst::isUnordered", NM="_ZN4llvm7CmpInst11isUnorderedENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst11isUnorderedENS0_9PredicateE")
  //</editor-fold>
  public static boolean isUnordered(Predicate predicate) {
    switch (predicate) {
     default:
      return false;
     case FCMP_UEQ:
     case FCMP_UNE:
     case FCMP_UGT:
     case FCMP_ULT:
     case FCMP_UGE:
     case FCMP_ULE:
     case FCMP_UNO:
      return true;
    }
  }

  
  /// Determine if the predicate is true when comparing a value with itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isTrueWhenEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3640,
   FQN="llvm::CmpInst::isTrueWhenEqual", NM="_ZN4llvm7CmpInst15isTrueWhenEqualENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst15isTrueWhenEqualENS0_9PredicateE")
  //</editor-fold>
  public static boolean isTrueWhenEqual(Predicate predicate) {
    switch (predicate) {
     default:
      return false;
     case ICMP_EQ:
     case ICMP_UGE:
     case ICMP_ULE:
     case ICMP_SGE:
     case ICMP_SLE:
     case FCMP_TRUE:
     case FCMP_UEQ:
     case FCMP_UGE:
     case FCMP_ULE:
      return true;
    }
  }

  
  /// Determine if the predicate is false when comparing a value with itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isFalseWhenEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3648,
   FQN="llvm::CmpInst::isFalseWhenEqual", NM="_ZN4llvm7CmpInst16isFalseWhenEqualENS0_9PredicateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst16isFalseWhenEqualENS0_9PredicateE")
  //</editor-fold>
  public static boolean isFalseWhenEqual(Predicate predicate) {
    switch (predicate) {
     case ICMP_NE:
     case ICMP_UGT:
     case ICMP_ULT:
     case ICMP_SGT:
     case ICMP_SLT:
     case FCMP_FALSE:
     case FCMP_ONE:
     case FCMP_OGT:
     case FCMP_OLT:
      return true;
     default:
      return false;
    }
  }

  
  /// Determine if Pred1 implies Pred2 is true when two compares have matching
  /// operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isImpliedTrueByMatchingCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3656,
   FQN="llvm::CmpInst::isImpliedTrueByMatchingCmp", NM="_ZN4llvm7CmpInst26isImpliedTrueByMatchingCmpENS0_9PredicateES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst26isImpliedTrueByMatchingCmpENS0_9PredicateES1_")
  //</editor-fold>
  public static boolean isImpliedTrueByMatchingCmp(Predicate Pred1, Predicate Pred2) {
    // If the predicates match, then we know the first condition implies the
    // second is true.
    if (Pred1 == Pred2) {
      return true;
    }
    switch (Pred1) {
     default:
      break;
     case ICMP_EQ:
      // A == B implies A >=u B, A <=u B, A >=s B, and A <=s B are true.
      return Pred2 == Predicate.ICMP_UGE || Pred2 == Predicate.ICMP_ULE || Pred2 == Predicate.ICMP_SGE
         || Pred2 == Predicate.ICMP_SLE;
     case ICMP_UGT: // A >u B implies A != B and A >=u B are true.
      return Pred2 == Predicate.ICMP_NE || Pred2 == Predicate.ICMP_UGE;
     case ICMP_ULT: // A <u B implies A != B and A <=u B are true.
      return Pred2 == Predicate.ICMP_NE || Pred2 == Predicate.ICMP_ULE;
     case ICMP_SGT: // A >s B implies A != B and A >=s B are true.
      return Pred2 == Predicate.ICMP_NE || Pred2 == Predicate.ICMP_SGE;
     case ICMP_SLT: // A <s B implies A != B and A <=s B are true.
      return Pred2 == Predicate.ICMP_NE || Pred2 == Predicate.ICMP_SLE;
    }
    return false;
  }

  
  /// Determine if Pred1 implies Pred2 is false when two compares have matching
  /// operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::isImpliedFalseByMatchingCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3681,
   FQN="llvm::CmpInst::isImpliedFalseByMatchingCmp", NM="_ZN4llvm7CmpInst27isImpliedFalseByMatchingCmpENS0_9PredicateES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst27isImpliedFalseByMatchingCmpENS0_9PredicateES1_")
  //</editor-fold>
  public static boolean isImpliedFalseByMatchingCmp(Predicate Pred1, Predicate Pred2) {
    return isImpliedTrueByMatchingCmp(Pred1, getInversePredicate(Pred2));
  }

  
  /// @brief Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1086,
   FQN="llvm::CmpInst::classof", NM="_ZN4llvm7CmpInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.ICmp
       || I.getOpcode() == Instruction.OtherOps.FCmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1090,
   FQN="llvm::CmpInst::classof", NM="_ZN4llvm7CmpInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CmpInst.classof(cast_Instruction(V));
  }

  
  /// @brief Create a result type for fcmp/icmp
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::makeCmpResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1095,
   FQN="llvm::CmpInst::makeCmpResultType", NM="_ZN4llvm7CmpInst17makeCmpResultTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst17makeCmpResultTypeEPNS_4TypeE")
  //</editor-fold>
  public static Type /*P*/ makeCmpResultType(Type /*P*/ opnd_type) {
    {
      VectorType /*P*/ vt = dyn_cast_VectorType(opnd_type);
      if ((vt != null)) {
        return VectorType.get(Type.getInt1Ty(opnd_type.getContext()), 
            vt.getNumElements());
      }
    }
    return Type.getInt1Ty(opnd_type.getContext());
  }

/*private:*/
  // Shadow Value::setValueSubclassData with a private forwarding method so that
  // subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::setValueSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 1106,
   FQN="llvm::CmpInst::setValueSubclassData", NM="_ZN4llvm7CmpInst20setValueSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInst20setValueSubclassDataEt")
  //</editor-fold>
  private void setValueSubclassData_CmpInst(/*ushort*/char D) {
    super.setValueSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CmpInst::~CmpInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InstrTypes.h", line = 856,
   FQN="llvm::CmpInst::~CmpInst", NM="_ZN4llvm7CmpInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7CmpInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
