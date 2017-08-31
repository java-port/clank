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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.ir.*;


/// The MS C++ ABI needs a pointer to RTTI data plus some flags to describe the
/// type of a catch handler, so we use this wrapper.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CatchTypeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 38,
 FQN="clang::CodeGen::CatchTypeInfo", NM="_ZN5clang7CodeGen13CatchTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CatchTypeInfoE")
//</editor-fold>
public class/*struct*/ CatchTypeInfo {
  public Constant /*P*/ RTTI;
  public /*uint*/int Flags;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CatchTypeInfo::CatchTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 38,
   FQN="clang::CodeGen::CatchTypeInfo::CatchTypeInfo", NM="_ZN5clang7CodeGen13CatchTypeInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CatchTypeInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CatchTypeInfo(final /*const*/ CatchTypeInfo /*&*/ $Prm0) {
    // : RTTI(.RTTI), Flags(.Flags) 
    //START JInit
    this.RTTI = $Prm0.RTTI;
    this.Flags = $Prm0.Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CatchTypeInfo::CatchTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 38,
   FQN="clang::CodeGen::CatchTypeInfo::CatchTypeInfo", NM="_ZN5clang7CodeGen13CatchTypeInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CatchTypeInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ CatchTypeInfo(JD$Move _dparam, final CatchTypeInfo /*&&*/$Prm0) {
    // : RTTI(static_cast<CatchTypeInfo &&>().RTTI), Flags(static_cast<CatchTypeInfo &&>().Flags) 
    //START JInit
    this.RTTI = $Prm0.RTTI;
    this.Flags = $Prm0.Flags;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CatchTypeInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 38,
   FQN="clang::CodeGen::CatchTypeInfo::operator=", NM="_ZN5clang7CodeGen13CatchTypeInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CatchTypeInfoaSERKS1_")
  //</editor-fold>
  public /*inline*/ CatchTypeInfo /*&*/ $assign(final /*const*/ CatchTypeInfo /*&*/ $Prm0) {
    this.RTTI = $Prm0.RTTI;
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CatchTypeInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 38,
   FQN="clang::CodeGen::CatchTypeInfo::operator=", NM="_ZN5clang7CodeGen13CatchTypeInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CatchTypeInfoaSEOS1_")
  //</editor-fold>
  public /*inline*/ CatchTypeInfo /*&*/ $assignMove(final CatchTypeInfo /*&&*/$Prm0) {
    this.RTTI = $Prm0.RTTI;
    this.Flags = $Prm0.Flags;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CatchTypeInfo(Constant RTTI, int Flags) {
    this.RTTI = RTTI;
    this.Flags = Flags;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "RTTI=" + RTTI // NOI18N
              + ", Flags=" + Flags; // NOI18N
  }
}
