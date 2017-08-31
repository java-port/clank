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

package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// GetElementPtrConstantExpr - This class is private to Constants.cpp, and is
/// used behind the scenes to implement getelementpr constant exprs.
//<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 224,
 FQN="llvm::GetElementPtrConstantExpr", NM="_ZN4llvm25GetElementPtrConstantExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExprE")
//</editor-fold>
public class GetElementPtrConstantExpr extends /*public*/ ConstantExpr implements Destructors.ClassWithDestructor {
  private Type /*P*/ SrcElementTy;
  private Type /*P*/ ResElementTy;
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 233,
   FQN="llvm::GetElementPtrConstantExpr::anchor", NM="_ZN4llvm25GetElementPtrConstantExpr6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::GetElementPtrConstantExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2263,
   FQN="llvm::GetElementPtrConstantExpr::GetElementPtrConstantExpr", NM="_ZN4llvm25GetElementPtrConstantExprC1EPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExprC1EPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EES2_")
  //</editor-fold>
  private GetElementPtrConstantExpr(Type /*P*/ SrcElementTy, Constant /*P*/ C, ArrayRef<Constant /*P*/ > IdxList, Type /*P*/ DestTy) {
    // : ConstantExpr(DestTy, Instruction::GetElementPtr, OperandTraits<GetElementPtrConstantExpr>::op_end(this) - (IdxList.size() + 1), IdxList.size() + 1), SrcElementTy(SrcElementTy), ResElementTy(GetElementPtrInst::getIndexedType(SrcElementTy, IdxList)) 
    //START JInit
    super(DestTy, Instruction.MemoryOps.GetElementPtr, 
        OperandTraitsGetElementPtrConstantExpr.op_end(User.$BEING_CREATED()/*this*/).$sub((IdxList.size() + 1)), 
        IdxList.size() + 1);
    this.SrcElementTy = SrcElementTy;
    this.ResElementTy = GetElementPtrInst.getIndexedType_Type$P_ArrayRef$Constant$P(SrcElementTy, new ArrayRef<Constant /*P*/ >(IdxList));
    //END JInit
    this./*<0>*/Op(0).$assign(C);
    type$ptr<Use /*P*/> OperandList = $tryClone(getOperandList());
    for (/*uint*/int i = 0, E = IdxList.size(); i != E; ++i)  {
      OperandList.$at(i + 1).$assign(IdxList.$at(i));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 232,
   FQN="llvm::GetElementPtrConstantExpr::Create", NM="_ZN4llvm25GetElementPtrConstantExpr6CreateEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EES2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr6CreateEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EES2_j")
  //</editor-fold>
  public static GetElementPtrConstantExpr /*P*/ Create(Type /*P*/ SrcElementTy, Constant /*P*/ C, 
        ArrayRef<Constant /*P*/ > IdxList, 
        Type /*P*/ DestTy, /*uint*/int Flags) {
    GetElementPtrConstantExpr /*P*/ Result = ((/*JCast*/GetElementPtrConstantExpr /*P*/ )(/*NEW_EXPR [User::new]*//*IdxList.size() + 1 = *//*new (IdxList.size() + 1)*/ User.$new_FixedUses(IdxList.size() + 1, (type$ptr<?> New$Mem)->{
        return new GetElementPtrConstantExpr(SrcElementTy, C, new ArrayRef<Constant /*P*/ >(IdxList), DestTy);
     })));
    Result.SubclassOptionalData = $uchar2uchar_7bits($uint2uchar(Flags));
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::getSourceElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2277,
   FQN="llvm::GetElementPtrConstantExpr::getSourceElementType", NM="_ZNK4llvm25GetElementPtrConstantExpr20getSourceElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm25GetElementPtrConstantExpr20getSourceElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getSourceElementType() /*const*/ {
    return SrcElementTy;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::getResultElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2281,
   FQN="llvm::GetElementPtrConstantExpr::getResultElementType", NM="_ZNK4llvm25GetElementPtrConstantExpr20getResultElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm25GetElementPtrConstantExpr20getResultElementTypeEv")
  //</editor-fold>
  public Type /*P*/ getResultElementType() /*const*/ {
    return ResElementTy;
  }

/// Transparently provide more efficient getOperand methods.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::getOperand", NM="_ZNK4llvm25GetElementPtrConstantExpr10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm25GetElementPtrConstantExpr10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsGetElementPtrConstantExpr.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsGetElementPtrConstantExpr.op_begin(((/*const_cast*/GetElementPtrConstantExpr /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::setOperand", NM="_ZN4llvm25GetElementPtrConstantExpr10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsGetElementPtrConstantExpr.operands(this))) : "setOperand() out of range!";
    OperandTraitsGetElementPtrConstantExpr.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::op_begin", NM="_ZN4llvm25GetElementPtrConstantExpr8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsGetElementPtrConstantExpr.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::op_begin", NM="_ZNK4llvm25GetElementPtrConstantExpr8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm25GetElementPtrConstantExpr8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsGetElementPtrConstantExpr.op_begin(((/*const_cast*/GetElementPtrConstantExpr /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::op_end", NM="_ZN4llvm25GetElementPtrConstantExpr6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsGetElementPtrConstantExpr.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::op_end", NM="_ZNK4llvm25GetElementPtrConstantExpr6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm25GetElementPtrConstantExpr6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsGetElementPtrConstantExpr.op_end(((/*const_cast*/GetElementPtrConstantExpr /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::Op", NM="Tpl__ZN4llvm25GetElementPtrConstantExpr2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZN4llvm25GetElementPtrConstantExpr2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::Op", NM="Tpl__ZNK4llvm25GetElementPtrConstantExpr2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=Tpl__ZNK4llvm25GetElementPtrConstantExpr2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 327,
   FQN="llvm::GetElementPtrConstantExpr::getNumOperands", NM="_ZNK4llvm25GetElementPtrConstantExpr14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm25GetElementPtrConstantExpr14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsGetElementPtrConstantExpr.operands(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 245,
   FQN="llvm::GetElementPtrConstantExpr::classof", NM="_ZN4llvm25GetElementPtrConstantExpr7classofEPKNS_12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr7classofEPKNS_12ConstantExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ ConstantExpr /*P*/ CE) {
    return CE.getOpcode() == Instruction.MemoryOps.GetElementPtr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 248,
   FQN="llvm::GetElementPtrConstantExpr::classof", NM="_ZN4llvm25GetElementPtrConstantExpr7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm25GetElementPtrConstantExpr7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return isa_ConstantExpr(V) && GetElementPtrConstantExpr.classof(cast_ConstantExpr(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GetElementPtrConstantExpr::~GetElementPtrConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 224,
   FQN="llvm::GetElementPtrConstantExpr::~GetElementPtrConstantExpr", NM="_ZN4llvm25GetElementPtrConstantExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm25GetElementPtrConstantExprD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  
  @Override public String toString() {
    return "" + "SrcElementTy=" + SrcElementTy // NOI18N
              + ", ResElementTy=" + ResElementTy // NOI18N
              + super.toString(); // NOI18N
  }
}
