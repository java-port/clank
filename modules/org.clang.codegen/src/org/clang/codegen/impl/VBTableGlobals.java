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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clank.support.Native.NativePOD;


/// Holds all the vbtable globals for a given class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VBTableGlobals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 38,
 FQN="(anonymous namespace)::VBTableGlobals", NM="_ZN12_GLOBAL__N_114VBTableGlobalsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_114VBTableGlobalsE")
//</editor-fold>
public class/*struct*/ VBTableGlobals implements Destructors.ClassWithDestructor, NativePOD<VBTableGlobals> {
  public /*const*/SmallVector<VPtrInfo /*P*/ > /*P*/ VBTables;
  public SmallVector<GlobalVariable /*P*/ > Globals;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VBTableGlobals::VBTableGlobals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 38,
   FQN="(anonymous namespace)::VBTableGlobals::VBTableGlobals", NM="_ZN12_GLOBAL__N_114VBTableGlobalsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_114VBTableGlobalsC1EOS0_")
  //</editor-fold>
  public /*inline*/ VBTableGlobals(JD$Move _dparam, final VBTableGlobals /*&&*/$Prm0) {
    // : VBTables(static_cast<VBTableGlobals &&>().VBTables), Globals(static_cast<VBTableGlobals &&>().Globals) 
    //START JInit
    this.VBTables = $Prm0.VBTables;
    this.Globals = new SmallVector<GlobalVariable /*P*/ >(JD$Move.INSTANCE, $Prm0.Globals);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VBTableGlobals::VBTableGlobals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 38,
   FQN="(anonymous namespace)::VBTableGlobals::VBTableGlobals", NM="_ZN12_GLOBAL__N_114VBTableGlobalsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_114VBTableGlobalsC1Ev")
  //</editor-fold>
  public /*inline*/ VBTableGlobals() {
    // : Globals() 
    //START JInit
    this.Globals = new SmallVector<GlobalVariable /*P*/ >(2, (GlobalVariable /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VBTableGlobals::~VBTableGlobals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 38,
   FQN="(anonymous namespace)::VBTableGlobals::~VBTableGlobals", NM="_ZN12_GLOBAL__N_114VBTableGlobalsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_114VBTableGlobalsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Globals.$destroy();
    //END JDestroy
  }

  @Override
  public VBTableGlobals clone() {
    VBTableGlobals res = new VBTableGlobals();
    if (this.VBTables != null) {
      res.VBTables = this.VBTables.clone();
    }
    res.Globals = this.Globals.clone();
    return res;
  }

  @Override
  public VBTableGlobals $assign(VBTableGlobals other) {
    this.VBTables.$assign(other.VBTables);
    this.Globals.$assign(other.Globals);
    return this;
  }
  
  @Override public String toString() {
    return "" + "VBTables=" + VBTables // NOI18N
              + ", Globals=" + Globals; // NOI18N
  }
}
