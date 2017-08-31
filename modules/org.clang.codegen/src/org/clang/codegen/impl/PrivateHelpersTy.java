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
import org.clank.support.Native.NativePOD;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrivateHelpersTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3151,
 FQN="(anonymous namespace)::PrivateHelpersTy", NM="_ZN12_GLOBAL__N_116PrivateHelpersTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_116PrivateHelpersTyE")
//</editor-fold>
public class/*struct*/ PrivateHelpersTy implements NativePOD<PrivateHelpersTy>, NativeMoveable<PrivateHelpersTy> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrivateHelpersTy::PrivateHelpersTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3152,
   FQN="(anonymous namespace)::PrivateHelpersTy::PrivateHelpersTy", NM="_ZN12_GLOBAL__N_116PrivateHelpersTyC1EPKN5clang7VarDeclES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_116PrivateHelpersTyC1EPKN5clang7VarDeclES4_S4_")
  //</editor-fold>
  public PrivateHelpersTy(/*const*/ VarDecl /*P*/ Original, /*const*/ VarDecl /*P*/ PrivateCopy, 
      /*const*/ VarDecl /*P*/ PrivateElemInit) {
    // : Original(Original), PrivateCopy(PrivateCopy), PrivateElemInit(PrivateElemInit) 
    //START JInit
    this.Original = Original;
    this.PrivateCopy = PrivateCopy;
    this.PrivateElemInit = PrivateElemInit;
    //END JInit
  }

  public /*const*/ VarDecl /*P*/ Original;
  public /*const*/ VarDecl /*P*/ PrivateCopy;
  public /*const*/ VarDecl /*P*/ PrivateElemInit;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrivateHelpersTy::PrivateHelpersTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3151,
   FQN="(anonymous namespace)::PrivateHelpersTy::PrivateHelpersTy", NM="_ZN12_GLOBAL__N_116PrivateHelpersTyC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_116PrivateHelpersTyC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PrivateHelpersTy(final /*const*/ PrivateHelpersTy /*&*/ $Prm0) {
    // : Original(.Original), PrivateCopy(.PrivateCopy), PrivateElemInit(.PrivateElemInit) 
    //START JInit
    this.Original = $Prm0.Original;
    this.PrivateCopy = $Prm0.PrivateCopy;
    this.PrivateElemInit = $Prm0.PrivateElemInit;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrivateHelpersTy::PrivateHelpersTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3151,
   FQN="(anonymous namespace)::PrivateHelpersTy::PrivateHelpersTy", NM="_ZN12_GLOBAL__N_116PrivateHelpersTyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_116PrivateHelpersTyC1EOS0_")
  //</editor-fold>
  public /*inline*/ PrivateHelpersTy(JD$Move _dparam, final PrivateHelpersTy /*&&*/$Prm0) {
    // : Original(static_cast<PrivateHelpersTy &&>().Original), PrivateCopy(static_cast<PrivateHelpersTy &&>().PrivateCopy), PrivateElemInit(static_cast<PrivateHelpersTy &&>().PrivateElemInit) 
    //START JInit
    this.Original = $Prm0.Original;
    this.PrivateCopy = $Prm0.PrivateCopy;
    this.PrivateElemInit = $Prm0.PrivateElemInit;
    //END JInit
  }

  @Override
  public PrivateHelpersTy $assign(PrivateHelpersTy $Prm0) {
    this.Original = $Prm0.Original;
    this.PrivateCopy = $Prm0.PrivateCopy;
    this.PrivateElemInit = $Prm0.PrivateElemInit;
    return this;
  }

  @Override
  public PrivateHelpersTy clone() {
    return new PrivateHelpersTy(this);
  }

  @Override
  public PrivateHelpersTy move() {
    return new PrivateHelpersTy(JD$Move.INSTANCE, this);
  }

  public PrivateHelpersTy() {
    this.Original = null;
    this.PrivateCopy = null;
    this.PrivateElemInit = null;
  }
  
  @Override public String toString() {
    return "" + "Original=" + "[VarDecl]" // NOI18N
              + ", PrivateCopy=" + "[VarDecl]" // NOI18N
              + ", PrivateElemInit=" + "[VarDecl]"; // NOI18N
  }
}
