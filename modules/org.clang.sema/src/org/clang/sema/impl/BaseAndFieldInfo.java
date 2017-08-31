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

package org.clang.sema.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3658,
 FQN="(anonymous namespace)::BaseAndFieldInfo", NM="_ZN12_GLOBAL__N_116BaseAndFieldInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116BaseAndFieldInfoE")
//</editor-fold>
public class/*struct*/ BaseAndFieldInfo implements Destructors.ClassWithDestructor {
  public final Sema /*&*/ S;
  public CXXConstructorDecl /*P*/ Ctor;
  public boolean AnyErrorsInInits;
  public ImplicitInitializerKind IIK;
  public DenseMap</*const*/Object/*void P*/, CXXCtorInitializer /*P*/ > AllBaseFields;
  public SmallVector<CXXCtorInitializer /*P*/ > AllToInit;
  public DenseMap<TagDecl /*P*/ , FieldDecl /*P*/ > ActiveUnionMember;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo::BaseAndFieldInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3667,
   FQN="(anonymous namespace)::BaseAndFieldInfo::BaseAndFieldInfo", NM="_ZN12_GLOBAL__N_116BaseAndFieldInfoC1ERN5clang4SemaEPNS1_18CXXConstructorDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116BaseAndFieldInfoC1ERN5clang4SemaEPNS1_18CXXConstructorDeclEb")
  //</editor-fold>
  public BaseAndFieldInfo(final Sema /*&*/ S, CXXConstructorDecl /*P*/ Ctor, boolean ErrorsInInits) {
    // : S(S), Ctor(Ctor), AnyErrorsInInits(ErrorsInInits), AllBaseFields(), AllToInit(), ActiveUnionMember() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Ctor = Ctor;
    this.AnyErrorsInInits = ErrorsInInits;
    this.AllBaseFields = new DenseMap</*const*/Object/*void P*/, CXXCtorInitializer /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CXXCtorInitializer /*P*/ )null);
    this.AllToInit = new SmallVector<CXXCtorInitializer /*P*/ >(8, (CXXCtorInitializer /*P*/ )null);
    this.ActiveUnionMember = new DenseMap<TagDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
    //END JInit
    boolean Generated = Ctor.isImplicit() || Ctor.isDefaulted();
    if (Ctor.getInheritedConstructor().$bool()) {
      IIK = ImplicitInitializerKind.IIK_Inherit;
    } else if (Generated && Ctor.isCopyConstructor()) {
      IIK = ImplicitInitializerKind.IIK_Copy;
    } else if (Generated && Ctor.isMoveConstructor()) {
      IIK = ImplicitInitializerKind.IIK_Move;
    } else {
      IIK = ImplicitInitializerKind.IIK_Default;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo::isImplicitCopyOrMove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3680,
   FQN="(anonymous namespace)::BaseAndFieldInfo::isImplicitCopyOrMove", NM="_ZNK12_GLOBAL__N_116BaseAndFieldInfo20isImplicitCopyOrMoveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK12_GLOBAL__N_116BaseAndFieldInfo20isImplicitCopyOrMoveEv")
  //</editor-fold>
  public boolean isImplicitCopyOrMove() /*const*/ {
    switch (IIK) {
     case IIK_Copy:
     case IIK_Move:
      return true;
     case IIK_Default:
     case IIK_Inherit:
      return false;
    }
    throw new llvm_unreachable("Invalid ImplicitInitializerKind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo::addFieldInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3694,
   FQN="(anonymous namespace)::BaseAndFieldInfo::addFieldInitializer", NM="_ZN12_GLOBAL__N_116BaseAndFieldInfo19addFieldInitializerEPN5clang18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116BaseAndFieldInfo19addFieldInitializerEPN5clang18CXXCtorInitializerE")
  //</editor-fold>
  public boolean addFieldInitializer(CXXCtorInitializer /*P*/ Init) {
    AllToInit.push_back(Init);
    
    // Check whether this initializer makes the field "used".
    if (Init.getInit().HasSideEffects(S.Context)) {
      S.UnusedPrivateFields.remove(Init.getAnyMember());
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo::isInactiveUnionMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3704,
   FQN="(anonymous namespace)::BaseAndFieldInfo::isInactiveUnionMember", NM="_ZN12_GLOBAL__N_116BaseAndFieldInfo21isInactiveUnionMemberEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116BaseAndFieldInfo21isInactiveUnionMemberEPN5clang9FieldDeclE")
  //</editor-fold>
  public boolean isInactiveUnionMember(FieldDecl /*P*/ Field) {
    RecordDecl /*P*/ Record = Field.getParent();
    if (!Record.isUnion()) {
      return false;
    }
    {
      
      FieldDecl /*P*/ Active = ActiveUnionMember.lookup(Record.getCanonicalDecl());
      if ((Active != null)) {
        return Active != Field.getCanonicalDecl();
      }
    }
    
    // In an implicit copy or move constructor, ignore any in-class initializer.
    if (isImplicitCopyOrMove()) {
      return true;
    }
    
    // If there's no explicit initialization, the field is active only if it
    // has an in-class initializer...
    if (Field.hasInClassInitializer()) {
      return false;
    }
    // ... or it's an anonymous struct or union whose class has an in-class
    // initializer.
    if (!Field.isAnonymousStructOrUnion()) {
      return true;
    }
    CXXRecordDecl /*P*/ FieldRD = Field.getType().$arrow().getAsCXXRecordDecl();
    return !FieldRD.hasInClassInitializer();
  }

  
  /// \brief Determine whether the given field is, or is within, a union member
  /// that is inactive (because there was an initializer given for a different
  /// member of the union, or because the union was not initialized at all).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo::isWithinInactiveUnionMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3732,
   FQN="(anonymous namespace)::BaseAndFieldInfo::isWithinInactiveUnionMember", NM="_ZN12_GLOBAL__N_116BaseAndFieldInfo27isWithinInactiveUnionMemberEPN5clang9FieldDeclEPNS1_17IndirectFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116BaseAndFieldInfo27isWithinInactiveUnionMemberEPN5clang9FieldDeclEPNS1_17IndirectFieldDeclE")
  //</editor-fold>
  public boolean isWithinInactiveUnionMember(FieldDecl /*P*/ FieldIn, 
                             IndirectFieldDecl /*P*/ Indirect) {
    if (!(Indirect != null)) {
      return isInactiveUnionMember(FieldIn);
    }
    
    for (NamedDecl /*P*/ C : Indirect.chain()) {
      FieldDecl /*P*/ Field = dyn_cast_FieldDecl(C);
      if ((Field != null) && isInactiveUnionMember(Field)) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseAndFieldInfo::~BaseAndFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3658,
   FQN="(anonymous namespace)::BaseAndFieldInfo::~BaseAndFieldInfo", NM="_ZN12_GLOBAL__N_116BaseAndFieldInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116BaseAndFieldInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ActiveUnionMember.$destroy();
    AllToInit.$destroy();
    AllBaseFields.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Ctor=" + Ctor // NOI18N
              + ", AnyErrorsInInits=" + AnyErrorsInInits // NOI18N
              + ", IIK=" + IIK // NOI18N
              + ", AllBaseFields=" + AllBaseFields // NOI18N
              + ", AllToInit=" + AllToInit // NOI18N
              + ", ActiveUnionMember=" + ActiveUnionMember; // NOI18N
  }
}
