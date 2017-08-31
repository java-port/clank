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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type AutoUpgradeLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.AutoUpgradeLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm16UpgradeDebugInfoERNS_6ModuleE;_ZN4llvm18UpgradeBitCastExprEjPNS_8ConstantEPNS_4TypeE;_ZN4llvm18UpgradeBitCastInstEjPNS_5ValueEPNS_4TypeERPNS_11InstructionE;_ZN4llvm18UpgradeModuleFlagsERNS_6ModuleE;_ZN4llvm20UpgradeIntrinsicCallEPNS_8CallInstEPNS_8FunctionE;_ZN4llvm21UpgradeGlobalVariableEPNS_14GlobalVariableE;_ZN4llvm22UpgradeInstWithTBAATagEPNS_11InstructionE;_ZN4llvm23UpgradeCallsToIntrinsicEPNS_8FunctionE;_ZN4llvm24UpgradeIntrinsicFunctionEPNS_8FunctionERS1_;_ZN4llvm25mayBeOldLoopAttachmentTagENS_9StringRefE;_ZN4llvm32upgradeInstructionLoopAttachmentERNS_6MDNodeE; -static-type=AutoUpgradeLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class AutoUpgradeLlvmGlobals {


/// This is a more granular function that simply checks an intrinsic function
/// for upgrading, and returns true if it requires upgrading. It may return
/// null in NewFn if the all calls to the original intrinsic function
/// should be transformed to non-function-call instructions.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeIntrinsicFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 403,
 FQN="llvm::UpgradeIntrinsicFunction", NM="_ZN4llvm24UpgradeIntrinsicFunctionEPNS_8FunctionERS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm24UpgradeIntrinsicFunctionEPNS_8FunctionERS1_")
//</editor-fold>
public static boolean UpgradeIntrinsicFunction(Function /*P*/ F, final type$ref<Function /*P*/ /*&*/> NewFn) {
  NewFn.$set(null);
  boolean Upgraded = AutoUpgradeStatics.UpgradeIntrinsicFunction1(F, NewFn);
  assert (F != NewFn.$deref()) : "Intrinsic function upgraded to the same function";
  
  // Upgrade intrinsic attributes.  This does not change the function.
  if ((NewFn.$deref() != null)) {
    F = NewFn.$deref();
  }
  {
    /*Intrinsic.ID*/int id = F.getIntrinsicID();
    if ((id != 0)) {
      F.setAttributes(getAttributes(F.getContext(), id));
    }
  }
  return Upgraded;
}


/// This is the complement to the above, replacing a specific call to an
/// intrinsic function with a call to the specified new function.

/// Upgrade a call to an old intrinsic. All argument and return casting must be
/// provided to seamlessly integrate with existing context.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeIntrinsicCall">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 634,
 FQN="llvm::UpgradeIntrinsicCall", NM="_ZN4llvm20UpgradeIntrinsicCallEPNS_8CallInstEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm20UpgradeIntrinsicCallEPNS_8CallInstEPNS_8FunctionE")
//</editor-fold>
public static void UpgradeIntrinsicCall(CallInst /*P*/ CI, Function /*P*/ NewFn) {
  IRBuilder Builder = null;
  try {
    Function /*P*/ F = CI.getCalledFunction();
    final LLVMContext /*&*/ C = CI.getContext();
    Builder/*J*/= new IRBuilder(C);
    Builder.SetInsertPoint(CI.getParent(), CI.getIterator());
    assert ((F != null)) : "Intrinsic call is not direct?";
    if (!(NewFn != null)) {
      // Get the Function's name.
      StringRef Name = F.getName();
      assert (Name.startswith(/*STRINGREF_STR*/"llvm.")) : "Intrinsic doesn't start with 'llvm.'";
      Name.$assignMove(Name.substr(5));
      
      boolean IsX86 = Name.startswith(/*STRINGREF_STR*/"x86.");
      if (IsX86) {
        Name.$assignMove(Name.substr(4));
      }
      
      Value /*P*/ Rep;
      // Upgrade packed integer vector compare intrinsics to compare instructions.
      if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"sse2.pcmpeq.")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pcmpeq."))) {
        Rep = Builder.CreateICmpEQ(CI.getArgOperand(0), CI.getArgOperand(1), 
            new Twine(/*KEEP_STR*/"pcmpeq"));
        Rep = Builder.CreateSExt(Rep, CI.getType(), new Twine(/*KEEP_STR*/$EMPTY));
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"sse2.pcmpgt.")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pcmpgt."))) {
        Rep = Builder.CreateICmpSGT(CI.getArgOperand(0), CI.getArgOperand(1), 
            new Twine(/*KEEP_STR*/"pcmpgt"));
        Rep = Builder.CreateSExt(Rep, CI.getType(), new Twine(/*KEEP_STR*/$EMPTY));
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.pcmpeq.")) {
        Rep = AutoUpgradeStatics.upgradeMaskedCompare(Builder, $Deref(CI), ICmpInst.Predicate.ICMP_EQ);
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.pcmpgt.")) {
        Rep = AutoUpgradeStatics.upgradeMaskedCompare(Builder, $Deref(CI), ICmpInst.Predicate.ICMP_SGT);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxsb")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pmaxs.w")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxsd")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmaxs"))) {
        Rep = AutoUpgradeStatics.upgradeIntMinMax(Builder, $Deref(CI), ICmpInst.Predicate.ICMP_SGT);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pmaxu.b")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxuw")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pmaxud")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmaxu"))) {
        Rep = AutoUpgradeStatics.upgradeIntMinMax(Builder, $Deref(CI), ICmpInst.Predicate.ICMP_UGT);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminsb")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pmins.w")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminsd")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmins"))) {
        Rep = AutoUpgradeStatics.upgradeIntMinMax(Builder, $Deref(CI), ICmpInst.Predicate.ICMP_SLT);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pminu.b")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminuw")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pminud")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pminu"))) {
        Rep = AutoUpgradeStatics.upgradeIntMinMax(Builder, $Deref(CI), ICmpInst.Predicate.ICMP_ULT);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.cvtdq2pd")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.cvtps2pd")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx.cvtdq2.pd.256")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx.cvt.ps2.pd.256"))) {
        // Lossless i32/float to double conversion.
        // Extract the bottom elements if necessary and convert to double vector.
        Value /*P*/ Src = CI.getArgOperand(0);
        VectorType /*P*/ SrcTy = cast_VectorType(Src.getType());
        VectorType /*P*/ DstTy = cast_VectorType(CI.getType());
        Rep = CI.getArgOperand(0);
        
        /*uint*/int NumDstElts = DstTy.getNumElements();
        if ($less_uint(NumDstElts, SrcTy.getNumElements())) {
          assert (NumDstElts == 2) : "Unexpected vector size";
          /*uint32_t*/int ShuffleMask[/*2*/] = new$uint(2, 0, 1);
          Rep = Builder.CreateShuffleVector(Rep, UndefValue.get(SrcTy), 
              new ArrayRefUInt(/*2,*/ ShuffleMask));
        }
        
        boolean Int2Double = (StringRef.npos != Name.find(/*STRINGREF_STR*/"cvtdq2"));
        if (Int2Double) {
          Rep = Builder.CreateSIToFP(Rep, DstTy, new Twine(/*KEEP_STR*/"cvtdq2pd"));
        } else {
          Rep = Builder.CreateFPExt(Rep, DstTy, new Twine(/*KEEP_STR*/"cvtps2pd"));
        }
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"sse4a.movnt.")) {
        Module /*P*/ M = F.getParent();
        SmallVector<Metadata /*P*/ > Elts/*J*/= new SmallVector<Metadata /*P*/ >(1, (Metadata /*P*/ )null);
        Elts.push_back(ConstantAsMetadata.get(ConstantInt.get(Type.getInt32Ty(C), $int2ulong(1))));
        MDNode /*P*/ Node = MDNode.get(C, new ArrayRef<Metadata /*P*/ >(Elts, true));
        
        Value /*P*/ Arg0 = CI.getArgOperand(0);
        Value /*P*/ Arg1 = CI.getArgOperand(1);
        
        // Nontemporal (unaligned) store of the 0'th element of the float/double
        // vector.
        Type /*P*/ SrcEltTy = cast_VectorType(Arg1.getType()).getElementType();
        PointerType /*P*/ EltPtrTy = PointerType.getUnqual(SrcEltTy);
        Value /*P*/ Addr = Builder.CreateBitCast(Arg0, EltPtrTy, new Twine(/*KEEP_STR*/"cast"));
        Value /*P*/ Extract = Builder.CreateExtractElement(Arg1, (long/*uint64_t*/)$int2ulong(0), new Twine(/*KEEP_STR*/"extractelement"));
        
        StoreInst /*P*/ SI = Builder.CreateAlignedStore(Extract, Addr, 1);
        SI.setMetadata(M.getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal")), Node);
        
        // Remove intrinsic.
        CI.eraseFromParent();
        return;
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx.movnt.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.storent."))) {
        Module /*P*/ M = F.getParent();
        SmallVector<Metadata /*P*/ > Elts/*J*/= new SmallVector<Metadata /*P*/ >(1, (Metadata /*P*/ )null);
        Elts.push_back(ConstantAsMetadata.get(ConstantInt.get(Type.getInt32Ty(C), $int2ulong(1))));
        MDNode /*P*/ Node = MDNode.get(C, new ArrayRef<Metadata /*P*/ >(Elts, true));
        
        Value /*P*/ Arg0 = CI.getArgOperand(0);
        Value /*P*/ Arg1 = CI.getArgOperand(1);
        
        // Convert the type of the pointer to a pointer to the stored type.
        Value /*P*/ BC = Builder.CreateBitCast(Arg0, 
            PointerType.getUnqual(Arg1.getType()), 
            new Twine(/*KEEP_STR*/"cast"));
        VectorType /*P*/ VTy = cast_VectorType(Arg1.getType());
        StoreInst /*P*/ SI = Builder.CreateAlignedStore(Arg1, BC, 
            $div_uint(VTy.getBitWidth(), 8));
        SI.setMetadata(M.getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal")), Node);
        
        // Remove intrinsic.
        CI.eraseFromParent();
        return;
      } else if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.storel.dq")) {
        Value /*P*/ Arg0 = CI.getArgOperand(0);
        Value /*P*/ Arg1 = CI.getArgOperand(1);
        
        Type /*P*/ NewVecTy = VectorType.get(Type.getInt64Ty(C), 2);
        Value /*P*/ BC0 = Builder.CreateBitCast(Arg1, NewVecTy, new Twine(/*KEEP_STR*/"cast"));
        Value /*P*/ Elt = Builder.CreateExtractElement(BC0, (long/*uint64_t*/)$int2ulong(0));
        Value /*P*/ BC = Builder.CreateBitCast(Arg0, 
            PointerType.getUnqual(Elt.getType()), 
            new Twine(/*KEEP_STR*/"cast"));
        Builder.CreateAlignedStore(Elt, BC, 1);
        
        // Remove intrinsic.
        CI.eraseFromParent();
        return;
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"sse.storeu.")
         || Name.startswith(/*STRINGREF_STR*/"sse2.storeu.")
         || Name.startswith(/*STRINGREF_STR*/"avx.storeu."))) {
        Value /*P*/ Arg0 = CI.getArgOperand(0);
        Value /*P*/ Arg1 = CI.getArgOperand(1);
        
        Arg0 = Builder.CreateBitCast(Arg0, 
            PointerType.getUnqual(Arg1.getType()), 
            new Twine(/*KEEP_STR*/"cast"));
        Builder.CreateAlignedStore(Arg1, Arg0, 1);
        
        // Remove intrinsic.
        CI.eraseFromParent();
        return;
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.storeu.q."))) {
        AutoUpgradeStatics.UpgradeMaskedStore(Builder, CI.getArgOperand(0), CI.getArgOperand(1), 
            CI.getArgOperand(2), /*Aligned*/ false);
        
        // Remove intrinsic.
        CI.eraseFromParent();
        return;
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.store.q."))) {
        AutoUpgradeStatics.UpgradeMaskedStore(Builder, CI.getArgOperand(0), CI.getArgOperand(1), 
            CI.getArgOperand(2), /*Aligned*/ true);
        
        // Remove intrinsic.
        CI.eraseFromParent();
        return;
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.loadu.q."))) {
        Rep = AutoUpgradeStatics.UpgradeMaskedLoad(Builder, CI.getArgOperand(0), 
            CI.getArgOperand(1), CI.getArgOperand(2), 
            /*Aligned*/ false);
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.b.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.w.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.d.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.load.q."))) {
        Rep = AutoUpgradeStatics.UpgradeMaskedLoad(Builder, CI.getArgOperand(0), 
            CI.getArgOperand(1), CI.getArgOperand(2), 
            /*Aligned*/ true);
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"xop.vpcom")) {
        /*Intrinsic.ID*/int intID;
        if (Name.endswith(/*STRINGREF_STR*/"ub")) {
          intID =ID.x86_xop_vpcomub;
        } else if (Name.endswith(/*STRINGREF_STR*/"uw")) {
          intID = ID.x86_xop_vpcomuw;
        } else if (Name.endswith(/*STRINGREF_STR*/"ud")) {
          intID = ID.x86_xop_vpcomud;
        } else if (Name.endswith(/*STRINGREF_STR*/"uq")) {
          intID = ID.x86_xop_vpcomuq;
        } else if (Name.endswith(/*STRINGREF_STR*/"b")) {
          intID = ID.x86_xop_vpcomb;
        } else if (Name.endswith(/*STRINGREF_STR*/"w")) {
          intID = ID.x86_xop_vpcomw;
        } else if (Name.endswith(/*STRINGREF_STR*/"d")) {
          intID = ID.x86_xop_vpcomd;
        } else if (Name.endswith(/*STRINGREF_STR*/"q")) {
          intID = ID.x86_xop_vpcomq;
        } else {
          throw new llvm_unreachable("Unknown suffix");
        }
        
        Name.$assignMove(Name.substr(9)); // strip off "xop.vpcom"
        /*uint*/int Imm;
        if (Name.startswith(/*STRINGREF_STR*/"lt")) {
          Imm = 0;
        } else if (Name.startswith(/*STRINGREF_STR*/"le")) {
          Imm = 1;
        } else if (Name.startswith(/*STRINGREF_STR*/"gt")) {
          Imm = 2;
        } else if (Name.startswith(/*STRINGREF_STR*/"ge")) {
          Imm = 3;
        } else if (Name.startswith(/*STRINGREF_STR*/"eq")) {
          Imm = 4;
        } else if (Name.startswith(/*STRINGREF_STR*/"ne")) {
          Imm = 5;
        } else if (Name.startswith(/*STRINGREF_STR*/"false")) {
          Imm = 6;
        } else if (Name.startswith(/*STRINGREF_STR*/"true")) {
          Imm = 7;
        } else {
          throw new llvm_unreachable("Unknown condition");
        }
        
        Function /*P*/ VPCOM = getDeclaration(F.getParent(), intID);
        Rep
           = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(VPCOM, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {
                  CI.getArgOperand(0), CI.getArgOperand(1), 
                  Builder.getInt8($uint2uchar(Imm))}, true)/* }*/);
      } else if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xop.vpcmov")) {
        Value /*P*/ Arg0 = CI.getArgOperand(0);
        Value /*P*/ Arg1 = CI.getArgOperand(1);
        Value /*P*/ Sel = CI.getArgOperand(2);
        /*uint*/int NumElts = CI.getType().getVectorNumElements();
        Constant /*P*/ MinusOne = ConstantVector.getSplat(NumElts, Builder.getInt64($int2ulong(-1)));
        Value /*P*/ NotSel = Builder.CreateXor(Sel, MinusOne);
        Value /*P*/ Sel0 = Builder.CreateAnd(Arg0, Sel);
        Value /*P*/ Sel1 = Builder.CreateAnd(Arg1, NotSel);
        Rep = Builder.CreateOr(Sel0, Sel1);
      } else if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse42.crc32.64.8")) {
        Function /*P*/ CRC32 = getDeclaration(F.getParent(), 
            ID.x86_sse42_crc32_32_8);
        Value /*P*/ Trunc0 = Builder.CreateTrunc(CI.getArgOperand(0), Type.getInt32Ty(C));
        Rep = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CRC32, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Trunc0, CI.getArgOperand(1)}, true)/* }*/);
        Rep = Builder.CreateZExt(Rep, CI.getType(), new Twine(/*KEEP_STR*/$EMPTY));
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx.vbroadcast")) {
        // Replace broadcasts with a series of insertelements.
        Type /*P*/ VecTy = CI.getType();
        Type /*P*/ EltTy = VecTy.getVectorElementType();
        /*uint*/int EltNum = VecTy.getVectorNumElements();
        Value /*P*/ Cast = Builder.CreateBitCast(CI.getArgOperand(0), 
            EltTy.getPointerTo());
        Value /*P*/ Load = Builder.CreateLoad(EltTy, Cast);
        Type /*P*/ I32Ty = Type.getInt32Ty(C);
        Rep = UndefValue.get(VecTy);
        for (/*uint*/int I = 0; $less_uint(I, EltNum); ++I)  {
          Rep = Builder.CreateInsertElement(Rep, Load, 
              ConstantInt.get(I32Ty, $uint2ulong(I)));
        }
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"sse41.pmovsx")
         || Name.startswith(/*STRINGREF_STR*/"sse41.pmovzx")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmovsx")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pmovzx"))) {
        VectorType /*P*/ SrcTy = cast_VectorType(CI.getArgOperand(0).getType());
        VectorType /*P*/ DstTy = cast_VectorType(CI.getType());
        /*uint*/int NumDstElts = DstTy.getNumElements();
        
        // Extract a subvector of the first NumDstElts lanes and sign/zero extend.
        SmallVectorUInt ShuffleMask/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 8, NumDstElts, (/*uint32_t*/int)0);
        for (/*uint*/int i = 0; i != NumDstElts; ++i)  {
          ShuffleMask.$set(i, i);
        }
        
        Value /*P*/ SV = Builder.CreateShuffleVector(CI.getArgOperand(0), UndefValue.get(SrcTy), new ArrayRefUInt(ShuffleMask));
        
        boolean DoSext = (StringRef.npos != Name.find(/*STRINGREF_STR*/"pmovsx"));
        Rep = DoSext ? Builder.CreateSExt(SV, DstTy) : Builder.CreateZExt(SV, DstTy);
      } else if (IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.vbroadcasti128")) {
        // Replace vbroadcasts with a vector shuffle.
        Type /*P*/ VT = VectorType.get(Type.getInt64Ty(C), 2);
        Value /*P*/ Op = Builder.CreatePointerCast(CI.getArgOperand(0), 
            PointerType.getUnqual(VT));
        Value /*P*/ Load = Builder.CreateLoad(VT, Op);
        /*uint32_t*/int Idxs[/*4*/] = new$uint(4, 0, 1, 0, 1);
        Rep = Builder.CreateShuffleVector(Load, UndefValue.get(Load.getType()), 
            new ArrayRefUInt(/*4,*/ Idxs));
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx2.pbroadcast")
         || Name.startswith(/*STRINGREF_STR*/"avx2.vbroadcast")
         || Name.startswith(/*STRINGREF_STR*/"avx512.pbroadcast")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.broadcast.s"))) {
        // Replace vp?broadcasts with a vector shuffle.
        Value /*P*/ Op = CI.getArgOperand(0);
        /*uint*/int NumElts = CI.getType().getVectorNumElements();
        Type /*P*/ MaskTy = VectorType.get(Type.getInt32Ty(C), NumElts);
        Rep = Builder.CreateShuffleVector(Op, UndefValue.get(Op.getType()), 
            Constant.getNullValue(MaskTy));
        if (CI.getNumArgOperands() == 3) {
          Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(2), Rep, 
              CI.getArgOperand(1));
        }
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.palignr.")) {
        Rep = AutoUpgradeStatics.UpgradeX86PALIGNRIntrinsics(Builder, CI.getArgOperand(0), 
            CI.getArgOperand(1), 
            CI.getArgOperand(2), 
            CI.getArgOperand(3), 
            CI.getArgOperand(4));
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.psll.dq")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.psll.dq"))) {
        // 128/256-bit shift left specified in bits.
        /*uint*/int Shift = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        Rep = AutoUpgradeStatics.UpgradeX86PSLLDQIntrinsics(Builder, CI.getArgOperand(0), 
            $div_uint(Shift, 8)); // Shift is in bits.
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.psrl.dq")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.psrl.dq"))) {
        // 128/256-bit shift right specified in bits.
        /*uint*/int Shift = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        Rep = AutoUpgradeStatics.UpgradeX86PSRLDQIntrinsics(Builder, CI.getArgOperand(0), 
            $div_uint(Shift, 8)); // Shift is in bits.
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.psll.dq.bs")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.psll.dq.bs")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512.psll.dq.512"))) {
        // 128/256/512-bit shift left specified in bytes.
        /*uint*/int Shift = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        Rep = AutoUpgradeStatics.UpgradeX86PSLLDQIntrinsics(Builder, CI.getArgOperand(0), Shift);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.psrl.dq.bs")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.psrl.dq.bs")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512.psrl.dq.512"))) {
        // 128/256/512-bit shift right specified in bytes.
        /*uint*/int Shift = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        Rep = AutoUpgradeStatics.UpgradeX86PSRLDQIntrinsics(Builder, CI.getArgOperand(0), Shift);
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse41.pblendw")
         || Name.startswith(/*STRINGREF_STR*/"sse41.blendp")
         || Name.startswith(/*STRINGREF_STR*/"avx.blend.p")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.pblendw")
         || Name.startswith(/*STRINGREF_STR*/"avx2.pblendd."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        Value /*P*/ Op1 = CI.getArgOperand(1);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(2)).getZExtValue());
        VectorType /*P*/ VecTy = cast_VectorType(CI.getType());
        /*uint*/int NumElts = VecTy.getNumElements();
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 16, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int i = 0; i != NumElts; ++i)  {
          Idxs.$set(i, (((Imm >>> ($rem_uint(i, 8))) & 1) != 0) ? i + NumElts : i);
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op1, new ArrayRefUInt(Idxs));
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx.vinsertf128.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.vinserti128"))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        Value /*P*/ Op1 = CI.getArgOperand(1);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(2)).getZExtValue());
        VectorType /*P*/ VecTy = cast_VectorType(CI.getType());
        /*uint*/int NumElts = VecTy.getNumElements();
        
        // Mask off the high bits of the immediate value; hardware ignores those.
        Imm = Imm & 1;
        
        // Extend the second operand into a vector that is twice as big.
        Value /*P*/ UndefV = UndefValue.get(Op1.getType());
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 8, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int i = 0; i != NumElts; ++i)  {
          Idxs.$set(i, i);
        }
        Rep = Builder.CreateShuffleVector(Op1, UndefV, new ArrayRefUInt(Idxs));
        
        // Insert the second operand into the first operand.
        
        // Note that there is no guarantee that instruction lowering will actually
        // produce a vinsertf128 instruction for the created shuffles. In
        // particular, the 0 immediate case involves no lane changes, so it can
        // be handled as a blend.
        
        // Example of shuffle mask for 32-bit elements:
        // Imm = 1  <i32 0, i32 1, i32 2,  i32 3,  i32 8, i32 9, i32 10, i32 11>
        // Imm = 0  <i32 8, i32 9, i32 10, i32 11, i32 4, i32 5, i32 6,  i32 7 >
        
        // The low half of the result is either the low half of the 1st operand
        // or the low half of the 2nd operand (the inserted vector).
        for (/*uint*/int i = 0; i != $div_uint(NumElts, 2); ++i)  {
          Idxs.$set(i, (Imm != 0) ? i : (i + NumElts));
        }
        // The high half of the result is either the low half of the 2nd operand
        // (the inserted vector) or the high half of the 1st operand.
        for (/*uint*/int i = $div_uint(NumElts, 2); i != NumElts; ++i)  {
          Idxs.$set(i, (Imm != 0) ? (i + $div_uint(NumElts, 2)) : i);
        }
        Rep = Builder.CreateShuffleVector(Op0, Rep, new ArrayRefUInt(Idxs));
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx.vextractf128.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2.vextracti128"))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        VectorType /*P*/ VecTy = cast_VectorType(CI.getType());
        /*uint*/int NumElts = VecTy.getNumElements();
        
        // Mask off the high bits of the immediate value; hardware ignores those.
        Imm = Imm & 1;
        
        // Get indexes for either the high half or low half of the input vector.
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 4, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int i = 0; i != NumElts; ++i) {
          Idxs.$set(i, (Imm != 0) ? (i + NumElts) : i);
        }
        
        Value /*P*/ UndefV = UndefValue.get(Op0.getType());
        Rep = Builder.CreateShuffleVector(Op0, UndefV, new ArrayRefUInt(Idxs));
      } else if (!IsX86 && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"stackprotectorcheck")) {
        Rep = null;
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.perm.df.")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.perm.di."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        VectorType /*P*/ VecTy = cast_VectorType(CI.getType());
        /*uint*/int NumElts = VecTy.getNumElements();
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 8, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int i = 0; i != NumElts; ++i)  {
          Idxs.$set(i, (i & ~0x3) + ((Imm >>> (2 * (i & 0x3))) & 3));
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op0, new ArrayRefUInt(Idxs));
        if (CI.getNumArgOperands() == 4) {
          Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
              CI.getArgOperand(2));
        }
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx.vpermil.")
         || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pshuf.d")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.vpermil.p")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pshuf.d."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        VectorType /*P*/ VecTy = cast_VectorType(CI.getType());
        /*uint*/int NumElts = VecTy.getNumElements();
        // Calculate the size of each index in the immediate.
        /*uint*/int IdxSize = $div_uint(64, VecTy.getScalarSizeInBits());
        /*uint*/int IdxMask = ((1 << IdxSize) - 1);
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 8, NumElts, (/*uint32_t*/int)0);
        // Lookup the bits for this element, wrapping around the immediate every
        // 8-bits. Elements are grouped into sets of 2 or 4 elements so we need
        // to offset by the first index of each group.
        for (/*uint*/int i = 0; i != NumElts; ++i)  {
          Idxs.$set(i, ((Imm >>> ($rem_uint((i * IdxSize), 8))) & IdxMask) | (i & ~IdxMask));
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op0, new ArrayRefUInt(Idxs));
        if (CI.getNumArgOperands() == 4) {
          Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
              CI.getArgOperand(2));
        }
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pshufl.w")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pshufl.w."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        /*uint*/int NumElts = CI.getType().getVectorNumElements();
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 16, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int l = 0; l != NumElts; l += 8) {
          for (/*uint*/int i = 0; i != 4; ++i)  {
            Idxs.$set(i + l, ((Imm >>> (2 * i)) & 0x3) + l);
          }
          for (/*uint*/int i = 4; i != 8; ++i)  {
            Idxs.$set(i + l, i + l);
          }
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op0, new ArrayRefUInt(Idxs));
        if (CI.getNumArgOperands() == 4) {
          Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
              CI.getArgOperand(2));
        }
      } else if (IsX86 && ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2.pshufh.w")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.pshufh.w."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        /*uint*/int Imm = $ulong2uint(cast_ConstantInt(CI.getArgOperand(1)).getZExtValue());
        /*uint*/int NumElts = CI.getType().getVectorNumElements();
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 16, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int l = 0; l != NumElts; l += 8) {
          for (/*uint*/int i = 0; i != 4; ++i)  {
            Idxs.$set(i + l, i + l);
          }
          for (/*uint*/int i = 0; i != 4; ++i)  {
            Idxs.$set(i + l + 4, ((Imm >>> (2 * i)) & 0x3) + 4 + l);
          }
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op0, new ArrayRefUInt(Idxs));
        if (CI.getNumArgOperands() == 4) {
          Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
              CI.getArgOperand(2));
        }
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.movddup")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.movshdup")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.movsldup"))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        /*uint*/int NumElts = CI.getType().getVectorNumElements();
        /*uint*/int NumLaneElts = $div_uint(128, CI.getType().getScalarSizeInBits());
        
        /*uint*/int Offset = 0;
        if (Name.startswith(/*STRINGREF_STR*/"avx512.mask.movshdup.")) {
          Offset = 1;
        }
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 16, NumElts, (/*uint32_t*/int)0);
        for (/*uint*/int l = 0; l != NumElts; l += NumLaneElts)  {
          for (/*uint*/int i = 0; i != NumLaneElts; i += 2) {
            Idxs.$set(i + l + 0, i + l + Offset);
            Idxs.$set(i + l + 1, i + l + Offset);
          }
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op0, new ArrayRefUInt(Idxs));
        
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(2), Rep, 
            CI.getArgOperand(1));
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.punpckl")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.unpckl."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        Value /*P*/ Op1 = CI.getArgOperand(1);
        int NumElts = CI.getType().getVectorNumElements();
        int NumLaneElts = $div_uint(128, CI.getType().getScalarSizeInBits());
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 64, NumElts, (/*uint32_t*/int)0);
        for (int l = 0; l != NumElts; l += NumLaneElts)  {
          for (int i = 0; i != NumLaneElts; ++i)  {
            Idxs.$set(i + l, l + (i / 2) + NumElts * (i % 2));
          }
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op1, new ArrayRefUInt(Idxs));
        
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
            CI.getArgOperand(2));
      } else if (IsX86 && (Name.startswith(/*STRINGREF_STR*/"avx512.mask.punpckh")
         || Name.startswith(/*STRINGREF_STR*/"avx512.mask.unpckh."))) {
        Value /*P*/ Op0 = CI.getArgOperand(0);
        Value /*P*/ Op1 = CI.getArgOperand(1);
        int NumElts = CI.getType().getVectorNumElements();
        int NumLaneElts = $div_uint(128, CI.getType().getScalarSizeInBits());
        
        SmallVectorUInt Idxs/*J*/= new SmallVectorUInt(JD$UInt_T$C$R.INSTANCE, 64, NumElts, (/*uint32_t*/int)0);
        for (int l = 0; l != NumElts; l += NumLaneElts)  {
          for (int i = 0; i != NumLaneElts; ++i)  {
            Idxs.$set(i + l, (NumLaneElts / 2) + l + (i / 2) + NumElts * (i % 2));
          }
        }
        
        Rep = Builder.CreateShuffleVector(Op0, Op1, new ArrayRefUInt(Idxs));
        
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
            CI.getArgOperand(2));
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.pand.")) {
        Rep = Builder.CreateAnd(CI.getArgOperand(0), CI.getArgOperand(1));
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
            CI.getArgOperand(2));
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.pandn.")) {
        Rep = Builder.CreateAnd(Builder.CreateNot(CI.getArgOperand(0)), 
            CI.getArgOperand(1));
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
            CI.getArgOperand(2));
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.por.")) {
        Rep = Builder.CreateOr(CI.getArgOperand(0), CI.getArgOperand(1));
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
            CI.getArgOperand(2));
      } else if (IsX86 && Name.startswith(/*STRINGREF_STR*/"avx512.mask.pxor.")) {
        Rep = Builder.CreateXor(CI.getArgOperand(0), CI.getArgOperand(1));
        Rep = AutoUpgradeStatics.EmitX86Select(Builder, CI.getArgOperand(3), Rep, 
            CI.getArgOperand(2));
      } else {
        throw new llvm_unreachable("Unknown function for CallInst upgrade.");
      }
      if ((Rep != null)) {
        CI.replaceAllUsesWith(Rep);
      }
      CI.eraseFromParent();
      return;
    }
    
    std.string Name = CI.getName().$string();
    if (!Name.empty()) {
      CI.setName(new Twine($add_string$C_T$C$P(Name, /*KEEP_STR*/".old")));
    }
    switch (NewFn.getIntrinsicID()) {
     default:
      throw new llvm_unreachable("Unknown function for CallInst upgrade.");
     case ID.x86_avx512_mask_psll_di_512:
     case ID.x86_avx512_mask_psra_di_512:
     case ID.x86_avx512_mask_psrl_di_512:
     case ID.x86_avx512_mask_psll_qi_512:
     case ID.x86_avx512_mask_psra_qi_512:
     case ID.x86_avx512_mask_psrl_qi_512:
     case ID.arm_neon_vld1:
     case ID.arm_neon_vld2:
     case ID.arm_neon_vld3:
     case ID.arm_neon_vld4:
     case ID.arm_neon_vld2lane:
     case ID.arm_neon_vld3lane:
     case ID.arm_neon_vld4lane:
     case ID.arm_neon_vst1:
     case ID.arm_neon_vst2:
     case ID.arm_neon_vst3:
     case ID.arm_neon_vst4:
     case ID.arm_neon_vst2lane:
     case ID.arm_neon_vst3lane:
     case ID.arm_neon_vst4lane:
      {
        SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 4, ((type$ptr<Use /*P*/> )CI.arg_operands().begin()), 
            ((type$ptr<Use /*P*/> )CI.arg_operands().end()), (Value /*P*/ )null, (Use a) -> a.$Value$P());
        CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, new ArrayRef<Value /*P*/ >(Args, true)));
        CI.eraseFromParent();
        return;
      }
     case ID.ctlz:
     case ID.cttz:
      assert (CI.getNumArgOperands() == 1) : "Mismatch between function args and call args";
      CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CI.getArgOperand(0), Builder.getFalse()}, true)/* }*/, new Twine(Name)));
      CI.eraseFromParent();
      return;
     case ID.objectsize:
      CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CI.getArgOperand(0), CI.getArgOperand(1)}, true)/* }*/, new Twine(Name)));
      CI.eraseFromParent();
      return;
     case ID.ctpop:
      {
        CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {CI.getArgOperand(0)}, true)/* }*/));
        CI.eraseFromParent();
        return;
      }
     case ID.x86_xop_vfrcz_ss:
     case ID.x86_xop_vfrcz_sd:
      CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {CI.getArgOperand(1)}, true)/* }*/, new Twine(Name)));
      CI.eraseFromParent();
      return;
     case ID.x86_xop_vpermil2pd:
     case ID.x86_xop_vpermil2ps:
     case ID.x86_xop_vpermil2pd_256:
     case ID.x86_xop_vpermil2ps_256:
      {
        SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 4, ((type$ptr<Use /*P*/> )CI.arg_operands().begin()), 
            ((type$ptr<Use /*P*/> )CI.arg_operands().end()), (Value /*P*/ )null, (Use a) -> a.$Value$P());
        VectorType /*P*/ FltIdxTy = cast_VectorType(Args.$at(2).getType());
        VectorType /*P*/ IntIdxTy = VectorType.getInteger(FltIdxTy);
        Args.$set(2, Builder.CreateBitCast(Args.$at(2), IntIdxTy));
        CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, new ArrayRef<Value /*P*/ >(Args, true), new Twine(Name)));
        CI.eraseFromParent();
        return;
      }
     case ID.x86_sse41_ptestc:
     case ID.x86_sse41_ptestz:
     case ID.x86_sse41_ptestnzc:
      {
        // The arguments for these intrinsics used to be v4f32, and changed
        // to v2i64. This is purely a nop, since those are bitwise intrinsics.
        // So, the only thing required is a bitcast for both arguments.
        // First, check the arguments have the old type.
        Value /*P*/ Arg0 = CI.getArgOperand(0);
        if (Arg0.getType() != VectorType.get(Type.getFloatTy(C), 4)) {
          return;
        }
        
        // Old intrinsic, add bitcasts
        Value /*P*/ Arg1 = CI.getArgOperand(1);
        
        Type /*P*/ NewVecTy = VectorType.get(Type.getInt64Ty(C), 2);
        
        Value /*P*/ BC0 = Builder.CreateBitCast(Arg0, NewVecTy, new Twine(/*KEEP_STR*/"cast"));
        Value /*P*/ BC1 = Builder.CreateBitCast(Arg1, NewVecTy, new Twine(/*KEEP_STR*/"cast"));
        
        CallInst /*P*/ NewCall = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {BC0, BC1}, true)/* }*/, new Twine(Name));
        CI.replaceAllUsesWith(NewCall);
        CI.eraseFromParent();
        return;
      }
     case ID.x86_sse41_insertps:
     case ID.x86_sse41_dppd:
     case ID.x86_sse41_dpps:
     case ID.x86_sse41_mpsadbw:
     case ID.x86_avx_dp_ps_256:
     case ID.x86_avx2_mpsadbw:
      {
        // Need to truncate the last argument from i32 to i8 -- this argument models
        // an inherently 8-bit immediate operand to these x86 instructions.
        SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 4, ((type$ptr<Use /*P*/> )CI.arg_operands().begin()), 
            ((type$ptr<Use /*P*/> )CI.arg_operands().end()), (Value /*P*/ )null, (Use a) -> a.$Value$P());
        
        // Replace the last argument with a trunc.
        Args.ref$back().$set(Builder.CreateTrunc(Args.back(), Type.getInt8Ty(C), new Twine(/*KEEP_STR*/"trunc")));
        
        CallInst /*P*/ NewCall = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, new ArrayRef<Value /*P*/ >(Args, true));
        CI.replaceAllUsesWith(NewCall);
        CI.eraseFromParent();
        return;
      }
     case ID.thread_pointer:
      {
        CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, /*{ */new ArrayRef<Value /*P*/ >(true)/* }*/));
        CI.eraseFromParent();
        return;
      }
     case ID.masked_load:
     case ID.masked_store:
      {
        SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 4, ((type$ptr<Use /*P*/> )CI.arg_operands().begin()), 
            ((type$ptr<Use /*P*/> )CI.arg_operands().end()), (Value /*P*/ )null, (Use a) -> a.$Value$P());
        CI.replaceAllUsesWith(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(NewFn, new ArrayRef<Value /*P*/ >(Args, true)));
        CI.eraseFromParent();
        return;
      }
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}


/// This is an auto-upgrade hook for any old intrinsic function syntaxes
/// which need to have both the function updated as well as all calls updated
/// to the new function. This should only be run in a post-processing fashion
/// so that it can update all calls to the old function.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeCallsToIntrinsic">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 notes = Converted.Notes.FIXME, // Why some declarations are vanished from IrLlvmGlobals after regeneration (includind UpgradeIntrinsicFunction)?
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1346,
 FQN="llvm::UpgradeCallsToIntrinsic", NM="_ZN4llvm23UpgradeCallsToIntrinsicEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm23UpgradeCallsToIntrinsicEPNS_8FunctionE")
//</editor-fold>
public static void UpgradeCallsToIntrinsic(Function /*P*/ F) {
  assert ((F != null)) : "Illegal attempt to upgrade a non-existent intrinsic.";
  
  // Check if this function should be upgraded and get the replacement function
  // if there is one.
  type$ref<Function /*P*/ > NewFn = create_type$ref();
  if (AutoUpgradeLlvmGlobals.UpgradeIntrinsicFunction(F, NewFn)) {
    // Replace all users of the old function with the new function or new
    // instructions. This is not a range loop because the call is deleted.
    for (Value.user_iterator_impl<User> UI = F.user_begin(), UE = F.user_end(); UI.$noteq(UE);)  {
      {
        CallInst /*P*/ CI = dyn_cast_CallInst(UI.$postInc(0).$star());
        if ((CI != null)) {
          AutoUpgradeLlvmGlobals.UpgradeIntrinsicCall(CI, NewFn.$deref());
        }
      }
    }
    
    // Remove old function, no longer used, from the module.
    F.eraseFromParent();
  }
}


/// This checks for global variables which should be upgraded. It returns true
/// if it requires upgrading.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeGlobalVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 416,
 FQN="llvm::UpgradeGlobalVariable", NM="_ZN4llvm21UpgradeGlobalVariableEPNS_14GlobalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm21UpgradeGlobalVariableEPNS_14GlobalVariableE")
//</editor-fold>
public static boolean UpgradeGlobalVariable(GlobalVariable /*P*/ GV) {
  // Nothing to do yet.
  return false;
}


/// This checks for module flags which should be upgraded. It returns true if
/// module is modified.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeModuleFlags">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1445,
 FQN="llvm::UpgradeModuleFlags", NM="_ZN4llvm18UpgradeModuleFlagsERNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm18UpgradeModuleFlagsERNS_6ModuleE")
//</editor-fold>
public static boolean UpgradeModuleFlags(final Module /*&*/ M) {
  /*const*/ NamedMDNode /*P*/ ModFlags = M.getModuleFlagsMetadata();
  if (!(ModFlags != null)) {
    return false;
  }
  
  boolean HasObjCFlag = false;
  boolean HasClassProperties = false;
  for (/*uint*/int I = 0, E = ModFlags.getNumOperands(); I != E; ++I) {
    MDNode /*P*/ Op = ModFlags.getOperand(I);
    if ($less_uint(Op.getNumOperands(), 2)) {
      continue;
    }
    MDString /*P*/ ID = IRManualRTTI.dyn_cast_or_null_MDString(Op.getOperand(1));
    if (!(ID != null)) {
      continue;
    }
    if ($eq_StringRef(ID.getString(), /*STRINGREF_STR*/"Objective-C Image Info Version")) {
      HasObjCFlag = true;
    }
    if ($eq_StringRef(ID.getString(), /*STRINGREF_STR*/"Objective-C Class Properties")) {
      HasClassProperties = true;
    }
  }
  // "Objective-C Class Properties" is recently added for Objective-C. We
  // upgrade ObjC bitcodes to contain a "Objective-C Class Properties" module
  // flag of value 0, so we can correclty report error when trying to link
  // an ObjC bitcode without this module flag with an ObjC bitcode with this
  // module flag.
  if (HasObjCFlag && !HasClassProperties) {
    M.addModuleFlag(Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C Class Properties"), 
        (/*uint32_t*/int)0);
    return true;
  }
  return false;
}


/// If the TBAA tag for the given instruction uses the scalar TBAA format,
/// we upgrade it to the struct-path aware TBAA format.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeInstWithTBAATag">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1364,
 FQN="llvm::UpgradeInstWithTBAATag", NM="_ZN4llvm22UpgradeInstWithTBAATagEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm22UpgradeInstWithTBAATagEPNS_11InstructionE")
//</editor-fold>
public static void UpgradeInstWithTBAATag(Instruction /*P*/ I) {
  MDNode /*P*/ MD = I.getMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue());
  assert ((MD != null)) : "UpgradeInstWithTBAATag should have a TBAA tag";
  // Check if the tag uses struct-path aware TBAA format.
  if (IRManualRTTI.isa_MDNode(MD.getOperand(0)) && $greatereq_uint(MD.getNumOperands(), 3)) {
    return;
  }
  if (MD.getNumOperands() == 3) {
    Metadata /*P*/ Elts[/*2*/] = new Metadata /*P*/  [/*2*/] {MD.getOperand(0).$Metadata$P(), MD.getOperand(1).$Metadata$P()};
    MDNode /*P*/ ScalarType = MDNode.get(I.getContext(), new ArrayRef<Metadata /*P*/ >(/*2,*/ Elts, true));
    // Create a MDNode <ScalarType, ScalarType, offset 0, const>
    Metadata /*P*/ Elts2[/*4*/] = new Metadata /*P*/  [/*4*/] {
      ScalarType, ScalarType, 
      ConstantAsMetadata.get(Constant.getNullValue(Type.getInt64Ty(I.getContext()))), 
      MD.getOperand(2).$Metadata$P()};
    I.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), MDNode.get(I.getContext(), new ArrayRef<Metadata /*P*/ >(/*4,*/ Elts2, true)));
  } else {
    // Create a MDNode <MD, MD, offset 0>
    Metadata /*P*/ Elts[/*3*/] = new Metadata /*P*/  [/*3*/] {
      MD, MD, ConstantAsMetadata.get(Constant.getNullValue(Type.getInt64Ty(I.getContext())))
    };
    I.setMetadata(LLVMContext.Unnamed_enum.MD_tbaa.getValue(), MDNode.get(I.getContext(), new ArrayRef<Metadata /*P*/ >(/*3,*/ Elts, true)));
  }
}


/// This is an auto-upgrade for bitcast between pointers with different
/// address spaces: the instruction is replaced by a pair ptrtoint+inttoptr.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeBitCastInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1388,
 FQN="llvm::UpgradeBitCastInst", NM="_ZN4llvm18UpgradeBitCastInstEjPNS_5ValueEPNS_4TypeERPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm18UpgradeBitCastInstEjPNS_5ValueEPNS_4TypeERPNS_11InstructionE")
//</editor-fold>
public static Instruction /*P*/ UpgradeBitCastInst(/*uint*/int Opc, Value /*P*/ V, Type /*P*/ DestTy, 
                  final type$ref<Instruction /*P*/ /*&*/> Temp) {
  if (Opc != Instruction.CastOps.BitCast) {
    return null;
  }
  
  Temp.$set(null);
  Type /*P*/ SrcTy = V.getType();
  if (SrcTy.isPtrOrPtrVectorTy() && DestTy.isPtrOrPtrVectorTy()
     && SrcTy.getPointerAddressSpace() != DestTy.getPointerAddressSpace()) {
    final LLVMContext /*&*/ Context = V.getContext();
    
    // We have no information about target data layout, so we assume that
    // the maximum pointer size is 64bit.
    Type /*P*/ MidTy = Type.getInt64Ty(Context);
    Temp.$set(CastInst.Create(Instruction.CastOps.PtrToInt, V, MidTy));
    
    return CastInst.Create(Instruction.CastOps.IntToPtr, Temp.$deref(), DestTy);
  }
  
  return null;
}


/// This is an auto-upgrade for bitcast constant expression between pointers
/// with different address spaces: the instruction is replaced by a pair
/// ptrtoint+inttoptr.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeBitCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1410,
 FQN="llvm::UpgradeBitCastExpr", NM="_ZN4llvm18UpgradeBitCastExprEjPNS_8ConstantEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm18UpgradeBitCastExprEjPNS_8ConstantEPNS_4TypeE")
//</editor-fold>
public static Value /*P*/ UpgradeBitCastExpr(/*uint*/int Opc, Constant /*P*/ C, Type /*P*/ DestTy) {
  if (Opc != Instruction.CastOps.BitCast) {
    return null;
  }
  
  Type /*P*/ SrcTy = C.getType();
  if (SrcTy.isPtrOrPtrVectorTy() && DestTy.isPtrOrPtrVectorTy()
     && SrcTy.getPointerAddressSpace() != DestTy.getPointerAddressSpace()) {
    final LLVMContext /*&*/ Context = C.getContext();
    
    // We have no information about target data layout, so we assume that
    // the maximum pointer size is 64bit.
    Type /*P*/ MidTy = Type.getInt64Ty(Context);
    
    return ConstantExpr.getIntToPtr(ConstantExpr.getPtrToInt(C, MidTy), 
        DestTy);
  }
  
  return null;
}


/// Check the debug info version number, if it is out-dated, drop the debug
/// info. Return true if module is modified.

/// Check the debug info version number, if it is out-dated, drop the debug
/// info. Return true if module is modified.
//<editor-fold defaultstate="collapsed" desc="llvm::UpgradeDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1432,
 FQN="llvm::UpgradeDebugInfo", NM="_ZN4llvm16UpgradeDebugInfoERNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm16UpgradeDebugInfoERNS_6ModuleE")
//</editor-fold>
public static boolean UpgradeDebugInfo(final Module /*&*/ M) {
  /*uint*/int Version = IrLlvmGlobals.getDebugMetadataVersionFromModule(M);
  if (Version == LLVMConstants.DEBUG_METADATA_VERSION.getValue()) {
    return false;
  }
  
  boolean RetCode = IrLlvmGlobals.StripDebugInfo(M);
  if (RetCode) {
    DiagnosticInfoDebugMetadataVersion DiagVersion = null;
    try {
      DiagVersion/*J*/= new DiagnosticInfoDebugMetadataVersion(M, Version);
      M.getContext().diagnose(DiagVersion);
    } finally {
      if (DiagVersion != null) { DiagVersion.$destroy(); }
    }
  }
  return RetCode;
}


/// Check whether a string looks like an old loop attachment tag.
//<editor-fold defaultstate="collapsed" desc="llvm::mayBeOldLoopAttachmentTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/AutoUpgrade.h", line = 73,
 FQN="llvm::mayBeOldLoopAttachmentTag", NM="_ZN4llvm25mayBeOldLoopAttachmentTagENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm25mayBeOldLoopAttachmentTagENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean mayBeOldLoopAttachmentTag(StringRef Name) {
  return Name.startswith(/*STRINGREF_STR*/"llvm.vectorizer.");
}


/// Upgrade the loop attachment metadata node.
//<editor-fold defaultstate="collapsed" desc="llvm::upgradeInstructionLoopAttachment">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp", line = 1522,
 FQN="llvm::upgradeInstructionLoopAttachment", NM="_ZN4llvm32upgradeInstructionLoopAttachmentERNS_6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AutoUpgrade.cpp -nm=_ZN4llvm32upgradeInstructionLoopAttachmentERNS_6MDNodeE")
//</editor-fold>
public static MDNode /*P*/ upgradeInstructionLoopAttachment(final MDNode /*&*/ N) {
  MDTuple /*P*/ T = dyn_cast_MDTuple($AddrOf(N));
  if (!(T != null)) {
    return $AddrOf(N);
  }
  if (!llvm.any_of(T.operands(), (MDOperand MD) -> AutoUpgradeStatics.isOldLoopArgument(MD.$Metadata$P()))){//AutoUpgradeStatics::isOldLoopArgument)) {
    return $AddrOf(N);
  }
  
  SmallVector<Metadata /*P*/ > Ops/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  Ops.reserve(T.getNumOperands());
  for (MDOperand /*P*/ operand : T.operands())  {
    Metadata /*P*/ MD = operand.$Metadata$P();
    Ops.push_back(AutoUpgradeStatics.upgradeLoopArgument(MD));
  }
  
  return MDTuple.get(T.getContext(), new ArrayRef<Metadata /*P*/ >(Ops, true));
}

} // END OF class AutoUpgradeLlvmGlobals
