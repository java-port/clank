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
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyUnpassedArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3234,
 FQN="(anonymous namespace)::DestroyUnpassedArg", NM="_ZN12_GLOBAL__N_118DestroyUnpassedArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_118DestroyUnpassedArgE")
//</editor-fold>
public final class/*struct*/ DestroyUnpassedArg extends /**/ EHScopeStack.Cleanup {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyUnpassedArg::DestroyUnpassedArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3235,
   FQN="(anonymous namespace)::DestroyUnpassedArg::DestroyUnpassedArg", NM="_ZN12_GLOBAL__N_118DestroyUnpassedArgC1EN5clang7CodeGen7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_118DestroyUnpassedArgC1EN5clang7CodeGen7AddressENS1_8QualTypeE")
  //</editor-fold>
  public DestroyUnpassedArg(Address Addr, QualType Ty) {
    // : EHScopeStack::Cleanup(), Addr(Addr), Ty(Ty) 
    //START JInit
    super();
    this.Addr = new Address(Addr);
    this.Ty = new QualType(Ty);
    //END JInit
  }

  
  public Address Addr;
  public QualType Ty;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyUnpassedArg::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3241,
   FQN="(anonymous namespace)::DestroyUnpassedArg::Emit", NM="_ZN12_GLOBAL__N_118DestroyUnpassedArg4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_118DestroyUnpassedArg4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    /*const*/ CXXDestructorDecl /*P*/ Dtor = Ty.$arrow().getAsCXXRecordDecl().getDestructor();
    assert (!Dtor.isTrivial());
    CGF.EmitCXXDestructorCall(Dtor, CXXDtorType.Dtor_Complete, /*for vbase*/ false, 
        /*Delegating=*/ false, new Address(Addr));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyUnpassedArg::DestroyUnpassedArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 3234,
   FQN="(anonymous namespace)::DestroyUnpassedArg::DestroyUnpassedArg", NM="_ZN12_GLOBAL__N_118DestroyUnpassedArgC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_118DestroyUnpassedArgC1EOS0_")
  //</editor-fold>
  public /*inline*/ DestroyUnpassedArg(JD$Move _dparam, final DestroyUnpassedArg /*&&*/$Prm0) {
    // : EHScopeStack::Cleanup(static_cast<DestroyUnpassedArg &&>()), Addr(static_cast<DestroyUnpassedArg &&>().Addr), Ty(static_cast<DestroyUnpassedArg &&>().Ty) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.Addr = new Address(JD$Move.INSTANCE, $Prm0.Addr);
    this.Ty = new QualType(JD$Move.INSTANCE, $Prm0.Ty);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static DestroyUnpassedArg $factory(DestroyUnpassedArg p) { return new DestroyUnpassedArg(JD$Move.INSTANCE, p); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Addr=" + Addr // NOI18N
              + ", Ty=" + Ty // NOI18N
              + super.toString(); // NOI18N
  }
}
