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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_or_null_FunctionDecl;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.cast_Function;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5605,
 FQN="(anonymous namespace)::NVPTXTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfoE")
//</editor-fold>
public class NVPTXTargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetCodeGenInfo::NVPTXTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5607,
   FQN="(anonymous namespace)::NVPTXTargetCodeGenInfo::NVPTXTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public NVPTXTargetCodeGenInfo(final CodeGenTypes /*&*/ CGT) {
    // : TargetCodeGenInfo(new NVPTXABIInfo(CGT)) 
    //START JInit
    super(new NVPTXABIInfo(CGT));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5665,
   FQN="(anonymous namespace)::NVPTXTargetCodeGenInfo::setTargetAttributes", NM="_ZNK12_GLOBAL__N_122NVPTXTargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_122NVPTXTargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void setTargetAttributes(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
                     final CodeGenModule /*&*/ M) /*const*//* override*/ {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
    if (!(FD != null)) {
      return;
    }
    
    Function /*P*/ F = cast_Function(GV);
    
    // Perform special handling in OpenCL mode
    if (M.getLangOpts().OpenCL) {
      // Use OpenCL function attributes to check for kernel functions
      // By default, all functions are device functions
      if (FD.hasAttr(OpenCLKernelAttr.class)) {
        // OpenCL __kernel functions get kernel metadata
        // Create !{<func-ref>, metadata !"kernel", i32 1} node
        NVPTXTargetCodeGenInfo.addNVVMMetadata(F, new StringRef(/*KEEP_STR*/$kernel), 1);
        // And kernel functions are not subject to inlining
        F.addFnAttr(Attribute.AttrKind.NoInline);
      }
    }
    
    // Perform special handling in CUDA mode.
    if (M.getLangOpts().CUDA) {
      // CUDA __global__ functions get a kernel metadata entry.  Since
      // __global__ functions cannot be called from the device, we do not
      // need to set the noinline attribute.
      if (FD.hasAttr(CUDAGlobalAttr.class)) {
        // Create !{<func-ref>, metadata !"kernel", i32 1} node
        NVPTXTargetCodeGenInfo.addNVVMMetadata(F, new StringRef(/*KEEP_STR*/$kernel), 1);
      }
      {
        CUDALaunchBoundsAttr /*P*/ Attr = FD.getAttr(CUDALaunchBoundsAttr.class);
        if ((Attr != null)) {
          // Create !{<func-ref>, metadata !"maxntidx", i32 <val>} node
          APSInt MaxThreads/*J*/= new APSInt(32);
          MaxThreads.$assignMove(Attr.getMaxThreads().EvaluateKnownConstInt(M.getContext()));
          if (MaxThreads.$greater(0)) {
            NVPTXTargetCodeGenInfo.addNVVMMetadata(F, new StringRef(/*KEEP_STR*/"maxntidx"), (int) MaxThreads.getExtValue());
          }
          
          // min blocks is an optional argument for CUDALaunchBoundsAttr. If it was
          // not specified in __launch_bounds__ or if the user specified a 0 value,
          // we don't have to add a PTX directive.
          if ((Attr.getMinBlocks() != null)) {
            APSInt MinBlocks/*J*/= new APSInt(32);
            MinBlocks.$assignMove(Attr.getMinBlocks().EvaluateKnownConstInt(M.getContext()));
            if (MinBlocks.$greater(0)) {
              // Create !{<func-ref>, metadata !"minctasm", i32 <val>} node
              NVPTXTargetCodeGenInfo.addNVVMMetadata(F, new StringRef(/*KEEP_STR*/"minctasm"), (int) MinBlocks.getExtValue());
            }
          }
        }
      }
    }
  }

/*private:*/
  // Adds a NamedMDNode with F, Name, and Operand as operands, and adds the
  // resulting MDNode to the nvvm.annotations MDNode.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetCodeGenInfo::addNVVMMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5716,
   FQN="(anonymous namespace)::NVPTXTargetCodeGenInfo::addNVVMMetadata", NM="_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfo15addNVVMMetadataEPN4llvm8FunctionENS1_9StringRefEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfo15addNVVMMetadataEPN4llvm8FunctionENS1_9StringRefEi")
  //</editor-fold>
  private static void addNVVMMetadata(Function /*P*/ F, StringRef Name, 
                 int Operand) {
    Module /*P*/ M = F.getParent();
    final LLVMContext /*&*/ Ctx = M.getContext();
    
    // Get "nvvm.annotations" metadata node
    NamedMDNode /*P*/ MD = M.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"nvvm.annotations"));
    
    Metadata /*P*/ MDVals[/*3*/] = new Metadata /*P*/  [/*3*/] {
      ConstantAsMetadata.get(F), MDString.get(Ctx, new StringRef(Name)), 
      ConstantAsMetadata.get(ConstantInt.get(Type.getInt32Ty(Ctx), $int2ulong(Operand)))
    };
    // Append metadata to nvvm.annotations
    MD.addOperand(MDNode.get(Ctx, new ArrayRef<Metadata /*P*/ >(MDVals, true)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXTargetCodeGenInfo::~NVPTXTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5605,
   FQN="(anonymous namespace)::NVPTXTargetCodeGenInfo::~NVPTXTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122NVPTXTargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
