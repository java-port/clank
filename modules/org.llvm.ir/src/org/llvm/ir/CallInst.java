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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.*;
import static org.llvm.ir.java.IrSizeofAndAlignment.*;


//===----------------------------------------------------------------------===//
/// CallInst - This class represents a function call, abstracting a target
/// machine's calling convention.  This class uses low bit of the SubClassData
/// field to indicate whether or not this is a tail call.  The rest of the bits
/// hold the calling convention of the call.
///
//<editor-fold defaultstate="collapsed" desc="llvm::CallInst">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1353,
 FQN="llvm::CallInst", NM="_ZN4llvm8CallInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstE")
//</editor-fold>
public class CallInst extends /*public*/ Instruction implements /*public*/ CallOrInvokeInst, OperandBundleUser<CallInst, type$ptr<Use/*P*/> >, Destructors.ClassWithDestructor {
  private AttributeSet AttributeList; ///< parameter attributes for call
  private FunctionType /*P*/ FTy;
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 306,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1ERKS0_")
  //</editor-fold>
  protected/*private*/ CallInst(final /*const*/ CallInst /*&*/ CI) {
    // : Instruction(CI.getType(), Instruction::Call, OperandTraits<CallInst>::op_end(this) - CI.getNumOperands(), CI.getNumOperands()), OperandBundleUser<CallInst, User::op_iterator>(), AttributeList(CI.AttributeList), FTy(CI.FTy)
    //START JInit
    super(CI.getType(), Instruction.OtherOps.Call,
        OperandTraitsCallInst.<CallInst>op_end(User.$BEING_CREATED()).$sub(CI.getNumOperands()),
        CI.getNumOperands());
    $OperandBundleUser();
    this.AttributeList = new AttributeSet(CI.AttributeList);
    this.FTy = CI.FTy;
    //END JInit
    setTailCallKind(CI.getTailCallKind());
    setCallingConv(CI.getCallingConv());

    std.copy(CI.op_begin$Const(), CI.op_end$Const(), op_begin());
    std.copy(CI.bundle_op_info_begin$Const(), CI.bundle_op_info_end$Const(),
        bundle_op_info_begin());
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(CI.SubclassOptionalData));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::init">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1358,
   FQN="llvm::CallInst::init", NM="_ZN4llvm8CallInst4initEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst4initEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineE")
  //</editor-fold>
  private void init(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, final /*const*/ Twine /*&*/ NameStr) {
    init(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::init">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 248,
   FQN="llvm::CallInst::init", NM="_ZN4llvm8CallInst4initEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EENS5_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst4initEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EENS5_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineE")
  //</editor-fold>
  private void init(FunctionType /*P*/ FTy, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, final /*const*/ Twine /*&*/ NameStr) {
    this.FTy = FTy;
    assert (getNumOperands() == Args.size() + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1) : "NumOperands not set up?";
    this./*<-1>*/Op(-1).$assign(Func);
    assert ((Args.size() == FTy.getNumParams() || (FTy.isVarArg() && $greater_uint(Args.size(), FTy.getNumParams())))) : "Calling a function with bad signature!";

    for (/*uint*/int i = 0; i != Args.size(); ++i)  {
      assert (($greatereq_uint(i, FTy.getNumParams()) || FTy.getParamType(i) == Args.$at(i).getType())) : "Calling a function with a bad signature!";
    }

    std.copy(Args.begin(), Args.end(), op_begin(), (source, dest)->dest.$star().$assign(source.$star()));

    type$ptr<Use /*P*/> It = $tryClone(populateBundleOperandInfos(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), Args.size()));
    ///*J:(void)*/It;
    assert ($eq_ptr(It.$add(1), op_end())) : "Should add up!";

    setName(NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 275,
   FQN="llvm::CallInst::init", NM="_ZN4llvm8CallInst4initEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst4initEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  private void init(Value /*P*/ Func, final /*const*/ Twine /*&*/ NameStr) {
    FTy
       = cast_FunctionType(cast_PointerType(Func.getType()).getElementType());
    assert (getNumOperands() == 1) : "NumOperands not set up?";
    this./*<-1>*/Op(-1).$assign(Func);
    assert (FTy.getNumParams() == 0) : "Calling a function with bad signature";

    setName(NameStr);
  }


  /// Construct a CallInst given a range of arguments.
  /// \brief Construct a CallInst from a range of arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1882,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1EPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EENS5_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1EPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EENS5_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  protected/*private*/ CallInst(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : Instruction(Ty->getReturnType(), Instruction::Call, OperandTraits<CallInst>::op_end(this) - (Args.size() + CountBundleInputs(Bundles) + 1), unsigned int(Args.size() + CountBundleInputs(Bundles) + 1), InsertBefore), OperandBundleUser<CallInst, User::op_iterator>(), AttributeList()
    //START JInit
    super(Ty.getReturnType(), Instruction.OtherOps.Call,
        OperandTraitsCallInst.<CallInst>op_end(User.$BEING_CREATED()).$sub((Args.size() + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1)),
        ((/*uint*/int)(Args.size() + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1)),
        InsertBefore);
    $OperandBundleUser();
    this.AttributeList = new AttributeSet();
    //END JInit
    init(Ty, Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1373,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1EPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1EPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  protected/*private*/ /*inline*/ CallInst(JD$Value$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_Twine$C_Instruction$P _dparam, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : CallInst(cast<FunctionType>(cast<PointerType>(Func->getType())->getElementType()), Func, Args, Bundles, NameStr, InsertBefore)
    //START JInit
    this(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr, InsertBefore);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1380,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1EPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1EPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  protected/*private*/ /*inline*/ CallInst(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args, final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : CallInst(Func, Args, None, NameStr, InsertBefore)
    //START JInit
    /*ExprWithCleanups*/this(JD$Value$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_Twine$C_Instruction$P.INSTANCE, Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), NameStr, InsertBefore);
    //END JInit
  }


  /// Construct a CallInst given a range of arguments.
  /// \brief Construct a CallInst from a range of arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1870,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1EPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1EPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  protected/*private*/ CallInst(JD$Value$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_Twine$C_BasicBlock$P _dparam, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(cast<FunctionType>(cast<PointerType>(Func->getType())->getElementType())->getReturnType(), Instruction::Call, OperandTraits<CallInst>::op_end(this) - (Args.size() + CountBundleInputs(Bundles) + 1), unsigned int(Args.size() + CountBundleInputs(Bundles) + 1), InsertAtEnd), OperandBundleUser<CallInst, User::op_iterator>(), AttributeList()
    //START JInit
    super(cast_FunctionType(cast_PointerType(Func.getType()).
    getElementType()).getReturnType(),
        Instruction.OtherOps.Call, OperandTraitsCallInst.<CallInst>op_end(User.$BEING_CREATED()).$sub((Args.size() + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1)),
        ((/*uint*/int)(Args.size() + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1)), InsertAtEnd);
    $OperandBundleUser();
    this.AttributeList = new AttributeSet();
    //END JInit
    init(Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 286,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1EPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1EPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  protected/*private*/ CallInst(Value /*P*/ Func, final /*const*/ Twine /*&*/ Name,
      Instruction /*P*/ InsertBefore) {
    // : Instruction(cast<FunctionType>(cast<PointerType>(Func->getType())->getElementType())->getReturnType(), Instruction::Call, OperandTraits<CallInst>::op_end(this) - 1, 1, InsertBefore), OperandBundleUser<CallInst, User::op_iterator>(), AttributeList()
    //START JInit
    super(cast_FunctionType(cast_PointerType(Func.getType()).
    getElementType()).getReturnType(),
        Instruction.OtherOps.Call,
        OperandTraitsCallInst.<CallInst>op_end(User.$BEING_CREATED()).$sub(1),
        1, InsertBefore);
    $OperandBundleUser();
    this.AttributeList = new AttributeSet();
    //END JInit
    init(Func, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CallInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 296,
   FQN="llvm::CallInst::CallInst", NM="_ZN4llvm8CallInstC1EPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstC1EPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  protected/*private*/ CallInst(Value /*P*/ Func, final /*const*/ Twine /*&*/ Name,
      BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(cast<FunctionType>(cast<PointerType>(Func->getType())->getElementType())->getReturnType(), Instruction::Call, OperandTraits<CallInst>::op_end(this) - 1, 1, InsertAtEnd), OperandBundleUser<CallInst, User::op_iterator>(), AttributeList()
    //START JInit
    super(cast_FunctionType(cast_PointerType(Func.getType()).
    getElementType()).getReturnType(),
        Instruction.OtherOps.Call,
        OperandTraitsCallInst.<CallInst>op_end(User.$BEING_CREATED()).$sub(1),
        1, InsertAtEnd);
    $OperandBundleUser();
    this.AttributeList = new AttributeSet();
    //END JInit
    init(Func, Name);
  }


  /*friend  class OperandBundleUser<CallInst, User::op_iterator>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::hasDescriptor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1395,
   FQN="llvm::CallInst::hasDescriptor", NM="_ZNK4llvm8CallInst13hasDescriptorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst13hasDescriptorEv")
  //</editor-fold>
  /*friend*/ public boolean hasDescriptor() /*const*/ {
    return HasDescriptor;
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4007,
   FQN="llvm::CallInst::cloneImpl", NM="_ZNK4llvm8CallInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst9cloneImplEv")
  //</editor-fold>
  protected CallInst /*P*/ cloneImpl() /*const*/ {
    if (hasOperandBundles()) {
      /*uint*/int DescriptorBytes = getNumOperandBundles() * $sizeof_BundleOpInfo();
      return /*NEW_EXPR [User::new]*//*new (getNumOperands(), DescriptorBytes)*/ User.$new_FixedUsesAndDesc(getNumOperands(), DescriptorBytes, (type$ptr<?> New$Mem)->{
          return new CallInst(/*Deref*/this);
       });
    }
    return ((/*JCast*/CallInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new CallInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1403,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CallInst /*P*/ Create_Value1(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args) {
    return Create_Value1(Func, Args,
               new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
               new Twine(/*KEEP_STR*/$EMPTY),
               (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create_Value1(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/) {
    return Create_Value1(Func, Args,
               Bundles,
               new Twine(/*KEEP_STR*/$EMPTY),
               (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create_Value1(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
               final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create_Value1(Func, Args,
               Bundles,
               NameStr,
               (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create_Value1(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
               final /*const*/ Twine /*&*/ NameStr/*= ""*/,
               Instruction /*P*/ InsertBefore/*= null*/) {
    return CallInst.Create(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr, InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1411,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CallInst /*P*/ Create_Value2(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               final /*const*/ Twine /*&*/ NameStr) {
    return Create_Value2(Func, Args,
               NameStr,
               (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create_Value2(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               final /*const*/ Twine /*&*/ NameStr,
               Instruction /*P*/ InsertBefore/*= null*/) {
    return CallInst.Create(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), NameStr, InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1418,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CallInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
        final /*const*/ Twine /*&*/ NameStr) {
    return Create(Ty, Func, Args,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
        final /*const*/ Twine /*&*/ NameStr,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [User::new]*//*new (uintint(Args.size() + 1))*/ User.$new_FixedUses(((/*uint*/int)(Args.size() + 1)), (type$ptr<?> New$Mem)->{
        return new CallInst(Ty, Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1424,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EENS5_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_12FunctionTypeEPNS_5ValueENS_8ArrayRefIS4_EENS5_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CallInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args) {
    return Create(Ty, Func, Args,
        new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
        ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/) {
    return Create(Ty, Func, Args,
        Bundles,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
        ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(Ty, Func, Args,
        Bundles,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
        ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    /*const*//*uint*/int TotalOps = ((/*uint*/int)(Args.size())) + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1;
    /*const*//*uint*/int DescriptorBytes = Bundles.size() * $sizeof_BundleOpInfo();

    return /*NEW_EXPR [User::new]*//*new (TotalOps, DescriptorBytes)*/ User.$new_FixedUsesAndDesc(TotalOps, DescriptorBytes, (type$ptr<?> New$Mem)->{
        return new CallInst(Ty, Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1435,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EENS3_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CallInst /*P*/ Create_Value3(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
               final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    /*const*//*uint*/int TotalOps = ((/*uint*/int)(Args.size())) + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 1;
    /*const*//*uint*/int DescriptorBytes = Bundles.size() * $sizeof_BundleOpInfo();

    return /*NEW_EXPR [User::new]*//*new (TotalOps, DescriptorBytes)*/ User.$new_FixedUsesAndDesc(TotalOps, DescriptorBytes, (type$ptr<?> New$Mem)->{
        return new CallInst(JD$Value$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_Twine$C_BasicBlock$P.INSTANCE, Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr, InsertAtEnd);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1445,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CallInst /*P*/ Create_Value4(Value /*P*/ Func, ArrayRef<Value /*P*/ > Args,
               final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [User::new]*//*new (uintint(Args.size() + 1))*/ User.$new_FixedUses(((/*uint*/int)(Args.size() + 1)), (type$ptr<?> New$Mem)->{
        return new CallInst(JD$Value$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_Twine$C_BasicBlock$P.INSTANCE, Func, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), NameStr, InsertAtEnd);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1450,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_5ValueERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_5ValueERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CallInst /*P*/ Create(Value /*P*/ F) {
    return Create(F, new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create(Value /*P*/ F, final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(F, NameStr,
        (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create(Value /*P*/ F, final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return ((/*JCast*/CallInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new CallInst(F, NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1454,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPNS_5ValueERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CallInst /*P*/ Create(Value /*P*/ F, final /*const*/ Twine /*&*/ NameStr,
        BasicBlock /*P*/ InsertAtEnd) {
    return ((/*JCast*/CallInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (1)*/ User.$new_FixedUses(1, (type$ptr<?> New$Mem)->{
        return new CallInst(F, NameStr, InsertAtEnd);
     })));
  }


  /// \brief Create a clone of \p CI with a different set of operand bundles and
  /// insert it before \p InsertPt.
  ///
  /// The returned call instruction is identical \p CI in every way except that
  /// the operand bundles for the new instruction are set to the operand bundles
  /// in \p Bundles.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 320,
   FQN="llvm::CallInst::Create", NM="_ZN4llvm8CallInst6CreateEPS0_NS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6CreateEPS0_NS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEEPNS_11InstructionE")
  //</editor-fold>
  public static CallInst /*P*/ Create_CallInst1(CallInst /*P*/ CI, ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB) {
    return Create_CallInst1(CI, OpB,
                  (Instruction /*P*/ )null);
  }
  public static CallInst /*P*/ Create_CallInst1(CallInst /*P*/ CI, ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB,
                  Instruction /*P*/ InsertPt/*= null*/) {
    std.vector<Value /*P*/ > Args = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Converter<Use, Value> $C = (Use U) -> U.$Value$P();
      Args/*J*/= new std.vector<Value /*P*/ >(new convert_iterator<>(CI.arg_begin(), $C), new convert_iterator<>(CI.arg_end(), $C), (Value /*P*/ )null);

      CallInst /*P*/ NewCI = CallInst.Create_Value1(CI.getCalledValue(), new ArrayRef<Value /*P*/ >(Args, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpB), new Twine(CI.getName()),
          InsertPt);
      NewCI.setTailCallKind(CI.getTailCallKind());
      NewCI.setCallingConv(CI.getCallingConv());
      NewCI.SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(CI.SubclassOptionalData));
      NewCI.setAttributes(CI.getAttributes());
      NewCI.setDebugLoc($c$.track(new DebugLoc(CI.getDebugLoc()))); $c$.clean();
      return NewCI;
    } finally {
      if (Args != null) { Args.$destroy(); }
      $c$.$destroy();
    }
  }


  /// CreateMalloc - Generate the IR for a call to malloc:
  /// 1. Compute the malloc call's argument as the specified type's size,
  ///    possibly multiplied by the array size if the array size is not
  ///    constant 1.
  /// 2. Call malloc with that argument.
  /// 3. Bitcast the result of the malloc call to the specified type.

  /// CreateMalloc - Generate the IR for a call to malloc:
  /// 1. Compute the malloc call's argument as the specified type's size,
  ///    possibly multiplied by the array size if the array size is not
  ///    constant 1.
  /// 2. Call malloc with that argument.
  /// 3. Bitcast the result of the malloc call to the specified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateMalloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 528,
   FQN="llvm::CallInst::CreateMalloc", NM="_ZN4llvm8CallInst12CreateMallocEPNS_11InstructionEPNS_4TypeES4_PNS_5ValueES6_PNS_8FunctionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12CreateMallocEPNS_11InstructionEPNS_4TypeES4_PNS_5ValueES6_PNS_8FunctionERKNS_5TwineE")
  //</editor-fold>
  public static Instruction /*P*/ CreateMalloc(Instruction /*P*/ InsertBefore,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize) {
    return CreateMalloc(InsertBefore,
              IntPtrTy, AllocTy,
              AllocSize, (Value /*P*/ )null,
              (Function /*P*/ )null,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc(Instruction /*P*/ InsertBefore,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/) {
    return CreateMalloc(InsertBefore,
              IntPtrTy, AllocTy,
              AllocSize, ArraySize,
              (Function /*P*/ )null,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc(Instruction /*P*/ InsertBefore,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
              Function /*P*/ MallocF/*= null*/) {
    return CreateMalloc(InsertBefore,
              IntPtrTy, AllocTy,
              AllocSize, ArraySize,
              MallocF,
              new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc(Instruction /*P*/ InsertBefore,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
              Function /*P*/ MallocF/*= null*/,
              final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return InstructionsStatics.createMalloc(InsertBefore, (BasicBlock /*P*/ )null, IntPtrTy, AllocTy, AllocSize,
        ArraySize, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), MallocF, Name);
  }


  /// CreateMalloc - Generate the IR for a call to malloc:
  /// 1. Compute the malloc call's argument as the specified type's size,
  ///    possibly multiplied by the array size if the array size is not
  ///    constant 1.
  /// 2. Call malloc with that argument.
  /// 3. Bitcast the result of the malloc call to the specified type.
  /// Note: This function does not add the bitcast to the basic block, that is the
  /// responsibility of the caller.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateMalloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 555,
   FQN="llvm::CallInst::CreateMalloc", NM="_ZN4llvm8CallInst12CreateMallocEPNS_10BasicBlockEPNS_4TypeES4_PNS_5ValueES6_PNS_8FunctionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12CreateMallocEPNS_10BasicBlockEPNS_4TypeES4_PNS_5ValueES6_PNS_8FunctionERKNS_5TwineE")
  //</editor-fold>
  public static Instruction /*P*/ CreateMalloc(BasicBlock /*P*/ InsertAtEnd,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize) {
    return CreateMalloc(InsertAtEnd,
              IntPtrTy, AllocTy,
              AllocSize, (Value /*P*/ )null,
              (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc(BasicBlock /*P*/ InsertAtEnd,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/) {
    return CreateMalloc(InsertAtEnd,
              IntPtrTy, AllocTy,
              AllocSize, ArraySize,
              (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc(BasicBlock /*P*/ InsertAtEnd,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
              Function /*P*/ MallocF/*= null*/) {
    return CreateMalloc(InsertAtEnd,
              IntPtrTy, AllocTy,
              AllocSize, ArraySize,
              MallocF, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc(BasicBlock /*P*/ InsertAtEnd,
              Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
              Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
              Function /*P*/ MallocF/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return InstructionsStatics.createMalloc((Instruction /*P*/ )null, InsertAtEnd, IntPtrTy, AllocTy, AllocSize,
        ArraySize, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), MallocF, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateMalloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 536,
   FQN="llvm::CallInst::CreateMalloc", NM="_ZN4llvm8CallInst12CreateMallocEPNS_11InstructionEPNS_4TypeES4_PNS_5ValueES6_NS_8ArrayRefINS_17OperandBundleDefTIS6_EEEEPNS_8FunctionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12CreateMallocEPNS_11InstructionEPNS_4TypeES4_PNS_5ValueES6_NS_8ArrayRefINS_17OperandBundleDefTIS6_EEEEPNS_8FunctionERKNS_5TwineE")
  //</editor-fold>
  public static Instruction /*P*/ CreateMalloc1(Instruction /*P*/ InsertBefore,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize) {
    return CreateMalloc1(InsertBefore,
               IntPtrTy, AllocTy,
               AllocSize, (Value /*P*/ )null,
               new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
               (Function /*P*/ )null,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc1(Instruction /*P*/ InsertBefore,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/) {
    return CreateMalloc1(InsertBefore,
               IntPtrTy, AllocTy,
               AllocSize, ArraySize,
               new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
               (Function /*P*/ )null,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc1(Instruction /*P*/ InsertBefore,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB/*= None*/) {
    return CreateMalloc1(InsertBefore,
               IntPtrTy, AllocTy,
               AllocSize, ArraySize,
               OpB,
               (Function /*P*/ )null,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc1(Instruction /*P*/ InsertBefore,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB/*= None*/,
               Function /*P*/ MallocF/*= null*/) {
    return CreateMalloc1(InsertBefore,
               IntPtrTy, AllocTy,
               AllocSize, ArraySize,
               OpB,
               MallocF,
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc1(Instruction /*P*/ InsertBefore,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB/*= None*/,
               Function /*P*/ MallocF/*= null*/,
               final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return InstructionsStatics.createMalloc(InsertBefore, (BasicBlock /*P*/ )null, IntPtrTy, AllocTy, AllocSize,
        ArraySize, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpB), MallocF, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateMalloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 562,
   FQN="llvm::CallInst::CreateMalloc", NM="_ZN4llvm8CallInst12CreateMallocEPNS_10BasicBlockEPNS_4TypeES4_PNS_5ValueES6_NS_8ArrayRefINS_17OperandBundleDefTIS6_EEEEPNS_8FunctionERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12CreateMallocEPNS_10BasicBlockEPNS_4TypeES4_PNS_5ValueES6_NS_8ArrayRefINS_17OperandBundleDefTIS6_EEEEPNS_8FunctionERKNS_5TwineE")
  //</editor-fold>
  public static Instruction /*P*/ CreateMalloc2(BasicBlock /*P*/ InsertAtEnd,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize) {
    return CreateMalloc2(InsertAtEnd,
               IntPtrTy, AllocTy,
               AllocSize, (Value /*P*/ )null,
               new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
               (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc2(BasicBlock /*P*/ InsertAtEnd,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/) {
    return CreateMalloc2(InsertAtEnd,
               IntPtrTy, AllocTy,
               AllocSize, ArraySize,
               new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
               (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc2(BasicBlock /*P*/ InsertAtEnd,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB/*= None*/) {
    return CreateMalloc2(InsertAtEnd,
               IntPtrTy, AllocTy,
               AllocSize, ArraySize,
               OpB,
               (Function /*P*/ )null, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc2(BasicBlock /*P*/ InsertAtEnd,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB/*= None*/,
               Function /*P*/ MallocF/*= null*/) {
    return CreateMalloc2(InsertAtEnd,
               IntPtrTy, AllocTy,
               AllocSize, ArraySize,
               OpB,
               MallocF, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public static Instruction /*P*/ CreateMalloc2(BasicBlock /*P*/ InsertAtEnd,
               Type /*P*/ IntPtrTy, Type /*P*/ AllocTy,
               Value /*P*/ AllocSize, Value /*P*/ ArraySize/*= null*/,
               ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB/*= None*/,
               Function /*P*/ MallocF/*= null*/, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return InstructionsStatics.createMalloc((Instruction /*P*/ )null, InsertAtEnd, IntPtrTy, AllocTy, AllocSize,
        ArraySize, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpB), MallocF, Name);
  }

  /// CreateFree - Generate the IR for a call to the builtin free function.

  /// CreateFree - Generate the IR for a call to the builtin free function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 606,
   FQN="llvm::CallInst::CreateFree", NM="_ZN4llvm8CallInst10CreateFreeEPNS_5ValueEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst10CreateFreeEPNS_5ValueEPNS_11InstructionE")
  //</editor-fold>
  public static Instruction /*P*/ CreateFree(Value /*P*/ Source, Instruction /*P*/ InsertBefore) {
    return InstructionsStatics.createFree(Source, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), InsertBefore, (BasicBlock /*P*/ )null);
  }


  /// CreateFree - Generate the IR for a call to the builtin free function.
  /// Note: This function does not add the call to the basic block, that is the
  /// responsibility of the caller.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 618,
   FQN="llvm::CallInst::CreateFree", NM="_ZN4llvm8CallInst10CreateFreeEPNS_5ValueEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst10CreateFreeEPNS_5ValueEPNS_10BasicBlockE")
  //</editor-fold>
  public static Instruction /*P*/ CreateFree(Value /*P*/ Source, BasicBlock /*P*/ InsertAtEnd) {
    Instruction /*P*/ FreeCall = InstructionsStatics.createFree(Source, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), (Instruction /*P*/ )null, InsertAtEnd);
    assert ((FreeCall != null)) : "CreateFree did not create a CallInst";
    return FreeCall;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 609,
   FQN="llvm::CallInst::CreateFree", NM="_ZN4llvm8CallInst10CreateFreeEPNS_5ValueENS_8ArrayRefINS_17OperandBundleDefTIS2_EEEEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst10CreateFreeEPNS_5ValueENS_8ArrayRefINS_17OperandBundleDefTIS2_EEEEPNS_11InstructionE")
  //</editor-fold>
  public static Instruction /*P*/ CreateFree_Value$P_ArrayRef$OperandBundleDefT$P_Instruction$P(Value /*P*/ Source,
                                                               ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
                                                               Instruction /*P*/ InsertBefore) {
    return InstructionsStatics.createFree(Source, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), InsertBefore, (BasicBlock /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::CreateFree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 623,
   FQN="llvm::CallInst::CreateFree", NM="_ZN4llvm8CallInst10CreateFreeEPNS_5ValueENS_8ArrayRefINS_17OperandBundleDefTIS2_EEEEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst10CreateFreeEPNS_5ValueENS_8ArrayRefINS_17OperandBundleDefTIS2_EEEEPNS_10BasicBlockE")
  //</editor-fold>
  public static Instruction /*P*/ CreateFree_Value$P_ArrayRef$OperandBundleDefT$P_BasicBlock$P(Value /*P*/ Source,
                                                              ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
                                                              BasicBlock /*P*/ InsertAtEnd) {
    Instruction /*P*/ FreeCall = InstructionsStatics.createFree(Source, new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), (Instruction /*P*/ )null, InsertAtEnd);
    assert ((FreeCall != null)) : "CreateFree did not create a CallInst";
    return FreeCall;
  }



  //===----------------------------------------------------------------------===//
  //                        CallInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::~CallInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 245,
   FQN="llvm::CallInst::~CallInst", NM="_ZN4llvm8CallInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInstD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
    OperandBundleUser.super.$destroy$OperandBundleUser();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1510,
   FQN="llvm::CallInst::getFunctionType", NM="_ZNK4llvm8CallInst15getFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst15getFunctionTypeEv")
  //</editor-fold>
  public FunctionType /*P*/ getFunctionType() /*const*/ {
    return FTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::mutateFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1512,
   FQN="llvm::CallInst::mutateFunctionType", NM="_ZN4llvm8CallInst18mutateFunctionTypeEPNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst18mutateFunctionTypeEPNS_12FunctionTypeE")
  //</editor-fold>
  public void mutateFunctionType(FunctionType /*P*/ FTy) {
    mutateType(FTy.getReturnType());
    this.FTy = FTy;
  }


  // Note that 'musttail' implies 'tail'.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::TailCallKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1518,
   FQN="llvm::CallInst::TailCallKind", NM="_ZN4llvm8CallInst12TailCallKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12TailCallKindE")
  //</editor-fold>
  public enum TailCallKind implements Native.NativeUIntEnum {
    TCK_None(0),
    TCK_Tail(1),
    TCK_MustTail(2),
    TCK_NoTail(3);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TailCallKind valueOf(int val) {
      TailCallKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TailCallKind[] VALUES;
      private static final TailCallKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TailCallKind kind : TailCallKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TailCallKind[min < 0 ? (1-min) : 0];
        VALUES = new TailCallKind[max >= 0 ? (1+max) : 0];
        for (TailCallKind kind : TailCallKind.values()) {
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

    private final /*uint*/int value;
    private TailCallKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getTailCallKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1520,
   FQN="llvm::CallInst::getTailCallKind", NM="_ZNK4llvm8CallInst15getTailCallKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst15getTailCallKindEv")
  //</editor-fold>
  public TailCallKind getTailCallKind() /*const*/ {
    return TailCallKind.valueOf(getSubclassDataFromInstruction() & 3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1523,
   FQN="llvm::CallInst::isTailCall", NM="_ZNK4llvm8CallInst10isTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst10isTailCallEv")
  //</editor-fold>
  public boolean isTailCall() /*const*/ {
    /*uint*/int Kind = getSubclassDataFromInstruction() & 3;
    return Kind == TailCallKind.TCK_Tail.getValue() || Kind == TailCallKind.TCK_MustTail.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isMustTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1527,
   FQN="llvm::CallInst::isMustTailCall", NM="_ZNK4llvm8CallInst14isMustTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst14isMustTailCallEv")
  //</editor-fold>
  public boolean isMustTailCall() /*const*/ {
    return (getSubclassDataFromInstruction() & 3) == TailCallKind.TCK_MustTail.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isNoTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1530,
   FQN="llvm::CallInst::isNoTailCall", NM="_ZNK4llvm8CallInst12isNoTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12isNoTailCallEv")
  //</editor-fold>
  public boolean isNoTailCall() /*const*/ {
    return (getSubclassDataFromInstruction() & 3) == TailCallKind.TCK_NoTail.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setTailCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1533,
   FQN="llvm::CallInst::setTailCall", NM="_ZN4llvm8CallInst11setTailCallEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst11setTailCallEb")
  //</editor-fold>
  public void setTailCall() {
    setTailCall(true);
  }
  public void setTailCall(boolean isTC/*= true*/) {
    setInstructionSubclassData_CallInst($uint2ushort((getSubclassDataFromInstruction() & ~3)
           | ((/*uint*/int)((isTC ? TailCallKind.TCK_Tail : TailCallKind.TCK_None).getValue()))));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setTailCallKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1537,
   FQN="llvm::CallInst::setTailCallKind", NM="_ZN4llvm8CallInst15setTailCallKindENS0_12TailCallKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst15setTailCallKindENS0_12TailCallKindE")
  //</editor-fold>
  public void setTailCallKind(TailCallKind TCK) {
    setInstructionSubclassData_CallInst($uint2ushort((getSubclassDataFromInstruction() & ~3)
           | ((/*uint*/int)(TCK.getValue()))));
  }


  /// Provide fast operand accessors
  /*public:*/

  // Note: if you get compile errors about private methods then
  //       please update your code to use the high-level operand
  //       interfaces. See line 943 above.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::getOperand", NM="_ZNK4llvm8CallInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsCallInst.<CallInst>operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsCallInst.<CallInst>op_begin(((/*const_cast*/CallInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::setOperand", NM="_ZN4llvm8CallInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsCallInst.<CallInst>operands(this))) : "setOperand() out of range!";
    OperandTraitsCallInst.<CallInst>op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::op_begin", NM="_ZN4llvm8CallInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsCallInst.<CallInst>op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::op_begin", NM="_ZNK4llvm8CallInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsCallInst.<CallInst>op_begin(((/*const_cast*/CallInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::op_end", NM="_ZN4llvm8CallInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsCallInst.<CallInst>op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::op_end", NM="_ZNK4llvm8CallInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsCallInst.<CallInst>op_end(((/*const_cast*/CallInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::Op", NM="Tpl__ZN4llvm8CallInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm8CallInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this.OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::Op", NM="Tpl__ZNK4llvm8CallInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm8CallInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this.OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1896,
   FQN="llvm::CallInst::getNumOperands", NM="_ZNK4llvm8CallInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsCallInst.<CallInst>operands(this);
  }


  /// getNumArgOperands - Return the number of call arguments.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getNumArgOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1547,
   FQN="llvm::CallInst::getNumArgOperands", NM="_ZNK4llvm8CallInst17getNumArgOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst17getNumArgOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumArgOperands() /*const*/ {
    return getNumOperands() - getNumTotalBundleOperands() - 1;
  }


  /// getArgOperand/setArgOperand - Return/set the i-th call argument.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1553,
   FQN="llvm::CallInst::getArgOperand", NM="_ZNK4llvm8CallInst13getArgOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst13getArgOperandEj")
  //</editor-fold>
  public Value /*P*/ getArgOperand(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    return getOperand(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1557,
   FQN="llvm::CallInst::setArgOperand", NM="_ZN4llvm8CallInst13setArgOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst13setArgOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setArgOperand(/*uint*/int i, Value /*P*/ v) {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    setOperand(i, v);
  }


  /// \brief Return the iterator pointing to the beginning of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1563,
   FQN="llvm::CallInst::arg_begin", NM="_ZN4llvm8CallInst9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst9arg_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> arg_begin() {
    return op_begin();
  }


  /// \brief Return the iterator pointing to the end of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1566,
   FQN="llvm::CallInst::arg_end", NM="_ZN4llvm8CallInst7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst7arg_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> arg_end() {
    // [ call args ], [ operand bundles ], callee
    return op_end().$sub(getNumTotalBundleOperands()).$sub(1);
  }


  /// \brief Iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::arg_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1572,
   FQN="llvm::CallInst::arg_operands", NM="_ZN4llvm8CallInst12arg_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12arg_operandsEv")
  //</editor-fold>
  public iterator_range<Use> arg_operands() {
    return make_range(arg_begin(), arg_end());
  }


  /// \brief Return the iterator pointing to the beginning of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1577,
   FQN="llvm::CallInst::arg_begin", NM="_ZNK4llvm8CallInst9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst9arg_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> arg_begin$Const() /*const*/ {
    return op_begin$Const();
  }


  /// \brief Return the iterator pointing to the end of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1580,
   FQN="llvm::CallInst::arg_end", NM="_ZNK4llvm8CallInst7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst7arg_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> arg_end$Const() /*const*/ {
    // [ call args ], [ operand bundles ], callee
    return op_end$Const().$sub(getNumTotalBundleOperands()).$sub(1);
  }


  /// \brief Iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::arg_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1586,
   FQN="llvm::CallInst::arg_operands", NM="_ZNK4llvm8CallInst12arg_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12arg_operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ Use> arg_operands$Const() /*const*/ {
    return make_range(arg_begin$Const(), arg_end$Const());
  }


  /// \brief Wrappers for getting the \c Use of a call argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getArgOperandUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1591,
   FQN="llvm::CallInst::getArgOperandUse", NM="_ZNK4llvm8CallInst16getArgOperandUseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst16getArgOperandUseEj")
  //</editor-fold>
  public /*const*/ Use /*&*/ getArgOperandUse$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    return getOperandUse$Const(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getArgOperandUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1595,
   FQN="llvm::CallInst::getArgOperandUse", NM="_ZN4llvm8CallInst16getArgOperandUseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst16getArgOperandUseEj")
  //</editor-fold>
  public Use /*&*/ getArgOperandUse(/*uint*/int i) {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    return getOperandUse(i);
  }


  /// If one of the arguments has the 'returned' attribute, return its
  /// operand value. Otherwise, return nullptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getReturnedArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 334,
   FQN="llvm::CallInst::getReturnedArgOperand", NM="_ZNK4llvm8CallInst21getReturnedArgOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst21getReturnedArgOperandEv")
  //</editor-fold>
  public Value /*P*/ getReturnedArgOperand() /*const*/ {
    uint$ptr Index = create_uint$ptr();
    if (AttributeList.hasAttrSomewhere(Attribute.AttrKind.Returned, $AddrOf(Index)) && (Index.$star() != 0)) {
      return getArgOperand(Index.$star() - 1);
    }
    {
      /*const*/ Function /*P*/ F = getCalledFunction();
      if ((F != null)) {
        if (F.getAttributes().hasAttrSomewhere(Attribute.AttrKind.Returned, $AddrOf(Index))
           && (Index.$star() != 0)) {
          return getArgOperand(Index.$star() - 1);
        }
      }
    }

    return null;
  }


  /// getCallingConv/setCallingConv - Get or set the calling convention of this
  /// function call.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1606,
   FQN="llvm::CallInst::getCallingConv", NM="_ZNK4llvm8CallInst14getCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst14getCallingConvEv")
  //</editor-fold>
  public /*uint*/int getCallingConv() /*const*/ {
    return ((/*static_cast*//*uint*/int)(getSubclassDataFromInstruction() >>> 2));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1609,
   FQN="llvm::CallInst::setCallingConv", NM="_ZN4llvm8CallInst14setCallingConvEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst14setCallingConvEj")
  //</editor-fold>
  public void setCallingConv(/*uint*/int CC) {
    /*uint*/int ID = ((/*static_cast*//*uint*/int)(CC));
    assert (!((ID & ~CallingConv.MaxID) != 0)) : "Unsupported calling convention";
    setInstructionSubclassData_CallInst($uint2ushort((getSubclassDataFromInstruction() & 3)
           | (ID << 2)));
  }


  /// getAttributes - Return the parameter attributes for this call.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1618,
   FQN="llvm::CallInst::getAttributes", NM="_ZNK4llvm8CallInst13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst13getAttributesEv")
  //</editor-fold>
  public /*const*/ AttributeSet /*&*/ getAttributes() /*const*/ {
    return AttributeList;
  }


  /// setAttributes - Set the parameter attributes for this call.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1622,
   FQN="llvm::CallInst::setAttributes", NM="_ZN4llvm8CallInst13setAttributesERKNS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst13setAttributesERKNS_12AttributeSetE")
  //</editor-fold>
  public void setAttributes(final /*const*/ AttributeSet /*&*/ Attrs) {
    AttributeList.$assign(Attrs);
  }


  /// addAttribute - adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 347,
   FQN="llvm::CallInst::addAttribute", NM="_ZN4llvm8CallInst12addAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12addAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addAttribute(getContext(), i, Kind));
    setAttributes(PAL);
  }


  /// addAttribute - adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 353,
   FQN="llvm::CallInst::addAttribute", NM="_ZN4llvm8CallInst12addAttributeEjNS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12addAttributeEjNS_9StringRefES1_")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, StringRef Kind, StringRef Value) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addAttribute(getContext(), i, new StringRef(Kind), new StringRef(Value)));
    setAttributes(PAL);
  }


  /// addAttribute - adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 359,
   FQN="llvm::CallInst::addAttribute", NM="_ZN4llvm8CallInst12addAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst12addAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute Attr) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addAttribute(getContext(), new ArrayRefUInt(i), new Attribute(Attr)));
    setAttributes(PAL);
  }


  /// removeAttribute - removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 365,
   FQN="llvm::CallInst::removeAttribute", NM="_ZN4llvm8CallInst15removeAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst15removeAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.removeAttribute(getContext(), i, Kind));
    setAttributes(PAL);
  }


  /// removeAttribute - removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 371,
   FQN="llvm::CallInst::removeAttribute", NM="_ZN4llvm8CallInst15removeAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst15removeAttributeEjNS_9StringRefE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, StringRef Kind) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.removeAttribute(getContext(), i, new StringRef(Kind)));
    setAttributes(PAL);
  }


  /// removeAttribute - removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 377,
   FQN="llvm::CallInst::removeAttribute", NM="_ZN4llvm8CallInst15removeAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst15removeAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute Attr) {
    AttrBuilder B = null;
    try {
      AttributeSet PAL = new AttributeSet(getAttributes());
      B/*J*/= new AttrBuilder(Attr);
      final LLVMContext /*&*/ Context = getContext();
      PAL.$assignMove(PAL.removeAttributes(Context, i,
              AttributeSet.get(Context, i, B)));
      setAttributes(PAL);
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }


  /// \brief adds the dereferenceable attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::addDereferenceableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 386,
   FQN="llvm::CallInst::addDereferenceableAttr", NM="_ZN4llvm8CallInst22addDereferenceableAttrEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst22addDereferenceableAttrEjy")
  //</editor-fold>
  public void addDereferenceableAttr(/*uint*/int i, long/*uint64_t*/ Bytes) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addDereferenceableAttr(getContext(), i, Bytes));
    setAttributes(PAL);
  }


  /// \brief adds the dereferenceable_or_null attribute to the list of
  /// attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::addDereferenceableOrNullAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 392,
   FQN="llvm::CallInst::addDereferenceableOrNullAttr", NM="_ZN4llvm8CallInst28addDereferenceableOrNullAttrEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst28addDereferenceableOrNullAttrEjy")
  //</editor-fold>
  public void addDereferenceableOrNullAttr(/*uint*/int i, long/*uint64_t*/ Bytes) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addDereferenceableOrNullAttr(getContext(), i, Bytes));
    setAttributes(PAL);
  }


  /// \brief Determine whether this call has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::hasFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1650,
   FQN="llvm::CallInst::hasFnAttr", NM="_ZNK4llvm8CallInst9hasFnAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst9hasFnAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasFnAttr(Attribute.AttrKind Kind) /*const*/ {
    assert (Kind != Attribute.AttrKind.NoBuiltin) : "Use CallInst::isNoBuiltin() to check for Attribute::NoBuiltin";
    return hasFnAttrImpl(Kind);
  }


  /// \brief Determine whether this call has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::hasFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1657,
   FQN="llvm::CallInst::hasFnAttr", NM="_ZNK4llvm8CallInst9hasFnAttrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst9hasFnAttrENS_9StringRefE")
  //</editor-fold>
  public boolean hasFnAttr(StringRef Kind) /*const*/ {
    return hasFnAttrImpl(new StringRef(Kind));
  }


  /// \brief Determine whether the call or the callee has the given attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::paramHasAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 398,
   FQN="llvm::CallInst::paramHasAttr", NM="_ZNK4llvm8CallInst12paramHasAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12paramHasAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean paramHasAttr(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    assert ($less_uint(i, (getNumArgOperands() + 1))) : "Param index out of bounds!";
    if (AttributeList.hasAttribute(i, Kind)) {
      return true;
    }
    {
      /*const*/ Function /*P*/ F = getCalledFunction();
      if ((F != null)) {
        return F.getAttributes().hasAttribute(i, Kind);
      }
    }
    return false;
  }


  /// \brief Get the attribute of a given kind at a position.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 408,
   FQN="llvm::CallInst::getAttribute", NM="_ZNK4llvm8CallInst12getAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12getAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    return getAttributes().getAttribute(i, Kind);
  }


  /// \brief Get the attribute of a given kind at a position.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 412,
   FQN="llvm::CallInst::getAttribute", NM="_ZNK4llvm8CallInst12getAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12getAttributeEjNS_9StringRefE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, StringRef Kind) /*const*/ {
    return getAttributes().getAttribute(i, new StringRef(Kind));
  }


  /// \brief Return true if the data operand at index \p i has the attribute \p
  /// A.
  ///
  /// Data operands include call arguments and values used in operand bundles,
  /// but does not include the callee operand.  This routine dispatches to the
  /// underlying AttributeList or the OperandBundleUser as appropriate.
  ///
  /// The index \p i is interpreted as
  ///
  ///  \p i == Attribute::ReturnIndex  -> the return value
  ///  \p i in [1, arg_size + 1)  -> argument number (\p i - 1)
  ///  \p i in [arg_size + 1, data_operand_size + 1) -> bundle operand at index
  ///     (\p i - 1) in the operand list.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::dataOperandHasImpliedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 416,
   FQN="llvm::CallInst::dataOperandHasImpliedAttr", NM="_ZNK4llvm8CallInst25dataOperandHasImpliedAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst25dataOperandHasImpliedAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean dataOperandHasImpliedAttr(/*uint*/int i,
                           Attribute.AttrKind Kind) /*const*/ {
    // There are getNumOperands() - 1 data operands.  The last operand is the
    // callee.
    assert ($less_uint(i, getNumOperands())) : "Data operand index out of bounds!";

    // The attribute A can either be directly specified, if the operand in
    // question is a call argument; or be indirectly implied by the kind of its
    // containing operand bundle, if the operand is a bundle operand.
    if ($less_uint(i, (getNumArgOperands() + 1))) {
      return paramHasAttr(i, Kind);
    }
    assert (hasOperandBundles() && $greatereq_uint(i, (getBundleOperandsStartIndex() + 1))) : "Must be either a call argument or an operand bundle!";
    return bundleOperandHasAttr(i - 1, Kind);
  }


  /// \brief Extract the alignment for a call or parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getParamAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1686,
   FQN="llvm::CallInst::getParamAlignment", NM="_ZNK4llvm8CallInst17getParamAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst17getParamAlignmentEj")
  //</editor-fold>
  public /*uint*/int getParamAlignment(/*uint*/int i) /*const*/ {
    return AttributeList.getParamAlignment(i);
  }


  /// \brief Extract the number of dereferenceable bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1692,
   FQN="llvm::CallInst::getDereferenceableBytes", NM="_ZNK4llvm8CallInst23getDereferenceableBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst23getDereferenceableBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes(/*uint*/int i) /*const*/ {
    return AttributeList.getDereferenceableBytes(i);
  }


  /// \brief Extract the number of dereferenceable_or_null bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1698,
   FQN="llvm::CallInst::getDereferenceableOrNullBytes", NM="_ZNK4llvm8CallInst29getDereferenceableOrNullBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst29getDereferenceableOrNullBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes(/*uint*/int i) /*const*/ {
    return AttributeList.getDereferenceableOrNullBytes(i);
  }


  /// @brief Determine if the parameter or return value is marked with NoAlias
  /// attribute.
  /// @param n The parameter to check. 1 is the first parameter, 0 is the return
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::doesNotAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1705,
   FQN="llvm::CallInst::doesNotAlias", NM="_ZNK4llvm8CallInst12doesNotAliasEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12doesNotAliasEj")
  //</editor-fold>
  public boolean doesNotAlias(/*uint*/int n) /*const*/ {
    return AttributeList.hasAttribute(n, Attribute.AttrKind.NoAlias);
  }


  /// \brief Return true if the call should not be treated as a call to a
  /// builtin.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isNoBuiltin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1711,
   FQN="llvm::CallInst::isNoBuiltin", NM="_ZNK4llvm8CallInst11isNoBuiltinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst11isNoBuiltinEv")
  //</editor-fold>
  public boolean isNoBuiltin() /*const*/ {
    return hasFnAttrImpl(Attribute.AttrKind.NoBuiltin)
       && !hasFnAttrImpl(Attribute.AttrKind.Builtin);
  }


  /// \brief Return true if the call should not be inlined.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isNoInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1717,
   FQN="llvm::CallInst::isNoInline", NM="_ZNK4llvm8CallInst10isNoInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst10isNoInlineEv")
  //</editor-fold>
  public boolean isNoInline() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoInline);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setIsNoInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1718,
   FQN="llvm::CallInst::setIsNoInline", NM="_ZN4llvm8CallInst13setIsNoInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst13setIsNoInlineEv")
  //</editor-fold>
  public void setIsNoInline() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoInline);
  }


  /// \brief Return true if the call can return twice
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::canReturnTwice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1723,
   FQN="llvm::CallInst::canReturnTwice", NM="_ZNK4llvm8CallInst14canReturnTwiceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst14canReturnTwiceEv")
  //</editor-fold>
  public boolean canReturnTwice() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.ReturnsTwice);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setCanReturnTwice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1726,
   FQN="llvm::CallInst::setCanReturnTwice", NM="_ZN4llvm8CallInst17setCanReturnTwiceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst17setCanReturnTwiceEv")
  //</editor-fold>
  public void setCanReturnTwice() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReturnsTwice);
  }


  /// \brief Determine if the call does not access memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1731,
   FQN="llvm::CallInst::doesNotAccessMemory", NM="_ZNK4llvm8CallInst19doesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst19doesNotAccessMemoryEv")
  //</editor-fold>
  public boolean doesNotAccessMemory() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.ReadNone);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setDoesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1734,
   FQN="llvm::CallInst::setDoesNotAccessMemory", NM="_ZN4llvm8CallInst22setDoesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst22setDoesNotAccessMemoryEv")
  //</editor-fold>
  public void setDoesNotAccessMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadNone);
  }


  /// \brief Determine if the call does not access or only reads memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1739,
   FQN="llvm::CallInst::onlyReadsMemory", NM="_ZNK4llvm8CallInst15onlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst15onlyReadsMemoryEv")
  //</editor-fold>
  public boolean onlyReadsMemory() /*const*/ {
    return doesNotAccessMemory() || hasFnAttr(Attribute.AttrKind.ReadOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setOnlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1742,
   FQN="llvm::CallInst::setOnlyReadsMemory", NM="_ZN4llvm8CallInst18setOnlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst18setOnlyReadsMemoryEv")
  //</editor-fold>
  public void setOnlyReadsMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadOnly);
  }


  /// \brief Determine if the call does not access or only writes memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::doesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1747,
   FQN="llvm::CallInst::doesNotReadMemory", NM="_ZNK4llvm8CallInst17doesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst17doesNotReadMemoryEv")
  //</editor-fold>
  public boolean doesNotReadMemory() /*const*/ {
    return doesNotAccessMemory() || hasFnAttr(Attribute.AttrKind.WriteOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setDoesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1750,
   FQN="llvm::CallInst::setDoesNotReadMemory", NM="_ZN4llvm8CallInst20setDoesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst20setDoesNotReadMemoryEv")
  //</editor-fold>
  public void setDoesNotReadMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.WriteOnly);
  }


  /// @brief Determine if the call can access memmory only using pointers based
  /// on its arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::onlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1756,
   FQN="llvm::CallInst::onlyAccessesArgMemory", NM="_ZNK4llvm8CallInst21onlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst21onlyAccessesArgMemoryEv")
  //</editor-fold>
  public boolean onlyAccessesArgMemory() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.ArgMemOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setOnlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1759,
   FQN="llvm::CallInst::setOnlyAccessesArgMemory", NM="_ZN4llvm8CallInst24setOnlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst24setOnlyAccessesArgMemoryEv")
  //</editor-fold>
  public void setOnlyAccessesArgMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ArgMemOnly);
  }


  /// \brief Determine if the call cannot return.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::doesNotReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1764,
   FQN="llvm::CallInst::doesNotReturn", NM="_ZNK4llvm8CallInst13doesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst13doesNotReturnEv")
  //</editor-fold>
  public boolean doesNotReturn() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoReturn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setDoesNotReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1765,
   FQN="llvm::CallInst::setDoesNotReturn", NM="_ZN4llvm8CallInst16setDoesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst16setDoesNotReturnEv")
  //</editor-fold>
  public void setDoesNotReturn() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoReturn);
  }


  /// \brief Determine if the call cannot unwind.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::doesNotThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1770,
   FQN="llvm::CallInst::doesNotThrow", NM="_ZNK4llvm8CallInst12doesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12doesNotThrowEv")
  //</editor-fold>
  public boolean doesNotThrow() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoUnwind);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setDoesNotThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1771,
   FQN="llvm::CallInst::setDoesNotThrow", NM="_ZN4llvm8CallInst15setDoesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst15setDoesNotThrowEv")
  //</editor-fold>
  public void setDoesNotThrow() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoUnwind);
  }


  /// \brief Determine if the call cannot be duplicated.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::cannotDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1776,
   FQN="llvm::CallInst::cannotDuplicate", NM="_ZNK4llvm8CallInst15cannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst15cannotDuplicateEv")
  //</editor-fold>
  public boolean cannotDuplicate() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoDuplicate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setCannotDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1777,
   FQN="llvm::CallInst::setCannotDuplicate", NM="_ZN4llvm8CallInst18setCannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst18setCannotDuplicateEv")
  //</editor-fold>
  public void setCannotDuplicate() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoDuplicate);
  }


  /// \brief Determine if the call is convergent
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1782,
   FQN="llvm::CallInst::isConvergent", NM="_ZNK4llvm8CallInst12isConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst12isConvergentEv")
  //</editor-fold>
  public boolean isConvergent() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.Convergent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1783,
   FQN="llvm::CallInst::setConvergent", NM="_ZN4llvm8CallInst13setConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst13setConvergentEv")
  //</editor-fold>
  public void setConvergent() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.Convergent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setNotConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1786,
   FQN="llvm::CallInst::setNotConvergent", NM="_ZN4llvm8CallInst16setNotConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst16setNotConvergentEv")
  //</editor-fold>
  public void setNotConvergent() {
    removeAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(),
        Attribute.get(getContext(), Attribute.AttrKind.Convergent));
  }


  /// \brief Determine if the call returns a structure through first
  /// pointer argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::hasStructRetAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1793,
   FQN="llvm::CallInst::hasStructRetAttr", NM="_ZNK4llvm8CallInst16hasStructRetAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst16hasStructRetAttrEv")
  //</editor-fold>
  public boolean hasStructRetAttr() /*const*/ {
    if (getNumArgOperands() == 0) {
      return false;
    }

    // Be friendly and also check the callee.
    return paramHasAttr(1, Attribute.AttrKind.StructRet);
  }


  /// \brief Determine if any call argument is an aggregate passed by value.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::hasByValArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1802,
   FQN="llvm::CallInst::hasByValArgument", NM="_ZNK4llvm8CallInst16hasByValArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst16hasByValArgumentEv")
  //</editor-fold>
  public boolean hasByValArgument() /*const*/ {
    return AttributeList.hasAttrSomewhere(Attribute.AttrKind.ByVal);
  }


  /// getCalledFunction - Return the function called, or null if this is an
  /// indirect function invocation.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getCalledFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1809,
   FQN="llvm::CallInst::getCalledFunction", NM="_ZNK4llvm8CallInst17getCalledFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst17getCalledFunctionEv")
  //</editor-fold>
  public Function /*P*/ getCalledFunction() /*const*/ {
    return dyn_cast_Function(this./*<-1>*/Op$Const(-1));
  }


  /// getCalledValue - Get a pointer to the function that is invoked by this
  /// instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getCalledValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1815,
   FQN="llvm::CallInst::getCalledValue", NM="_ZNK4llvm8CallInst14getCalledValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst14getCalledValueEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getCalledValue$Const() /*const*/ {
    return this./*<-1>*/Op$Const(-1).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::getCalledValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1816,
   FQN="llvm::CallInst::getCalledValue", NM="_ZN4llvm8CallInst14getCalledValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst14getCalledValueEv")
  //</editor-fold>
  public Value /*P*/ getCalledValue() {
    return this./*<-1>*/Op(-1).$Value$P();
  }


  /// setCalledFunction - Set the function called.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setCalledFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1819,
   FQN="llvm::CallInst::setCalledFunction", NM="_ZN4llvm8CallInst17setCalledFunctionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst17setCalledFunctionEPNS_5ValueE")
  //</editor-fold>
  public void setCalledFunction(Value /*P*/ Fn) {
    setCalledFunction(cast_FunctionType(cast_PointerType(Fn.getType()).getElementType()),
        Fn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setCalledFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1824,
   FQN="llvm::CallInst::setCalledFunction", NM="_ZN4llvm8CallInst17setCalledFunctionEPNS_12FunctionTypeEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst17setCalledFunctionEPNS_12FunctionTypeEPNS_5ValueE")
  //</editor-fold>
  public void setCalledFunction(FunctionType /*P*/ FTy, Value /*P*/ Fn) {
    this.FTy = FTy;
    assert (FTy == cast_FunctionType(cast_PointerType(Fn.getType()).getElementType()));
    this./*<-1>*/Op(-1).$assign(Fn);
  }


  /// isInlineAsm - Check if this call is an inline asm statement.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::isInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1832,
   FQN="llvm::CallInst::isInlineAsm", NM="_ZNK4llvm8CallInst11isInlineAsmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallInst11isInlineAsmEv")
  //</editor-fold>
  public boolean isInlineAsm() /*const*/ {
    return isa_InlineAsm(this./*<-1>*/Op$Const(-1));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1837,
   FQN="llvm::CallInst::classof", NM="_ZN4llvm8CallInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode()== Instruction.OtherOps.Call;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1840,
   FQN="llvm::CallInst::classof", NM="_ZN4llvm8CallInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CallInst.classof(cast_Instruction(V));
  }

/*private:*/
  /*template <typename AttrKind> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::hasFnAttrImpl">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1845,
   FQN="llvm::CallInst::hasFnAttrImpl", NM="Tpl__ZNK4llvm8CallInst13hasFnAttrImplET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm8CallInst13hasFnAttrImplET_")
  //</editor-fold>
  private boolean hasFnAttrImpl(Attribute.AttrKind A) /*const*/ {
    if (AttributeList.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A)) {
      return true;
    }

    // Operand bundles override attributes on the called function, but don't
    // override attributes directly present on the call instruction.
    if (isFnAttrDisallowedByOpBundle(A)) {
      return false;
    }
    {

      /*const*/ Function /*P*/ F = getCalledFunction();
      if ((F != null)) {
        return F.getAttributes().hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A);
      }
    }
    return false;
  }

  // Shadow Instruction::setInstructionSubclassData with a private forwarding
  // method so that subclasses cannot accidentally use it.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1861,
   FQN="llvm::CallInst::setInstructionSubclassData", NM="_ZN4llvm8CallInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_CallInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected CallInst() { throw new UnsupportedOperationException("EmptyBody"); }

  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1845)
  private boolean hasFnAttrImpl(StringRef A) /*const*/ {
    if (AttributeList.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A)) {
      return true;
    }

    // Operand bundles override attributes on the called function, but don't
    // override attributes directly present on the call instruction.
    if (isFnAttrDisallowedByOpBundle(A)) {
      return false;
    }
    {

      /*const*/ Function /*P*/ F = getCalledFunction();
      if ((F != null)) {
        return F.getAttributes().hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A);
      }
    }
    return false;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "AttributeList=" + AttributeList // NOI18N
              + ", FTy=" + FTy // NOI18N
              + super.toString(); // NOI18N
  }
}
