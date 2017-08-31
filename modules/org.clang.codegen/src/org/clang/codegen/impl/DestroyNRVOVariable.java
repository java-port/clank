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
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyNRVOVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 441,
 FQN="(anonymous namespace)::DestroyNRVOVariable", NM="_ZN12_GLOBAL__N_119DestroyNRVOVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_119DestroyNRVOVariableE")
//</editor-fold>
public final class/*struct*/ DestroyNRVOVariable extends /**/ EHScopeStack.Cleanup {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyNRVOVariable::DestroyNRVOVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 442,
   FQN="(anonymous namespace)::DestroyNRVOVariable::DestroyNRVOVariable", NM="_ZN12_GLOBAL__N_119DestroyNRVOVariableC1EN5clang7CodeGen7AddressEPKNS1_17CXXDestructorDeclEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_119DestroyNRVOVariableC1EN5clang7CodeGen7AddressEPKNS1_17CXXDestructorDeclEPN4llvm5ValueE")
  //</editor-fold>
  public DestroyNRVOVariable(Address addr, 
      /*const*/ CXXDestructorDecl /*P*/ Dtor, 
      Value /*P*/ NRVOFlag) {
    // : EHScopeStack::Cleanup(), Dtor(Dtor), NRVOFlag(NRVOFlag), Loc(addr) 
    //START JInit
    super();
    this.Dtor = Dtor;
    this.NRVOFlag = NRVOFlag;
    this.Loc = new Address(addr);
    //END JInit
  }

  
  public /*const*/ CXXDestructorDecl /*P*/ Dtor;
  public Value /*P*/ NRVOFlag;
  public Address Loc;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyNRVOVariable::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 451,
   FQN="(anonymous namespace)::DestroyNRVOVariable::Emit", NM="_ZN12_GLOBAL__N_119DestroyNRVOVariable4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_119DestroyNRVOVariable4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    // Along the exceptions path we always execute the dtor.
    boolean NRVO = flags.isForNormalCleanup() && (NRVOFlag != null);
    
    BasicBlock /*P*/ SkipDtorBB = null;
    if (NRVO) {
      // If we exited via NRVO, we skip the destructor call.
      BasicBlock /*P*/ RunDtorBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"nrvo.unused"));
      SkipDtorBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"nrvo.skipdtor"));
      Value /*P*/ DidNRVO = CGF.Builder.CreateFlagLoad(NRVOFlag, new Twine(/*KEEP_STR*/"nrvo.val"));
      CGF.Builder.CreateCondBr(DidNRVO, SkipDtorBB, RunDtorBB);
      CGF.EmitBlock(RunDtorBB);
    }
    
    CGF.EmitCXXDestructorCall(Dtor, CXXDtorType.Dtor_Complete, 
        /*ForVirtualBase=*/ false, 
        /*Delegating=*/ false, 
        new Address(Loc));
    if (NRVO) {
      CGF.EmitBlock(SkipDtorBB);
    }
  }

  
  @Override public String toString() {
    return "" + "Dtor=" + "[CXXDestructorDecl]" // NOI18N
              + ", NRVOFlag=" + NRVOFlag // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
