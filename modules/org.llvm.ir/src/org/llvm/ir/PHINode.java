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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
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
//                               PHINode Class
//===----------------------------------------------------------------------===//

// PHINode - The PHINode class is used to represent the magical mystical PHI
// node, that can not exist in nature, but can be synthesized in a computer
// scientist's overactive imagination.
//
//<editor-fold defaultstate="collapsed" desc="llvm::PHINode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2478,
 FQN="llvm::PHINode", NM="_ZN4llvm7PHINodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodeE")
//</editor-fold>
public class PHINode extends /*public*/ Instruction implements Destructors.ClassWithDestructor {

  //===----------------------------------------------------------------------===//
  //                               PHINode Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 90,
   FQN="llvm::PHINode::anchor", NM="_ZN4llvm7PHINode6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2481,
   FQN="llvm::PHINode::operator new", NM="_ZN4llvm7PHINodenwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodenwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_PHINode(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  /// ReservedSpace - The number of operands actually allocated.  NumOperands is
  /// the number actually in use.
  private /*uint*/int ReservedSpace;
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::PHINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 92,
   FQN="llvm::PHINode::PHINode", NM="_ZN4llvm7PHINodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodeC1ERKS0_")
  //</editor-fold>
  private PHINode(final /*const*/ PHINode /*&*/ PN) {
    // : Instruction(PN.getType(), Instruction::PHI, null, PN.getNumOperands()), ReservedSpace(PN.getNumOperands())
    //START JInit
    super(PN.getType(), Instruction.OtherOps.PHI, (type$ptr<Use /*P*/> )null, PN.getNumOperands());
    this.ReservedSpace = PN.getNumOperands();
    //END JInit
    allocHungoffUses(PN.getNumOperands());
    std.copy(PN.op_begin$Const(), PN.op_end$Const(), op_begin());
    std.copy(PN.block_begin$Const(), PN.block_end$Const(), block_begin());
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(PN.SubclassOptionalData));
  }

  // allocate space for exactly zero operands
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2487,
   FQN="llvm::PHINode::operator new", NM="_ZN4llvm7PHINodenwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodenwEj")
  //</editor-fold>
  private static <T extends PHINode> T/*void P*/ $new_PHINode(/*size_t int s,*/ New$ConstructorCallback<T> $Ctor) {
    return User.$new_HangOffUses($Ctor);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::PHINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2490,
   FQN="llvm::PHINode::PHINode", NM="_ZN4llvm7PHINodeC1EPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodeC1EPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private /*explicit*/ PHINode(Type /*P*/ Ty, /*uint*/int NumReservedValues) {
    this(Ty, NumReservedValues,
      new Twine(/*KEEP_STR*/$EMPTY),
      (Instruction /*P*/ )null);
  }
  private /*explicit*/ PHINode(Type /*P*/ Ty, /*uint*/int NumReservedValues,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    this(Ty, NumReservedValues,
      NameStr,
      (Instruction /*P*/ )null);
  }
  private /*explicit*/ PHINode(Type /*P*/ Ty, /*uint*/int NumReservedValues,
      final /*const*/ Twine /*&*/ NameStr/*= ""*/,
      Instruction /*P*/ InsertBefore/*= null*/) {
    // : Instruction(Ty, Instruction::PHI, null, 0, InsertBefore), ReservedSpace(NumReservedValues)
    //START JInit
    super(Ty, Instruction.OtherOps.PHI, (type$ptr<Use /*P*/> )null, 0, InsertBefore);
    this.ReservedSpace = NumReservedValues;
    //END JInit
    setName(NameStr);
    allocHungoffUses(ReservedSpace);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::PHINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2499,
   FQN="llvm::PHINode::PHINode", NM="_ZN4llvm7PHINodeC1EPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodeC1EPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private PHINode(Type /*P*/ Ty, /*uint*/int NumReservedValues, final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(Ty, Instruction::PHI, null, 0, InsertAtEnd), ReservedSpace(NumReservedValues)
    //START JInit
    super(Ty, Instruction.OtherOps.PHI, (type$ptr<Use /*P*/> )null, 0, InsertAtEnd);
    this.ReservedSpace = NumReservedValues;
    //END JInit
    setName(NameStr);
    allocHungoffUses(ReservedSpace);
  }

/*protected:*/
  // allocHungoffUses - this is more complicated than the generic
  // User::allocHungoffUses, because we have to allocate Uses for the incoming
  // values and pointers to the incoming blocks, all in one allocation.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::allocHungoffUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2511,
   FQN="llvm::PHINode::allocHungoffUses", NM="_ZN4llvm7PHINode16allocHungoffUsesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode16allocHungoffUsesEj")
  //</editor-fold>
  protected void allocHungoffUses(/*uint*/int N) {
    super.allocHungoffUses(N, /* IsPhi */ true);
  }


  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4035,
   FQN="llvm::PHINode::cloneImpl", NM="_ZNK4llvm7PHINode9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode9cloneImplEv")
  //</editor-fold>
  protected PHINode /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [PHINode::new]*/PHINode.$new_PHINode((type$ptr<?> New$Mem)->{
        return new PHINode(/*Deref*/this);
     });
  }

/*public:*/
  /// Constructors - NumReservedValues is a hint for the number of incoming
  /// edges that this phi node will have (use 0 if you really have no idea).
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2522,
   FQN="llvm::PHINode::Create", NM="_ZN4llvm7PHINode6CreateEPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode6CreateEPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static PHINode /*P*/ Create(Type /*P*/ Ty, /*uint*/int NumReservedValues) {
    return Create(Ty, NumReservedValues,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static PHINode /*P*/ Create(Type /*P*/ Ty, /*uint*/int NumReservedValues,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(Ty, NumReservedValues,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static PHINode /*P*/ Create(Type /*P*/ Ty, /*uint*/int NumReservedValues,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [PHINode::new]*/PHINode.$new_PHINode((type$ptr<?> New$Mem)->{
        return new PHINode(Ty, NumReservedValues, NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2527,
   FQN="llvm::PHINode::Create", NM="_ZN4llvm7PHINode6CreateEPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode6CreateEPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static PHINode /*P*/ Create(Type /*P*/ Ty, /*uint*/int NumReservedValues,
        final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [PHINode::new]*/PHINode.$new_PHINode((type$ptr<?> New$Mem)->{
        return new PHINode(Ty, NumReservedValues, NameStr, InsertAtEnd);
     });
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::getOperand", NM="_ZNK4llvm7PHINode10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsPHINode.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsPHINode.op_begin(((/*const_cast*/PHINode /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::setOperand", NM="_ZN4llvm7PHINode10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsPHINode.operands(this))) : "setOperand() out of range!";
    OperandTraitsPHINode.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::op_begin", NM="_ZN4llvm7PHINode8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsPHINode.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::op_begin", NM="_ZNK4llvm7PHINode8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsPHINode.op_begin(((/*const_cast*/PHINode /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::op_end", NM="_ZN4llvm7PHINode6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsPHINode.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::op_end", NM="_ZNK4llvm7PHINode6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsPHINode.op_end(((/*const_cast*/PHINode /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::Op", NM="Tpl__ZN4llvm7PHINode2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm7PHINode2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::Op", NM="Tpl__ZNK4llvm7PHINode2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm7PHINode2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2689,
   FQN="llvm::PHINode::getNumOperands", NM="_ZNK4llvm7PHINode14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsPHINode.operands(this);
  }


  // Block iterator interface. This provides access to the list of incoming
  // basic blocks, which parallels the list of incoming values.
  // JAVA: typedef BasicBlock **block_iterator
//  public final class block_iterator extends type$ptr<BasicBlock /*P*/ /*P*/>{ };
  // JAVA: typedef BasicBlock *const *const_block_iterator
//  public final class const_block_iterator extends type$ptr<BasicBlock /*P*/ /*const*/ /*P*/>{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::block_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2541,
   FQN="llvm::PHINode::block_begin", NM="_ZN4llvm7PHINode11block_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode11block_beginEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*P*/> block_begin() {
    //PointerUIntPair<User /*P*/ > /*P*/ ref = ((PointerUIntPair<User /*P*/ > /*P*/)reinterpret_cast(PointerUIntPair.class, op_begin().$add(ReservedSpace)));
    type$ptr<Use> ref = op_begin().$add(ReservedSpace);
    return ((type$ptr<BasicBlock /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, ref.$add(1)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::block_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2547,
   FQN="llvm::PHINode::block_begin", NM="_ZNK4llvm7PHINode11block_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode11block_beginEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> block_begin$Const() /*const*/ {
    ///*const*/PointerUIntPair<User /*P*/ > /*P*/ ref = ((/*const*/PointerUIntPair<User /*P*/ > /*P*/)reinterpret_cast(/*const*/PointerUIntPair.class, op_begin$Const().$add(ReservedSpace)));
    type$ptr<Use> ref = op_begin$Const().$add(ReservedSpace);
    return ((type$ptr<BasicBlock /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, ref.$add(1)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::block_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2553,
   FQN="llvm::PHINode::block_end", NM="_ZN4llvm7PHINode9block_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode9block_endEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*P*/> block_end() {
    return block_begin().$add(getNumOperands());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::block_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2557,
   FQN="llvm::PHINode::block_end", NM="_ZNK4llvm7PHINode9block_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode9block_endEv")
  //</editor-fold>
  public type$ptr<BasicBlock /*P*/ /*const*/ /*P*/> block_end$Const() /*const*/ {
    return block_begin$Const().$add(getNumOperands());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::blocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2561,
   FQN="llvm::PHINode::blocks", NM="_ZN4llvm7PHINode6blocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode6blocksEv")
  //</editor-fold>
  public iterator_range<BasicBlock /*P*/ > blocks() {
    return make_range(block_begin(), block_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::blocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2565,
   FQN="llvm::PHINode::blocks", NM="_ZNK4llvm7PHINode6blocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode6blocksEv")
  //</editor-fold>
  public iterator_range<BasicBlock /*P*/ /*const*/> blocks$Const() /*const*/ {
    return make_range(block_begin$Const(), block_end$Const());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::incoming_values">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2569,
   FQN="llvm::PHINode::incoming_values", NM="_ZN4llvm7PHINode15incoming_valuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode15incoming_valuesEv")
  //</editor-fold>
  public iterator_range<Use> incoming_values() {
    return operands();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::incoming_values">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2571,
   FQN="llvm::PHINode::incoming_values", NM="_ZNK4llvm7PHINode15incoming_valuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode15incoming_valuesEv")
  //</editor-fold>
  public iterator_range</*const*/ Use> incoming_values$Const() /*const*/ {
    return operands$Const();
  }


  /// getNumIncomingValues - Return the number of incoming edges
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getNumIncomingValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2575,
   FQN="llvm::PHINode::getNumIncomingValues", NM="_ZNK4llvm7PHINode20getNumIncomingValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode20getNumIncomingValuesEv")
  //</editor-fold>
  public /*uint*/int getNumIncomingValues() /*const*/ {
    return getNumOperands();
  }


  /// getIncomingValue - Return incoming value number x
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getIncomingValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2579,
   FQN="llvm::PHINode::getIncomingValue", NM="_ZNK4llvm7PHINode16getIncomingValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode16getIncomingValueEj")
  //</editor-fold>
  public Value /*P*/ getIncomingValue(/*uint*/int i) /*const*/ {
    return getOperand(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::setIncomingValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2582,
   FQN="llvm::PHINode::setIncomingValue", NM="_ZN4llvm7PHINode16setIncomingValueEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode16setIncomingValueEjPNS_5ValueE")
  //</editor-fold>
  public void setIncomingValue(/*uint*/int i, Value /*P*/ V) {
    assert ((V != null)) : "PHI node got a null value!";
    assert (getType() == V.getType()) : "All operands to PHI node must be the same type as the PHI node!";
    setOperand(i, V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getOperandNumForIncomingValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2588,
   FQN="llvm::PHINode::getOperandNumForIncomingValue", NM="_ZN4llvm7PHINode29getOperandNumForIncomingValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode29getOperandNumForIncomingValueEj")
  //</editor-fold>
  public static /*uint*/int getOperandNumForIncomingValue(/*uint*/int i) {
    return i;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getIncomingValueNumForOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2591,
   FQN="llvm::PHINode::getIncomingValueNumForOperand", NM="_ZN4llvm7PHINode29getIncomingValueNumForOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode29getIncomingValueNumForOperandEj")
  //</editor-fold>
  public static /*uint*/int getIncomingValueNumForOperand(/*uint*/int i) {
    return i;
  }


  /// getIncomingBlock - Return incoming basic block number @p i.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getIncomingBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2597,
   FQN="llvm::PHINode::getIncomingBlock", NM="_ZNK4llvm7PHINode16getIncomingBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode16getIncomingBlockEj")
  //</editor-fold>
  public BasicBlock /*P*/ getIncomingBlock(/*uint*/int i) /*const*/ {
    return block_begin$Const().$at(i);
  }


  /// getIncomingBlock - Return incoming basic block corresponding
  /// to an operand of the PHI.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getIncomingBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2604,
   FQN="llvm::PHINode::getIncomingBlock", NM="_ZNK4llvm7PHINode16getIncomingBlockERKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode16getIncomingBlockERKNS_3UseE")
  //</editor-fold>
  public BasicBlock /*P*/ getIncomingBlock(final /*const*/ Use /*&*/ U) /*const*/ {
    assert (this == U.getUser()) : "Iterator doesn't point to PHI's Uses?";
    return getIncomingBlock(((/*uint*/int)(U.$This$Ptr().$sub(op_begin$Const()))));
  }


  /// getIncomingBlock - Return incoming basic block corresponding
  /// to value use iterator.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getIncomingBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2612,
   FQN="llvm::PHINode::getIncomingBlock", NM="_ZNK4llvm7PHINode16getIncomingBlockENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode16getIncomingBlockENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public BasicBlock /*P*/ getIncomingBlock(Value.user_iterator_impl</*const*/ User> I) /*const*/ {
    return getIncomingBlock(I.getUse());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::setIncomingBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2616,
   FQN="llvm::PHINode::setIncomingBlock", NM="_ZN4llvm7PHINode16setIncomingBlockEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode16setIncomingBlockEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setIncomingBlock(/*uint*/int i, BasicBlock /*P*/ BB) {
    assert ((BB != null)) : "PHI node got a null basic block!";
    block_begin().$set(i, BB);
  }


  /// addIncoming - Add an incoming value to the end of the PHI list
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::addIncoming">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2623,
   FQN="llvm::PHINode::addIncoming", NM="_ZN4llvm7PHINode11addIncomingEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode11addIncomingEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  public void addIncoming(Value /*P*/ V, BasicBlock /*P*/ BB) {
    if (getNumOperands() == ReservedSpace) {
      growOperands(); // Get more space!
    }
    // Initialize some new operands.
    setNumHungOffUseOperands(getNumOperands() + 1);
    setIncomingValue(getNumOperands() - 1, V);
    setIncomingBlock(getNumOperands() - 1, BB);
  }


  /// removeIncomingValue - Remove an incoming value.  This is useful if a
  /// predecessor basic block is deleted.  The value removed is returned.
  ///
  /// If the last incoming value for a PHI node is removed (and DeletePHIIfEmpty
  /// is true), the PHI node is destroyed and any uses of it are replaced with
  /// dummy values.  The only time there should be zero incoming values to a PHI
  /// node is when the block is dead, so this strategy is sound.
  ///

  // removeIncomingValue - Remove an incoming value.  This is useful if a
  // predecessor basic block is deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::removeIncomingValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 103,
   FQN="llvm::PHINode::removeIncomingValue", NM="_ZN4llvm7PHINode19removeIncomingValueEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode19removeIncomingValueEjb")
  //</editor-fold>
  public Value /*P*/ removeIncomingValue(/*uint*/int Idx) {
    return removeIncomingValue(Idx, true);
  }
  public Value /*P*/ removeIncomingValue(/*uint*/int Idx, boolean DeletePHIIfEmpty/*= true*/) {
    Value /*P*/ Removed = getIncomingValue(Idx);

    // Move everything after this operand down.
    //
    // FIXME: we could just swap with the end of the list, then erase.  However,
    // clients might not expect this to happen.  The code as it is thrashes the
    // use/def lists, which is kinda lame.
    std.copy(op_begin().$add(Idx).$add(1), op_end(), op_begin().$add(Idx));
    std.copy(block_begin().$add(Idx).$add(1), block_end(), block_begin().$add(Idx));

    // Nuke the last value.
    this./*<-1>*/Op(-1).set((Value /*P*/ )null);
    setNumHungOffUseOperands(getNumOperands() - 1);

    // If the PHI node is dead, because it has zero entries, nuke it now.
    if (getNumOperands() == 0 && DeletePHIIfEmpty) {
      // If anyone is using this PHI, make them use a dummy value instead...
      replaceAllUsesWith(UndefValue.get(getType()));
      eraseFromParent();
    }
    return Removed;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::removeIncomingValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2642,
   FQN="llvm::PHINode::removeIncomingValue", NM="_ZN4llvm7PHINode19removeIncomingValueEPKNS_10BasicBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode19removeIncomingValueEPKNS_10BasicBlockEb")
  //</editor-fold>
  public Value /*P*/ removeIncomingValue(/*const*/ BasicBlock /*P*/ BB) {
    return removeIncomingValue(BB, true);
  }
  public Value /*P*/ removeIncomingValue(/*const*/ BasicBlock /*P*/ BB, boolean DeletePHIIfEmpty/*= true*/) {
    int Idx = getBasicBlockIndex(BB);
    assert (Idx >= 0) : "Invalid basic block argument to remove!";
    return removeIncomingValue(Idx, DeletePHIIfEmpty);
  }


  /// getBasicBlockIndex - Return the first index of the specified basic
  /// block in the value list for this PHI.  Returns -1 if no instance.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getBasicBlockIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2651,
   FQN="llvm::PHINode::getBasicBlockIndex", NM="_ZNK4llvm7PHINode18getBasicBlockIndexEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode18getBasicBlockIndexEPKNS_10BasicBlockE")
  //</editor-fold>
  public int getBasicBlockIndex(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i)  {
      if (block_begin$Const().$at(i) == BB) {
        return i;
      }
    }
    return -1;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::getIncomingValueForBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2658,
   FQN="llvm::PHINode::getIncomingValueForBlock", NM="_ZNK4llvm7PHINode24getIncomingValueForBlockEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode24getIncomingValueForBlockEPKNS_10BasicBlockE")
  //</editor-fold>
  public Value /*P*/ getIncomingValueForBlock(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    int Idx = getBasicBlockIndex(BB);
    assert (Idx >= 0) : "Invalid basic block argument!";
    return getIncomingValue(Idx);
  }


  /// hasConstantValue - If the specified PHI node always merges together the
  /// same value, return the value, otherwise return null.

  /// hasConstantValue - If the specified PHI node always merges together the same
  /// value, return the value, otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::hasConstantValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 142,
   FQN="llvm::PHINode::hasConstantValue", NM="_ZNK4llvm7PHINode16hasConstantValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode16hasConstantValueEv")
  //</editor-fold>
  public Value /*P*/ hasConstantValue() /*const*/ {
    // Exploit the fact that phi nodes always have at least one entry.
    Value /*P*/ ConstantValue = getIncomingValue(0);
    for (/*uint*/int i = 1, e = getNumIncomingValues(); i != e; ++i)  {
      if (getIncomingValue(i) != ConstantValue && getIncomingValue(i) != this) {
        if (ConstantValue != this) {
          return null; // Incoming values not all the same.
        }
        // The case where the first value is this PHI.
        ConstantValue = getIncomingValue(i);
      }
    }
    if (ConstantValue == this) {
      return UndefValue.get(getType());
    }
    return ConstantValue;
  }


  /// hasConstantOrUndefValue - Whether the specified PHI node always merges
  /// together the same value, assuming undefs are equal to a unique
  /// non-undef value.

  /// hasConstantOrUndefValue - Whether the specified PHI node always merges
  /// together the same value, assuming that undefs result in the same value as
  /// non-undefs.
  /// Unlike \ref hasConstantValue, this does not return a value because the
  /// unique non-undef incoming value need not dominate the PHI node.
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::hasConstantOrUndefValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 162,
   FQN="llvm::PHINode::hasConstantOrUndefValue", NM="_ZNK4llvm7PHINode23hasConstantOrUndefValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm7PHINode23hasConstantOrUndefValueEv")
  //</editor-fold>
  public boolean hasConstantOrUndefValue() /*const*/ {
    Value /*P*/ ConstantValue = null;
    for (/*uint*/int i = 0, e = getNumIncomingValues(); i != e; ++i) {
      Value /*P*/ Incoming = getIncomingValue(i);
      if (Incoming != this && !isa_UndefValue(Incoming)) {
        if ((ConstantValue != null) && ConstantValue != Incoming) {
          return false;
        }
        ConstantValue = Incoming;
      }
    }
    return true;
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2674,
   FQN="llvm::PHINode::classof", NM="_ZN4llvm7PHINode7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.PHI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2677,
   FQN="llvm::PHINode::classof", NM="_ZN4llvm7PHINode7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && PHINode.classof(cast_Instruction(V));
  }

/*private:*/

  /// growOperands - grow operands - This grows the operand list in response
  /// to a push_back style of operation.  This grows the number of ops by 1.5
  /// times.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::growOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 131,
   FQN="llvm::PHINode::growOperands", NM="_ZN4llvm7PHINode12growOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINode12growOperandsEv")
  //</editor-fold>
  private void growOperands() {
    /*uint*/int e = getNumOperands();
    /*uint*/int NumOps = e + $div_uint(e, 2);
    if ($less_uint(NumOps, 2)) {
      NumOps = 2; // 2 op PHI nodes are VERY common.
    }

    ReservedSpace = NumOps;
    growHungoffUses(ReservedSpace, /* IsPhi */ true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PHINode::~PHINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2478,
   FQN="llvm::PHINode::~PHINode", NM="_ZN4llvm7PHINodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm7PHINodeD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "ReservedSpace=" + ReservedSpace // NOI18N
              + super.toString(); // NOI18N
  }
}
