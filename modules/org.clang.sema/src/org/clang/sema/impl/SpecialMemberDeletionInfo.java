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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.impl.SemaDeclCXXStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5566,
 FQN="(anonymous namespace)::SpecialMemberDeletionInfo", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfoE")
//</editor-fold>
public class/*struct*/ SpecialMemberDeletionInfo {
  public final Sema /*&*/ S;
  public CXXMethodDecl /*P*/ MD;
  public Sema.CXXSpecialMember CSM;
  public Sema.InheritedConstructorInfo /*P*/ ICI;
  public boolean Diagnose;
  
  // Properties of the special member, computed for convenience.
  public boolean IsConstructor;
  public boolean IsAssignment;
  public boolean IsMove;
  public boolean ConstArg;
  public SourceLocation Loc;
  
  public boolean AllFieldsAreConst;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::SpecialMemberDeletionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5579,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::SpecialMemberDeletionInfo", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfoC1ERN5clang4SemaEPNS1_13CXXMethodDeclENS2_16CXXSpecialMemberEPNS2_24InheritedConstructorInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfoC1ERN5clang4SemaEPNS1_13CXXMethodDeclENS2_16CXXSpecialMemberEPNS2_24InheritedConstructorInfoEb")
  //</editor-fold>
  public SpecialMemberDeletionInfo(final Sema /*&*/ S, CXXMethodDecl /*P*/ MD, 
      Sema.CXXSpecialMember CSM, 
      Sema.InheritedConstructorInfo /*P*/ ICI, boolean Diagnose) {
    // : S(S), MD(MD), CSM(CSM), ICI(ICI), Diagnose(Diagnose), IsConstructor(false), IsAssignment(false), IsMove(false), ConstArg(false), Loc(MD->getLocation()), AllFieldsAreConst(true) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.MD = MD;
    this.CSM = CSM;
    this.ICI = ICI;
    this.Diagnose = Diagnose;
    this.IsConstructor = false;
    this.IsAssignment = false;
    this.IsMove = false;
    this.ConstArg = false;
    this.Loc = MD.getLocation();
    this.AllFieldsAreConst = true;
    //END JInit
    switch (CSM) {
     case CXXDefaultConstructor:
     case CXXCopyConstructor:
      IsConstructor = true;
      break;
     case CXXMoveConstructor:
      IsConstructor = true;
      IsMove = true;
      break;
     case CXXCopyAssignment:
      IsAssignment = true;
      break;
     case CXXMoveAssignment:
      IsAssignment = true;
      IsMove = true;
      break;
     case CXXDestructor:
      break;
     case CXXInvalid:
      throw new llvm_unreachable("invalid special member kind");
    }
    if ((MD.getNumParams() != 0)) {
      {
        /*const*/ ReferenceType /*P*/ RT = MD.getParamDecl(0).getType().$arrow().getAs(ReferenceType.class);
        if ((RT != null)) {
          ConstArg = RT.getPointeeType().isConstQualified();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::inUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5614,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::inUnion", NM="_ZNK12_GLOBAL__N_125SpecialMemberDeletionInfo7inUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK12_GLOBAL__N_125SpecialMemberDeletionInfo7inUnionEv")
  //</editor-fold>
  public boolean inUnion() /*const*/ {
    return MD.getParent().isUnion();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::getEffectiveCSM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5616,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::getEffectiveCSM", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo15getEffectiveCSMEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo15getEffectiveCSMEv")
  //</editor-fold>
  public Sema.CXXSpecialMember getEffectiveCSM() {
    return (ICI != null) ? Sema.CXXSpecialMember.CXXInvalid : CSM;
  }

  
  /// Look up the corresponding special member in the given class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::lookupIn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5621,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::lookupIn", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo8lookupInEPN5clang13CXXRecordDeclEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo8lookupInEPN5clang13CXXRecordDeclEjb")
  //</editor-fold>
  public Sema.SpecialMemberOverloadResult /*P*/ lookupIn(CXXRecordDecl /*P*/ Class, 
          /*uint*/int Quals, boolean IsMutable) {
    return lookupCallFromSpecialMember(S, Class, CSM, Quals, 
        ConstArg && !IsMutable);
  }

  
  /*typedef llvm::PointerUnion<CXXBaseSpecifier *, FieldDecl *> Subobject*/
//  public final class Subobject extends PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >{ };
  
  
  /// Check whether we should delete a special member function due to the class
  /// having a particular direct or virtual base class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5757,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForBase", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo19shouldDeleteForBaseEPN5clang16CXXBaseSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo19shouldDeleteForBaseEPN5clang16CXXBaseSpecifierE")
  //</editor-fold>
  public boolean shouldDeleteForBase(CXXBaseSpecifier /*P*/ Base) {
    CXXRecordDecl /*P*/ BaseClass = Base.getType().$arrow().getAsCXXRecordDecl();
    // If program is correct, BaseClass cannot be null, but if it is, the error
    // must be reported elsewhere.
    if (!(BaseClass != null)) {
      return false;
    }
    // If we have an inheriting constructor, check whether we're calling an
    // inherited constructor instead of a default constructor.
    if ((ICI != null)) {
      assert (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor);
      CXXConstructorDecl /*P*/ BaseCtor = ICI.findConstructorForBase(BaseClass, cast_CXXConstructorDecl(MD).
              getInheritedConstructor().
              getConstructor()).
          first;
      if ((BaseCtor != null)) {
        if (BaseCtor.isDeleted() && Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Base.getLocStart(), 
                                        diag.note_deleted_special_member_class_subobject)), 
                                    getEffectiveCSM()), MD.getParent()), /*IsField*/ false), 
                        Base.getType()), /*Deleted*/ 1), /*IsDtorCallInCtor*/ false));
            S.NoteDeletedFunction(BaseCtor);
          } finally {
            $c$.$destroy();
          }
        }
        return BaseCtor.isDeleted();
      }
    }
    return shouldDeleteForClassSubobject(BaseClass, new PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >(JD$T.INSTANCE, CXXBaseSpecifier /*P*/ .class, Base), 0);
  }

  
  /// Check whether we should delete a special member function due to the class
  /// having a particular non-static data member.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5788,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForField", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo20shouldDeleteForFieldEPN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo20shouldDeleteForFieldEPN5clang9FieldDeclE")
  //</editor-fold>
  public boolean shouldDeleteForField(FieldDecl /*P*/ FD) {
    QualType FieldType = S.Context.getBaseElementType(FD.getType());
    CXXRecordDecl /*P*/ FieldRecord = FieldType.$arrow().getAsCXXRecordDecl();
    if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor) {
      // For a default constructor, all references must be initialized in-class
      // and, if a union, it must have a non-const member.
      if (FieldType.$arrow().isReferenceType() && !FD.hasInClassInitializer()) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_deleted_default_ctor_uninit_field)), 
                                !!(ICI != null)), MD.getParent()), FD), FieldType), /*Reference*/ 0));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
      // C++11 [class.ctor]p5: any non-variant non-static data member of
      // const-qualified type (or array thereof) with no
      // brace-or-equal-initializer does not have a user-provided default
      // constructor.
      if (!inUnion() && FieldType.isConstQualified()
         && !FD.hasInClassInitializer()
         && (!(FieldRecord != null) || !FieldRecord.hasUserProvidedDefaultConstructor())) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_deleted_default_ctor_uninit_field)), 
                                !!(ICI != null)), MD.getParent()), FD), FD.getType()), /*Const*/ 1));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
      if (inUnion() && !FieldType.isConstQualified()) {
        AllFieldsAreConst = false;
      }
    } else if (CSM == Sema.CXXSpecialMember.CXXCopyConstructor) {
      // For a copy constructor, data members must not be of rvalue reference
      // type.
      if (FieldType.$arrow().isRValueReferenceType()) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_deleted_copy_ctor_rvalue_reference)), 
                        MD.getParent()), FD), FieldType));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
    } else if (IsAssignment) {
      // For an assignment operator, data members must not be of reference type.
      if (FieldType.$arrow().isReferenceType()) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_deleted_assign_field)), 
                                IsMove), MD.getParent()), FD), FieldType), /*Reference*/ 0));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
      if (!(FieldRecord != null) && FieldType.isConstQualified()) {
        // C++11 [class.copy]p23:
        // -- a non-static data member of const non-class type (or array thereof)
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_deleted_assign_field)), 
                                IsMove), MD.getParent()), FD), FD.getType()), /*Const*/ 1));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
    }
    if ((FieldRecord != null)) {
      // Some additional restrictions exist on the variant members.
      if (!inUnion() && FieldRecord.isUnion()
         && FieldRecord.isAnonymousStructOrUnion()) {
        boolean AllVariantFieldsAreConst = true;
        
        // FIXME: Handle anonymous unions declared within anonymous unions.
        for (FieldDecl /*P*/ UI : FieldRecord.fields()) {
          QualType UnionFieldType = S.Context.getBaseElementType(UI.getType());
          if (!UnionFieldType.isConstQualified()) {
            AllVariantFieldsAreConst = false;
          }
          
          CXXRecordDecl /*P*/ UnionFieldRecord = UnionFieldType.$arrow().getAsCXXRecordDecl();
          if ((UnionFieldRecord != null)
             && shouldDeleteForClassSubobject(UnionFieldRecord, new PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >(JD$T1.INSTANCE, FieldDecl /*P*/ .class, UI), 
              UnionFieldType.getCVRQualifiers())) {
            return true;
          }
        }
        
        // At least one member in each anonymous union must be non-const
        if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor && AllVariantFieldsAreConst
           && !FieldRecord.field_empty()) {
          if (Diagnose) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FieldRecord.getLocation(), 
                              diag.note_deleted_default_ctor_all_const)), 
                          !!(ICI != null)), MD.getParent()), /*anonymous union*/ 1));
            } finally {
              $c$.$destroy();
            }
          }
          return true;
        }
        
        // Don't check the implicit member of the anonymous union type.
        // This is technically non-conformant, but sanity demands it.
        return false;
      }
      if (shouldDeleteForClassSubobject(FieldRecord, new PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >(JD$T1.INSTANCE, FieldDecl /*P*/ .class, FD), 
          FieldType.getCVRQualifiers())) {
        return true;
      }
    }
    
    return false;
  }

  
  /// C++11 [class.ctor] p5:
  ///   A defaulted default constructor for a class X is defined as deleted if
  /// X is a union and all of its variant members are of const-qualified type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForAllConstMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5889,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForAllConstMembers", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo30shouldDeleteForAllConstMembersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo30shouldDeleteForAllConstMembersEv")
  //</editor-fold>
  public boolean shouldDeleteForAllConstMembers() {
    // This is a silly definition, because it gives an empty union a deleted
    // default constructor. Don't do that.
    if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor && inUnion() && AllFieldsAreConst
       && !MD.getParent().field_empty()) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(MD.getParent().getLocation(), 
                          diag.note_deleted_default_ctor_all_const)), 
                      !!(ICI != null)), MD.getParent()), /*not anonymous union*/ 0));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    return false;
  }

  
  
  /// Check whether we should delete a special member function due to having a
  /// direct or virtual base class or non-static data member of class type M.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForClassSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5716,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForClassSubobject", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo29shouldDeleteForClassSubobjectEPN5clang13CXXRecordDeclEN4llvm12PointerUnionIPNS1_16CXXBaseSpecifierEPNS1_9FieldDeclEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo29shouldDeleteForClassSubobjectEPN5clang13CXXRecordDeclEN4llvm12PointerUnionIPNS1_16CXXBaseSpecifierEPNS1_9FieldDeclEEEj")
  //</editor-fold>
  public boolean shouldDeleteForClassSubobject(CXXRecordDecl /*P*/ Class, PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ > Subobj, /*uint*/int Quals) {
    FieldDecl /*P*/ Field = Subobj.dyn_cast(FieldDecl /*P*/ .class);
    boolean IsMutable = (Field != null) && Field.isMutable();
    
    // C++11 [class.ctor]p5:
    // -- any direct or virtual base class, or non-static data member with no
    //    brace-or-equal-initializer, has class type M (or array thereof) and
    //    either M has no default constructor or overload resolution as applied
    //    to M's default constructor results in an ambiguity or in a function
    //    that is deleted or inaccessible
    // C++11 [class.copy]p11, C++11 [class.copy]p23:
    // -- a direct or virtual base class B that cannot be copied/moved because
    //    overload resolution, as applied to B's corresponding special member,
    //    results in an ambiguity or a function that is deleted or inaccessible
    //    from the defaulted special member
    // C++11 [class.dtor]p5:
    // -- any direct or virtual base class [...] has a type with a destructor
    //    that is deleted or inaccessible
    if (!(CSM == Sema.CXXSpecialMember.CXXDefaultConstructor
       && (Field != null) && Field.hasInClassInitializer())
       && shouldDeleteForSubobjectCall(new PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >(Subobj), lookupIn(Class, Quals, IsMutable), 
        false)) {
      return true;
    }
    
    // C++11 [class.ctor]p5, C++11 [class.copy]p11:
    // -- any direct or virtual base class or non-static data member has a
    //    type with a destructor that is deleted or inaccessible
    if (IsConstructor) {
      Sema.SpecialMemberOverloadResult /*P*/ SMOR = S.LookupSpecialMember(Class, Sema.CXXSpecialMember.CXXDestructor, 
          false, false, false, false, false);
      if (shouldDeleteForSubobjectCall(new PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >(Subobj), SMOR, true)) {
        return true;
      }
    }
    
    return false;
  }

  
  /// Check whether we should delete a special member due to the implicit
  /// definition containing a call to a special member of a subobject.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForSubobjectCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5665,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::shouldDeleteForSubobjectCall", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo28shouldDeleteForSubobjectCallEN4llvm12PointerUnionIPN5clang16CXXBaseSpecifierEPNS3_9FieldDeclEEEPNS3_4Sema27SpecialMemberOverloadResultEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo28shouldDeleteForSubobjectCallEN4llvm12PointerUnionIPN5clang16CXXBaseSpecifierEPNS3_9FieldDeclEEEPNS3_4Sema27SpecialMemberOverloadResultEb")
  //</editor-fold>
  public boolean shouldDeleteForSubobjectCall(PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ > Subobj, Sema.SpecialMemberOverloadResult /*P*/ SMOR, 
                              boolean IsDtorCallInCtor) {
    CXXMethodDecl /*P*/ Decl = SMOR.getMethod();
    FieldDecl /*P*/ Field = Subobj.dyn_cast(FieldDecl /*P*/ .class);
    
    int DiagKind = -1;
    if (SMOR.getKind() == Sema.SpecialMemberOverloadResult.Kind.NoMemberOrDeleted) {
      DiagKind = !(Decl != null) ? 0 : 1;
    } else if (SMOR.getKind() == Sema.SpecialMemberOverloadResult.Kind.Ambiguous) {
      DiagKind = 2;
    } else if (!isAccessible(new PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ >(Subobj), Decl)) {
      DiagKind = 3;
    } else if (!IsDtorCallInCtor && (Field != null) && Field.getParent().isUnion()
       && !Decl.isTrivial()) {
      // A member of a union must have a trivial corresponding special member.
      // As a weird special case, a destructor call from a union's constructor
      // must be accessible and non-deleted, but need not be trivial. Such a
      // destructor is never actually called, but is semantically checked as
      // if it were.
      DiagKind = 4;
    }
    if (DiagKind == -1) {
      return false;
    }
    if (Diagnose) {
      if ((Field != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Field.getLocation(), 
                                      diag.note_deleted_special_member_class_subobject)), 
                                  getEffectiveCSM()), MD.getParent()), /*IsField*/ true), 
                      Field), DiagKind), IsDtorCallInCtor));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          CXXBaseSpecifier /*P*/ Base = Subobj.get(CXXBaseSpecifier /*P*/ .class);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Base.getLocStart(), 
                                      diag.note_deleted_special_member_class_subobject)), 
                                  getEffectiveCSM()), MD.getParent()), /*IsField*/ false), 
                      Base.getType()), DiagKind), IsDtorCallInCtor));
        } finally {
          $c$.$destroy();
        }
      }
      if (DiagKind == 1) {
        S.NoteDeletedFunction(Decl);
      }
      // FIXME: Explain inaccessibility if DiagKind == 3.
    }
    
    return true;
  }

  
  
  /// Is the given special member inaccessible when used on the given
  /// sub-object.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SpecialMemberDeletionInfo::isAccessible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5645,
   FQN="(anonymous namespace)::SpecialMemberDeletionInfo::isAccessible", NM="_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo12isAccessibleEN4llvm12PointerUnionIPN5clang16CXXBaseSpecifierEPNS3_9FieldDeclEEEPNS3_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_125SpecialMemberDeletionInfo12isAccessibleEN4llvm12PointerUnionIPN5clang16CXXBaseSpecifierEPNS3_9FieldDeclEEEPNS3_13CXXMethodDeclE")
  //</editor-fold>
  public boolean isAccessible(PointerUnion<CXXBaseSpecifier /*P*/ , FieldDecl /*P*/ > Subobj, 
              CXXMethodDecl /*P*/ target) {
    /// If we're operating on a base class, the object type is the
    /// type of this special member.
    QualType objectTy/*J*/= new QualType();
    AccessSpecifier access = target.getAccess();
    {
      CXXBaseSpecifier /*P*/ base = Subobj.dyn_cast(CXXBaseSpecifier /*P*/ .class);
      if ((base != null)) {
        objectTy.$assignMove(S.Context.getTypeDeclType(MD.getParent()));
        access = CXXRecordDecl.MergeAccess(base.getAccessSpecifier(), access);
        // If we're operating on a field, the object type is the type of the field.
      } else {
        objectTy.$assignMove(S.Context.getTypeDeclType(target.getParent()));
      }
    }
    
    return S.isSpecialMemberAccessibleForDeletion(target, access, new QualType(objectTy));
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", MD=" + MD // NOI18N
              + ", CSM=" + CSM // NOI18N
              + ", ICI=" + ICI // NOI18N
              + ", Diagnose=" + Diagnose // NOI18N
              + ", IsConstructor=" + IsConstructor // NOI18N
              + ", IsAssignment=" + IsAssignment // NOI18N
              + ", IsMove=" + IsMove // NOI18N
              + ", ConstArg=" + ConstArg // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", AllFieldsAreConst=" + AllFieldsAreConst; // NOI18N
  }
}
