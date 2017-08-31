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
import org.clang.basic.*;
import org.clank.support.Native.NativePOD;


/// A POD class for pairing a NamedDecl* with an access specifier.
/// Can be put into unions.
//<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 30,
 FQN="clang::DeclAccessPair", NM="_ZN5clang14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairE")
//</editor-fold>
public class DeclAccessPair implements NativePOD<DeclAccessPair>, NativeMoveable<DeclAccessPair> {
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /* NamedDecl* or (ID << 2)*//*uintptr_t*/Object Ptr; // we'd use llvm::PointerUnion, but it isn't trivial
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private AccessSpecifier Specifier = AccessSpecifier.AS_public;
  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 33,
   FQN="clang::DeclAccessPair::(anonymous)", NM="_ZN5clang14DeclAccessPairE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int Mask = 0x3;
  /*}*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::make">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 36,
   FQN="clang::DeclAccessPair::make", NM="_ZN5clang14DeclAccessPair4makeEPNS_9NamedDeclENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPair4makeEPNS_9NamedDeclENS_15AccessSpecifierE")
  //</editor-fold>
  public static DeclAccessPair make(NamedDecl /*P*/ D, AccessSpecifier AS) {
    DeclAccessPair p/*J*/= new DeclAccessPair();
    p.set(D, AS);
    return p;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::getDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 42,
   FQN="clang::DeclAccessPair::getDecl", NM="_ZNK5clang14DeclAccessPair7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK5clang14DeclAccessPair7getDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getDecl() /*const*/ {
    assert this != DEFAULT;
    return (NamedDecl/*P*/)Ptr;//reinterpret_cast(NamedDecl /*P*/ .class, ~Mask & Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::getAccess">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 45,
   FQN="clang::DeclAccessPair::getAccess", NM="_ZNK5clang14DeclAccessPair9getAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK5clang14DeclAccessPair9getAccessEv")
  //</editor-fold>
  public AccessSpecifier getAccess() /*const*/ {
    assert this != DEFAULT;
    return Specifier; //AccessSpecifier.valueOf(Mask & Ptr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::setDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 49,
   FQN="clang::DeclAccessPair::setDecl", NM="_ZN5clang14DeclAccessPair7setDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPair7setDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void setDecl(NamedDecl /*P*/ D) {
    assert this != DEFAULT;
    set(D, getAccess());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::setAccess">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 52,
   FQN="clang::DeclAccessPair::setAccess", NM="_ZN5clang14DeclAccessPair9setAccessENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPair9setAccessENS_15AccessSpecifierE")
  //</editor-fold>
  public void setAccess(AccessSpecifier AS) {
    assert this != DEFAULT;
    set(Ptr, AS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 55,
   FQN="clang::DeclAccessPair::set", NM="_ZN5clang14DeclAccessPair3setEPNS_9NamedDeclENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPair3setEPNS_9NamedDeclENS_15AccessSpecifierE")
  //</editor-fold>
  public void set(NamedDecl /*P*/ D, AccessSpecifier AS) {
    assert this != DEFAULT;
    Ptr = D;//((Object/*uintptr_t*/)(AS.getValue())) | reinterpret_cast_Object/*uintptr_t*/(D);
    Specifier = AS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::operator NamedDecl * ">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 59,
   FQN="clang::DeclAccessPair::operator NamedDecl * ", NM="_ZNK5clang14DeclAccessPaircvPNS_9NamedDeclEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK5clang14DeclAccessPaircvPNS_9NamedDeclEEv")
  //</editor-fold>
  public NamedDecl /*P*/ $NamedDecl$P() /*const*/ {
    assert this != DEFAULT;
    return getDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 60,
   FQN="clang::DeclAccessPair::operator->", NM="_ZNK5clang14DeclAccessPairptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK5clang14DeclAccessPairptEv")
  //</editor-fold>
  public NamedDecl /*P*/ $arrow() /*const*/ {
    assert this != DEFAULT;
    return getDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::DeclAccessPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 30,
   FQN="clang::DeclAccessPair::DeclAccessPair", NM="_ZN5clang14DeclAccessPairC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairC1Ev")
  //</editor-fold>
  public /*inline*/ DeclAccessPair() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::DeclAccessPair">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 30,
   FQN="clang::DeclAccessPair::DeclAccessPair", NM="_ZN5clang14DeclAccessPairC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclAccessPair(final /*const*/ DeclAccessPair /*&*/ $Prm0) {
    // : Ptr(.Ptr) 
    //START JInit
    this.Ptr = $Prm0.Ptr;
    this.Specifier = $Prm0.Specifier;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::DeclAccessPair">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 30,
   FQN="clang::DeclAccessPair::DeclAccessPair", NM="_ZN5clang14DeclAccessPairC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclAccessPair(JD$Move _dparam, final DeclAccessPair /*&&*/$Prm0) {
    assert DEFAULT != $Prm0;
    // : Ptr(static_cast<DeclAccessPair &&>().Ptr) 
    //START JInit
    this.Ptr = $Prm0.Ptr;
    this.Specifier = $Prm0.Specifier;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 30,
   FQN="clang::DeclAccessPair::operator=", NM="_ZN5clang14DeclAccessPairaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeclAccessPair /*&*/ $assign(final /*const*/ DeclAccessPair /*&*/ $Prm0) {
    assert this != DEFAULT;
    this.Ptr = $Prm0.Ptr;
    this.Specifier = $Prm0.Specifier;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclAccessPair::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclAccessPair.h", line = 30,
   FQN="clang::DeclAccessPair::operator=", NM="_ZN5clang14DeclAccessPairaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang14DeclAccessPairaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeclAccessPair /*&*/ $assignMove(final DeclAccessPair /*&&*/$Prm0) {
    assert this != DEFAULT;
    assert $Prm0 != DEFAULT;
    this.Ptr = $Prm0.Ptr;
    this.Specifier = $Prm0.Specifier;
    return /*Deref*/this;
  }

  @Override
  public DeclAccessPair clone() {
    return new DeclAccessPair(this);
  }

  /*friend*/ Integer /*P*/ getDecl$ID() /*const*/ {
    assert Ptr != null : "must be used only by lazy decls";
    return (Integer)Ptr;
  }

  private void set(Object /*P*/ D, AccessSpecifier AS) {
    assert this != DEFAULT;
    Ptr = D;//((Object/*uintptr_t*/)(AS.getValue())) | reinterpret_cast_Object/*uintptr_t*/(D);
    Specifier = AS;
  }

  public static DeclAccessPair make(int /*NamedDecl P*/ D, AccessSpecifier AS) {
    DeclAccessPair p/*J*/ = new DeclAccessPair();
    p.set(Integer.valueOf(D), AS);
    return p;
  }
  
  @Override public DeclAccessPair move() {
    return new DeclAccessPair(JD$Move.INSTANCE, this);
  }
  
  public static final DeclAccessPair DEFAULT = new DeclAccessPair();
  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }
}
