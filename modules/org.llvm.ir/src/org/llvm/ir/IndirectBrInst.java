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
//                             IndirectBrInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// IndirectBrInst - Indirect Branch Instruction.
///
//<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3291,
 FQN="llvm::IndirectBrInst", NM="_ZN4llvm14IndirectBrInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstE")
//</editor-fold>
public class IndirectBrInst extends /*public*/ TerminatorInst implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3292,
   FQN="llvm::IndirectBrInst::operator new", NM="_ZN4llvm14IndirectBrInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  private /*uint*/int ReservedSpace;
  // Operand[0]    = Value to switch on
  // Operand[1]    = Default basic block destination
  // Operand[2n  ] = Value to match
  // Operand[2n+1] = BasicBlock to go to on match
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::IndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3834,
   FQN="llvm::IndirectBrInst::IndirectBrInst", NM="_ZN4llvm14IndirectBrInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstC1ERKS0_")
  //</editor-fold>
  private IndirectBrInst(final /*const*/ IndirectBrInst /*&*/ IBI) {
    // : TerminatorInst(Type::getVoidTy(IBI.getContext()), Instruction::IndirectBr, null, IBI.getNumOperands())
    //START JInit
    super(Type.getVoidTy(IBI.getContext()), Instruction.TermOps.IndirectBr,
        (type$ptr<Use /*P*/> )null, IBI.getNumOperands());
    //END JInit
    allocHungoffUses(IBI.getNumOperands());
    type$ptr<Use /*P*/> OL = $tryClone(getOperandList());
    /*const*/type$ptr<Use /*P*/> InOL = $tryClone(IBI.getOperandList$Const());
    for (/*uint*/int i = 0, E = IBI.getNumOperands(); i != E; ++i)  {
      OL.$at(i).$assign(InOL.$at(i));
    }
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(IBI.SubclassOptionalData));
  }


  //===----------------------------------------------------------------------===//
  //                        IndirectBrInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3798,
   FQN="llvm::IndirectBrInst::init", NM="_ZN4llvm14IndirectBrInst4initEPNS_5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst4initEPNS_5ValueEj")
  //</editor-fold>
  private void init(Value /*P*/ Address, /*uint*/int NumDests) {
    assert ((Address != null) && Address.getType().isPointerTy()) : "Address of indirectbr must be a pointer";
    ReservedSpace = 1 + NumDests;
    setNumHungOffUseOperands(1);
    allocHungoffUses(ReservedSpace);

    this./*<0>*/Op(0).$assign(Address);
  }


  /// growOperands - grow operands - This grows the operand list in response
  /// to a push_back style of operation.  This grows the number of ops by 2 times.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::growOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3812,
   FQN="llvm::IndirectBrInst::growOperands", NM="_ZN4llvm14IndirectBrInst12growOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst12growOperandsEv")
  //</editor-fold>
  private void growOperands() {
    /*uint*/int e = getNumOperands();
    /*uint*/int NumOps = e * 2;

    ReservedSpace = NumOps;
    growHungoffUses(ReservedSpace);
  }

  // allocate space for exactly zero operands
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3302,
   FQN="llvm::IndirectBrInst::operator new", NM="_ZN4llvm14IndirectBrInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstnwEj")
  //</editor-fold>
  private static <T extends IndirectBrInst> T/*void P*/ $new_IndirectBrInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_HangOffUses(/*s*/$Ctor);
  }

  /// IndirectBrInst ctor - Create a new indirectbr instruction, specifying an
  /// Address to jump to.  The number of expected destinations can be specified
  /// here to make memory allocation more efficient.  This constructor can also
  /// autoinsert before another instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::IndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3820,
   FQN="llvm::IndirectBrInst::IndirectBrInst", NM="_ZN4llvm14IndirectBrInstC1EPNS_5ValueEjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstC1EPNS_5ValueEjPNS_11InstructionE")
  //</editor-fold>
  private IndirectBrInst(Value /*P*/ Address, /*uint*/int NumCases,
      Instruction /*P*/ InsertBefore) {
    // : TerminatorInst(Type::getVoidTy(Address->getContext()), Instruction::IndirectBr, null, 0, InsertBefore)
    //START JInit
    super(Type.getVoidTy(Address.getContext()), Instruction.TermOps.IndirectBr,
        (type$ptr<Use /*P*/> )null, 0, InsertBefore);
    //END JInit
    init(Address, NumCases);
  }


  /// IndirectBrInst ctor - Create a new indirectbr instruction, specifying an
  /// Address to jump to.  The number of expected destinations can be specified
  /// here to make memory allocation more efficient.  This constructor also
  /// autoinserts at the end of the specified BasicBlock.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::IndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3827,
   FQN="llvm::IndirectBrInst::IndirectBrInst", NM="_ZN4llvm14IndirectBrInstC1EPNS_5ValueEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstC1EPNS_5ValueEjPNS_10BasicBlockE")
  //</editor-fold>
  private IndirectBrInst(Value /*P*/ Address, /*uint*/int NumCases,
      BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(Type::getVoidTy(Address->getContext()), Instruction::IndirectBr, null, 0, InsertAtEnd)
    //START JInit
    super(Type.getVoidTy(Address.getContext()), Instruction.TermOps.IndirectBr,
        (type$ptr<Use /*P*/> )null, 0, InsertAtEnd);
    //END JInit
    init(Address, NumCases);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4051,
   FQN="llvm::IndirectBrInst::cloneImpl", NM="_ZNK4llvm14IndirectBrInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst9cloneImplEv")
  //</editor-fold>
  protected IndirectBrInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [IndirectBrInst::new]*/IndirectBrInst.$new_IndirectBrInst((type$ptr<?> New$Mem)->{
        return new IndirectBrInst(/*Deref*/this);
     });
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3323,
   FQN="llvm::IndirectBrInst::Create", NM="_ZN4llvm14IndirectBrInst6CreateEPNS_5ValueEjPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst6CreateEPNS_5ValueEjPNS_11InstructionE")
  //</editor-fold>
  public static IndirectBrInst /*P*/ Create(Value /*P*/ Address, /*uint*/int NumDests) {
    return Create(Address, NumDests,
        (Instruction /*P*/ )null);
  }
  public static IndirectBrInst /*P*/ Create(Value /*P*/ Address, /*uint*/int NumDests,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [IndirectBrInst::new]*/IndirectBrInst.$new_IndirectBrInst((type$ptr<?> New$Mem)->{
        return new IndirectBrInst(Address, NumDests, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3327,
   FQN="llvm::IndirectBrInst::Create", NM="_ZN4llvm14IndirectBrInst6CreateEPNS_5ValueEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst6CreateEPNS_5ValueEjPNS_10BasicBlockE")
  //</editor-fold>
  public static IndirectBrInst /*P*/ Create(Value /*P*/ Address, /*uint*/int NumDests,
        BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [IndirectBrInst::new]*/IndirectBrInst.$new_IndirectBrInst((type$ptr<?> New$Mem)->{
        return new IndirectBrInst(Address, NumDests, InsertAtEnd);
     });
  }


  /// Provide fast operand accessors.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::getOperand", NM="_ZNK4llvm14IndirectBrInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsIndirectBrInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsIndirectBrInst.op_begin(((/*const_cast*/IndirectBrInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::setOperand", NM="_ZN4llvm14IndirectBrInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsIndirectBrInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsIndirectBrInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::op_begin", NM="_ZN4llvm14IndirectBrInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsIndirectBrInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::op_begin", NM="_ZNK4llvm14IndirectBrInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsIndirectBrInst.op_begin(((/*const_cast*/IndirectBrInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::op_end", NM="_ZN4llvm14IndirectBrInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsIndirectBrInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::op_end", NM="_ZNK4llvm14IndirectBrInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsIndirectBrInst.op_end(((/*const_cast*/IndirectBrInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::Op", NM="Tpl__ZN4llvm14IndirectBrInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm14IndirectBrInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::Op", NM="Tpl__ZNK4llvm14IndirectBrInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm14IndirectBrInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3382,
   FQN="llvm::IndirectBrInst::getNumOperands", NM="_ZNK4llvm14IndirectBrInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsIndirectBrInst.operands(this);
  }


  // Accessor Methods for IndirectBrInst instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3336,
   FQN="llvm::IndirectBrInst::getAddress", NM="_ZN4llvm14IndirectBrInst10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst10getAddressEv")
  //</editor-fold>
  public Value /*P*/ getAddress() {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3337,
   FQN="llvm::IndirectBrInst::getAddress", NM="_ZNK4llvm14IndirectBrInst10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst10getAddressEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getAddress$Const() /*const*/ {
    return getOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::setAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3338,
   FQN="llvm::IndirectBrInst::setAddress", NM="_ZN4llvm14IndirectBrInst10setAddressEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst10setAddressEPNS_5ValueE")
  //</editor-fold>
  public void setAddress(Value /*P*/ V) {
    setOperand(0, V);
  }


  /// getNumDestinations - return the number of possible destinations in this
  /// indirectbr instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getNumDestinations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3342,
   FQN="llvm::IndirectBrInst::getNumDestinations", NM="_ZNK4llvm14IndirectBrInst18getNumDestinationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst18getNumDestinationsEv")
  //</editor-fold>
  public /*uint*/int getNumDestinations() /*const*/ {
    return getNumOperands() - 1;
  }


  /// getDestination - Return the specified destination.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getDestination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3345,
   FQN="llvm::IndirectBrInst::getDestination", NM="_ZN4llvm14IndirectBrInst14getDestinationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst14getDestinationEj")
  //</editor-fold>
  public BasicBlock /*P*/ getDestination(/*uint*/int i) {
    return getSuccessor(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getDestination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3346,
   FQN="llvm::IndirectBrInst::getDestination", NM="_ZNK4llvm14IndirectBrInst14getDestinationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst14getDestinationEj")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getDestination$Const(/*uint*/int i) /*const*/ {
    return getSuccessor(i);
  }


  /// addDestination - Add a destination.
  ///

  /// addDestination - Add a destination.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::addDestination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3847,
   FQN="llvm::IndirectBrInst::addDestination", NM="_ZN4llvm14IndirectBrInst14addDestinationEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst14addDestinationEPNS_10BasicBlockE")
  //</editor-fold>
  public void addDestination(BasicBlock /*P*/ DestBB) {
    /*uint*/int OpNo = getNumOperands();
    if ($greater_uint(OpNo + 1, ReservedSpace)) {
      growOperands(); // Get more space!
    }
    // Initialize some new operands.
    assert ($less_uint(OpNo, ReservedSpace)) : "Growing didn't work!";
    setNumHungOffUseOperands(OpNo + 1);
    getOperandList().$at(OpNo).$assign(DestBB);
  }


  /// removeDestination - This method removes the specified successor from the
  /// indirectbr instruction.

  /// removeDestination - This method removes the specified successor from the
  /// indirectbr instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::removeDestination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3859,
   FQN="llvm::IndirectBrInst::removeDestination", NM="_ZN4llvm14IndirectBrInst17removeDestinationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst17removeDestinationEj")
  //</editor-fold>
  public void removeDestination(/*uint*/int idx) {
    assert ($less_uint(idx, getNumOperands() - 1)) : "Successor index out of range!";

    /*uint*/int NumOps = getNumOperands();
    type$ptr<Use /*P*/> OL = $tryClone(getOperandList());

    // Replace this value with the last one.
    OL.$at(idx + 1).$assign(OL.$at(NumOps - 1));

    // Nuke the last value.
    OL.$at(NumOps - 1).set((Value /*P*/ )null);
    setNumHungOffUseOperands(NumOps - 1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3356,
   FQN="llvm::IndirectBrInst::getNumSuccessors", NM="_ZNK4llvm14IndirectBrInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return getNumOperands() - 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3357,
   FQN="llvm::IndirectBrInst::getSuccessor", NM="_ZNK4llvm14IndirectBrInst12getSuccessorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst12getSuccessorEj")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor(/*uint*/int i) /*const*/ {
    return cast_BasicBlock(getOperand(i + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::setSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3360,
   FQN="llvm::IndirectBrInst::setSuccessor", NM="_ZN4llvm14IndirectBrInst12setSuccessorEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst12setSuccessorEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(/*uint*/int i, BasicBlock /*P*/ NewSucc) {
    setOperand(i + 1, NewSucc);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3365,
   FQN="llvm::IndirectBrInst::classof", NM="_ZN4llvm14IndirectBrInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.TermOps.IndirectBr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3368,
   FQN="llvm::IndirectBrInst::classof", NM="_ZN4llvm14IndirectBrInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && IndirectBrInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3873,
   FQN="llvm::IndirectBrInst::getSuccessorV", NM="_ZNK4llvm14IndirectBrInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    return getSuccessor(idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3876,
   FQN="llvm::IndirectBrInst::getNumSuccessorsV", NM="_ZNK4llvm14IndirectBrInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14IndirectBrInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 3879,
   FQN="llvm::IndirectBrInst::setSuccessorV", NM="_ZN4llvm14IndirectBrInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ B)/* override*/ {
    setSuccessor(idx, B);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IndirectBrInst::~IndirectBrInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3291,
   FQN="llvm::IndirectBrInst::~IndirectBrInst", NM="_ZN4llvm14IndirectBrInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14IndirectBrInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "ReservedSpace=" + ReservedSpace // NOI18N
              + super.toString(); // NOI18N
  }
}
