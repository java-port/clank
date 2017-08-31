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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import org.llvm.ir.CallingConv;
import org.llvm.ir.Type;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7509,
 FQN="(anonymous namespace)::SPIRTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_121SPIRTargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_121SPIRTargetCodeGenInfoE")
//</editor-fold>
public class SPIRTargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetCodeGenInfo::SPIRTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7511,
   FQN="(anonymous namespace)::SPIRTargetCodeGenInfo::SPIRTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_121SPIRTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_121SPIRTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public SPIRTargetCodeGenInfo(final CodeGenTypes /*&*/ CGT) {
    // : TargetCodeGenInfo(new DefaultABIInfo(CGT)) 
    //START JInit
    super(new DefaultABIInfo(CGT));
    //END JInit
  }

  // End anonymous namespace.
  
  /// Emit SPIR specific metadata: OpenCL and SPIR version.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetCodeGenInfo::emitTargetMD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7520,
   FQN="(anonymous namespace)::SPIRTargetCodeGenInfo::emitTargetMD", NM="_ZNK12_GLOBAL__N_121SPIRTargetCodeGenInfo12emitTargetMDEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_121SPIRTargetCodeGenInfo12emitTargetMDEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void emitTargetMD(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
              final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    final LLVMContext /*&*/ Ctx = CGM.getModule().getContext();
    Type /*P*/ Int32Ty = Type.getInt32Ty(Ctx);
    final Module /*&*/ M = CGM.getModule();
    // SPIR v2.0 s2.12 - The SPIR version used by the module is stored in the
    // opencl.spir.version named metadata.
    Metadata /*P*/ SPIRVerElts[/*2*/] = new Metadata /*P*/  [/*2*/] {
      ConstantAsMetadata.get(ConstantInt.get(Int32Ty, $int2ulong(2))), 
      ConstantAsMetadata.get(ConstantInt.get(Int32Ty, $int2ulong(0)))};
    NamedMDNode /*P*/ SPIRVerMD = M.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"opencl.spir.version"));
    SPIRVerMD.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(SPIRVerElts, true)));
    // SPIR v2.0 s2.13 - The OpenCL version used by the module is stored in the
    // opencl.ocl.version named metadata node.
    Metadata /*P*/ OCLVerElts[/*2*/] = new Metadata /*P*/  [/*2*/] {
      ConstantAsMetadata.get(ConstantInt.get(Int32Ty, $uint2ulong($div_uint(CGM.getLangOpts().OpenCLVersion, 100)))), 
      ConstantAsMetadata.get(ConstantInt.get(Int32Ty, $uint2ulong($div_uint(($rem_uint(CGM.getLangOpts().OpenCLVersion, 100)), 10))))
    };
    NamedMDNode /*P*/ OCLVerMD = M.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"opencl.ocl.version"));
    OCLVerMD.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(OCLVerElts, true)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetCodeGenInfo::getOpenCLKernelCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7545,
   FQN="(anonymous namespace)::SPIRTargetCodeGenInfo::getOpenCLKernelCallingConv", NM="_ZNK12_GLOBAL__N_121SPIRTargetCodeGenInfo26getOpenCLKernelCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_121SPIRTargetCodeGenInfo26getOpenCLKernelCallingConvEv")
  //</editor-fold>
  @Override public /*uint*/int getOpenCLKernelCallingConv() /*const*//* override*/ {
    return CallingConv.SPIR_KERNEL;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetCodeGenInfo::~SPIRTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7509,
   FQN="(anonymous namespace)::SPIRTargetCodeGenInfo::~SPIRTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_121SPIRTargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_121SPIRTargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
