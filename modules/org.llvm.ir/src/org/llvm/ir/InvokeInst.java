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
import static org.llvm.ir.java.IrSizeofAndAlignment.$sizeof_BundleOpInfo;


//===----------------------------------------------------------------------===//
//                               InvokeInst Class
//===----------------------------------------------------------------------===//

/// InvokeInst - Invoke instruction.  The SubclassData field is used to hold the
/// calling convention of the call.
///
//<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3391,
 FQN="llvm::InvokeInst", NM="_ZN4llvm10InvokeInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInstE")
//</editor-fold>
public class InvokeInst extends /*public*/ TerminatorInst implements /*public*/ OperandBundleUser<InvokeInst, type$ptr<Use/*P*/> >, CallOrInvokeInst, Destructors.ClassWithDestructor {
  private AttributeSet AttributeList;
  private FunctionType /*P*/ FTy;
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::InvokeInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 667,
   FQN="llvm::InvokeInst::InvokeInst", NM="_ZN4llvm10InvokeInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInstC1ERKS0_")
  //</editor-fold>
  private InvokeInst(final /*const*/ InvokeInst /*&*/ II) {
    // : TerminatorInst(II.getType(), Instruction::Invoke, OperandTraits<InvokeInst>::op_end(this) - II.getNumOperands(), II.getNumOperands()), OperandBundleUser<InvokeInst, User::op_iterator>(), AttributeList(II.AttributeList), FTy(II.FTy)
    //START JInit
    super(II.getType(), Instruction.TermOps.Invoke,
        OperandTraitsInvokeInst.<InvokeInst>op_end(User.$BEING_CREATED()/*this*/).$sub(II.getNumOperands()),
        II.getNumOperands());
    $OperandBundleUser();
    this.AttributeList = new AttributeSet(II.AttributeList);
    this.FTy = II.FTy;
    //END JInit
    setCallingConv(II.getCallingConv());
    std.copy(II.op_begin$Const(), II.op_end$Const(), op_begin());
    std.copy(II.bundle_op_info_begin$Const(), II.bundle_op_info_end$Const(),
        bundle_op_info_begin());
    SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(II.SubclassOptionalData));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3396,
   FQN="llvm::InvokeInst::init", NM="_ZN4llvm10InvokeInst4initEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst4initEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineE")
  //</editor-fold>
  private void init(Value /*P*/ Func, BasicBlock /*P*/ IfNormal, BasicBlock /*P*/ IfException,
      ArrayRef<Value /*P*/ > Args, ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
      final /*const*/ Twine /*&*/ NameStr) {
    init(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr);
  }


  //===----------------------------------------------------------------------===//
  //                        InvokeInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::init">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 635,
   FQN="llvm::InvokeInst::init", NM="_ZN4llvm10InvokeInst4initEPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EENS7_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst4initEPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EENS7_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineE")
  //</editor-fold>
  private void init(FunctionType /*P*/ FTy, Value /*P*/ Fn, BasicBlock /*P*/ IfNormal,
      BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
      final /*const*/ Twine /*&*/ NameStr) {
    this.FTy = FTy;
    assert (getNumOperands() == 3 + Args.size() + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles))) : "NumOperands not set up?";
    this./*<-3>*/Op(-3).$assign(Fn);
    this./*<-2>*/Op(-2).$assign(IfNormal);
    this./*<-1>*/Op(-1).$assign(IfException);
    assert (((Args.size() == FTy.getNumParams()) || (FTy.isVarArg() && $greater_uint(Args.size(), FTy.getNumParams())))) : "Invoking a function with bad signature";

    for (/*uint*/int i = 0, e = Args.size(); i != e; i++)  {
      assert (($greatereq_uint(i, FTy.getNumParams()) || FTy.getParamType(i) == Args.$at(i).getType())) : "Invoking a function with a bad signature!";
    }

    std.copy(Args.begin(), Args.end(), op_begin(), (source, dest)->dest.$star().$assign(source.$star()));

    type$ptr<Use /*P*/> It = $tryClone(populateBundleOperandInfos(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), Args.size()));
    ///*J:(void)*/It;
    assert ($eq_ptr(It.$add(3), op_end())) : "Should add up!";

    setName(NameStr);
  }


  /// Construct an InvokeInst given a range of arguments.
  ///
  /// \brief Construct an InvokeInst from a range of arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::InvokeInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3410,
   FQN="llvm::InvokeInst::InvokeInst", NM="_ZN4llvm10InvokeInstC1EPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInstC1EPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private /*inline*/ InvokeInst(JD$Value$P_BasicBlock$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_UInt_Twine$C_Instruction$P _dparam, Value /*P*/ Func, BasicBlock /*P*/ IfNormal, BasicBlock /*P*/ IfException,
      ArrayRef<Value /*P*/ > Args, ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
      /*uint*/int Values, final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : InvokeInst(cast<FunctionType>(cast<PointerType>(Func->getType())->getElementType()), Func, IfNormal, IfException, Args, Bundles, Values, NameStr, InsertBefore)
    //START JInit
    this(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), Values, NameStr,
        InsertBefore);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::InvokeInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3863,
   FQN="llvm::InvokeInst::InvokeInst", NM="_ZN4llvm10InvokeInstC1EPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EENS7_INS_17OperandBundleDefTIS4_EEEEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInstC1EPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EENS7_INS_17OperandBundleDefTIS4_EEEEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private InvokeInst(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
      BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, /*uint*/int Values,
      final /*const*/ Twine /*&*/ NameStr, Instruction /*P*/ InsertBefore) {
    // : TerminatorInst(Ty->getReturnType(), Instruction::Invoke, OperandTraits<InvokeInst>::op_end(this) - Values, Values, InsertBefore), OperandBundleUser<InvokeInst, User::op_iterator>(), AttributeList()
    //START JInit
    super(Ty.getReturnType(), Instruction.TermOps.Invoke,
        OperandTraitsInvokeInst.<InvokeInst>op_end(User.$BEING_CREATED()/*this*/).$sub(Values), Values,
        InsertBefore);
    $OperandBundleUser();
    this.AttributeList = new AttributeSet();
    //END JInit
    init(Ty, Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr);
  }

  /// Construct an InvokeInst given a range of arguments.
  ///
  /// \brief Construct an InvokeInst from a range of arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::InvokeInst">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3872,
   FQN="llvm::InvokeInst::InvokeInst", NM="_ZN4llvm10InvokeInstC1EPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEEjRKNS_5TwineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInstC1EPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEEjRKNS_5TwineES4_")
  //</editor-fold>
  private InvokeInst(JD$Value$P_BasicBlock$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_UInt_Twine$C_BasicBlock$P _dparam, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
      BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
      ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles, /*uint*/int Values,
      final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    // : TerminatorInst(cast<FunctionType>(cast<PointerType>(Func->getType())->getElementType())->getReturnType(), Instruction::Invoke, OperandTraits<InvokeInst>::op_end(this) - Values, Values, InsertAtEnd), OperandBundleUser<InvokeInst, User::op_iterator>(), AttributeList()
    //START JInit
    super(cast_FunctionType(cast_PointerType(Func.getType()).
    getElementType()).getReturnType(),
        Instruction.TermOps.Invoke, OperandTraitsInvokeInst.<InvokeInst>op_end(User.$BEING_CREATED()/*this*/).$sub(Values),
        Values, InsertAtEnd);
    $OperandBundleUser();
    this.AttributeList = new AttributeSet();
    //END JInit
    init(Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr);
  }


  /*friend  class OperandBundleUser<InvokeInst, User::op_iterator>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::hasDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3432,
   FQN="llvm::InvokeInst::hasDescriptor", NM="_ZNK4llvm10InvokeInst13hasDescriptorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13hasDescriptorEv")
  //</editor-fold>
  /*friend*/ public/*private*/ boolean hasDescriptor() /*const*/ {
    return HasDescriptor;
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::cloneImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4055,
   FQN="llvm::InvokeInst::cloneImpl", NM="_ZNK4llvm10InvokeInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst9cloneImplEv")
  //</editor-fold>
  protected InvokeInst /*P*/ cloneImpl() /*const*/ {
    if (hasOperandBundles()) {
      /*uint*/int DescriptorBytes = getNumOperandBundles() * $sizeof_BundleOpInfo();
      return /*NEW_EXPR [User::new]*//*new (getNumOperands(), DescriptorBytes)*/ User.$new_FixedUsesAndDesc(getNumOperands(), DescriptorBytes, (type$ptr<?> New$Mem)->{
          return new InvokeInst(/*Deref*/this);
       });
    }
    return ((/*JCast*/InvokeInst /*P*/ )(/*NEW_EXPR [User::new]*//*getNumOperands() = *//*new (getNumOperands())*/ User.$new_FixedUses(getNumOperands(), (type$ptr<?> New$Mem)->{
        return new InvokeInst(/*Deref*/this);
     })));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3440,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static InvokeInst /*P*/ Create1(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
         final /*const*/ Twine /*&*/ NameStr) {
    return Create1(Func, IfNormal,
         IfException, Args,
         NameStr,
         (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create1(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
         final /*const*/ Twine /*&*/ NameStr,
         Instruction /*P*/ InsertBefore/*= null*/) {
    return InvokeInst.Create(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false), NameStr,
        InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3449,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static InvokeInst /*P*/ Create2(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args) {
    return Create2(Func, IfNormal,
         IfException, Args,
         new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
         new Twine(/*KEEP_STR*/$EMPTY),
         (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create2(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
         ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/) {
    return Create2(Func, IfNormal,
         IfException, Args,
         Bundles,
         new Twine(/*KEEP_STR*/$EMPTY),
         (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create2(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
         ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
         final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create2(Func, IfNormal,
         IfException, Args,
         Bundles,
         NameStr,
         (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create2(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
         ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
         final /*const*/ Twine /*&*/ NameStr/*= ""*/,
         Instruction /*P*/ InsertBefore/*= null*/) {
    return InvokeInst.Create(cast_FunctionType(cast_PointerType(Func.getType()).getElementType()),
        Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), NameStr,
        InsertBefore);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3459,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static InvokeInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
        BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
        final /*const*/ Twine /*&*/ NameStr) {
    return Create(Ty, Func, IfNormal,
        IfException, Args,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
        BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
        final /*const*/ Twine /*&*/ NameStr,
        Instruction /*P*/ InsertBefore/*= null*/) {
    /*uint*/int Values = ((/*uint*/int)(Args.size())) + 3;
    return /*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new InvokeInst(Ty, Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
                Values, NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3467,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EENS7_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPNS_12FunctionTypeEPNS_5ValueEPNS_10BasicBlockES6_NS_8ArrayRefIS4_EENS7_INS_17OperandBundleDefTIS4_EEEERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static InvokeInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
        BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args) {
    return Create(Ty, Func, IfNormal,
        IfException, Args,
        new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
        BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
        ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/) {
    return Create(Ty, Func, IfNormal,
        IfException, Args,
        Bundles,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
        BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
        ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(Ty, Func, IfNormal,
        IfException, Args,
        Bundles,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create(FunctionType /*P*/ Ty, Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
        BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
        ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles/*= None*/,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    /*uint*/int Values = ((/*uint*/int)(Args.size())) + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 3;
    /*uint*/int DescriptorBytes = Bundles.size() * $sizeof_BundleOpInfo();

    return /*NEW_EXPR [User::new]*//*new (Values, DescriptorBytes)*/ User.$new_FixedUsesAndDesc(Values, DescriptorBytes, (type$ptr<?> New$Mem)->{
        return new InvokeInst(Ty, Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), Values, 
                NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3479,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EERKNS_5TwineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EERKNS_5TwineES4_")
  //</editor-fold>
  public static InvokeInst /*P*/ Create3(Value /*P*/ Func,
         BasicBlock /*P*/ IfNormal, BasicBlock /*P*/ IfException,
         ArrayRef<Value /*P*/ > Args, final /*const*/ Twine /*&*/ NameStr,
         BasicBlock /*P*/ InsertAtEnd) {
    /*uint*/int Values = ((/*uint*/int)(Args.size())) + 3;
    return /*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new InvokeInst(JD$Value$P_BasicBlock$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_UInt_Twine$C_BasicBlock$P.INSTANCE, Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(None, false),
                Values, NameStr, InsertAtEnd);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3487,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPNS_5ValueEPNS_10BasicBlockES4_NS_8ArrayRefIS2_EENS5_INS_17OperandBundleDefTIS2_EEEERKNS_5TwineES4_")
  //</editor-fold>
  public static InvokeInst /*P*/ Create4(Value /*P*/ Func, BasicBlock /*P*/ IfNormal,
         BasicBlock /*P*/ IfException, ArrayRef<Value /*P*/ > Args,
         ArrayRef<OperandBundleDefT<Value /*P*/ >> Bundles,
         final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    /*uint*/int Values = ((/*uint*/int)(Args.size())) + OperandBundleUser.CountBundleInputs(new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles)) + 3;
    /*uint*/int DescriptorBytes = Bundles.size() * $sizeof_BundleOpInfo();

    return /*NEW_EXPR [User::new]*//*new (Values, DescriptorBytes)*/ User.$new_FixedUsesAndDesc(Values, DescriptorBytes, (type$ptr<?> New$Mem)->{
        return new InvokeInst(JD$Value$P_BasicBlock$P_ArrayRef$Value$P_ArrayRef$OperandBundleDefT$P_UInt_Twine$C_BasicBlock$P.INSTANCE, Func, IfNormal, IfException, new ArrayRef<Value /*P*/ >(Args), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(Bundles), Values, NameStr,
                InsertAtEnd);
     });
  }


  /// \brief Create a clone of \p II with a different set of operand bundles and
  /// insert it before \p InsertPt.
  ///
  /// The returned invoke instruction is identical to \p II in every way except
  /// that the operand bundles for the new instruction are set to the operand
  /// bundles in \p Bundles.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 680,
   FQN="llvm::InvokeInst::Create", NM="_ZN4llvm10InvokeInst6CreateEPS0_NS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6CreateEPS0_NS_8ArrayRefINS_17OperandBundleDefTIPNS_5ValueEEEEEPNS_11InstructionE")
  //</editor-fold>
  public static InvokeInst /*P*/ Create(InvokeInst /*P*/ II, ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB) {
    return Create(II, OpB,
        (Instruction /*P*/ )null);
  }
  public static InvokeInst /*P*/ Create(InvokeInst /*P*/ II, ArrayRef<OperandBundleDefT<Value /*P*/ >> OpB,
        Instruction /*P*/ InsertPt/*= null*/) {
    std.vector<Value /*P*/ > Args = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Converter<Use, Value> $C = (Use U) -> U.$Value$P();
      Args/*J*/= new std.vector<Value /*P*/ >(II.arg_begin(), II.arg_end(), (Value /*P*/ )null, $C);

      InvokeInst /*P*/ NewII = InvokeInst.Create2(II.getCalledValue(), II.getNormalDest(),
          II.getUnwindDest(), new ArrayRef<Value /*P*/ >(Args, true), new ArrayRef<OperandBundleDefT<Value /*P*/ >>(OpB),
          new Twine(II.getName()), InsertPt);
      NewII.setCallingConv(II.getCallingConv());
      NewII.SubclassOptionalData = $uchar2uchar_7bits($7bits_uchar2uchar(II.SubclassOptionalData));
      NewII.setAttributes(II.getAttributes());
      NewII.setDebugLoc($c$.track(new DebugLoc(II.getDebugLoc()))); $c$.clean();
      return NewII;
    } finally {
      if (Args != null) { Args.$destroy(); }
      $c$.$destroy();
    }
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::getOperand", NM="_ZNK4llvm10InvokeInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsInvokeInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsInvokeInst.op_begin(((/*const_cast*/InvokeInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::setOperand", NM="_ZN4llvm10InvokeInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsInvokeInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsInvokeInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::op_begin", NM="_ZN4llvm10InvokeInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsInvokeInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::op_begin", NM="_ZNK4llvm10InvokeInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsInvokeInst.op_begin(((/*const_cast*/InvokeInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::op_end", NM="_ZN4llvm10InvokeInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsInvokeInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::op_end", NM="_ZNK4llvm10InvokeInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsInvokeInst.op_end(((/*const_cast*/InvokeInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::Op", NM="Tpl__ZN4llvm10InvokeInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm10InvokeInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::Op">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::Op", NM="Tpl__ZNK4llvm10InvokeInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10InvokeInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3884,
   FQN="llvm::InvokeInst::getNumOperands", NM="_ZNK4llvm10InvokeInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsInvokeInst.operands(this);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3511,
   FQN="llvm::InvokeInst::getFunctionType", NM="_ZNK4llvm10InvokeInst15getFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst15getFunctionTypeEv")
  //</editor-fold>
  public FunctionType /*P*/ getFunctionType() /*const*/ {
    return FTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::mutateFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3513,
   FQN="llvm::InvokeInst::mutateFunctionType", NM="_ZN4llvm10InvokeInst18mutateFunctionTypeEPNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst18mutateFunctionTypeEPNS_12FunctionTypeE")
  //</editor-fold>
  public void mutateFunctionType(FunctionType /*P*/ FTy) {
    mutateType(FTy.getReturnType());
    this.FTy = FTy;
  }


  /// getNumArgOperands - Return the number of invoke arguments.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getNumArgOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3520,
   FQN="llvm::InvokeInst::getNumArgOperands", NM="_ZNK4llvm10InvokeInst17getNumArgOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst17getNumArgOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumArgOperands() /*const*/ {
    return getNumOperands() - getNumTotalBundleOperands() - 3;
  }


  /// getArgOperand/setArgOperand - Return/set the i-th invoke argument.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3526,
   FQN="llvm::InvokeInst::getArgOperand", NM="_ZNK4llvm10InvokeInst13getArgOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13getArgOperandEj")
  //</editor-fold>
  public Value /*P*/ getArgOperand(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    return getOperand(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3530,
   FQN="llvm::InvokeInst::setArgOperand", NM="_ZN4llvm10InvokeInst13setArgOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setArgOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setArgOperand(/*uint*/int i, Value /*P*/ v) {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    setOperand(i, v);
  }


  /// \brief Return the iterator pointing to the beginning of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3536,
   FQN="llvm::InvokeInst::arg_begin", NM="_ZN4llvm10InvokeInst9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst9arg_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> arg_begin() {
    return op_begin();
  }


  /// \brief Return the iterator pointing to the end of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3539,
   FQN="llvm::InvokeInst::arg_end", NM="_ZN4llvm10InvokeInst7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst7arg_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> arg_end() {
    // [ invoke args ], [ operand bundles ], normal dest, unwind dest, callee
    return op_end().$sub(getNumTotalBundleOperands()).$sub(3);
  }


  /// \brief Iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::arg_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3545,
   FQN="llvm::InvokeInst::arg_operands", NM="_ZN4llvm10InvokeInst12arg_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst12arg_operandsEv")
  //</editor-fold>
  public iterator_range<Use> arg_operands() {
    return make_range(arg_begin(), arg_end());
  }


  /// \brief Return the iterator pointing to the beginning of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3550,
   FQN="llvm::InvokeInst::arg_begin", NM="_ZNK4llvm10InvokeInst9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst9arg_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> arg_begin$Const() /*const*/ {
    return op_begin$Const();
  }


  /// \brief Return the iterator pointing to the end of the argument list.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3553,
   FQN="llvm::InvokeInst::arg_end", NM="_ZNK4llvm10InvokeInst7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst7arg_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> arg_end$Const() /*const*/ {
    // [ invoke args ], [ operand bundles ], normal dest, unwind dest, callee
    return op_end$Const().$sub(getNumTotalBundleOperands()).$sub(3);
  }


  /// \brief Iteration adapter for range-for loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::arg_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3559,
   FQN="llvm::InvokeInst::arg_operands", NM="_ZNK4llvm10InvokeInst12arg_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12arg_operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ Use> arg_operands$Const() /*const*/ {
    return make_range(arg_begin$Const(), arg_end$Const());
  }


  /// \brief Wrappers for getting the \c Use of a invoke argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getArgOperandUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3564,
   FQN="llvm::InvokeInst::getArgOperandUse", NM="_ZNK4llvm10InvokeInst16getArgOperandUseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst16getArgOperandUseEj")
  //</editor-fold>
  public /*const*/ Use /*&*/ getArgOperandUse$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    return getOperandUse$Const(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getArgOperandUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3568,
   FQN="llvm::InvokeInst::getArgOperandUse", NM="_ZN4llvm10InvokeInst16getArgOperandUseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst16getArgOperandUseEj")
  //</editor-fold>
  public Use /*&*/ getArgOperandUse(/*uint*/int i) {
    assert ($less_uint(i, getNumArgOperands())) : "Out of bounds!";
    return getOperandUse(i);
  }


  /// If one of the arguments has the 'returned' attribute, return its
  /// operand value. Otherwise, return nullptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getReturnedArgOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 704,
   FQN="llvm::InvokeInst::getReturnedArgOperand", NM="_ZNK4llvm10InvokeInst21getReturnedArgOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst21getReturnedArgOperandEv")
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
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3579,
   FQN="llvm::InvokeInst::getCallingConv", NM="_ZNK4llvm10InvokeInst14getCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst14getCallingConvEv")
  //</editor-fold>
  public /*uint*/int getCallingConv() /*const*/ {
    return ((/*static_cast*//*uint*/int)(getSubclassDataFromInstruction()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3582,
   FQN="llvm::InvokeInst::setCallingConv", NM="_ZN4llvm10InvokeInst14setCallingConvEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst14setCallingConvEj")
  //</editor-fold>
  public void setCallingConv(/*uint*/int CC) {
    /*uint*/int ID = ((/*static_cast*//*uint*/int)(CC));
    assert (!((ID & ~CallingConv.MaxID) != 0)) : "Unsupported calling convention";
    setInstructionSubclassData_InvokeInst($uint2ushort(ID));
  }


  /// getAttributes - Return the parameter attributes for this invoke.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3590,
   FQN="llvm::InvokeInst::getAttributes", NM="_ZNK4llvm10InvokeInst13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13getAttributesEv")
  //</editor-fold>
  public /*const*/ AttributeSet /*&*/ getAttributes() /*const*/ {
    return AttributeList;
  }


  /// setAttributes - Set the parameter attributes for this invoke.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3594,
   FQN="llvm::InvokeInst::setAttributes", NM="_ZN4llvm10InvokeInst13setAttributesERKNS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setAttributesERKNS_12AttributeSetE")
  //</editor-fold>
  public void setAttributes(final /*const*/ AttributeSet /*&*/ Attrs) {
    AttributeList.$assign(Attrs);
  }


  /// addAttribute - adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 745,
   FQN="llvm::InvokeInst::addAttribute", NM="_ZN4llvm10InvokeInst12addAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst12addAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addAttribute(getContext(), i, Kind));
    setAttributes(PAL);
  }


  /// addAttribute - adds the attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 751,
   FQN="llvm::InvokeInst::addAttribute", NM="_ZN4llvm10InvokeInst12addAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst12addAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute Attr) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addAttribute(getContext(), new ArrayRefUInt(i), new Attribute(Attr)));
    setAttributes(PAL);
  }


  /// removeAttribute - removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 757,
   FQN="llvm::InvokeInst::removeAttribute", NM="_ZN4llvm10InvokeInst15removeAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst15removeAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.removeAttribute(getContext(), i, Kind));
    setAttributes(PAL);
  }


  /// removeAttribute - removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 763,
   FQN="llvm::InvokeInst::removeAttribute", NM="_ZN4llvm10InvokeInst15removeAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst15removeAttributeEjNS_9StringRefE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, StringRef Kind) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.removeAttribute(getContext(), i, new StringRef(Kind)));
    setAttributes(PAL);
  }


  /// removeAttribute - removes the attribute from the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 769,
   FQN="llvm::InvokeInst::removeAttribute", NM="_ZN4llvm10InvokeInst15removeAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst15removeAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute Attr) {
    AttrBuilder B = null;
    try {
      AttributeSet PAL = new AttributeSet(getAttributes());
      B/*J*/= new AttrBuilder(Attr);
      PAL.$assignMove(PAL.removeAttributes(getContext(), i,
              AttributeSet.get(getContext(), i, B)));
      setAttributes(PAL);
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }


  /// \brief adds the dereferenceable attribute to the list of attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::addDereferenceableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 786,
   FQN="llvm::InvokeInst::addDereferenceableAttr", NM="_ZN4llvm10InvokeInst22addDereferenceableAttrEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst22addDereferenceableAttrEjy")
  //</editor-fold>
  public void addDereferenceableAttr(/*uint*/int i, long/*uint64_t*/ Bytes) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addDereferenceableAttr(getContext(), i, Bytes));
    setAttributes(PAL);
  }


  /// \brief adds the dereferenceable_or_null attribute to the list of
  /// attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::addDereferenceableOrNullAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 792,
   FQN="llvm::InvokeInst::addDereferenceableOrNullAttr", NM="_ZN4llvm10InvokeInst28addDereferenceableOrNullAttrEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst28addDereferenceableOrNullAttrEjy")
  //</editor-fold>
  public void addDereferenceableOrNullAttr(/*uint*/int i, long/*uint64_t*/ Bytes) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addDereferenceableOrNullAttr(getContext(), i, Bytes));
    setAttributes(PAL);
  }


  /// \brief Determine whether this call has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::hasFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3619,
   FQN="llvm::InvokeInst::hasFnAttr", NM="_ZNK4llvm10InvokeInst9hasFnAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst9hasFnAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasFnAttr(Attribute.AttrKind Kind) /*const*/ {
    assert (Kind != Attribute.AttrKind.NoBuiltin) : "Use CallInst::isNoBuiltin() to check for Attribute::NoBuiltin";
    return hasFnAttrImpl(Kind);
  }


  /// \brief Determine whether this call has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::hasFnAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3626,
   FQN="llvm::InvokeInst::hasFnAttr", NM="_ZNK4llvm10InvokeInst9hasFnAttrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst9hasFnAttrENS_9StringRefE")
  //</editor-fold>
  public boolean hasFnAttr(StringRef Kind) /*const*/ {
    return hasFnAttrImpl(new StringRef(Kind));
  }


  /// \brief Determine whether the call or the callee has the given attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::paramHasAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 717,
   FQN="llvm::InvokeInst::paramHasAttr", NM="_ZNK4llvm10InvokeInst12paramHasAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12paramHasAttrEjNS_9Attribute8AttrKindE")
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
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 777,
   FQN="llvm::InvokeInst::getAttribute", NM="_ZNK4llvm10InvokeInst12getAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12getAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i,
              Attribute.AttrKind Kind) /*const*/ {
    return getAttributes().getAttribute(i, Kind);
  }


  /// \brief Get the attribute of a given kind at a position.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 782,
   FQN="llvm::InvokeInst::getAttribute", NM="_ZNK4llvm10InvokeInst12getAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12getAttributeEjNS_9StringRefE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, StringRef Kind) /*const*/ {
    return getAttributes().getAttribute(i, new StringRef(Kind));
  }


  /// \brief Return true if the data operand at index \p i has the attribute \p
  /// A.
  ///
  /// Data operands include invoke arguments and values used in operand bundles,
  /// but does not include the invokee operand, or the two successor blocks.
  /// This routine dispatches to the underlying AttributeList or the
  /// OperandBundleUser as appropriate.
  ///
  /// The index \p i is interpreted as
  ///
  ///  \p i == Attribute::ReturnIndex  -> the return value
  ///  \p i in [1, arg_size + 1)  -> argument number (\p i - 1)
  ///  \p i in [arg_size + 1, data_operand_size + 1) -> bundle operand at index
  ///     (\p i - 1) in the operand list.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::dataOperandHasImpliedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 727,
   FQN="llvm::InvokeInst::dataOperandHasImpliedAttr", NM="_ZNK4llvm10InvokeInst25dataOperandHasImpliedAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst25dataOperandHasImpliedAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean dataOperandHasImpliedAttr(/*uint*/int i,
                           Attribute.AttrKind Kind) /*const*/ {
    // There are getNumOperands() - 3 data operands.  The last three operands are
    // the callee and the two successor basic blocks.
    assert ($less_uint(i, (getNumOperands() - 2))) : "Data operand index out of bounds!";

    // The attribute A can either be directly specified, if the operand in
    // question is an invoke argument; or be indirectly implied by the kind of its
    // containing operand bundle, if the operand is a bundle operand.
    if ($less_uint(i, (getNumArgOperands() + 1))) {
      return paramHasAttr(i, Kind);
    }
    assert (hasOperandBundles() && $greatereq_uint(i, (getBundleOperandsStartIndex() + 1))) : "Must be either an invoke argument or an operand bundle!";
    return bundleOperandHasAttr(i - 1, Kind);
  }


  /// \brief Extract the alignment for a call or parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getParamAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3656,
   FQN="llvm::InvokeInst::getParamAlignment", NM="_ZNK4llvm10InvokeInst17getParamAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst17getParamAlignmentEj")
  //</editor-fold>
  public /*uint*/int getParamAlignment(/*uint*/int i) /*const*/ {
    return AttributeList.getParamAlignment(i);
  }


  /// \brief Extract the number of dereferenceable bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3662,
   FQN="llvm::InvokeInst::getDereferenceableBytes", NM="_ZNK4llvm10InvokeInst23getDereferenceableBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst23getDereferenceableBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes(/*uint*/int i) /*const*/ {
    return AttributeList.getDereferenceableBytes(i);
  }


  /// \brief Extract the number of dereferenceable_or_null bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3668,
   FQN="llvm::InvokeInst::getDereferenceableOrNullBytes", NM="_ZNK4llvm10InvokeInst29getDereferenceableOrNullBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst29getDereferenceableOrNullBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes(/*uint*/int i) /*const*/ {
    return AttributeList.getDereferenceableOrNullBytes(i);
  }


  /// @brief Determine if the parameter or return value is marked with NoAlias
  /// attribute.
  /// @param n The parameter to check. 1 is the first parameter, 0 is the return
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::doesNotAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3675,
   FQN="llvm::InvokeInst::doesNotAlias", NM="_ZNK4llvm10InvokeInst12doesNotAliasEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12doesNotAliasEj")
  //</editor-fold>
  public boolean doesNotAlias(/*uint*/int n) /*const*/ {
    return AttributeList.hasAttribute(n, Attribute.AttrKind.NoAlias);
  }


  /// \brief Return true if the call should not be treated as a call to a
  /// builtin.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::isNoBuiltin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3681,
   FQN="llvm::InvokeInst::isNoBuiltin", NM="_ZNK4llvm10InvokeInst11isNoBuiltinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst11isNoBuiltinEv")
  //</editor-fold>
  public boolean isNoBuiltin() /*const*/ {
    // We assert in hasFnAttr if one passes in Attribute::NoBuiltin, so we have
    // to check it by hand.
    return hasFnAttrImpl(Attribute.AttrKind.NoBuiltin)
       && !hasFnAttrImpl(Attribute.AttrKind.Builtin);
  }


  /// \brief Return true if the call should not be inlined.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::isNoInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3689,
   FQN="llvm::InvokeInst::isNoInline", NM="_ZNK4llvm10InvokeInst10isNoInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst10isNoInlineEv")
  //</editor-fold>
  public boolean isNoInline() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoInline);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setIsNoInline">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3690,
   FQN="llvm::InvokeInst::setIsNoInline", NM="_ZN4llvm10InvokeInst13setIsNoInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setIsNoInlineEv")
  //</editor-fold>
  public void setIsNoInline() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoInline);
  }


  /// \brief Determine if the call does not access memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3695,
   FQN="llvm::InvokeInst::doesNotAccessMemory", NM="_ZNK4llvm10InvokeInst19doesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst19doesNotAccessMemoryEv")
  //</editor-fold>
  public boolean doesNotAccessMemory() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.ReadNone);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setDoesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3698,
   FQN="llvm::InvokeInst::setDoesNotAccessMemory", NM="_ZN4llvm10InvokeInst22setDoesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst22setDoesNotAccessMemoryEv")
  //</editor-fold>
  public void setDoesNotAccessMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadNone);
  }


  /// \brief Determine if the call does not access or only reads memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3703,
   FQN="llvm::InvokeInst::onlyReadsMemory", NM="_ZNK4llvm10InvokeInst15onlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst15onlyReadsMemoryEv")
  //</editor-fold>
  public boolean onlyReadsMemory() /*const*/ {
    return doesNotAccessMemory() || hasFnAttr(Attribute.AttrKind.ReadOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setOnlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3706,
   FQN="llvm::InvokeInst::setOnlyReadsMemory", NM="_ZN4llvm10InvokeInst18setOnlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst18setOnlyReadsMemoryEv")
  //</editor-fold>
  public void setOnlyReadsMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ReadOnly);
  }


  /// \brief Determine if the call does not access or only writes memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::doesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3711,
   FQN="llvm::InvokeInst::doesNotReadMemory", NM="_ZNK4llvm10InvokeInst17doesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst17doesNotReadMemoryEv")
  //</editor-fold>
  public boolean doesNotReadMemory() /*const*/ {
    return doesNotAccessMemory() || hasFnAttr(Attribute.AttrKind.WriteOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setDoesNotReadMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3714,
   FQN="llvm::InvokeInst::setDoesNotReadMemory", NM="_ZN4llvm10InvokeInst20setDoesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst20setDoesNotReadMemoryEv")
  //</editor-fold>
  public void setDoesNotReadMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.WriteOnly);
  }


  /// @brief Determine if the call access memmory only using it's pointer
  /// arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::onlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3720,
   FQN="llvm::InvokeInst::onlyAccessesArgMemory", NM="_ZNK4llvm10InvokeInst21onlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst21onlyAccessesArgMemoryEv")
  //</editor-fold>
  public boolean onlyAccessesArgMemory() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.ArgMemOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setOnlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3723,
   FQN="llvm::InvokeInst::setOnlyAccessesArgMemory", NM="_ZN4llvm10InvokeInst24setOnlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst24setOnlyAccessesArgMemoryEv")
  //</editor-fold>
  public void setOnlyAccessesArgMemory() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.ArgMemOnly);
  }


  /// \brief Determine if the call cannot return.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::doesNotReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3728,
   FQN="llvm::InvokeInst::doesNotReturn", NM="_ZNK4llvm10InvokeInst13doesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13doesNotReturnEv")
  //</editor-fold>
  public boolean doesNotReturn() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoReturn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setDoesNotReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3729,
   FQN="llvm::InvokeInst::setDoesNotReturn", NM="_ZN4llvm10InvokeInst16setDoesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst16setDoesNotReturnEv")
  //</editor-fold>
  public void setDoesNotReturn() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoReturn);
  }


  /// \brief Determine if the call cannot unwind.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::doesNotThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3734,
   FQN="llvm::InvokeInst::doesNotThrow", NM="_ZNK4llvm10InvokeInst12doesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12doesNotThrowEv")
  //</editor-fold>
  public boolean doesNotThrow() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoUnwind);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setDoesNotThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3735,
   FQN="llvm::InvokeInst::setDoesNotThrow", NM="_ZN4llvm10InvokeInst15setDoesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst15setDoesNotThrowEv")
  //</editor-fold>
  public void setDoesNotThrow() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoUnwind);
  }


  /// \brief Determine if the invoke cannot be duplicated.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::cannotDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3740,
   FQN="llvm::InvokeInst::cannotDuplicate", NM="_ZNK4llvm10InvokeInst15cannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst15cannotDuplicateEv")
  //</editor-fold>
  public boolean cannotDuplicate() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.NoDuplicate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setCannotDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3741,
   FQN="llvm::InvokeInst::setCannotDuplicate", NM="_ZN4llvm10InvokeInst18setCannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst18setCannotDuplicateEv")
  //</editor-fold>
  public void setCannotDuplicate() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.NoDuplicate);
  }


  /// \brief Determine if the invoke is convergent
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::isConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3746,
   FQN="llvm::InvokeInst::isConvergent", NM="_ZNK4llvm10InvokeInst12isConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12isConvergentEv")
  //</editor-fold>
  public boolean isConvergent() /*const*/ {
    return hasFnAttr(Attribute.AttrKind.Convergent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3747,
   FQN="llvm::InvokeInst::setConvergent", NM="_ZN4llvm10InvokeInst13setConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setConvergentEv")
  //</editor-fold>
  public void setConvergent() {
    addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), Attribute.AttrKind.Convergent);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setNotConvergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3750,
   FQN="llvm::InvokeInst::setNotConvergent", NM="_ZN4llvm10InvokeInst16setNotConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst16setNotConvergentEv")
  //</editor-fold>
  public void setNotConvergent() {
    removeAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(),
        Attribute.get(getContext(), Attribute.AttrKind.Convergent));
  }


  /// \brief Determine if the call returns a structure through first
  /// pointer argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::hasStructRetAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3757,
   FQN="llvm::InvokeInst::hasStructRetAttr", NM="_ZNK4llvm10InvokeInst16hasStructRetAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst16hasStructRetAttrEv")
  //</editor-fold>
  public boolean hasStructRetAttr() /*const*/ {
    if (getNumArgOperands() == 0) {
      return false;
    }

    // Be friendly and also check the callee.
    return paramHasAttr(1, Attribute.AttrKind.StructRet);
  }


  /// \brief Determine if any call argument is an aggregate passed by value.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::hasByValArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3766,
   FQN="llvm::InvokeInst::hasByValArgument", NM="_ZNK4llvm10InvokeInst16hasByValArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst16hasByValArgumentEv")
  //</editor-fold>
  public boolean hasByValArgument() /*const*/ {
    return AttributeList.hasAttrSomewhere(Attribute.AttrKind.ByVal);
  }


  /// getCalledFunction - Return the function called, or null if this is an
  /// indirect function invocation.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getCalledFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3773,
   FQN="llvm::InvokeInst::getCalledFunction", NM="_ZNK4llvm10InvokeInst17getCalledFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst17getCalledFunctionEv")
  //</editor-fold>
  public Function /*P*/ getCalledFunction() /*const*/ {
    return dyn_cast_Function(this./*<-3>*/Op$Const(-3));
  }


  /// getCalledValue - Get a pointer to the function that is invoked by this
  /// instruction
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getCalledValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3779,
   FQN="llvm::InvokeInst::getCalledValue", NM="_ZNK4llvm10InvokeInst14getCalledValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst14getCalledValueEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getCalledValue$Const() /*const*/ {
    return this./*<-3>*/Op$Const(-3).$Value$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getCalledValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3780,
   FQN="llvm::InvokeInst::getCalledValue", NM="_ZN4llvm10InvokeInst14getCalledValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst14getCalledValueEv")
  //</editor-fold>
  public Value /*P*/ getCalledValue() {
    return this./*<-3>*/Op(-3).$Value$P();
  }


  /// setCalledFunction - Set the function called.
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setCalledFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3783,
   FQN="llvm::InvokeInst::setCalledFunction", NM="_ZN4llvm10InvokeInst17setCalledFunctionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst17setCalledFunctionEPNS_5ValueE")
  //</editor-fold>
  public void setCalledFunction(Value /*P*/ Fn) {
    setCalledFunction(cast_FunctionType(cast_PointerType(Fn.getType()).getElementType()),
        Fn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setCalledFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3788,
   FQN="llvm::InvokeInst::setCalledFunction", NM="_ZN4llvm10InvokeInst17setCalledFunctionEPNS_12FunctionTypeEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst17setCalledFunctionEPNS_12FunctionTypeEPNS_5ValueE")
  //</editor-fold>
  public void setCalledFunction(FunctionType /*P*/ FTy, Value /*P*/ Fn) {
    this.FTy = FTy;
    assert (FTy == cast_FunctionType(cast_PointerType(Fn.getType()).getElementType()));
    this./*<-3>*/Op(-3).$assign(Fn);
  }


  // get*Dest - Return the destination basic blocks...
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getNormalDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3796,
   FQN="llvm::InvokeInst::getNormalDest", NM="_ZNK4llvm10InvokeInst13getNormalDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13getNormalDestEv")
  //</editor-fold>
  public BasicBlock /*P*/ getNormalDest() /*const*/ {
    return cast_BasicBlock(this./*<-2>*/Op$Const(-2));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3799,
   FQN="llvm::InvokeInst::getUnwindDest", NM="_ZNK4llvm10InvokeInst13getUnwindDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13getUnwindDestEv")
  //</editor-fold>
  public BasicBlock /*P*/ getUnwindDest() /*const*/ {
    return cast_BasicBlock(this./*<-1>*/Op$Const(-1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setNormalDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3802,
   FQN="llvm::InvokeInst::setNormalDest", NM="_ZN4llvm10InvokeInst13setNormalDestEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setNormalDestEPNS_10BasicBlockE")
  //</editor-fold>
  public void setNormalDest(BasicBlock /*P*/ B) {
    this./*<-2>*/Op(-2).$assign(reinterpret_cast(Value /*P*/ .class, B));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setUnwindDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3805,
   FQN="llvm::InvokeInst::setUnwindDest", NM="_ZN4llvm10InvokeInst13setUnwindDestEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setUnwindDestEPNS_10BasicBlockE")
  //</editor-fold>
  public void setUnwindDest(BasicBlock /*P*/ B) {
    this./*<-1>*/Op(-1).$assign(reinterpret_cast(Value /*P*/ .class, B));
  }


  /// getLandingPadInst - Get the landingpad instruction from the landing pad
  /// block (the unwind destination).
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getLandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 798,
   FQN="llvm::InvokeInst::getLandingPadInst", NM="_ZNK4llvm10InvokeInst17getLandingPadInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst17getLandingPadInstEv")
  //</editor-fold>
  public LandingPadInst /*P*/ getLandingPadInst() /*const*/ {
    return cast_LandingPadInst(getUnwindDest().getFirstNonPHI());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3813,
   FQN="llvm::InvokeInst::getSuccessor", NM="_ZNK4llvm10InvokeInst12getSuccessorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst12getSuccessorEj")
  //</editor-fold>
  public BasicBlock /*P*/ getSuccessor(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, 2)) : "Successor # out of range for invoke!";
    return i == 0 ? getNormalDest() : getUnwindDest();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setSuccessor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3818,
   FQN="llvm::InvokeInst::setSuccessor", NM="_ZN4llvm10InvokeInst12setSuccessorEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst12setSuccessorEjPNS_10BasicBlockE")
  //</editor-fold>
  public void setSuccessor(/*uint*/int idx, BasicBlock /*P*/ NewSucc) {
    assert ($less_uint(idx, 2)) : "Successor # out of range for invoke!";
    this./*<-2>*/Op$Addr(-2).$add(idx).$star().$assign(reinterpret_cast(Value /*P*/ .class, NewSucc));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getNumSuccessors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3823,
   FQN="llvm::InvokeInst::getNumSuccessors", NM="_ZNK4llvm10InvokeInst16getNumSuccessorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst16getNumSuccessorsEv")
  //</editor-fold>
  public /*uint*/int getNumSuccessors() /*const*/ {
    return 2;
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3826,
   FQN="llvm::InvokeInst::classof", NM="_ZN4llvm10InvokeInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return (I.getOpcode() == Instruction.TermOps.Invoke);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3829,
   FQN="llvm::InvokeInst::classof", NM="_ZN4llvm10InvokeInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && InvokeInst.classof(cast_Instruction(V));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 694,
   FQN="llvm::InvokeInst::getSuccessorV", NM="_ZNK4llvm10InvokeInst13getSuccessorVEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst13getSuccessorVEj")
  //</editor-fold>
  @Override protected/*private*/ BasicBlock /*P*/ getSuccessorV(/*uint*/int idx) /*const*//* override*/ {
    return getSuccessor(idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::getNumSuccessorsV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 697,
   FQN="llvm::InvokeInst::getNumSuccessorsV", NM="_ZNK4llvm10InvokeInst17getNumSuccessorsVEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm10InvokeInst17getNumSuccessorsVEv")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int getNumSuccessorsV() /*const*//* override*/ {
    return getNumSuccessors();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setSuccessorV">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 700,
   FQN="llvm::InvokeInst::setSuccessorV", NM="_ZN4llvm10InvokeInst13setSuccessorVEjPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst13setSuccessorVEjPNS_10BasicBlockE")
  //</editor-fold>
  @Override protected/*private*/ void setSuccessorV(/*uint*/int idx, BasicBlock /*P*/ B)/* override*/ {
    setSuccessor(idx, B);
    /*JAVA:return*/return;
  }


  /*template <typename AttrKind> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::hasFnAttrImpl">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3838,
   FQN="llvm::InvokeInst::hasFnAttrImpl", NM="Tpl__ZNK4llvm10InvokeInst13hasFnAttrImplET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10InvokeInst13hasFnAttrImplET_")
  //</editor-fold>
  private boolean hasFnAttrImpl(Attribute.AttrKind A) /*const*/ {
    if (AttributeList.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A)) {
      return true;
    }

    // Operand bundles override attributes on the called function, but don't
    // override attributes directly present on the invoke instruction.
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

  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3838,
   FQN="llvm::InvokeInst::hasFnAttrImpl", NM="Tpl__ZNK4llvm10InvokeInst13hasFnAttrImplET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm10InvokeInst13hasFnAttrImplET_")
  //</editor-fold>
  private boolean hasFnAttrImpl(StringRef A) /*const*/ {
    if (AttributeList.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A)) {
      return true;
    }

    // Operand bundles override attributes on the called function, but don't
    // override attributes directly present on the invoke instruction.
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
  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::setInstructionSubclassData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3854,
   FQN="llvm::InvokeInst::setInstructionSubclassData", NM="_ZN4llvm10InvokeInst26setInstructionSubclassDataEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInst26setInstructionSubclassDataEt")
  //</editor-fold>
  private void setInstructionSubclassData_InvokeInst(/*ushort*/char D) {
    super.setInstructionSubclassData(D);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InvokeInst::~InvokeInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 3391,
   FQN="llvm::InvokeInst::~InvokeInst", NM="_ZN4llvm10InvokeInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm10InvokeInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    OperandBundleUser.super.$destroy$OperandBundleUser();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void addAttribute(/*uint*/int i, StringRef Kind, StringRef Value) {
    AttributeSet PAL = new AttributeSet(getAttributes());
    PAL.$assignMove(PAL.addAttribute(getContext(), i, Kind));
    setAttributes(PAL);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "AttributeList=" + AttributeList // NOI18N
              + ", FTy=" + FTy // NOI18N
              + super.toString(); // NOI18N
  }
}
