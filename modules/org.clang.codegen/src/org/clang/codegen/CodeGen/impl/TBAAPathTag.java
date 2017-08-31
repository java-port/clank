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

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TBAAPathTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 35,
 FQN="clang::CodeGen::TBAAPathTag", NM="_ZN5clang7CodeGen11TBAAPathTagE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11TBAAPathTagE")
//</editor-fold>
public class/*struct*/ TBAAPathTag {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TBAAPathTag::TBAAPathTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 36,
   FQN="clang::CodeGen::TBAAPathTag::TBAAPathTag", NM="_ZN5clang7CodeGen11TBAAPathTagC1EPKNS_4TypeEPKN4llvm6MDNodeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11TBAAPathTagC1EPKNS_4TypeEPKN4llvm6MDNodeEy")
  //</editor-fold>
  public TBAAPathTag(/*const*/ org.clang.ast.Type /*P*/ B, /*const*/ MDNode /*P*/ A, long/*uint64_t*/ O) {
    // : BaseT(B), AccessN(A), Offset(O) 
    //START JInit
    this.BaseT = B;
    this.AccessN = A;
    this.Offset = O;
    //END JInit
  }

  public /*const*/ org.clang.ast.Type /*P*/ BaseT;
  public /*const*/ MDNode /*P*/ AccessN;
  public long/*uint64_t*/ Offset;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TBAAPathTag::TBAAPathTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 35,
   FQN="clang::CodeGen::TBAAPathTag::TBAAPathTag", NM="_ZN5clang7CodeGen11TBAAPathTagC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11TBAAPathTagC1ERKS1_")
  //</editor-fold>
  public /*inline*/ TBAAPathTag(final /*const*/ TBAAPathTag /*&*/ $Prm0) {
    // : BaseT(.BaseT), AccessN(.AccessN), Offset(.Offset) 
    //START JInit
    this.BaseT = $Prm0.BaseT;
    this.AccessN = $Prm0.AccessN;
    this.Offset = $Prm0.Offset;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TBAAPathTag::TBAAPathTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 35,
   FQN="clang::CodeGen::TBAAPathTag::TBAAPathTag", NM="_ZN5clang7CodeGen11TBAAPathTagC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11TBAAPathTagC1EOS1_")
  //</editor-fold>
  public /*inline*/ TBAAPathTag(JD$Move _dparam, final TBAAPathTag /*&&*/$Prm0) {
    // : BaseT(static_cast<TBAAPathTag &&>().BaseT), AccessN(static_cast<TBAAPathTag &&>().AccessN), Offset(static_cast<TBAAPathTag &&>().Offset) 
    //START JInit
    this.BaseT = $Prm0.BaseT;
    this.AccessN = $Prm0.AccessN;
    this.Offset = $Prm0.Offset;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TBAAPathTag::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 35,
   FQN="clang::CodeGen::TBAAPathTag::operator=", NM="_ZN5clang7CodeGen11TBAAPathTagaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11TBAAPathTagaSERKS1_")
  //</editor-fold>
  public /*inline*/ TBAAPathTag /*&*/ $assign(final /*const*/ TBAAPathTag /*&*/ $Prm0) {
    this.BaseT = $Prm0.BaseT;
    this.AccessN = $Prm0.AccessN;
    this.Offset = $Prm0.Offset;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::TBAAPathTag::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 35,
   FQN="clang::CodeGen::TBAAPathTag::operator=", NM="_ZN5clang7CodeGen11TBAAPathTagaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11TBAAPathTagaSEOS1_")
  //</editor-fold>
  public /*inline*/ TBAAPathTag /*&*/ $assignMove(final TBAAPathTag /*&&*/$Prm0) {
    this.BaseT = $Prm0.BaseT;
    this.AccessN = $Prm0.AccessN;
    this.Offset = $Prm0.Offset;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "BaseT=" + BaseT // NOI18N
              + ", AccessN=" + AccessN // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}
