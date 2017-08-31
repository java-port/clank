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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.llvm.ir.Type;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGCUDABuiltin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGCUDABuiltin",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGBuiltin ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDABuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitCUDADevicePrintfCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE; -static-type=CodeGenFunction_CGCUDABuiltin -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGCUDABuiltin extends CodeGenFunction_CGBuiltin {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGCUDABuiltin(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


// Transforms a call to printf into a call to the NVPTX vprintf syscall (which
// isn't particularly special; it's invoked just like a regular function).
// vprintf takes two args: A format string, and a pointer to a buffer containing
// the varargs.
//
// For example, the call
//
//   printf("format string", arg1, arg2, arg3);
//
// is converted into something resembling
//
//   struct Tmp {
//     Arg1 a1;
//     Arg2 a2;
//     Arg3 a3;
//   };
//   char* buf = alloca(sizeof(Tmp));
//   *(Tmp*)buf = {a1, a2, a3};
//   vprintf("format string", buf);
//
// buf is aligned to the max of {alignof(Arg1), ...}.  Furthermore, each of the
// args is itself aligned to its preferred alignment.
//
// Note that by the time this function runs, E's args have already undergone the
// standard C vararg promotion (short -> int, float -> double, etc.).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCUDADevicePrintfCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDABuiltin.cpp", line = 69,
 FQN="clang::CodeGen::CodeGenFunction::EmitCUDADevicePrintfCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitCUDADevicePrintfCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDABuiltin.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitCUDADevicePrintfCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitCUDADevicePrintfCallExpr(/*const*/ CallExpr /*P*/ E, 
                            ReturnValueSlot ReturnValue) {
  CallArgList Args = null;
  try {
    assert Native.$bool($this().getLangOpts().CUDA);
    assert Native.$bool($this().getLangOpts().CUDAIsDevice);
    assert (E.getBuiltinCallee() == Builtin.ID.BIprintf.getValue());
    assert ($greatereq_uint(E.getNumArgs(), 1)); // printf always has at least one arg.
    
    final /*const*/ DataLayout /*&*/ DL = $this().CGM.getDataLayout();
    final LLVMContext /*&*/ Ctx = $this().CGM.getLLVMContext();
    
    Args/*J*/= new CallArgList();
    $this().EmitCallArgs(Args, 
        E.getDirectCallee$Const().getType().$arrow().getAs(FunctionProtoType.class), 
        E.arguments$Const(), E.getDirectCallee$Const(), 
        /* ParamsToSkip = */ 0);
    
    // We don't know how to emit non-scalar varargs.
    if (std.any_of(Args.begin().$add(1), Args.end(), 
        /*[]*/ (final /*const*/ CallArg /*&*/ A) -> {
              return !A.RV.isScalar();
            })) {
      $this().CGM.ErrorUnsupported(E, $("non-scalar arg to printf"));
      return RValue.get(ConstantInt.get(IntTy, $int2ulong(0)));
    }
    
    // Construct and fill the args buffer that we'll pass to vprintf.
    Value /*P*/ BufferPtr;
    if ($lesseq_uint(Args.size(), 1)) {
      // If there are no args, pass a null pointer to vprintf.
      BufferPtr = ConstantPointerNull.get(org.llvm.ir.Type.getInt8PtrTy(Ctx));
    } else {
      SmallVector<org.llvm.ir.Type /*P*/ > ArgTypes/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(8, (org.llvm.ir.Type /*P*/ )null);
      for (/*uint*/int I = 1, NumArgs = Args.size(); $less_uint(I, NumArgs); ++I)  {
        ArgTypes.push_back(Args.$at(I).RV.getScalarVal().getType());
      }
      org.llvm.ir.Type /*P*/ AllocaTy = StructType.create(new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), new StringRef(/*KEEP_STR*/"printf_args"));
      Value /*P*/ Alloca = $this().CreateTempAlloca(AllocaTy);
      
      for (/*uint*/int I = 1, NumArgs = Args.size(); $less_uint(I, NumArgs); ++I) {
        Value /*P*/ P = $this().Builder.CreateStructGEP(AllocaTy, Alloca, I - 1);
        Value /*P*/ Arg = Args.$at(I).RV.getScalarVal();
        $this().Builder.CreateAlignedStore(Arg, P, DL.getPrefTypeAlignment(Arg.getType()));
      }
      BufferPtr = $this().Builder.CreatePointerCast(Alloca, org.llvm.ir.Type.getInt8PtrTy(Ctx));
    }
    
    // Invoke vprintf and return.
    Function /*P*/ VprintfFunc = CGCUDABuiltinStatics.GetVprintfDeclaration($this().CGM.getModule());
    return RValue.get($this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(VprintfFunc, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Args.$at(0).RV.getScalarVal(), BufferPtr}, true)/* }*/));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

} // END OF class CodeGenFunction_CGCUDABuiltin
