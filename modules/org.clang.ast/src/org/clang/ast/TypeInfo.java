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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;

//<editor-fold defaultstate="collapsed" desc="clang::TypeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 81,
 FQN="clang::TypeInfo", NM="_ZN5clang8TypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8TypeInfoE")
//</editor-fold>
public class/*struct*/ TypeInfo implements NativePOD<TypeInfo> {
  public long/*uint64_t*/ Width;
  public /*uint*/int Align;
  public /*JBIT bool*/ boolean AlignIsRequired /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="clang::TypeInfo::TypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 85,
   FQN="clang::TypeInfo::TypeInfo", NM="_ZN5clang8TypeInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8TypeInfoC1Ev")
  //</editor-fold>
  public TypeInfo() {
    // : Width(0), Align(0), AlignIsRequired(false) 
    //START JInit
    this.Width = 0;
    this.Align = 0;
    this.AlignIsRequired = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeInfo::TypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 86,
   FQN="clang::TypeInfo::TypeInfo", NM="_ZN5clang8TypeInfoC1Eyjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8TypeInfoC1Eyjb")
  //</editor-fold>
  public TypeInfo(long/*uint64_t*/ Width, /*uint*/int Align, boolean AlignIsRequired) {
    // : Width(Width), Align(Align), AlignIsRequired(AlignIsRequired) 
    //START JInit
    this.Width = Width;
    this.Align = Align;
    this.AlignIsRequired = AlignIsRequired;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeInfo::TypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 81,
   FQN="clang::TypeInfo::TypeInfo", NM="_ZN5clang8TypeInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8TypeInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TypeInfo(final /*const*/ TypeInfo /*&*/ $Prm0) {
    // : Width(.Width), Align(.Align), AlignIsRequired(.AlignIsRequired) 
    //START JInit
    this.Width = $Prm0.Width;
    this.Align = $Prm0.Align;
    this.AlignIsRequired = $Prm0.AlignIsRequired;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeInfo::TypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 81,
   FQN="clang::TypeInfo::TypeInfo", NM="_ZN5clang8TypeInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8TypeInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ TypeInfo(JD$Move _dparam, final TypeInfo /*&&*/$Prm0) {
    // : Width(static_cast<TypeInfo &&>().Width), Align(static_cast<TypeInfo &&>().Align), AlignIsRequired(static_cast<TypeInfo &&>().AlignIsRequired) 
    //START JInit
    this.Width = $Prm0.Width;
    this.Align = $Prm0.Align;
    this.AlignIsRequired = $Prm0.AlignIsRequired;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 81,
   FQN="clang::TypeInfo::operator=", NM="_ZN5clang8TypeInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang8TypeInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ TypeInfo /*&*/ $assign(final /*const*/ TypeInfo /*&*/ $Prm0) {
    this.Width = $Prm0.Width;
    this.Align = $Prm0.Align;
    this.AlignIsRequired = $Prm0.AlignIsRequired;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public TypeInfo clone() { 
    return new TypeInfo(this); 
  }

  @Override
  public boolean $eq(TypeInfo other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.Width != other.Width) {
      return false;
    }
    if (this.Align != other.Align) {
      return false;
    }
    if (this.AlignIsRequired != other.AlignIsRequired) {
      return false;
    }
    return true;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Width=" + Width // NOI18N
              + ", Align=" + Align // NOI18N
              + ", AlignIsRequired=" + AlignIsRequired; // NOI18N
  }
}
