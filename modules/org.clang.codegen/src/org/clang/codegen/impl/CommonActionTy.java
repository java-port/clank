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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;

/// Common pre(post)-action for different OpenMP constructs.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommonActionTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2039,
 FQN="(anonymous namespace)::CommonActionTy", NM="_ZN12_GLOBAL__N_114CommonActionTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_114CommonActionTyE")
//</editor-fold>
public final class CommonActionTy extends /*public*/ PrePostActionTy implements Destructors.ClassWithDestructor {
  private Value /*P*/ EnterCallee;
  private ArrayRef<Value /*P*/ > EnterArgs;
  private Value /*P*/ ExitCallee;
  private ArrayRef<Value /*P*/ > ExitArgs;
  private boolean Conditional;
  private BasicBlock /*P*/ ContBlock/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommonActionTy::CommonActionTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2048,
   FQN="(anonymous namespace)::CommonActionTy::CommonActionTy", NM="_ZN12_GLOBAL__N_114CommonActionTyC1EPN4llvm5ValueENS1_8ArrayRefIS3_EES3_S5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_114CommonActionTyC1EPN4llvm5ValueENS1_8ArrayRefIS3_EES3_S5_b")
  //</editor-fold>
  public CommonActionTy(Value /*P*/ EnterCallee, ArrayRef<Value /*P*/ > EnterArgs, 
      Value /*P*/ ExitCallee, ArrayRef<Value /*P*/ > ExitArgs) {
    this(EnterCallee, EnterArgs, 
      ExitCallee, ExitArgs, 
      false);
  }
  public CommonActionTy(Value /*P*/ EnterCallee, ArrayRef<Value /*P*/ > EnterArgs, 
      Value /*P*/ ExitCallee, ArrayRef<Value /*P*/ > ExitArgs, 
      boolean Conditional/*= false*/) {
    // : PrePostActionTy(), EnterCallee(EnterCallee), EnterArgs(EnterArgs), ExitCallee(ExitCallee), ExitArgs(ExitArgs), Conditional(Conditional), ContBlock(null) 
    //START JInit
    super();
    this.EnterCallee = EnterCallee;
    this.EnterArgs = new ArrayRef<Value /*P*/ >(EnterArgs);
    this.ExitCallee = ExitCallee;
    this.ExitArgs = new ArrayRef<Value /*P*/ >(ExitArgs);
    this.Conditional = Conditional;
    /*InClass*/this.ContBlock = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommonActionTy::Enter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2053,
   FQN="(anonymous namespace)::CommonActionTy::Enter", NM="_ZN12_GLOBAL__N_114CommonActionTy5EnterERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_114CommonActionTy5EnterERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void Enter(final CodeGenFunction /*&*/ CGF)/* override*/ {
    Value /*P*/ EnterRes = CGF.EmitRuntimeCall(EnterCallee, new ArrayRef<Value /*P*/ >(EnterArgs));
    if (Conditional) {
      Value /*P*/ CallBool = CGF.Builder.CreateIsNotNull(EnterRes);
      BasicBlock /*P*/ ThenBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_if.then"));
      ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_if.end"));
      // Generate the branch (If-stmt)
      CGF.Builder.CreateCondBr(CallBool, ThenBlock, ContBlock);
      CGF.EmitBlock(ThenBlock);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommonActionTy::Done">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2064,
   FQN="(anonymous namespace)::CommonActionTy::Done", NM="_ZN12_GLOBAL__N_114CommonActionTy4DoneERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_114CommonActionTy4DoneERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public void Done(final CodeGenFunction /*&*/ CGF) {
    // Emit the rest of blocks/branches
    CGF.EmitBranch(ContBlock);
    CGF.EmitBlock(ContBlock, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommonActionTy::Exit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2069,
   FQN="(anonymous namespace)::CommonActionTy::Exit", NM="_ZN12_GLOBAL__N_114CommonActionTy4ExitERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_114CommonActionTy4ExitERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void Exit(final CodeGenFunction /*&*/ CGF)/* override*/ {
    CGF.EmitRuntimeCall(ExitCallee, new ArrayRef<Value /*P*/ >(ExitArgs));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommonActionTy::~CommonActionTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2039,
   FQN="(anonymous namespace)::CommonActionTy::~CommonActionTy", NM="_ZN12_GLOBAL__N_114CommonActionTyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_114CommonActionTyD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "EnterCallee=" + EnterCallee // NOI18N
              + ", EnterArgs=" + EnterArgs // NOI18N
              + ", ExitCallee=" + ExitCallee // NOI18N
              + ", ExitArgs=" + ExitArgs // NOI18N
              + ", Conditional=" + Conditional // NOI18N
              + ", ContBlock=" + ContBlock // NOI18N
              + super.toString(); // NOI18N
  }
}
