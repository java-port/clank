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
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 45,
 FQN="clang::CodeGen::CallArg", NM="_ZN5clang7CodeGen7CallArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen7CallArgE")
//</editor-fold>
public class/*struct*/ CallArg implements NativeCloneable<CallArg> {
  public RValue RV;
  public QualType Ty;
  public boolean NeedsCopy;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArg::CallArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 49,
   FQN="clang::CodeGen::CallArg::CallArg", NM="_ZN5clang7CodeGen7CallArgC1ENS0_6RValueENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen7CallArgC1ENS0_6RValueENS_8QualTypeEb")
  //</editor-fold>
  public CallArg(RValue rv, QualType ty, boolean needscopy) {
    // : RV(rv), Ty(ty), NeedsCopy(needscopy) 
    //START JInit
    this.RV = new RValue(rv);
    this.Ty = new QualType(ty);
    this.NeedsCopy = needscopy;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArg::CallArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 45,
   FQN="clang::CodeGen::CallArg::CallArg", NM="_ZN5clang7CodeGen7CallArgC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen7CallArgC1EOS1_")
  //</editor-fold>
  public /*inline*/ CallArg(JD$Move _dparam, final CallArg /*&&*/$Prm0) {
    // : RV(static_cast<CallArg &&>().RV), Ty(static_cast<CallArg &&>().Ty), NeedsCopy(static_cast<CallArg &&>().NeedsCopy) 
    //START JInit
    this.RV = new RValue(JD$Move.INSTANCE, $Prm0.RV);
    this.Ty = new QualType(JD$Move.INSTANCE, $Prm0.Ty);
    this.NeedsCopy = $Prm0.NeedsCopy;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArg::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 45,
   FQN="clang::CodeGen::CallArg::operator=", NM="_ZN5clang7CodeGen7CallArgaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen7CallArgaSERKS1_")
  //</editor-fold>
  public /*inline*/ CallArg /*&*/ $assign(final /*const*/ CallArg /*&*/ $Prm0) {
    this.RV.$assign($Prm0.RV);
    this.Ty.$assign($Prm0.Ty);
    this.NeedsCopy = $Prm0.NeedsCopy;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CallArg::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.h", line = 45,
   FQN="clang::CodeGen::CallArg::operator=", NM="_ZN5clang7CodeGen7CallArgaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen7CallArgaSEOS1_")
  //</editor-fold>
  public /*inline*/ CallArg /*&*/ $assignMove(final CallArg /*&&*/$Prm0) {
    this.RV.$assignMove($Prm0.RV);
    this.Ty.$assignMove($Prm0.Ty);
    this.NeedsCopy = $Prm0.NeedsCopy;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CallArg() {
    this.RV = new RValue();
    this.Ty = new QualType();
    this.NeedsCopy = false;
  }
  
  @Override
  public CallArg clone() {
    return new CallArg(RV, Ty, NeedsCopy);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "RV=" + RV // NOI18N
              + ", Ty=" + Ty // NOI18N
              + ", NeedsCopy=" + NeedsCopy; // NOI18N
  }
}
