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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.intrinsic.ID;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformSEHFinally">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1408,
 FQN="(anonymous namespace)::PerformSEHFinally", NM="_ZN12_GLOBAL__N_117PerformSEHFinallyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_117PerformSEHFinallyE")
//</editor-fold>
public final class/*struct*/ PerformSEHFinally extends /**/ EHScopeStack.Cleanup {
  public Function /*P*/ OutlinedFinally;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformSEHFinally::PerformSEHFinally">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1410,
   FQN="(anonymous namespace)::PerformSEHFinally::PerformSEHFinally", NM="_ZN12_GLOBAL__N_117PerformSEHFinallyC1EPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_117PerformSEHFinallyC1EPN4llvm8FunctionE")
  //</editor-fold>
  public PerformSEHFinally(Function /*P*/ OutlinedFinally) {
    // : EHScopeStack::Cleanup(), OutlinedFinally(OutlinedFinally) 
    //START JInit
    super();
    this.OutlinedFinally = OutlinedFinally;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformSEHFinally::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1413,
   FQN="(anonymous namespace)::PerformSEHFinally::Emit", NM="_ZN12_GLOBAL__N_117PerformSEHFinally4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_117PerformSEHFinally4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags F)/* override*/ {
    CallArgList Args = null;
    try {
      final ASTContext /*&*/ Context = CGF.getContext();
      final CodeGenModule /*&*/ CGM = CGF.CGM;
      
      Args/*J*/= new CallArgList();
      
      // Compute the two argument values.
      QualType ArgTys[/*2*/] = new QualType [/*2*/] {Context.UnsignedCharTy.$QualType(), Context.VoidPtrTy.$QualType()};
      Value /*P*/ LocalAddrFn = CGM.getIntrinsic(ID.localaddress);
      Value /*P*/ FP = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(LocalAddrFn);
      Value /*P*/ IsForEH = ConstantInt.get(CGF.ConvertType(new QualType(ArgTys[0])), (F.isForEHCleanup() ? 1 : 0));
      Args.add(RValue.get(IsForEH), new QualType(ArgTys[0]));
      Args.add(RValue.get(FP), new QualType(ArgTys[1]));
      
      // Arrange a two-arg function info and type.
      final /*const*/ CGFunctionInfo /*&*/ FnInfo = CGM.getTypes().arrangeBuiltinFunctionCall(Context.VoidTy.$QualType(), Args);
      
      CGF.EmitCall(FnInfo, OutlinedFinally, new ReturnValueSlot(), Args);
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "OutlinedFinally=" + OutlinedFinally // NOI18N
              + super.toString(); // NOI18N
  }
}
