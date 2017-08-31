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


/// Description of a constructor that was inherited from a base class.
//<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2161,
 FQN="clang::InheritedConstructor", NM="_ZN5clang20InheritedConstructorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructorE")
//</editor-fold>
public class InheritedConstructor implements Native.Native$Bool, Native.NativePOD<InheritedConstructor> {
  private ConstructorUsingShadowDecl /*P*/ Shadow;
  private CXXConstructorDecl /*P*/ BaseCtor;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::InheritedConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2166,
   FQN="clang::InheritedConstructor::InheritedConstructor", NM="_ZN5clang20InheritedConstructorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructorC1Ev")
  //</editor-fold>
  public InheritedConstructor() {
    // : Shadow(implicit ConstructorUsingShadowDecl * ()), BaseCtor(implicit CXXConstructorDecl * ()) 
    //START JInit
    this.Shadow = /*implicit-init*/((ConstructorUsingShadowDecl /*P*/ )/*zero-init*/null);
    this.BaseCtor = /*implicit-init*/((CXXConstructorDecl /*P*/ )/*zero-init*/null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::InheritedConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2167,
   FQN="clang::InheritedConstructor::InheritedConstructor", NM="_ZN5clang20InheritedConstructorC1EPNS_26ConstructorUsingShadowDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructorC1EPNS_26ConstructorUsingShadowDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public InheritedConstructor(ConstructorUsingShadowDecl /*P*/ Shadow, 
      CXXConstructorDecl /*P*/ BaseCtor) {
    // : Shadow(Shadow), BaseCtor(BaseCtor) 
    //START JInit
    this.Shadow = Shadow;
    this.BaseCtor = BaseCtor;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2171,
   FQN="clang::InheritedConstructor::operator bool", NM="_ZNK5clang20InheritedConstructorcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang20InheritedConstructorcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (Shadow != null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::getShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2173,
   FQN="clang::InheritedConstructor::getShadowDecl", NM="_ZNK5clang20InheritedConstructor13getShadowDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang20InheritedConstructor13getShadowDeclEv")
  //</editor-fold>
  public ConstructorUsingShadowDecl /*P*/ getShadowDecl() /*const*/ {
    return Shadow;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::getConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2174,
   FQN="clang::InheritedConstructor::getConstructor", NM="_ZNK5clang20InheritedConstructor14getConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang20InheritedConstructor14getConstructorEv")
  //</editor-fold>
  public CXXConstructorDecl /*P*/ getConstructor() /*const*/ {
    return BaseCtor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::InheritedConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2161,
   FQN="clang::InheritedConstructor::InheritedConstructor", NM="_ZN5clang20InheritedConstructorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InheritedConstructor(final /*const*/ InheritedConstructor /*&*/ $Prm0) {
    // : Shadow(.Shadow), BaseCtor(.BaseCtor) 
    //START JInit
    this.Shadow = $Prm0.Shadow;
    this.BaseCtor = $Prm0.BaseCtor;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::InheritedConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2161,
   FQN="clang::InheritedConstructor::InheritedConstructor", NM="_ZN5clang20InheritedConstructorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructorC1EOS0_")
  //</editor-fold>
  public /*inline*/ InheritedConstructor(JD$Move _dparam, final InheritedConstructor /*&&*/$Prm0) {
    // : Shadow(static_cast<InheritedConstructor &&>().Shadow), BaseCtor(static_cast<InheritedConstructor &&>().BaseCtor) 
    //START JInit
    this.Shadow = $Prm0.Shadow;
    this.BaseCtor = $Prm0.BaseCtor;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2161,
   FQN="clang::InheritedConstructor::operator=", NM="_ZN5clang20InheritedConstructoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructoraSERKS0_")
  //</editor-fold>
  public /*inline*/ InheritedConstructor /*&*/ $assign(final /*const*/ InheritedConstructor /*&*/ $Prm0) {
    this.Shadow = $Prm0.Shadow;
    this.BaseCtor = $Prm0.BaseCtor;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InheritedConstructor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2161,
   FQN="clang::InheritedConstructor::operator=", NM="_ZN5clang20InheritedConstructoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang20InheritedConstructoraSEOS0_")
  //</editor-fold>
  public /*inline*/ InheritedConstructor /*&*/ $assignMove(final InheritedConstructor /*&&*/$Prm0) {
    this.Shadow = $Prm0.Shadow;
    this.BaseCtor = $Prm0.BaseCtor;
    return /*Deref*/this;
  }

  @Override
  public InheritedConstructor clone() {
    return new InheritedConstructor(this);
  }
  
  @Override public String toString() {
    return "" + "Shadow=" + Shadow // NOI18N
              + ", BaseCtor=" + BaseCtor; // NOI18N
  }
}
