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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::BaseInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 420,
 FQN="(anonymous namespace)::(anonymous namespace)::BaseInfo", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoE")
//</editor-fold>
public class/*struct*/ BaseInfo implements ComparableLower, NativePOD<BaseInfo>, NativeMoveable<BaseInfo> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::BaseInfo::BaseInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 421,
   FQN="(anonymous namespace)::(anonymous namespace)::BaseInfo::BaseInfo", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoC1EPKN5clang13CXXRecordDeclENS2_9CharUnitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoC1EPKN5clang13CXXRecordDeclENS2_9CharUnitsEj")
  //</editor-fold>
  public BaseInfo(/*const*/ CXXRecordDecl /*P*/ Decl, CharUnits Offset, /*uint*/int Index) {
    // : Decl(Decl), Offset(Offset), Index(Index) 
    //START JInit
    this.Decl = Decl;
    this.Offset = new CharUnits(Offset);
    this.Index = Index;
    //END JInit
  }

  
  public /*const*/ CXXRecordDecl /*P*/ Decl;
  public final CharUnits Offset;
  public /*uint*/int Index;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::BaseInfo::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 429,
   FQN="(anonymous namespace)::(anonymous namespace)::BaseInfo::operator<", NM="_ZNK12_GLOBAL__N_112_GLOBAL__N_18BaseInfoltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZNK12_GLOBAL__N_112_GLOBAL__N_18BaseInfoltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ BaseInfo /*&*/ O) /*const*/ {
    return Offset.$less(O.Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::BaseInfo::BaseInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 420,
   FQN="(anonymous namespace)::(anonymous namespace)::BaseInfo::BaseInfo", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ BaseInfo(JD$Move _dparam, final BaseInfo /*&&*/$Prm0) {
    // : Decl(static_cast<BaseInfo &&>().Decl), Offset(static_cast<BaseInfo &&>().Offset), Index(static_cast<BaseInfo &&>().Index) 
    //START JInit
    this.Decl = $Prm0.Decl;
    this.Offset = new CharUnits(JD$Move.INSTANCE, $Prm0.Offset);
    this.Index = $Prm0.Index;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous namespace)::BaseInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 420,
   FQN="(anonymous namespace)::(anonymous namespace)::BaseInfo::operator=", NM="_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_112_GLOBAL__N_18BaseInfoaSEOS1_")
  //</editor-fold>
  public /*inline*/ BaseInfo /*&*/ $assignMove(final BaseInfo /*&&*/$Prm0) {
    this.Decl = $Prm0.Decl;
    this.Offset.$assignMove($Prm0.Offset);
    this.Index = $Prm0.Index;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override
  boolean $less(Object obj) {
    return $less((BaseInfo) obj);
  }

  public BaseInfo() {
    this.Offset = new CharUnits();
  }

  public /*inline*/ BaseInfo /*&*/ $assign(final BaseInfo /*&&*/ $Prm0) {
    this.Decl = $Prm0.Decl;
    this.Offset.$assign($Prm0.Offset);
    this.Index = $Prm0.Index;
    return /*Deref*/ this;
  }

  public /*inline*/ BaseInfo(final BaseInfo /*&&*/ $Prm0) {
    // : Decl(static_cast<BaseInfo &&>().Decl), Offset(static_cast<BaseInfo &&>().Offset), Index(static_cast<BaseInfo &&>().Index) 
    //START JInit
    this.Decl = $Prm0.Decl;
    this.Offset = new CharUnits($Prm0.Offset);
    this.Index = $Prm0.Index;
    //END JInit
  }

  @Override
  public BaseInfo clone() {
    return new BaseInfo(this);
  }

  @Override
  public BaseInfo move() {
    return new BaseInfo(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Decl=" + "[CXXRecordDecl]" // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", Index=" + Index; // NOI18N
  }
}
