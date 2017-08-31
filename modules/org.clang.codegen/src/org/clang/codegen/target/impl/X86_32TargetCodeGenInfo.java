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
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_or_null_FunctionDecl;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.cast_Function;
import static org.clang.codegen.java.ClangCodeGenDummies.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 937,
 FQN="(anonymous namespace)::X86_32TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfoE")
//</editor-fold>
public class X86_32TargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::X86_32TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 939,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::X86_32TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesEbbbjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesEbbbjb")
  //</editor-fold>
  public X86_32TargetCodeGenInfo(final CodeGenTypes /*&*/ CGT, boolean DarwinVectorABI, 
      boolean RetSmallStructInRegABI, boolean Win32StructABI, 
      /*uint*/int NumRegisterParameters, boolean SoftFloatABI) {
    // : TargetCodeGenInfo(new X86_32ABIInfo(CGT, DarwinVectorABI, RetSmallStructInRegABI, Win32StructABI, NumRegisterParameters, SoftFloatABI)) 
    //START JInit
    super(new X86_32ABIInfo(CGT, DarwinVectorABI, RetSmallStructInRegABI, Win32StructABI, 
            NumRegisterParameters, SoftFloatABI));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::isStructReturnInRegABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1708,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::isStructReturnInRegABI", NM="_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfo22isStructReturnInRegABIERKN4llvm6TripleERKN5clang14CodeGenOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfo22isStructReturnInRegABIERKN4llvm6TripleERKN5clang14CodeGenOptionsE")
  //</editor-fold>
  public static boolean isStructReturnInRegABI(final /*const*/ Triple /*&*/ $Triple, final /*const*/ CodeGenOptions /*&*/ Opts) {
    assert ($Triple.getArch() == Triple.ArchType.x86);
    switch (Opts.getStructReturnConvention()) {
     case SRCK_Default:
      break;
     case SRCK_OnStack: // -fpcc-struct-return
      return false;
     case SRCK_InRegs: // -freg-struct-return
      return true;
    }
    if ($Triple.isOSDarwin() || $Triple.isOSIAMCU()) {
      return true;
    }
    switch ($Triple.getOS()) {
     case DragonFly:
     case FreeBSD:
     case OpenBSD:
     case Bitrig:
     case Win32:
      return true;
     default:
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1736,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::setTargetAttributes", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void setTargetAttributes(/*const*/ Decl /*P*/ D, 
                     GlobalValue /*P*/ GV, 
                     final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        if (FD.hasAttr(X86ForceAlignArgPointerAttr.class)) {
          AttrBuilder B = null;
          try {
            // Get the LLVM function.
            Function /*P*/ Fn = cast_Function(GV);
            
            // Now add the 'alignstack' attribute with a value of 16.
            B/*J*/= new AttrBuilder();
            B.addStackAlignmentAttr(16);
            Fn.addAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
                AttributeSet.get(CGM.getLLVMContext(), 
                    AttributeSet.AttrIndex.FunctionIndex.getValue(), 
                    B));
          } finally {
            if (B != null) { B.$destroy(); }
          }
        }
        if (FD.hasAttr(AnyX86InterruptAttr.class)) {
          Function /*P*/ Fn = cast_Function(GV);
          Fn.setCallingConv(org.llvm.ir.CallingConv.X86_INTR);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 952,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public int getDwarfEHStackPointer(final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    // Darwin uses different dwarf register numbers for EH.
    if (CGM.getTarget().getTriple().isOSDarwin()) {
      return 5;
    }
    return 4;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1759,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*//* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    Value /*P*/ Four8 = ConstantInt.get(CGF.Int8Ty, $int2ulong(4));
    
    // 0-7 are the eight integer registers;  the order is different
    //   on Darwin (for EH), but the range is the same.
    // 8 is %eip.
    AssignToArrayRange(Builder, Address, Four8, 0, 8);
    if (CGF.CGM.getTarget().getTriple().isOSDarwin()) {
      // 12-16 are st(0..4).  Not sure why we stop at 4.
      // These have size 16, which is sizeof(long double) on
      // platforms with 8-byte alignment for that type.
      Value /*P*/ Sixteen8 = ConstantInt.get(CGF.Int8Ty, $int2ulong(16));
      AssignToArrayRange(Builder, Address, Sixteen8, 12, 16);
    } else {
      // 9 is %eflags, which doesn't get a size on Darwin for some
      // reason.
      Builder.CreateAlignedStore(Four8, Builder.CreateConstInBoundsGEP1_32(CGF.Int8Ty, Address, 9), 
          CharUnits.One());
      
      // 11-16 are st(0..5).  Not sure why we stop at 5.
      // These have size 12, which is sizeof(long double) on
      // platforms with 4-byte alignment for that type.
      Value /*P*/ Twelve8 = ConstantInt.get(CGF.Int8Ty, $int2ulong(12));
      AssignToArrayRange(Builder, Address, Twelve8, 11, 16);
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::adjustInlineAsmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 961,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::adjustInlineAsmType", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo19adjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS5_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo19adjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS5_4TypeE")
  //</editor-fold>
  @Override public Type /*P*/ adjustInlineAsmType(final CodeGenFunction /*&*/ CGF, 
                     StringRef Constraint, 
                     Type /*P*/ Ty) /*const*//* override*/ {
    return X86AdjustInlineAsmType(CGF, new StringRef(Constraint), Ty);
  }

  
  
  /// Add output constraints for EAX:EDX because they are return registers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::addReturnRegisterOutputs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 1038,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::addReturnRegisterOutputs", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo24addReturnRegisterOutputsERN5clang7CodeGen15CodeGenFunctionENS2_6LValueERSsRSt6vectorIPN4llvm4TypeESaISA_EESD_RS7_IS5_SaIS5_EES6_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo24addReturnRegisterOutputsERN5clang7CodeGen15CodeGenFunctionENS2_6LValueERSsRSt6vectorIPN4llvm4TypeESaISA_EESD_RS7_IS5_SaIS5_EES6_j")
  //</editor-fold>
  @Override public void addReturnRegisterOutputs(final CodeGenFunction /*&*/ CGF, LValue ReturnSlot, final std.string/*&*/ Constraints, 
                          final std.vector<Type /*P*/ > /*&*/ ResultRegTypes, 
                          final std.vector<Type /*P*/ > /*&*/ ResultTruncRegTypes, 
                          final std.vector<LValue> /*&*/ ResultRegDests, final std.string/*&*/ AsmString, 
                          /*uint*/int NumOutputs) /*const*//* override*/ {
    long/*uint64_t*/ RetWidth = CGF.getContext().getTypeSize(ReturnSlot.getType());
    
    // Use the EAX constraint if the width is 32 or smaller and EAX:EDX if it is
    // larger.
    if (!Constraints.empty()) {
      Constraints.$addassign_T($$COMMA);
    }
    if ($lesseq_ulong_ullong(RetWidth, $int2ullong(32))) {
      Constraints.$addassign_T$C$P(/*KEEP_STR*/"={eax}");
      ResultRegTypes.push_back_T$RR(CGF.Int32Ty);
    } else {
      // Use the 'A' constraint for EAX:EDX.
      Constraints.$addassign_T$C$P(/*KEEP_STR*/"=A");
      ResultRegTypes.push_back_T$RR(CGF.Int64Ty);
    }
    
    // Truncate EAX or EAX:EDX to an integer of the appropriate size.
    Type /*P*/ CoerceTy = IntegerType.get(CGF.getLLVMContext(), $ulong2uint(RetWidth));
    ResultTruncRegTypes.push_back_T$C$R(CoerceTy);
    
    // Coerce the integer by bitcasting the return slot pointer.
    ReturnSlot.setAddress(CGF.Builder.CreateBitCast(ReturnSlot.getAddress(), 
            CoerceTy.getPointerTo()));
    ResultRegDests.push_back_T$C$R(ReturnSlot);
    
    rewriteInputConstraintReferences(NumOutputs, 1, AsmString);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::getUBSanFunctionSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 975,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::getUBSanFunctionSignature", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo25getUBSanFunctionSignatureERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo25getUBSanFunctionSignatureERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public Constant /*P*/ getUBSanFunctionSignature(final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    /*uint*/int Sig = (0xeb << 0) // jmp rel8
       | (0x06 << 8) //           .+0x08
       | ($$F << 16)
       | ($$T << 24);
    return ConstantInt.get(CGM.Int32Ty, $uint2ulong(Sig));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::getARCRetainAutoreleasedReturnValueMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 984,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::getARCRetainAutoreleasedReturnValueMarker", NM="_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo41getARCRetainAutoreleasedReturnValueMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_32TargetCodeGenInfo41getARCRetainAutoreleasedReturnValueMarkerEv")
  //</editor-fold>
  @Override public StringRef getARCRetainAutoreleasedReturnValueMarker() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"movl\t%ebp, %ebp\t\t## marker for objc_retainAutoreleaseReturnValue");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_32TargetCodeGenInfo::~X86_32TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 937,
   FQN="(anonymous namespace)::X86_32TargetCodeGenInfo::~X86_32TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_32TargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
