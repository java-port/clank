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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 36,
 FQN="clang::CodeGen::CGCUDARuntime", NM="_ZN5clang7CodeGen13CGCUDARuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntimeE")
//</editor-fold>
public abstract class CGCUDARuntime implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final CodeGenModule /*&*/ CGM;
/*public:*/
  // Global variable properties that must be passed to CUDA runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::DeviceVarFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 42,
   FQN="clang::CodeGen::CGCUDARuntime::DeviceVarFlags", NM="_ZN5clang7CodeGen13CGCUDARuntime14DeviceVarFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntime14DeviceVarFlagsE")
  //</editor-fold>
  public static final class/*enum*/ DeviceVarFlags {
    public static final /*uint*/int ExternDeviceVar = 0x01; // extern
    public static final /*uint*/int ConstantDeviceVar = 0x02; // __constant__
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::CGCUDARuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 47,
   FQN="clang::CodeGen::CGCUDARuntime::CGCUDARuntime", NM="_ZN5clang7CodeGen13CGCUDARuntimeC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntimeC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CGCUDARuntime(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::~CGCUDARuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp", line = 25,
   FQN="clang::CodeGen::CGCUDARuntime::~CGCUDARuntime", NM="_ZN5clang7CodeGen13CGCUDARuntimeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntimeD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::EmitCUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp", line = 27,
   FQN="clang::CodeGen::CGCUDARuntime::EmitCUDAKernelCallExpr", NM="_ZN5clang7CodeGen13CGCUDARuntime22EmitCUDAKernelCallExprERNS0_15CodeGenFunctionEPKNS_18CUDAKernelCallExprENS0_15ReturnValueSlotE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntime22EmitCUDAKernelCallExprERNS0_15CodeGenFunctionEPKNS_18CUDAKernelCallExprENS0_15ReturnValueSlotE")
  //</editor-fold>
  public RValue EmitCUDAKernelCallExpr(final CodeGenFunction /*&*/ CGF, 
                        /*const*/ CUDAKernelCallExpr /*P*/ E, 
                        ReturnValueSlot ReturnValue) {
    BasicBlock /*P*/ ConfigOKBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"kcall.configok"));
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"kcall.end"));
    
    CodeGenFunction.ConditionalEvaluation eval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
    CGF.EmitBranchOnBoolExpr(E.getConfig$Const(), ContBlock, ConfigOKBlock, 
        /*TrueCount=*/ $int2ulong(0));
    
    eval.begin(CGF);
    CGF.EmitBlock(ConfigOKBlock);
    
    /*const*/ Decl /*P*/ TargetDecl = null;
    {
      /*const*/ ImplicitCastExpr /*P*/ CE = dyn_cast_ImplicitCastExpr(E.getCallee$Const());
      if ((CE != null)) {
        {
          /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CE.getSubExpr$Const());
          if ((DRE != null)) {
            TargetDecl = DRE.getDecl$Const();
          }
        }
      }
    }
    
    Value /*P*/ Callee = CGF.EmitScalarExpr(E.getCallee$Const());
    CGF.EmitCall(E.getCallee$Const().getType(), Callee, E, new ReturnValueSlot(ReturnValue), new CGCalleeInfo(TargetDecl));
    CGF.EmitBranch(ContBlock);
    
    CGF.EmitBlock(ContBlock);
    eval.end(CGF);
    
    return RValue.get((Value /*P*/ )null);
  }

  
  /// Emits a kernel launch stub.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::emitDeviceStub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 55,
   FQN="clang::CodeGen::CGCUDARuntime::emitDeviceStub", NM="_ZN5clang7CodeGen13CGCUDARuntime14emitDeviceStubERNS0_15CodeGenFunctionERNS0_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntime14emitDeviceStubERNS0_15CodeGenFunctionERNS0_15FunctionArgListE")
  //</editor-fold>
  public abstract /*virtual*/ void emitDeviceStub(final CodeGenFunction /*&*/ CGF, final FunctionArgList /*&*/ Args)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::registerDeviceVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 56,
   FQN="clang::CodeGen::CGCUDARuntime::registerDeviceVar", NM="_ZN5clang7CodeGen13CGCUDARuntime17registerDeviceVarERN4llvm14GlobalVariableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntime17registerDeviceVarERN4llvm14GlobalVariableEj")
  //</editor-fold>
  public abstract /*virtual*/ void registerDeviceVar(final GlobalVariable /*&*/ Var, /*uint*/int Flags)/* = 0*/;

  
  /// Constructs and returns a module initialization function or nullptr if it's
  /// not needed. Must be called after all kernels have been emitted.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::makeModuleCtorFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 60,
   FQN="clang::CodeGen::CGCUDARuntime::makeModuleCtorFunction", NM="_ZN5clang7CodeGen13CGCUDARuntime22makeModuleCtorFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntime22makeModuleCtorFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Function /*P*/ makeModuleCtorFunction()/* = 0*/;

  
  /// Returns a module cleanup function or nullptr if it's not needed.
  /// Must be called after ModuleCtorFunction
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCUDARuntime::makeModuleDtorFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.h", line = 64,
   FQN="clang::CodeGen::CGCUDARuntime::makeModuleDtorFunction", NM="_ZN5clang7CodeGen13CGCUDARuntime22makeModuleDtorFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDARuntime.cpp -nm=_ZN5clang7CodeGen13CGCUDARuntime22makeModuleDtorFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Function /*P*/ makeModuleDtorFunction()/* = 0*/;

  
  @Override public String toString() {
    return "" + "CGM=" + CGM; // NOI18N
  }
}
