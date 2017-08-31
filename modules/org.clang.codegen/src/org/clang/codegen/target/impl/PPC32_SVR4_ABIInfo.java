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

package org.clang.codegen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

/// PPC32_SVR4_ABIInfo - The 32-bit PowerPC ELF (SVR4) ABI information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32_SVR4_ABIInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3633,
 FQN="(anonymous namespace)::PPC32_SVR4_ABIInfo", NM="_ZN12_GLOBAL__N_118PPC32_SVR4_ABIInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC32_SVR4_ABIInfoE")
//</editor-fold>
public class PPC32_SVR4_ABIInfo extends /*public*/ DefaultABIInfo implements Destructors.ClassWithDestructor {
  private boolean IsSoftFloatABI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32_SVR4_ABIInfo::PPC32_SVR4_ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3636,
   FQN="(anonymous namespace)::PPC32_SVR4_ABIInfo::PPC32_SVR4_ABIInfo", NM="_ZN12_GLOBAL__N_118PPC32_SVR4_ABIInfoC1ERN5clang7CodeGen12CodeGenTypesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC32_SVR4_ABIInfoC1ERN5clang7CodeGen12CodeGenTypesEb")
  //</editor-fold>
  public PPC32_SVR4_ABIInfo(final CodeGenTypes /*&*/ CGT, boolean SoftFloatABI) {
    // : DefaultABIInfo(CGT), IsSoftFloatABI(SoftFloatABI) 
    //START JInit
    super(CGT);
    this.IsSoftFloatABI = SoftFloatABI;
    //END JInit
  }

  
  
  // TODO: this implementation is now likely redundant with
  // DefaultABIInfo::EmitVAArg.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32_SVR4_ABIInfo::EmitVAArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3661,
   FQN="(anonymous namespace)::PPC32_SVR4_ABIInfo::EmitVAArg", NM="_ZNK12_GLOBAL__N_118PPC32_SVR4_ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_118PPC32_SVR4_ABIInfo9EmitVAArgERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address EmitVAArg(final CodeGenFunction /*&*/ CGF, Address VAList, 
           QualType Ty) /*const*//* override*/ {
    /*const*//*uint*/int OverflowLimit = 8;
    {
      /*const*/ ComplexType /*P*/ CTy = Ty.$arrow().getAs(ComplexType.class);
      if ((CTy != null)) {
        // TODO: Implement this. For now ignore.
        ///*J:(void)*/CTy;
        return Address.invalid(); // FIXME?
      }
    }
    
    // struct __va_list_tag {
    //   unsigned char gpr;
    //   unsigned char fpr;
    //   unsigned short reserved;
    //   void *overflow_arg_area;
    //   void *reg_save_area;
    // };
    boolean isI64 = Ty.$arrow().isIntegerType() && getContext().getTypeSize(new QualType(Ty)) == $int2ullong(64);
    boolean isInt = Ty.$arrow().isIntegerType() || Ty.$arrow().isPointerType() || Ty.$arrow().isAggregateType();
    boolean isF64 = Ty.$arrow().isFloatingType() && getContext().getTypeSize(new QualType(Ty)) == $int2ullong(64);
    
    // All aggregates are passed indirectly?  That doesn't seem consistent
    // with the argument-lowering code.
    boolean isIndirect = Ty.$arrow().isAggregateType();
    
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    // The calling convention either uses 1-2 GPRs or 1 FPR.
    Address NumRegsAddr = Address.invalid();
    if (isInt || IsSoftFloatABI) {
      NumRegsAddr.$assignMove(Builder.CreateStructGEP(new Address(VAList), 0, CharUnits.Zero(), new Twine(/*KEEP_STR*/"gpr")));
    } else {
      NumRegsAddr.$assignMove(Builder.CreateStructGEP(new Address(VAList), 1, CharUnits.One(), new Twine(/*KEEP_STR*/"fpr")));
    }
    
    Value /*P*/ NumRegs = Builder.CreateLoad(new Address(NumRegsAddr), $("numUsedRegs"));
    
    // "Align" the register count when TY is i64.
    if (isI64 || (isF64 && IsSoftFloatABI)) {
      NumRegs = Builder.CreateAdd(NumRegs, Builder.getInt8($int2uchar(1)));
      NumRegs = Builder.CreateAnd(NumRegs, Builder.getInt8((byte/*uint8_t*/)$uint2uchar(~1/*U*/)));
    }
    
    Value /*P*/ CC = Builder.CreateICmpULT(NumRegs, Builder.getInt8($uint2uchar(OverflowLimit)), new Twine(/*KEEP_STR*/"cond"));
    
    BasicBlock /*P*/ UsingRegs = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"using_regs"));
    BasicBlock /*P*/ UsingOverflow = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"using_overflow"));
    BasicBlock /*P*/ Cont = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cont"));
    
    Builder.CreateCondBr(CC, UsingRegs, UsingOverflow);
    
    Type /*P*/ DirectTy = CGF.ConvertType(new QualType(Ty));
    if (isIndirect) {
      DirectTy = DirectTy.getPointerTo(0);
    }
    
    // Case 1: consume registers.
    Address RegAddr = Address.invalid();
    {
      CGF.EmitBlock(UsingRegs);
      
      Address RegSaveAreaPtr = Builder.CreateStructGEP(new Address(VAList), 4, CharUnits.fromQuantity(8));
      RegAddr.$assignMove(new Address(Builder.CreateLoad(new Address(RegSaveAreaPtr)), 
              CharUnits.fromQuantity(8)));
      assert (RegAddr.getElementType() == CGF.Int8Ty);
      
      // Floating-point registers start after the general-purpose registers.
      if (!(isInt || IsSoftFloatABI)) {
        RegAddr.$assignMove(Builder.CreateConstInBoundsByteGEP(new Address(RegAddr), 
                CharUnits.fromQuantity(32)));
      }
      
      // Get the address of the saved value by scaling the number of
      // registers we've used by the number of 
      CharUnits RegSize = CharUnits.fromQuantity((isInt || IsSoftFloatABI) ? 4 : 8);
      Value /*P*/ RegOffset = Builder.CreateMul(NumRegs, Builder.getInt8($long2uchar(RegSize.getQuantity())));
      RegAddr.$assignMove(new Address(Builder.CreateInBoundsGEP(CGF.Int8Ty, 
                  RegAddr.getPointer(), RegOffset), 
              RegAddr.getAlignment().alignmentOfArrayElement(new CharUnits(RegSize))));
      RegAddr.$assignMove(Builder.CreateElementBitCast(new Address(RegAddr), DirectTy));
      
      // Increase the used-register count.
      NumRegs
         = Builder.CreateAdd(NumRegs, 
          Builder.getInt8($int2uchar((isI64 || (isF64 && IsSoftFloatABI)) ? 2 : 1)));
      Builder.CreateStore(NumRegs, new Address(NumRegsAddr));
      
      CGF.EmitBranch(Cont);
    }
    
    // Case 2: consume space in the overflow area.
    Address MemAddr = Address.invalid();
    {
      CGF.EmitBlock(UsingOverflow);
      
      Builder.CreateStore(Builder.getInt8($uint2uchar(OverflowLimit)), new Address(NumRegsAddr));
      
      // Everything in the overflow area is rounded up to a size of at least 4.
      CharUnits OverflowAreaAlign = CharUnits.fromQuantity(4);
      
      CharUnits Size/*J*/= new CharUnits();
      if (!isIndirect) {
        std.pair<CharUnits, CharUnits> TypeInfo = CGF.getContext().getTypeInfoInChars(new QualType(Ty));
        Size.$assignMove(TypeInfo.first.alignTo(OverflowAreaAlign));
      } else {
        Size.$assignMove(CGF.getPointerSize());
      }
      
      Address OverflowAreaAddr = Builder.CreateStructGEP(new Address(VAList), 3, CharUnits.fromQuantity(4));
      Address OverflowArea/*J*/= new Address(Builder.CreateLoad(new Address(OverflowAreaAddr), $("argp.cur")), 
          new CharUnits(OverflowAreaAlign));
      // Round up address of argument to alignment
      CharUnits Align = CGF.getContext().getTypeAlignInChars(new QualType(Ty));
      if (Align.$greater(OverflowAreaAlign)) {
        Value /*P*/ Ptr = OverflowArea.getPointer();
        OverflowArea.$assignMove(new Address(emitRoundPointerUpToAlignment(CGF, Ptr, new CharUnits(Align)), 
                new CharUnits(Align)));
      }
      
      MemAddr.$assignMove(Builder.CreateElementBitCast(new Address(OverflowArea), DirectTy));
      
      // Increase the overflow area.
      OverflowArea.$assignMove(Builder.CreateConstInBoundsByteGEP(new Address(OverflowArea), new CharUnits(Size)));
      Builder.CreateStore(OverflowArea.getPointer(), new Address(OverflowAreaAddr));
      CGF.EmitBranch(Cont);
    }
    
    CGF.EmitBlock(Cont);
    
    // Merge the cases with a phi.
    Address Result = emitMergePHI(CGF, new Address(RegAddr), UsingRegs, new Address(MemAddr), UsingOverflow, 
        new Twine(/*KEEP_STR*/"vaarg.addr"));
    
    // Load the pointer if the argument was passed indirectly.
    if (isIndirect) {
      Result.$assignMove(new Address(Builder.CreateLoad(new Address(Result), $("aggr")), 
              getContext().getTypeAlignInChars(new QualType(Ty))));
    }
    
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32_SVR4_ABIInfo::~PPC32_SVR4_ABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3633,
   FQN="(anonymous namespace)::PPC32_SVR4_ABIInfo::~PPC32_SVR4_ABIInfo", NM="_ZN12_GLOBAL__N_118PPC32_SVR4_ABIInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_118PPC32_SVR4_ABIInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "IsSoftFloatABI=" + IsSoftFloatABI // NOI18N
              + super.toString(); // NOI18N
  }
}
