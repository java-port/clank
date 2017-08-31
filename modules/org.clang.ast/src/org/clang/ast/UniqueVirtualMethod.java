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


/// \brief Uniquely identifies a virtual method within a class
/// hierarchy by the method itself and a class subobject number.
//<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 230,
 FQN="clang::UniqueVirtualMethod", NM="_ZN5clang19UniqueVirtualMethodE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodE")
//</editor-fold>
public class/*struct*/ UniqueVirtualMethod implements Native.NativePOD<UniqueVirtualMethod> {
  //<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod::UniqueVirtualMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 231,
   FQN="clang::UniqueVirtualMethod::UniqueVirtualMethod", NM="_ZN5clang19UniqueVirtualMethodC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodC1Ev")
  //</editor-fold>
  public UniqueVirtualMethod() {
    // : Method(null), Subobject(0), InVirtualSubobject(null) 
    //START JInit
    this.Method = null;
    this.Subobject = 0;
    this.InVirtualSubobject = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod::UniqueVirtualMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 234,
   FQN="clang::UniqueVirtualMethod::UniqueVirtualMethod", NM="_ZN5clang19UniqueVirtualMethodC1EPNS_13CXXMethodDeclEjPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodC1EPNS_13CXXMethodDeclEjPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public UniqueVirtualMethod(CXXMethodDecl /*P*/ Method, /*uint*/int Subobject, 
      /*const*/ CXXRecordDecl /*P*/ InVirtualSubobject) {
    // : Method(Method), Subobject(Subobject), InVirtualSubobject(InVirtualSubobject) 
    //START JInit
    this.Method = Method;
    this.Subobject = Subobject;
    this.InVirtualSubobject = InVirtualSubobject;
    //END JInit
  }

  
  /// \brief The overriding virtual method.
  public CXXMethodDecl /*P*/ Method;
  
  /// \brief The subobject in which the overriding virtual method
  /// resides.
  public /*uint*/int Subobject;
  
  /// \brief The virtual base class subobject of which this overridden
  /// virtual method is a part. Note that this records the closest
  /// derived virtual base class subobject.
  public /*const*/ CXXRecordDecl /*P*/ InVirtualSubobject;
  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 251,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_19UniqueVirtualMethodES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clangeqERKNS_19UniqueVirtualMethodES2_")
  //</editor-fold>
  public static boolean $eq_UniqueVirtualMethod$C(final /*const*/ UniqueVirtualMethod /*&*/ X, 
                           final /*const*/ UniqueVirtualMethod /*&*/ Y) {
    return X.Method == Y.Method && X.Subobject == Y.Subobject
       && X.InVirtualSubobject == Y.InVirtualSubobject;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 257,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_19UniqueVirtualMethodES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clangneERKNS_19UniqueVirtualMethodES2_")
  //</editor-fold>
  public static boolean $noteq_UniqueVirtualMethod$C(final /*const*/ UniqueVirtualMethod /*&*/ X, 
                              final /*const*/ UniqueVirtualMethod /*&*/ Y) {
    return !($eq_UniqueVirtualMethod$C(X, Y));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod::UniqueVirtualMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 230,
   FQN="clang::UniqueVirtualMethod::UniqueVirtualMethod", NM="_ZN5clang19UniqueVirtualMethodC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodC1ERKS0_")
  //</editor-fold>
  public /*inline*/ UniqueVirtualMethod(final /*const*/ UniqueVirtualMethod /*&*/ $Prm0) {
    // : Method(.Method), Subobject(.Subobject), InVirtualSubobject(.InVirtualSubobject) 
    //START JInit
    this.Method = $Prm0.Method;
    this.Subobject = $Prm0.Subobject;
    this.InVirtualSubobject = $Prm0.InVirtualSubobject;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod::UniqueVirtualMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 230,
   FQN="clang::UniqueVirtualMethod::UniqueVirtualMethod", NM="_ZN5clang19UniqueVirtualMethodC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodC1EOS0_")
  //</editor-fold>
  public /*inline*/ UniqueVirtualMethod(JD$Move _dparam, final UniqueVirtualMethod /*&&*/$Prm0) {
    // : Method(static_cast<UniqueVirtualMethod &&>().Method), Subobject(static_cast<UniqueVirtualMethod &&>().Subobject), InVirtualSubobject(static_cast<UniqueVirtualMethod &&>().InVirtualSubobject) 
    //START JInit
    this.Method = $Prm0.Method;
    this.Subobject = $Prm0.Subobject;
    this.InVirtualSubobject = $Prm0.InVirtualSubobject;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 230,
   FQN="clang::UniqueVirtualMethod::operator=", NM="_ZN5clang19UniqueVirtualMethodaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodaSERKS0_")
  //</editor-fold>
  public /*inline*/ UniqueVirtualMethod /*&*/ $assign(final /*const*/ UniqueVirtualMethod /*&*/ $Prm0) {
    this.Method = $Prm0.Method;
    this.Subobject = $Prm0.Subobject;
    this.InVirtualSubobject = $Prm0.InVirtualSubobject;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UniqueVirtualMethod::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 230,
   FQN="clang::UniqueVirtualMethod::operator=", NM="_ZN5clang19UniqueVirtualMethodaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang19UniqueVirtualMethodaSEOS0_")
  //</editor-fold>
  public /*inline*/ UniqueVirtualMethod /*&*/ $assignMove(final UniqueVirtualMethod /*&&*/$Prm0) {
    this.Method = $Prm0.Method;
    this.Subobject = $Prm0.Subobject;
    this.InVirtualSubobject = $Prm0.InVirtualSubobject;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public UniqueVirtualMethod clone() {
    return new UniqueVirtualMethod(this);
  }

  @Override
  public boolean $eq(UniqueVirtualMethod other) {
    return $eq_UniqueVirtualMethod$C(this, other);
  }

  @Override
  public boolean $noteq(UniqueVirtualMethod other) {
    return $noteq_UniqueVirtualMethod$C(this, other);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Method=" + Method // NOI18N
              + ", Subobject=" + Subobject // NOI18N
              + ", InVirtualSubobject=" + InVirtualSubobject; // NOI18N
  }
}
