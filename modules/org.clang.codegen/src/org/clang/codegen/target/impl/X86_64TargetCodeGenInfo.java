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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_or_null_FunctionDecl;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import org.clang.basic.CallingConv;
import org.llvm.ir.Type;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.cast_Function;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2009,
 FQN="(anonymous namespace)::X86_64TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_123X86_64TargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_64TargetCodeGenInfoE")
//</editor-fold>
public class X86_64TargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::X86_64TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2011,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::X86_64TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_123X86_64TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesENS_14X86AVXABILevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_64TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesENS_14X86AVXABILevelE")
  //</editor-fold>
  public X86_64TargetCodeGenInfo(final CodeGenTypes /*&*/ CGT, X86AVXABILevel AVXLevel) {
    // : TargetCodeGenInfo(new X86_64ABIInfo(CGT, AVXLevel)) 
    //START JInit
    super(new X86_64ABIInfo(CGT, AVXLevel));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::getABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2014,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::getABIInfo", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo10getABIInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo10getABIInfoEv")
  //</editor-fold>
  public /*const*/ X86_64ABIInfo /*&*/ getABIInfo() /*const*/ {
    return ((/*static_cast*//*const*/ X86_64ABIInfo /*&*/ )(super.getABIInfo()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2018,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public int getDwarfEHStackPointer(final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    return 7;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2022,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*//* override*/ {
    Value /*P*/ Eight8 = ConstantInt.get(CGF.Int8Ty, $int2ulong(8));
    
    // 0-15 are the 16 integer registers.
    // 16 is %rip.
    AssignToArrayRange(CGF.Builder, Address, Eight8, 0, 16);
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::adjustInlineAsmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2032,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::adjustInlineAsmType", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo19adjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS5_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo19adjustInlineAsmTypeERN5clang7CodeGen15CodeGenFunctionEN4llvm9StringRefEPNS5_4TypeE")
  //</editor-fold>
  @Override public Type /*P*/ adjustInlineAsmType(final CodeGenFunction /*&*/ CGF, 
                     StringRef Constraint, 
                     Type /*P*/ Ty) /*const*//* override*/ {
    return X86AdjustInlineAsmType(CGF, new StringRef(Constraint), Ty);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::isNoProtoCallVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2038,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::isNoProtoCallVariadic", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo21isNoProtoCallVariadicERKN5clang7CodeGen11CallArgListEPKNS1_19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo21isNoProtoCallVariadicERKN5clang7CodeGen11CallArgListEPKNS1_19FunctionNoProtoTypeE")
  //</editor-fold>
  @Override public boolean isNoProtoCallVariadic(final /*const*/ CallArgList /*&*/ args, 
                       /*const*/ FunctionNoProtoType /*P*/ fnType) /*const*//* override*/ {
    // The default CC on x86-64 sets %al to the number of SSA
    // registers used, and GCC sets this when calling an unprototyped
    // function, so we override the default behavior.  However, don't do
    // that when AVX types are involved: the ABI explicitly states it is
    // undefined, and it doesn't work in practice because of how the ABI
    // defines varargs anyway.
    if (fnType.getCallConv() == CallingConv.CC_C) {
      boolean HasAVXType = false;
      for (type$ptr</*const*/ CallArg /*P*/ > it = $tryClone(args.begin$Const()), /*P*/ ie = $tryClone(args.end$Const()); $noteq_ptr(it, ie); it.$preInc()) {
        if (getABIInfo().isPassedUsingAVXType(new QualType(it./*->*/$star().Ty))) {
          HasAVXType = true;
          break;
        }
      }
      if (!HasAVXType) {
        return true;
      }
    }
    
    return super.isNoProtoCallVariadic(args, fnType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::getUBSanFunctionSignature">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2063,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::getUBSanFunctionSignature", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo25getUBSanFunctionSignatureERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo25getUBSanFunctionSignatureERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public Constant /*P*/ getUBSanFunctionSignature(final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    /*uint*/int Sig;
    if (getABIInfo().has64BitPointers()) {
      Sig = (0xeb << 0) // jmp rel8
         | (0x0a << 8) //           .+0x0c
         | ($$F << 16)
         | ($$T << 24);
    } else {
      Sig = (0xeb << 0) // jmp rel8
         | (0x06 << 8) //           .+0x08
         | ($$F << 16)
         | ($$T << 24);
    }
    return ConstantInt.get(CGM.Int32Ty, $uint2ulong(Sig));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2079,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::setTargetAttributes", NM="_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_123X86_64TargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void setTargetAttributes(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
                     final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if ((FD != null)) {
        if (FD.hasAttr(AnyX86InterruptAttr.class)) {
          Function /*P*/ Fn = cast_Function(GV);
          Fn.setCallingConv(org.llvm.ir.CallingConv.X86_INTR);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86_64TargetCodeGenInfo::~X86_64TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 2009,
   FQN="(anonymous namespace)::X86_64TargetCodeGenInfo::~X86_64TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_123X86_64TargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_123X86_64TargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
