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

package org.clang.ast.impl;

import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1150,
 FQN="(anonymous namespace)::MemberPtr", NM="_ZN12_GLOBAL__N_19MemberPtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtrE")
//</editor-fold>
public class/*struct*/ MemberPtr implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::MemberPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1151,
   FQN="(anonymous namespace)::MemberPtr::MemberPtr", NM="_ZN12_GLOBAL__N_19MemberPtrC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtrC1Ev")
  //</editor-fold>
  public MemberPtr() {
    // : DeclAndIsDerivedMember(), Path() 
    //START JInit
    this.DeclAndIsDerivedMember = new PointerBoolPair</*const*/ ValueDecl /*P*/ >();
    this.Path = new SmallVector</*const*/ CXXRecordDecl /*P*/ >(4, (/*const*/ CXXRecordDecl /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::MemberPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1152,
   FQN="(anonymous namespace)::MemberPtr::MemberPtr", NM="_ZN12_GLOBAL__N_19MemberPtrC1EPKN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtrC1EPKN5clang9ValueDeclE")
  //</editor-fold>
  public /*explicit*/ MemberPtr(/*const*/ ValueDecl /*P*/ Decl) {
    // : DeclAndIsDerivedMember(Decl, false), Path() 
    //START JInit
    this.DeclAndIsDerivedMember = new PointerBoolPair</*const*/ ValueDecl /*P*/ >(Decl, false);
    this.Path = new SmallVector</*const*/ CXXRecordDecl /*P*/ >(4, (/*const*/ CXXRecordDecl /*P*/ )null);
    //END JInit
  }

  
  /// The member or (direct or indirect) field referred to by this member
  /// pointer, or 0 if this is a null member pointer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1157,
   FQN="(anonymous namespace)::MemberPtr::getDecl", NM="_ZNK12_GLOBAL__N_19MemberPtr7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_19MemberPtr7getDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ getDecl() /*const*/ {
    return DeclAndIsDerivedMember.getPointer();
  }

  /// Is this actually a member of some type derived from the relevant class?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::isDerivedMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1161,
   FQN="(anonymous namespace)::MemberPtr::isDerivedMember", NM="_ZNK12_GLOBAL__N_19MemberPtr15isDerivedMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_19MemberPtr15isDerivedMemberEv")
  //</editor-fold>
  public boolean isDerivedMember() /*const*/ {
    return DeclAndIsDerivedMember.getInt();
  }

  /// Get the class which the declaration actually lives in.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::getContainingRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1165,
   FQN="(anonymous namespace)::MemberPtr::getContainingRecord", NM="_ZNK12_GLOBAL__N_19MemberPtr19getContainingRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_19MemberPtr19getContainingRecordEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getContainingRecord() /*const*/ {
    return cast_CXXRecordDecl(DeclAndIsDerivedMember.getPointer().getDeclContext$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::moveInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1170,
   FQN="(anonymous namespace)::MemberPtr::moveInto", NM="_ZNK12_GLOBAL__N_19MemberPtr8moveIntoERN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_19MemberPtr8moveIntoERN5clang7APValueE")
  //</editor-fold>
  public void moveInto(final APValue /*&*/ V) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(V.$assign($c$.track(new APValue(getDecl(), isDerivedMember(), new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(Path, true)))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::setFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1173,
   FQN="(anonymous namespace)::MemberPtr::setFrom", NM="_ZN12_GLOBAL__N_19MemberPtr7setFromERKN5clang7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtr7setFromERKN5clang7APValueE")
  //</editor-fold>
  public void setFrom(final /*const*/ APValue /*&*/ V) {
    assert (V.isMemberPointer());
    DeclAndIsDerivedMember.setPointer(V.getMemberPointerDecl());
    DeclAndIsDerivedMember.setInt(V.isMemberPointerToDerivedMember());
    Path.clear();
    ArrayRef</*const*/ CXXRecordDecl /*P*/ > P = V.getMemberPointerPath();
    Path.insert$T$value_T(Path.end(), P.begin(), P.end());
  }

  
  /// DeclAndIsDerivedMember - The member declaration, and a flag indicating
  /// whether the member is a member of some class derived from the class type
  /// of the member pointer.
  public PointerBoolPair</*const*/ ValueDecl /*P*/ > DeclAndIsDerivedMember;
  /// Path - The path of base/derived classes from the member declaration's
  /// class (exclusive) to the class type of the member pointer (inclusive).
  public SmallVector</*const*/ CXXRecordDecl /*P*/ > Path;
  
  /// Perform a cast towards the class of the Decl (either up or down the
  /// hierarchy).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::castBack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1192,
   FQN="(anonymous namespace)::MemberPtr::castBack", NM="_ZN12_GLOBAL__N_19MemberPtr8castBackEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtr8castBackEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public boolean castBack(/*const*/ CXXRecordDecl /*P*/ Class) {
    assert (!Path.empty());
    /*const*/ CXXRecordDecl /*P*/ Expected;
    if ($greatereq_uint(Path.size(), 2)) {
      Expected = Path.$at(Path.size() - 2);
    } else {
      Expected = getContainingRecord();
    }
    if (Expected.getCanonicalDecl$Const() != Class.getCanonicalDecl$Const()) {
      // C++11 [expr.static.cast]p12: In a conversion from (D::*) to (B::*),
      // if B does not contain the original member and is not a base or
      // derived class of the class containing the original member, the result
      // of the cast is undefined.
      // C++11 [conv.mem]p2 does not cover this case for a cast from (B::*) to
      // (D::*). We consider that to be a language defect.
      return false;
    }
    Path.pop_back();
    return true;
  }

  /// Perform a base-to-derived member pointer cast.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::castToDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1212,
   FQN="(anonymous namespace)::MemberPtr::castToDerived", NM="_ZN12_GLOBAL__N_19MemberPtr13castToDerivedEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtr13castToDerivedEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public boolean castToDerived(/*const*/ CXXRecordDecl /*P*/ Derived) {
    if (!(getDecl() != null)) {
      return true;
    }
    if (!isDerivedMember()) {
      Path.push_back(Derived);
      return true;
    }
    if (!castBack(Derived)) {
      return false;
    }
    if (Path.empty()) {
      DeclAndIsDerivedMember.setInt(false);
    }
    return true;
  }

  /// Perform a derived-to-base member pointer cast.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::castToBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1226,
   FQN="(anonymous namespace)::MemberPtr::castToBase", NM="_ZN12_GLOBAL__N_19MemberPtr10castToBaseEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtr10castToBaseEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public boolean castToBase(/*const*/ CXXRecordDecl /*P*/ Base) {
    if (!(getDecl() != null)) {
      return true;
    }
    if (Path.empty()) {
      DeclAndIsDerivedMember.setInt(true);
    }
    if (isDerivedMember()) {
      Path.push_back(Base);
      return true;
    }
    return castBack(Base);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1150,
   FQN="(anonymous namespace)::MemberPtr::operator=", NM="_ZN12_GLOBAL__N_19MemberPtraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtraSEOS0_")
  //</editor-fold>
  public /*inline*/ MemberPtr /*&*/ $assignMove(final MemberPtr /*&&*/$Prm0) {
    this.DeclAndIsDerivedMember.$assignMove($Prm0.DeclAndIsDerivedMember);
    this.Path.$assignMove($Prm0.Path);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemberPtr::~MemberPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 1150,
   FQN="(anonymous namespace)::MemberPtr::~MemberPtr", NM="_ZN12_GLOBAL__N_19MemberPtrD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19MemberPtrD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Path.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "DeclAndIsDerivedMember=" + DeclAndIsDerivedMember // NOI18N
              + ", Path=" + Path; // NOI18N
  }
}
