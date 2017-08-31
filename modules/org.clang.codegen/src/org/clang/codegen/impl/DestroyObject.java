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
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 420,
 FQN="(anonymous namespace)::DestroyObject", NM="_ZN12_GLOBAL__N_113DestroyObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_113DestroyObjectE")
//</editor-fold>
public final class/*struct*/ DestroyObject extends /**/ EHScopeStack.Cleanup {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyObject::DestroyObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 421,
   FQN="(anonymous namespace)::DestroyObject::DestroyObject", NM="_ZN12_GLOBAL__N_113DestroyObjectC1EN5clang7CodeGen7AddressENS1_8QualTypeEPFvRNS2_15CodeGenFunctionES3_S4_Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_113DestroyObjectC1EN5clang7CodeGen7AddressENS1_8QualTypeEPFvRNS2_15CodeGenFunctionES3_S4_Eb")
  //</editor-fold>
  public DestroyObject(Address addr, QualType type, 
      CodeGenFunction.AddressQualType2Void destroyer, 
      boolean useEHCleanupForArray) {
    // : EHScopeStack::Cleanup(), addr(addr), type(type), destroyer(destroyer), useEHCleanupForArray(useEHCleanupForArray) 
    //START JInit
    super();
    this.addr = new Address(addr);
    this.type = new QualType(type);
    this.destroyer = $tryClone(destroyer);
    this.useEHCleanupForArray = useEHCleanupForArray;
    //END JInit
  }

  
  public Address addr;
  public QualType type;
  public CodeGenFunction.AddressQualType2Void destroyer;
  public boolean useEHCleanupForArray;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyObject::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 432,
   FQN="(anonymous namespace)::DestroyObject::Emit", NM="_ZN12_GLOBAL__N_113DestroyObject4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_113DestroyObject4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    // Don't use an EH cleanup recursively from an EH cleanup.
    boolean useEHCleanupForArray = flags.isForNormalCleanup() && this.useEHCleanupForArray;
    
    CGF.emitDestroy(new Address(addr), new QualType(type), destroyer, useEHCleanupForArray);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyObject::DestroyObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 420,
   FQN="(anonymous namespace)::DestroyObject::DestroyObject", NM="_ZN12_GLOBAL__N_113DestroyObjectC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_113DestroyObjectC1EOS0_")
  //</editor-fold>
  public /*inline*/ DestroyObject(JD$Move _dparam, final DestroyObject /*&&*/$Prm0) {
    // : EHScopeStack::Cleanup(static_cast<DestroyObject &&>()), addr(static_cast<DestroyObject &&>().addr), type(static_cast<DestroyObject &&>().type), destroyer(static_cast<DestroyObject &&>().destroyer), useEHCleanupForArray(static_cast<DestroyObject &&>().useEHCleanupForArray) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.addr = new Address(JD$Move.INSTANCE, $Prm0.addr);
    this.type = new QualType(JD$Move.INSTANCE, $Prm0.type);
    this.destroyer = $tryClone($Prm0.destroyer);
    this.useEHCleanupForArray = $Prm0.useEHCleanupForArray;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "addr=" + addr // NOI18N
              + ", type=" + type // NOI18N
              + ", destroyer=" + destroyer // NOI18N
              + ", useEHCleanupForArray=" + useEHCleanupForArray // NOI18N
              + super.toString(); // NOI18N
  }
}
