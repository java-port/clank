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
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_or_null_FunctionDecl;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import static org.llvm.ir.java.IrRTTI.cast_Function;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TCETargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6523,
 FQN="(anonymous namespace)::TCETargetCodeGenInfo", NM="_ZN12_GLOBAL__N_120TCETargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_120TCETargetCodeGenInfoE")
//</editor-fold>
public class TCETargetCodeGenInfo extends /*public*/ DefaultTargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TCETargetCodeGenInfo::TCETargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6525,
   FQN="(anonymous namespace)::TCETargetCodeGenInfo::TCETargetCodeGenInfo", NM="_ZN12_GLOBAL__N_120TCETargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_120TCETargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public TCETargetCodeGenInfo(final CodeGenTypes /*&*/ CGT) {
    // : DefaultTargetCodeGenInfo(CGT) 
    //START JInit
    super(CGT);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TCETargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6532,
   FQN="(anonymous namespace)::TCETargetCodeGenInfo::setTargetAttributes", NM="_ZNK12_GLOBAL__N_120TCETargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120TCETargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void setTargetAttributes(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, final CodeGenModule /*&*/ M) /*const*//* override*/ {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
    if (!(FD != null)) {
      return;
    }
    
    Function /*P*/ F = cast_Function(GV);
    if (M.getLangOpts().OpenCL) {
      if (FD.hasAttr(OpenCLKernelAttr.class)) {
        // OpenCL C Kernel functions are not subject to inlining
        F.addFnAttr(Attribute.AttrKind.NoInline);
        /*const*/ ReqdWorkGroupSizeAttr /*P*/ Attr = FD.getAttr(ReqdWorkGroupSizeAttr.class);
        if ((Attr != null)) {
          // Convert the reqd_work_group_size() attributes to metadata.
          final LLVMContext /*&*/ Context = F.getContext();
          NamedMDNode /*P*/ OpenCLMetadata = M.getModule().getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"opencl.kernel_wg_size_info"));
          
          SmallVector<Metadata /*P*/ > Operands/*J*/= new SmallVector<Metadata /*P*/ >(5, (Metadata /*P*/ )null);
          Operands.push_back(ConstantAsMetadata.get(F));
          
          Operands.push_back(ConstantAsMetadata.get(Constant.getIntegerValue(M.Int32Ty, new APInt(32, $uint2ulong(Attr.getXDim())))));
          Operands.push_back(ConstantAsMetadata.get(Constant.getIntegerValue(M.Int32Ty, new APInt(32, $uint2ulong(Attr.getYDim())))));
          Operands.push_back(ConstantAsMetadata.get(Constant.getIntegerValue(M.Int32Ty, new APInt(32, $uint2ulong(Attr.getZDim())))));
          
          // Add a boolean constant operand for "required" (true) or "hint"
          // (false) for implementing the work_group_size_hint attr later.
          // Currently always true as the hint is not yet implemented.
          Operands.push_back(ConstantAsMetadata.get(ConstantInt.getTrue(Context)));
          OpenCLMetadata.addOperand(MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Operands, true)));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TCETargetCodeGenInfo::~TCETargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6523,
   FQN="(anonymous namespace)::TCETargetCodeGenInfo::~TCETargetCodeGenInfo", NM="_ZN12_GLOBAL__N_120TCETargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_120TCETargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
