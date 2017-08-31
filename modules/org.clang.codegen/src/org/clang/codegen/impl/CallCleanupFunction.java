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
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallCleanupFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 500,
 FQN="(anonymous namespace)::CallCleanupFunction", NM="_ZN12_GLOBAL__N_119CallCleanupFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_119CallCleanupFunctionE")
//</editor-fold>
public final class/*struct*/ CallCleanupFunction extends /**/ EHScopeStack.Cleanup {
  public Constant /*P*/ CleanupFn;
  public final /*const*/ CGFunctionInfo /*&*/ FnInfo;
  public final /*const*/ VarDecl /*&*/ Var;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallCleanupFunction::CallCleanupFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 505,
   FQN="(anonymous namespace)::CallCleanupFunction::CallCleanupFunction", NM="_ZN12_GLOBAL__N_119CallCleanupFunctionC1EPN4llvm8ConstantEPKN5clang7CodeGen14CGFunctionInfoEPKNS4_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_119CallCleanupFunctionC1EPN4llvm8ConstantEPKN5clang7CodeGen14CGFunctionInfoEPKNS4_7VarDeclE")
  //</editor-fold>
  public CallCleanupFunction(Constant /*P*/ CleanupFn, /*const*/ CGFunctionInfo /*P*/ Info, 
      /*const*/ VarDecl /*P*/ Var) {
    // : EHScopeStack::Cleanup(), CleanupFn(CleanupFn), FnInfo(*Info), Var(*Var) 
    //START JInit
    super();
    this.CleanupFn = CleanupFn;
    this./*&*/FnInfo=/*&*/$Deref(Info);
    this./*&*/Var=/*&*/$Deref(Var);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallCleanupFunction::Emit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 509,
   FQN="(anonymous namespace)::CallCleanupFunction::Emit", NM="_ZN12_GLOBAL__N_119CallCleanupFunction4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_119CallCleanupFunction4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    CallArgList Args = null;
    try {
      DeclRefExpr DRE/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )($AddrOf(Var))), false, 
          Var.getType(), ExprValueKind.VK_LValue, new SourceLocation());
      // Compute the address of the local variable, in case it's a byref
      // or something.
      Value /*P*/ Addr = CGF.EmitDeclRefLValue($AddrOf(DRE)).getPointer();
      
      // In some cases, the type of the function argument will be different from
      // the type of the pointer. An example of this is
      // void f(void* arg);
      // __attribute__((cleanup(f))) void *g;
      //
      // To fix this we insert a bitcast here.
      QualType ArgTy = FnInfo.arg_begin$Const().$star().type.$QualType();
      Value /*P*/ Arg = CGF.Builder.CreateBitCast(Addr, CGF.ConvertType(new QualType(ArgTy)));
      
      Args/*J*/= new CallArgList();
      Args.add(RValue.get(Arg), 
          CGF.getContext().getPointerType(Var.getType()));
      CGF.EmitCall(FnInfo, CleanupFn, new ReturnValueSlot(), Args);
    } finally {
      if (Args != null) { Args.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "CleanupFn=" + CleanupFn // NOI18N
              + ", FnInfo=" + FnInfo // NOI18N
              + ", Var=" + "[VarDecl]" // NOI18N
              + super.toString(); // NOI18N
  }
}
