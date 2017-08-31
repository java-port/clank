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
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                               SwitchInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// Multiway switch
///
//<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2984,
 FQN="llvm::SwitchInst", NM="_ZN4llvm10SwitchInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInstE")
//</editor-fold>
public class SwitchInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2985,
   FQN="llvm::SwitchInst::operator new", NM="_ZN4llvm10SwitchInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_SwitchInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  private /*uint*/int ReservedSpace;
  // Operand[0]    = Value to switch on
  // Operand[1]    = Default basic block destination
  // Operand[2n  ] = Value to match
  // Operand[2n+1] = BasicBlock to go to on match
  // Operand[0]    = Value to switch on
  // Operand[1]    = Default basic block destination
  // Operand[2n  ] = Value to match
  // Operand[2n+1] = BasicBlock to go to on match
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::SwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3721,
   FQN="llvm::SwitchInst::SwitchInst", NM="_ZN4llvm10SwitchInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInstC1ERKS0_")
  //</editor-fold>
  private SwitchInst(final /*const*/ SwitchInst /*&*/ SI) {
    // : TerminatorInst(SI.getType(), Instruction::Switch, null, 0) 
    //START JInit
    super(SI.getType(), Instruction.TermOps.Switch, (type$ptr<Use /*P*/> )null, 0);
    //END JInit
    init(SI.getCondition(), SI.getDefaultDest(), SI.getNumOperands());
    setNumHungOffUseOperands(SI.getNumOperands());
    type$ptr<Use /*P*/> OL = $tryClone(getOperandList());
    /*const*/type$ptr<Use /*P*/> InOL = $tryClone(SI.getOperandList$Const());
    for (/*uint*/int i = 2, E = SI.getNumOperands(); i != E; i += 2) {
      OL.$at(i).$assign(InOL.$at(i));
      OL.$at(i + 1).$assign(InOL.$at(i + 1));
    }
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(SI.SubclassOptionalData));
  }


  
  //===----------------------------------------------------------------------===//
  //                        SwitchInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3689,
   FQN="llvm::SwitchInst::init", NM="_ZN4llvm10SwitchInst4initEPNS_5ValueEPNS_10BasicBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInst4initEPNS_5ValueEPNS_10BasicBlockEj")
  //</editor-fold>
  private void init(Value /*P*/ $Value, BasicBlock /*P*/ Default, /*uint*/int NumReserved) {
    assert (($Value != null) && (Default != null) && (NumReserved != 0));
    ReservedSpace = NumReserved;
    setNumHungOffUseOperands(2);
    allocHungoffUses(ReservedSpace);
    
    this./*<0>*/Op(0).$assign($Value);
    this./*<1>*/Op(1).$assign(Default);
  }


  
  /// growOperands - grow operands - This grows the operand list in response
  /// to a push_back style of operation.  This grows the number of ops by 3 times.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::growOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3775,
   FQN="llvm::SwitchInst::growOperands", NM="_ZN4llvm10SwitchInst12growOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInst12growOperandsEv")
  //</editor-fold>
  private void growOperands() {
    /*uint*/int e = getNumOperands();
    /*uint*/int NumOps = e * 3;
    
    ReservedSpace = NumOps;
    growHungoffUses(ReservedSpace);
  }


  // allocate space for exactly zero operands
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2995,
   FQN="llvm::SwitchInst::operator new", NM="_ZN4llvm10SwitchInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInstnwEj")
  //</editor-fold>
  private static SwitchInst/*void P*/ $new_SwitchInst(New$ConstructorCallback<SwitchInst> s) {///*size_t*/int s) {
    return User.$new_HangOffUses(s);
  }

  /// Create a new switch instruction, specifying a value to switch on and a
  /// default destination. The number of additional cases can be specified here
  /// to make memory allocation more efficient. This constructor can also
  /// auto-insert before another instruction.
  /// Create a new switch instruction, specifying a value to switch on and a
  /// default destination. The number of additional cases can be specified here
  /// to make memory allocation more efficient. This constructor can also
  /// auto-insert before another instruction.
  
  /// SwitchInst ctor - Create a new switch instruction, specifying a value to
  /// switch on and a default destination.  The number of additional cases can
  /// be specified here to make memory allocation more efficient.  This
  /// constructor can also autoinsert before another instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::SwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3703,
   FQN="llvm::SwitchInst::SwitchInst", NM="_ZN4llvm10SwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjPNS_11InstructionE")
  //</editor-fold>
  private SwitchInst(Value /*P*/ $Value, BasicBlock /*P*/ Default, /*uint*/int NumCases, 
      Instruction /*P*/ InsertBefore) {
    // : TerminatorInst(Type::getVoidTy(Value->getContext()), Instruction::Switch, null, 0, InsertBefore) 
    //START JInit
    super(Type.getVoidTy($Value.getContext()), Instruction.TermOps.Switch, 
        (type$ptr<Use /*P*/> )null, 0, InsertBefore);
    //END JInit
    init($Value, Default, 2 + NumCases * 2);
  }


  
  /// Create a new switch instruction, specifying a value to switch on and a
  /// default destination. The number of additional cases can be specified here
  /// to make memory allocation more efficient. This constructor also
  /// auto-inserts at the end of the specified BasicBlock.
  
  /// Create a new switch instruction, specifying a value to switch on and a
  /// default destination. The number of additional cases can be specified here
  /// to make memory allocation more efficient. This constructor also
  /// auto-inserts at the end of the specified BasicBlock.
  
  /// SwitchInst ctor - Create a new switch instruction, specifying a value to
  /// switch on and a default destination.  The number of additional cases can
  /// be specified here to make memory allocation more efficient.  This
  /// constructor also autoinserts at the end of the specified BasicBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::SwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3714,
   FQN="llvm::SwitchInst::SwitchInst", NM="_ZN4llvm10SwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInstC1EPNS_5ValueEPNS_10BasicBlockEjS4_")
  //</editor-fold>
  private SwitchInst(Value /*P*/ $Value, BasicBlock /*P*/ Default, /*uint*/int NumCases, 
      BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(Value->getContext()), Instruction::Switch, null, 0, InsertAtEnd) 
    //START JInit
    super(Type.getVoidTy($Value.getContext()), Instruction.TermOps.Switch, 
        (type$ptr<Use /*P*/> )null, 0, InsertAtEnd);
    //END JInit
    init($Value, Default, 2 + NumCases * 2);
  }


/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4049,
   FQN="llvm::SwitchInst::cloneImpl", NM="_ZNK4llvm10SwitchInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SwitchInst9cloneImplEv")
  //</editor-fold>
  protected SwitchInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [SwitchInst::new]*/SwitchInst.$new_SwitchInst((type$ptr<?> New$Mem)->{
        return new SwitchInst(/*Deref*/this);
     });
  }


/*public:*/
  // -2
  public static /*const*//*uint*/int DefaultPseudoIndex = ((/*static_cast*//*uint*/int)(~0L/*L*/ - 1));
  
  /*template <class SwitchInstTy, class ConstantIntTy, class BasicBlockTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3021,
   FQN="llvm::SwitchInst::CaseIteratorT", NM="_ZN4llvm10SwitchInst13CaseIteratorTE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTE")
  //</editor-fold>
  public static class CaseIteratorT</*class*/ SwitchInstTy extends SwitchInst, /*class*/ ConstantIntTy extends Value, /*class*/ BasicBlockTy extends BasicBlock>  implements type$iterator<CaseIteratorT, CaseIteratorT>, Native.NativeComparable {
  /*protected:*/
    protected SwitchInstTy /*P*/ SI;
    protected /*uint*/int Index;
  /*public:*/
    // JAVA: typedef CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> Self
//    public final class Self extends CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy>{ };
    
    /// Initializes case iterator for given SwitchInst and for given
    /// case number.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3032,
     FQN="llvm::SwitchInst::CaseIteratorT::CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy>", NM="_ZN4llvm10SwitchInst13CaseIteratorTC1EPT_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTC1EPT_j")
    //</editor-fold>
    public CaseIteratorT(SwitchInstTy /*P*/ SI, /*uint*/int CaseNum) {
      this.SI = SI;
      Index = CaseNum;
    }

    
    /// Initializes case iterator for given SwitchInst and for given
    /// TerminatorInst's successor index.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::fromSuccessorIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3039,
     FQN="llvm::SwitchInst::CaseIteratorT::fromSuccessorIndex", NM="_ZN4llvm10SwitchInst13CaseIteratorT18fromSuccessorIndexEPT_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorT18fromSuccessorIndexEPT_j")
    //</editor-fold>
    public static </*class*/ SwitchInstTy extends SwitchInst, /*class*/ ConstantIntTy extends Value, /*class*/ BasicBlockTy extends BasicBlock> CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> fromSuccessorIndex(SwitchInstTy /*P*/ SI, /*uint*/int SuccessorIndex) {
      assert Native.$bool(Native.$less(SuccessorIndex, SI.getNumSuccessors())) : "Successor index # out of range!";
      return SuccessorIndex != 0 ? new CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy>(SI, SuccessorIndex - 1) : new CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy>(SI, SwitchInst.DefaultPseudoIndex);
    }

    
    /// Resolves case value for current case.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::getCaseValue">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3048,
     FQN="llvm::SwitchInst::CaseIteratorT::getCaseValue", NM="_ZN4llvm10SwitchInst13CaseIteratorT12getCaseValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorT12getCaseValueEv")
    //</editor-fold>
    public ConstantIntTy /*P*/ getCaseValue() {
      assert Native.$bool(Native.$less(Index, SI.getNumCases())) : "Index out the number of cases.";
      return (ConstantIntTy)SI.getOperand(Native.$add(2, Index * 2));//reinterpret_cast(ConstantIntTy /*P*/ .class, SI.getOperand(Native.$add(2, Index * 2)));
    }

    
    /// Resolves successor for current case.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::getCaseSuccessor">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3054,
     FQN="llvm::SwitchInst::CaseIteratorT::getCaseSuccessor", NM="_ZN4llvm10SwitchInst13CaseIteratorT16getCaseSuccessorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorT16getCaseSuccessorEv")
    //</editor-fold>
    public BasicBlockTy /*P*/ getCaseSuccessor() {
      assert Native.$bool((Native.$bool(Native.$less(Index, SI.getNumCases())) || Native.$bool(Native.$eq(Index, SwitchInst.DefaultPseudoIndex)))) : "Index out the number of cases.";
      return (BasicBlockTy)SI.getSuccessor(getSuccessorIndex());
    }

    
    /// Returns number of current case.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::getCaseIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3062,
     FQN="llvm::SwitchInst::CaseIteratorT::getCaseIndex", NM="_ZNK4llvm10SwitchInst13CaseIteratorT12getCaseIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst13CaseIteratorT12getCaseIndexEv")
    //</editor-fold>
    public /*uint*/int getCaseIndex() /*const*/ {
      return Index;
    }

    
    /// Returns TerminatorInst's successor index for current case successor.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::getSuccessorIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3065,
     FQN="llvm::SwitchInst::CaseIteratorT::getSuccessorIndex", NM="_ZNK4llvm10SwitchInst13CaseIteratorT17getSuccessorIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst13CaseIteratorT17getSuccessorIndexEv")
    //</editor-fold>
    public /*uint*/int getSuccessorIndex() /*const*/ {
      assert Native.$bool((Native.$bool(Native.$eq(Index, SwitchInst.DefaultPseudoIndex)) || Native.$bool(Native.$less(Index, SI.getNumCases())))) : "Index out the number of cases.";
      return Native.$noteq(Index, SwitchInst.DefaultPseudoIndex) ? Native.$add(Index, 1) : 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3071,
     FQN="llvm::SwitchInst::CaseIteratorT::operator++", NM="_ZN4llvm10SwitchInst13CaseIteratorTppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTppEv")
    //</editor-fold>
    public CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $preInc() {
      // Check index correctness after increment.
      // Note: Index == getNumCases() means end().
      assert Native.$bool(Native.$lesseq(Native.$add(Index, 1), SI.getNumCases())) : "Index out the number of cases.";
      ++Index;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3078,
     FQN="llvm::SwitchInst::CaseIteratorT::operator++", NM="_ZN4llvm10SwitchInst13CaseIteratorTppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTppEi")
    //</editor-fold>
    public CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $postInc(int $Prm0) {
      CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> tmp = new CaseIteratorT(SI, Index);///*Deref*/this;
      ++Index;//++(/*Deref*/this);
      return tmp;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator--">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3083,
     FQN="llvm::SwitchInst::CaseIteratorT::operator--", NM="_ZN4llvm10SwitchInst13CaseIteratorTmmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTmmEv")
    //</editor-fold>
    public CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $preDec() {
      // Check index correctness after decrement.
      // Note: Index == getNumCases() means end().
      // Also allow "-1" iterator here. That will became valid after ++.
      assert Native.$bool((Native.$bool(Native.$eq(Index, 0)) || Native.$bool(Native.$lesseq(Index - 1, SI.getNumCases())))) : "Index out the number of cases.";
      --Index;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator--">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3092,
     FQN="llvm::SwitchInst::CaseIteratorT::operator--", NM="_ZN4llvm10SwitchInst13CaseIteratorTmmEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTmmEi")
    //</editor-fold>
    public CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $postDec(int $Prm0) {
      CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> tmp = new CaseIteratorT(SI, Index);///*Deref*/this;
      --Index;//--(/*Deref*/this);
      return tmp;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3097,
     FQN="llvm::SwitchInst::CaseIteratorT::operator==", NM="_ZNK4llvm10SwitchInst13CaseIteratorTeqERKNS0_13CaseIteratorTIT_T0_T1_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst13CaseIteratorTeqERKNS0_13CaseIteratorTIT_T0_T1_EE")
    //</editor-fold>
    public boolean $eq(final /*const*/ CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> /*&*/ RHS) /*const*/ {
      assert Native.$bool(Native.$eq(RHS.SI, SI)) : "Incompatible operators.";
      return Native.$eq(RHS.Index, Index);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3101,
     FQN="llvm::SwitchInst::CaseIteratorT::operator!=", NM="_ZNK4llvm10SwitchInst13CaseIteratorTneERKNS0_13CaseIteratorTIT_T0_T1_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst13CaseIteratorTneERKNS0_13CaseIteratorTIT_T0_T1_EE")
    //</editor-fold>
    public boolean $noteq(final /*const*/ CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> /*&*/ RHS) /*const*/ {
      assert Native.$bool(Native.$eq(RHS.SI, SI)) : "Incompatible operators.";
      return Native.$noteq(RHS.Index, Index);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIteratorT::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3105,
     FQN="llvm::SwitchInst::CaseIteratorT::operator*", NM="_ZN4llvm10SwitchInst13CaseIteratorTdeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13CaseIteratorTdeEv")
    //</editor-fold>
    public CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> /*&*/ $star() {
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    protected CaseIteratorT(CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $Prm0) {
      this.SI = $Prm0.SI;
      this.Index = $Prm0.Index;
    }
    
    protected CaseIteratorT(JD$Move _dparam, CaseIteratorT<SwitchInstTy, ConstantIntTy, BasicBlockTy> $Prm0) {
      this.SI = $Prm0.SI;
      this.Index = $Prm0.Index;
    }

    @Override
    public CaseIteratorT clone() {
      return new CaseIteratorT(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "SI=" + SI // NOI18N
                + ", Index=" + Index; // NOI18N
    }
  };
  
  // JAVA: typedef CaseIteratorT<const SwitchInst, const ConstantInt, const BasicBlock> ConstCaseIt
//  public final class ConstCaseIt extends CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3113,
   FQN="llvm::SwitchInst::CaseIt", NM="_ZN4llvm10SwitchInst6CaseItE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseItE")
  //</editor-fold>
  public static class CaseIt extends /*public*/ CaseIteratorT<SwitchInst, ConstantInt, BasicBlock> {
    
    // JAVA: typedef CaseIteratorT<SwitchInst, ConstantInt, BasicBlock> ParentTy
//    public final class ParentTy extends CaseIteratorT<SwitchInst, ConstantInt, BasicBlock>{ };
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt::CaseIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3118,
     FQN="llvm::SwitchInst::CaseIt::CaseIt", NM="_ZN4llvm10SwitchInst6CaseItC1ERKNS0_13CaseIteratorTIS0_NS_11ConstantIntENS_10BasicBlockEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseItC1ERKNS0_13CaseIteratorTIS0_NS_11ConstantIntENS_10BasicBlockEEE")
    //</editor-fold>
    public CaseIt(final /*const*/ CaseIteratorT<SwitchInst, ConstantInt, BasicBlock> /*&*/ Src) {
      // : ParentTy(Src) 
      //START JInit
      super(Src);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt::CaseIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3119,
     FQN="llvm::SwitchInst::CaseIt::CaseIt", NM="_ZN4llvm10SwitchInst6CaseItC1EPS0_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseItC1EPS0_j")
    //</editor-fold>
    public CaseIt(SwitchInst /*P*/ SI, /*uint*/int CaseNum) {
      // : ParentTy(SI, CaseNum) 
      //START JInit
      super(SI, CaseNum);
      //END JInit
    }

    
    /// Sets the new value for current case.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt::setValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3122,
     FQN="llvm::SwitchInst::CaseIt::setValue", NM="_ZN4llvm10SwitchInst6CaseIt8setValueEPNS_11ConstantIntE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseIt8setValueEPNS_11ConstantIntE")
    //</editor-fold>
    public void setValue(ConstantInt /*P*/ V) {
      assert ($less_uint(Index, SI.getNumCases())) : "Index out the number of cases.";
      SI.setOperand(2 + Index * 2, reinterpret_cast(Value /*P*/ .class, V));
    }

    
    /// Sets the new successor for current case.
    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt::setSuccessor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3128,
     FQN="llvm::SwitchInst::CaseIt::setSuccessor", NM="_ZN4llvm10SwitchInst6CaseIt12setSuccessorEPNS_10BasicBlockE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseIt12setSuccessorEPNS_10BasicBlockE")
    //</editor-fold>
    public void setSuccessor(BasicBlock /*P*/ S) {
      SI.setSuccessor(getSuccessorIndex(), S);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt::CaseIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3113,
     FQN="llvm::SwitchInst::CaseIt::CaseIt", NM="_ZN4llvm10SwitchInst6CaseItC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseItC1ERKS1_")
    //</editor-fold>
    public /*inline*/ CaseIt(final /*const*/ CaseIt /*&*/ $Prm0) {
      // : CaseIteratorT<SwitchInst, ConstantInt, BasicBlock>() 
      //START JInit
      super($Prm0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::CaseIt::CaseIt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3113,
     FQN="llvm::SwitchInst::CaseIt::CaseIt", NM="_ZN4llvm10SwitchInst6CaseItC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CaseItC1EOS1_")
    //</editor-fold>
    public /*inline*/ CaseIt(JD$Move _dparam, final CaseIt /*&&*/$Prm0) {
      // : CaseIteratorT<SwitchInst, ConstantInt, BasicBlock>(static_cast<CaseIt &&>()) 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3133,
   FQN="llvm::SwitchInst::Create", NM="_ZN4llvm10SwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjPNS_11InstructionE")
  //</editor-fold>
  public static SwitchInst /*P*/ Create(Value /*P*/ $Value, BasicBlock /*P*/ Default, 
        /*uint*/int NumCases) {
    return Create($Value, Default, 
        NumCases, 
        (Instruction /*P*/ )null);
  }
  public static SwitchInst /*P*/ Create(Value /*P*/ $Value, BasicBlock /*P*/ Default, 
        /*uint*/int NumCases, 
        Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [SwitchInst::new]*/SwitchInst.$new_SwitchInst((type$ptr<?> New$Mem)->{
        return new SwitchInst($Value, Default, NumCases, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3138,
   FQN="llvm::SwitchInst::Create", NM="_ZN4llvm10SwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6CreateEPNS_5ValueEPNS_10BasicBlockEjS4_")
  //</editor-fold>
  public static SwitchInst /*P*/ Create(Value /*P*/ $Value, BasicBlock /*P*/ Default, 
        /*uint*/int NumCases, BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [SwitchInst::new]*/SwitchInst.$new_SwitchInst((type$ptr<?> New$Mem)->{
        return new SwitchInst($Value, Default, NumCases, InsertAtEnd);
     });
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::getOperand", NM="_ZNK4llvm10SwitchInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsSwitchInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsSwitchInst.op_begin(((/*const_cast*/SwitchInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::setOperand", NM="_ZN4llvm10SwitchInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsSwitchInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsSwitchInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::op_begin", NM="_ZN4llvm10SwitchInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsSwitchInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::op_begin", NM="_ZNK4llvm10SwitchInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsSwitchInst.op_begin(((/*const_cast*/SwitchInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::op_end", NM="_ZN4llvm10SwitchInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsSwitchInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::op_end", NM="_ZNK4llvm10SwitchInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsSwitchInst.op_end(((/*const_cast*/SwitchInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::Op", NM="Tpl__ZN4llvm10SwitchInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=Tpl__ZN4llvm10SwitchInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::Op", NM="Tpl__ZNK4llvm10SwitchInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=Tpl__ZNK4llvm10SwitchInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3282,
   FQN="llvm::SwitchInst::getNumOperands", NM="_ZNK4llvm10SwitchInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsSwitchInst.operands(this);
  }

  
  // Accessor Methods for Switch stmt
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3147,
   FQN="llvm::SwitchInst::getCondition", NM="_ZNK4llvm10SwitchInst12getConditionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst12getConditionEv")
  //</editor-fold>
  public Value /*P*/ getCondition() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::setCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3148,
   FQN="llvm::SwitchInst::setCondition", NM="_ZN4llvm10SwitchInst12setConditionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst12setConditionEPNS_5ValueE")
  //</editor-fold>
  public void setCondition(Value /*P*/ V) {
    setOperand(0, V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getDefaultDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3150,
   FQN="llvm::SwitchInst::getDefaultDest", NM="_ZNK4llvm10SwitchInst14getDefaultDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst14getDefaultDestEv")
  //</editor-fold>
  public BasicBlock /*P*/ getDefaultDest() /*const*/ {
    return cast_BasicBlock(getOperand(1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::setDefaultDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3154,
   FQN="llvm::SwitchInst::setDefaultDest", NM="_ZN4llvm10SwitchInst14setDefaultDestEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst14setDefaultDestEPNS_10BasicBlockE")
  //</editor-fold>
  public void setDefaultDest(BasicBlock /*P*/ DefaultCase) {
    setOperand(1, reinterpret_cast(Value /*P*/ .class, DefaultCase));
  }

  
  /// Return the number of 'cases' in this switch instruction, excluding the
  /// default case.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getNumCases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3160,
   FQN="llvm::SwitchInst::getNumCases", NM="_ZNK4llvm10SwitchInst11getNumCasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst11getNumCasesEv")
  //</editor-fold>
  public /*uint*/int getNumCases() /*const*/ {
    return $div_uint(getNumOperands(), 2) - 1;
  }

  
  /// Returns a read/write iterator that points to the first case in the
  /// SwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::case_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3166,
   FQN="llvm::SwitchInst::case_begin", NM="_ZN4llvm10SwitchInst10case_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst10case_beginEv")
  //</editor-fold>
  public CaseIt case_begin() {
    return new CaseIt(this, 0);
  }

  /// Returns a read-only iterator that points to the first case in the
  /// SwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::case_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3171,
   FQN="llvm::SwitchInst::case_begin", NM="_ZNK4llvm10SwitchInst10case_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst10case_beginEv")
  //</editor-fold>
  public CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> case_begin$Const() /*const*/ {
    return new CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock>(this, 0);
  }

  
  /// Returns a read/write iterator that points one past the last in the
  /// SwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::case_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3177,
   FQN="llvm::SwitchInst::case_end", NM="_ZN4llvm10SwitchInst8case_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst8case_endEv")
  //</editor-fold>
  public CaseIt case_end() {
    return new CaseIt(this, getNumCases());
  }

  /// Returns a read-only iterator that points one past the last in the
  /// SwitchInst.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::case_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3182,
   FQN="llvm::SwitchInst::case_end", NM="_ZNK4llvm10SwitchInst8case_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst8case_endEv")
  //</editor-fold>
  public CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> case_end$Const() /*const*/ {
    return new CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock>(this, getNumCases());
  }

  
  /// Iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::cases">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3187,
   FQN="llvm::SwitchInst::cases", NM="_ZN4llvm10SwitchInst5casesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst5casesEv")
  //</editor-fold>
  public iterator_range<CaseIteratorT> cases() {
    return make_range(case_begin(), case_end());
  }

  
  /// Constant iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::cases">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3192,
   FQN="llvm::SwitchInst::cases", NM="_ZNK4llvm10SwitchInst5casesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst5casesEv")
  //</editor-fold>
  public iterator_range<CaseIteratorT> cases$Const() /*const*/ {
    return make_range(case_begin$Const(), case_end$Const());
  }

  
  /// Returns an iterator that points to the default case.
  /// Note: this iterator allows to resolve successor only. Attempt
  /// to resolve case value causes an assertion.
  /// Also note, that increment and decrement also causes an assertion and
  /// makes iterator invalid.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::case_default">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3201,
   FQN="llvm::SwitchInst::case_default", NM="_ZN4llvm10SwitchInst12case_defaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst12case_defaultEv")
  //</editor-fold>
  public CaseIt case_default() {
    return new CaseIt(this, DefaultPseudoIndex);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::case_default">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3204,
   FQN="llvm::SwitchInst::case_default", NM="_ZNK4llvm10SwitchInst12case_defaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst12case_defaultEv")
  //</editor-fold>
  public CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> case_default$Const() /*const*/ {
    return new CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock>(this, DefaultPseudoIndex);
  }

  
  /// Search all of the case values for the specified constant. If it is
  /// explicitly handled, return the case iterator of it, otherwise return
  /// default case iterator to indicate that it is handled by the default
  /// handler.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::findCaseValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3212,
   FQN="llvm::SwitchInst::findCaseValue", NM="_ZN4llvm10SwitchInst13findCaseValueEPKNS_11ConstantIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst13findCaseValueEPKNS_11ConstantIntE")
  //</editor-fold>
  public CaseIt findCaseValue(/*const*/ ConstantInt /*P*/ C) {
    for (CaseIt i = case_begin(), e = case_end(); i.$noteq(e); i.$preInc())  {
      if (i.getCaseValue() == C) {
        return i;
      }
    }
    return case_default();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::findCaseValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3218,
   FQN="llvm::SwitchInst::findCaseValue", NM="_ZNK4llvm10SwitchInst13findCaseValueEPKNS_11ConstantIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst13findCaseValueEPKNS_11ConstantIntE")
  //</editor-fold>
  public CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> findCaseValue$Const(/*const*/ ConstantInt /*P*/ C) /*const*/ {
    for (CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> i = case_begin$Const(), e = case_end$Const(); i.$noteq(e); i.$preInc())  {
      if (i.getCaseValue() == C) {
        return i;
      }
    }
    return case_default$Const();
  }

  
  /// Finds the unique case value for a given successor. Returns null if the
  /// successor is not found, not unique, or is the default case.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::findCaseDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3227,
   FQN="llvm::SwitchInst::findCaseDest", NM="_ZN4llvm10SwitchInst12findCaseDestEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst12findCaseDestEPNS_10BasicBlockE")
  //</editor-fold>
  public ConstantInt /*P*/ findCaseDest(BasicBlock /*P*/ BB) {
    if (BB == getDefaultDest()) {
      return null;
    }
    
    ConstantInt /*P*/ CI = null;
    for (CaseIt i = case_begin(), e = case_end(); i.$noteq(e); i.$preInc()) {
      if (i.getCaseSuccessor() == BB) {
        if ((CI != null)) {
          return null; // Multiple cases lead to BB.
        } else {
          CI = i.getCaseValue();
        }
      }
    }
    return CI;
  }

  
  /// Add an entry to the switch instruction.
  /// Note:
  /// This action invalidates case_end(). Old case_end() iterator will
  /// point to the added case.
  
  /// Add an entry to the switch instruction.
  /// Note:
  /// This action invalidates case_end(). Old case_end() iterator will
  /// point to the added case.
  
  /// addCase - Add an entry to the switch instruction...
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::addCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3737,
   FQN="llvm::SwitchInst::addCase", NM="_ZN4llvm10SwitchInst7addCaseEPNS_11ConstantIntEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInst7addCaseEPNS_11ConstantIntEPNS_10BasicBlockE")
  //</editor-fold>
  public void addCase(ConstantInt /*P*/ OnVal, BasicBlock /*P*/ Dest) {
    /*uint*/int NewCaseIdx = getNumCases();
    /*uint*/int OpNo = getNumOperands();
    if ($greater_uint(OpNo + 2, ReservedSpace)) {
      growOperands(); // Get more space!
    }
    // Initialize some new operands.
    assert ($less_uint(OpNo + 1, ReservedSpace)) : "Growing didn't work!";
    setNumHungOffUseOperands(OpNo + 2);
    CaseIt Case/*J*/= new CaseIt(this, NewCaseIdx);
    Case.setValue(OnVal);
    Case.setSuccessor(Dest);
  }


  
  /// This method removes the specified case and its successor from the switch
  /// instruction. Note that this operation may reorder the remaining cases at
  /// index idx and above.
  /// Note:
  /// This action invalidates iterators for all cases following the one removed,
  /// including the case_end() iterator.
  
  /// This method removes the specified case and its successor from the switch
  /// instruction. Note that this operation may reorder the remaining cases at
  /// index idx and above.
  /// Note:
  /// This action invalidates iterators for all cases following the one removed,
  /// including the case_end() iterator.
  
  /// removeCase - This method removes the specified case and its successor
  /// from the switch instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::removeCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3752,
   FQN="llvm::SwitchInst::removeCase", NM="_ZN4llvm10SwitchInst10removeCaseENS0_6CaseItE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInst10removeCaseENS0_6CaseItE")
  //</editor-fold>
  public void removeCase(CaseIt i) {
    /*uint*/int idx = i.getCaseIndex();
    assert ($less_uint(2 + idx * 2, getNumOperands())) : "Case index out of range!!!";
    
    /*uint*/int NumOps = getNumOperands();
    type$ptr<Use /*P*/> OL = $tryClone(getOperandList());
    
    // Overwrite this case with the end of the list.
    if (2 + (idx + 1) * 2 != NumOps) {
      OL.$at(2 + idx * 2).$assign(OL.$at(NumOps - 2));
      OL.$at(2 + idx * 2 + 1).$assign(OL.$at(NumOps - 1));
    }
    
    // Nuke the last value.
    OL.$at(NumOps - 2).set((Value /*P*/ )null);
    OL.$at(NumOps - 2 + 1).set((Value /*P*/ )null);
    setNumHungOffUseOperands(NumOps - 2);
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3254,
   FQN="llvm::SwitchInst::getNumSuccessors", NM="_ZNK4llvm10SwitchInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return $div_uint(getNumOperands(), 2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3255,
   FQN="llvm::SwitchInst::getSuccessor", NM="_ZNK4llvm10SwitchInst12getSuccessorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZNK4llvm10SwitchInst12getSuccessorEj")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor(/*uint*/int idx) /*const*/ {
    assert ($less_uint(idx, getNumSuccessors())) : "Successor idx out of range for switch!";
    return cast_BasicBlock(getOperand(idx * 2 + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::setSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3259,
   FQN="llvm::SwitchInst::setSuccessor", NM="_ZN4llvm10SwitchInst12setSuccessorEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst12setSuccessorEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(/*uint*/int idx, BasicBlock /*P*/ NewSucc) {
    assert ($less_uint(idx, getNumSuccessors())) : "Successor # out of range for switch!";
    setOperand(idx * 2 + 1, NewSucc);
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3265,
   FQN="llvm::SwitchInst::classof", NM="_ZN4llvm10SwitchInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.TermOps.Switch;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3268,
   FQN="llvm::SwitchInst::classof", NM="_ZN4llvm10SwitchInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm10SwitchInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && SwitchInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3784,
   FQN="llvm::SwitchInst::getSuccessorV", NM="_ZNK4llvm10SwitchInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SwitchInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    return getSuccessor(idx);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3787,
   FQN="llvm::SwitchInst::getNumSuccessorsV", NM="_ZNK4llvm10SwitchInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10SwitchInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3790,
   FQN="llvm::SwitchInst::setSuccessorV", NM="_ZN4llvm10SwitchInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ B)/* override*/ {
    setSuccessor(idx, B);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SwitchInst::~SwitchInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2984,
   FQN="llvm::SwitchInst::~SwitchInst", NM="_ZN4llvm10SwitchInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10SwitchInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  
  @Override public String toString() {
    return "" + "ReservedSpace=" + ReservedSpace // NOI18N
              + super.toString(); // NOI18N
  }
}
