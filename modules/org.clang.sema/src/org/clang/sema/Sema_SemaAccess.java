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
package org.clang.sema;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaAccessStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaAccess">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_Sema ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema17CheckFriendAccessEPNS_9NamedDeclE;_ZN5clang4Sema17CheckLookupAccessERKNS_12LookupResultE;_ZN5clang4Sema17CheckMemberAccessENS_14SourceLocationEPNS_13CXXRecordDeclENS_14DeclAccessPairE;_ZN5clang4Sema18IsSimplyAccessibleEPNS_9NamedDeclEPNS_11DeclContextE;_ZN5clang4Sema20CheckBaseClassAccessENS_14SourceLocationENS_8QualTypeES2_RKNS_11CXXBasePathEjbb;_ZN5clang4Sema21CheckAllocationAccessENS_14SourceLocationENS_11SourceRangeEPNS_13CXXRecordDeclENS_14DeclAccessPairEb;_ZN5clang4Sema21CheckDestructorAccessENS_14SourceLocationEPNS_17CXXDestructorDeclERKNS_17PartialDiagnosticENS_8QualTypeE;_ZN5clang4Sema22CheckConstructorAccessENS_14SourceLocationEPNS_18CXXConstructorDeclENS_14DeclAccessPairERKNS_17InitializedEntityERKNS_17PartialDiagnosticE;_ZN5clang4Sema22CheckConstructorAccessENS_14SourceLocationEPNS_18CXXConstructorDeclENS_14DeclAccessPairERKNS_17InitializedEntityEb;_ZN5clang4Sema24HandleDelayedAccessCheckERNS_4sema17DelayedDiagnosticEPNS_4DeclE;_ZN5clang4Sema24SetMemberAccessSpecifierEPNS_9NamedDeclES2_NS_15AccessSpecifierE;_ZN5clang4Sema25CheckMemberOperatorAccessENS_14SourceLocationEPNS_4ExprES3_NS_14DeclAccessPairE;_ZN5clang4Sema26CheckAddressOfMemberAccessEPNS_4ExprENS_14DeclAccessPairE;_ZN5clang4Sema26HandleDependentAccessCheckERKNS_19DependentDiagnosticERKNS_30MultiLevelTemplateArgumentListE;_ZN5clang4Sema27CheckUnresolvedLookupAccessEPNS_20UnresolvedLookupExprENS_14DeclAccessPairE;_ZN5clang4Sema27CheckUnresolvedMemberAccessEPNS_20UnresolvedMemberExprENS_14DeclAccessPairE;_ZN5clang4Sema36isSpecialMemberAccessibleForDeletionEPNS_13CXXMethodDeclENS_15AccessSpecifierENS_8QualTypeE; -static-type=Sema_SemaAccess -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaAccess extends Sema_Sema {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// SetMemberAccessSpecifier - Set the access specifier of a member.
/// Returns true on error (when the previous member decl access specifier
/// is different from the new member decl access specifier).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetMemberAccessSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 39,
 FQN="clang::Sema::SetMemberAccessSpecifier", NM="_ZN5clang4Sema24SetMemberAccessSpecifierEPNS_9NamedDeclES2_NS_15AccessSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema24SetMemberAccessSpecifierEPNS_9NamedDeclES2_NS_15AccessSpecifierE")
//</editor-fold>
public final boolean SetMemberAccessSpecifier(NamedDecl /*P*/ MemberDecl, 
                        NamedDecl /*P*/ PrevMemberDecl, 
                        AccessSpecifier LexicalAS) {
  if (!(PrevMemberDecl != null)) {
    // Use the lexical access specifier.
    MemberDecl.setAccess(LexicalAS);
    return false;
  }
  
  // C++ [class.access.spec]p3: When a member is redeclared its access
  // specifier must be same as its initial declaration.
  if (LexicalAS != AccessSpecifier.AS_none && LexicalAS != PrevMemberDecl.getAccess()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemberDecl.getLocation(), 
                  diag.err_class_redeclared_with_different_access)), 
              MemberDecl), LexicalAS));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevMemberDecl.getLocation(), diag.note_previous_access_declaration)), 
              PrevMemberDecl), PrevMemberDecl.getAccess()));
      
      MemberDecl.setAccess(LexicalAS);
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  MemberDecl.setAccess(PrevMemberDecl.getAccess());
  return false;
}


/// Perform access-control checking on a previously-unresolved member
/// access which has now been resolved to a member.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUnresolvedMemberAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1547,
 FQN="clang::Sema::CheckUnresolvedMemberAccess", NM="_ZN5clang4Sema27CheckUnresolvedMemberAccessEPNS_20UnresolvedMemberExprENS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema27CheckUnresolvedMemberAccessEPNS_20UnresolvedMemberExprENS_14DeclAccessPairE")
//</editor-fold>
public final Sema.AccessResult CheckUnresolvedMemberAccess(UnresolvedMemberExpr /*P*/ E, 
                           DeclAccessPair Found) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    QualType BaseType = E.getBaseType();
    if (E.isArrow()) {
      BaseType.$assignMove(BaseType.$arrow().getAs(PointerType.class).getPointeeType());
    }
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, E.getNamingClass(), 
        new DeclAccessPair(Found), new QualType(BaseType));
    $out_PartialDiagnostic$C_SourceRange(Entity.setDiag(diag.err_access), E.getSourceRange());
    
    return CheckAccess(/*Deref*/$this(), E.getMemberLoc(), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUnresolvedLookupAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1531,
 FQN="clang::Sema::CheckUnresolvedLookupAccess", NM="_ZN5clang4Sema27CheckUnresolvedLookupAccessEPNS_20UnresolvedLookupExprENS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema27CheckUnresolvedLookupAccessEPNS_20UnresolvedLookupExprENS_14DeclAccessPairE")
//</editor-fold>
public final Sema.AccessResult CheckUnresolvedLookupAccess(UnresolvedLookupExpr /*P*/ E, 
                           DeclAccessPair Found) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || !(E.getNamingClass() != null)
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, E.getNamingClass(), 
        new DeclAccessPair(Found), new QualType());
    $out_PartialDiagnostic$C_SourceRange(Entity.setDiag(diag.err_access), E.getSourceRange());
    
    return CheckAccess(/*Deref*/$this(), E.getNameLoc(), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}


/// Checks access to an overloaded operator new or delete.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAllocationAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1696,
 FQN="clang::Sema::CheckAllocationAccess", NM="_ZN5clang4Sema21CheckAllocationAccessENS_14SourceLocationENS_11SourceRangeEPNS_13CXXRecordDeclENS_14DeclAccessPairEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema21CheckAllocationAccessENS_14SourceLocationENS_11SourceRangeEPNS_13CXXRecordDeclENS_14DeclAccessPairEb")
//</editor-fold>
public final Sema.AccessResult CheckAllocationAccess(SourceLocation OpLoc, 
                     SourceRange PlacementRange, 
                     CXXRecordDecl /*P*/ NamingClass, 
                     DeclAccessPair Found) {
  return CheckAllocationAccess(OpLoc, 
                     PlacementRange, 
                     NamingClass, 
                     Found, 
                     true);
}
public final Sema.AccessResult CheckAllocationAccess(SourceLocation OpLoc, 
                     SourceRange PlacementRange, 
                     CXXRecordDecl /*P*/ NamingClass, 
                     DeclAccessPair Found, 
                     boolean Diagnose/*= true*/) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || !(NamingClass != null)
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, NamingClass, new DeclAccessPair(Found), 
        new QualType());
    if (Diagnose) {
      $out_PartialDiagnostic$C_SourceRange(Entity.setDiag(diag.err_access), 
          /*NO_COPY*/PlacementRange);
    }
    
    return CheckAccess(/*Deref*/$this(), new SourceLocation(OpLoc), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}


/// Checks access to a constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstructorAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1611,
 FQN="clang::Sema::CheckConstructorAccess", NM="_ZN5clang4Sema22CheckConstructorAccessENS_14SourceLocationEPNS_18CXXConstructorDeclENS_14DeclAccessPairERKNS_17InitializedEntityEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema22CheckConstructorAccessENS_14SourceLocationEPNS_18CXXConstructorDeclENS_14DeclAccessPairERKNS_17InitializedEntityEb")
//</editor-fold>
public final Sema.AccessResult CheckConstructorAccess(SourceLocation UseLoc, 
                      CXXConstructorDecl /*P*/ Constructor, 
                      DeclAccessPair Found, 
                      final /*const*/ InitializedEntity /*&*/ Entity) {
  return CheckConstructorAccess(UseLoc, 
                      Constructor, 
                      Found, 
                      Entity, 
                      false);
}
public final Sema.AccessResult CheckConstructorAccess(SourceLocation UseLoc, 
                      CXXConstructorDecl /*P*/ Constructor, 
                      DeclAccessPair Found, 
                      final /*const*/ InitializedEntity /*&*/ Entity, 
                      boolean IsCopyBindingRefToTemp/*= false*/) {
  PartialDiagnostic PD = null;
  try {
    if (!$this().getLangOpts().AccessControl || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    PD/*J*/= $this().PDiag();
    switch (Entity.getKind()) {
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(PD.$assignMove($c$.track($this().PDiag(IsCopyBindingRefToTemp ? diag.ext_rvalue_to_reference_access_ctor : diag.err_access_ctor))));
          
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case EK_Base:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(PD.$assignMove($c$.track($this().PDiag(diag.err_access_base_ctor))));
          $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int(PD, (Entity.isInheritedVirtualBase() ? 1 : 0)), 
                  Entity.getBaseSpecifier().getType()), $this().getSpecialMember(Constructor).getValue());
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case EK_Member:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/ FieldDecl /*P*/ Field = cast_FieldDecl(Entity.getDecl());
          $c$.clean(PD.$assignMove($c$.track($this().PDiag(diag.err_access_field_ctor))));
          $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType(PD, Field.getType()), $this().getSpecialMember(Constructor).getValue());
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case EK_LambdaCapture:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef VarName = Entity.getCapturedVarName();
          $c$.clean(PD.$assignMove($c$.track($this().PDiag(diag.err_access_lambda_capture))));
          $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef(PD, /*NO_COPY*/VarName), Entity.getType()), $this().getSpecialMember(Constructor).getValue());
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return $this().CheckConstructorAccess(new SourceLocation(UseLoc), Constructor, new DeclAccessPair(Found), Entity, PD);
  } finally {
    if (PD != null) { PD.$destroy(); }
  }
}


/// Checks access to a constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstructorAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1654,
 FQN="clang::Sema::CheckConstructorAccess", NM="_ZN5clang4Sema22CheckConstructorAccessENS_14SourceLocationEPNS_18CXXConstructorDeclENS_14DeclAccessPairERKNS_17InitializedEntityERKNS_17PartialDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema22CheckConstructorAccessENS_14SourceLocationEPNS_18CXXConstructorDeclENS_14DeclAccessPairERKNS_17InitializedEntityERKNS_17PartialDiagnosticE")
//</editor-fold>
public final Sema.AccessResult CheckConstructorAccess(SourceLocation UseLoc, 
                      CXXConstructorDecl /*P*/ Constructor, 
                      DeclAccessPair Found, 
                      final /*const*/ InitializedEntity /*&*/ Entity, 
                      final /*const*/ PartialDiagnostic /*&*/ PD) {
  AccessTarget AccessEntity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    CXXRecordDecl /*P*/ NamingClass = Constructor.getParent();
    
    // Initializing a base sub-object is an instance method call on an
    // object of the derived class.  Otherwise, we have an instance method
    // call on an object of the constructed type.
    //
    // FIXME: If we have a parent, we're initializing the base class subobject
    // in aggregate initialization. It's not clear whether the object class
    // should be the base class or the derived class in that case.
    CXXRecordDecl /*P*/ ObjectClass;
    if ((Entity.getKind() == InitializedEntity.EntityKind.EK_Base
       || Entity.getKind() == InitializedEntity.EntityKind.EK_Delegating)
       && !(Entity.getParent() != null)) {
      ObjectClass = cast_CXXConstructorDecl($this().CurContext).getParent();
    } else {
      ConstructorUsingShadowDecl /*P*/ Shadow = dyn_cast_ConstructorUsingShadowDecl(Found.getDecl());
      if ((Shadow != null)) {
        // If we're using an inheriting constructor to construct an object,
        // the object class is the derived class, not the base class.
        ObjectClass = Shadow.getParent();
      } else {
        ObjectClass = NamingClass;
      }
    }
    
    AccessEntity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, NamingClass, 
        DeclAccessPair.make(Constructor, Found.getAccess()), 
        $this().Context.getTypeDeclType(ObjectClass));
    AccessEntity.setDiag(PD);
    
    return CheckAccess(/*Deref*/$this(), new SourceLocation(UseLoc), AccessEntity);
  } finally {
    if (AccessEntity != null) { AccessEntity.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDestructorAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1587,
 FQN="clang::Sema::CheckDestructorAccess", NM="_ZN5clang4Sema21CheckDestructorAccessENS_14SourceLocationEPNS_17CXXDestructorDeclERKNS_17PartialDiagnosticENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema21CheckDestructorAccessENS_14SourceLocationEPNS_17CXXDestructorDeclERKNS_17PartialDiagnosticENS_8QualTypeE")
//</editor-fold>
public final Sema.AccessResult CheckDestructorAccess(SourceLocation Loc, 
                     CXXDestructorDecl /*P*/ Dtor, 
                     final /*const*/ PartialDiagnostic /*&*/ PDiag) {
  return CheckDestructorAccess(Loc, 
                     Dtor, 
                     PDiag, 
                     new QualType());
}
public final Sema.AccessResult CheckDestructorAccess(SourceLocation Loc, 
                     CXXDestructorDecl /*P*/ Dtor, 
                     final /*const*/ PartialDiagnostic /*&*/ PDiag, 
                     QualType ObjectTy/*= QualType()*/) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl) {
      return AccessResult.AR_accessible;
    }
    
    // There's never a path involved when checking implicit destructor access.
    AccessSpecifier Access = Dtor.getAccess();
    if (Access == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    CXXRecordDecl /*P*/ NamingClass = Dtor.getParent();
    if (ObjectTy.isNull()) {
      ObjectTy.$assignMove($this().Context.getTypeDeclType(NamingClass));
    }
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, NamingClass, 
        DeclAccessPair.make(Dtor, Access), 
        new QualType(ObjectTy));
    Entity.setDiag(PDiag); // TODO: avoid copy
    
    return CheckAccess(/*Deref*/$this(), new SourceLocation(Loc), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}


/// Checks access to the target of a friend declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFriendAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1753,
 FQN="clang::Sema::CheckFriendAccess", NM="_ZN5clang4Sema17CheckFriendAccessEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema17CheckFriendAccessEPNS_9NamedDeclE")
//</editor-fold>
public final Sema.AccessResult CheckFriendAccess(NamedDecl /*P*/ target) {
  AccessTarget entity = null;
  EffectiveContext EC = null;
  try {
    assert (isa_CXXMethodDecl(target.getAsFunction()));
    
    // Friendship lookup is a redeclaration lookup, so there's never an
    // inheritance path modifying access.
    AccessSpecifier access = target.getAccess();
    if (!$this().getLangOpts().AccessControl || access == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    CXXMethodDecl /*P*/ method = cast_CXXMethodDecl(target.getAsFunction());
    
    entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, 
        cast_CXXRecordDecl(target.getDeclContext()), 
        DeclAccessPair.make(target, access), 
        /*no instance context*/ new QualType());
    $out_PartialDiagnostic$C_SourceRange(entity.setDiag(diag.err_access_friend_function), 
        ((method.getQualifier() != null) ? method.getQualifierLoc().getSourceRange() : method.getNameInfo().getSourceRange()));
    
    // We need to bypass delayed-diagnostics because we might be called
    // while the ParsingDeclarator is active.
    EC/*J*/= new EffectiveContext($this().CurContext);
    switch (CheckEffectiveAccess(/*Deref*/$this(), EC, target.getLocation(), entity)) {
     case AR_accessible:
      return Sema.AccessResult.AR_accessible;
     case AR_inaccessible:
      return Sema.AccessResult.AR_inaccessible;
     case AR_dependent:
      return Sema.AccessResult.AR_dependent;
    }
    throw new llvm_unreachable("invalid access result");
  } finally {
    if (EC != null) { EC.$destroy(); }
    if (entity != null) { entity.$destroy(); }
  }
}


/// \brief Checks access to a member.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMemberAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1716,
 FQN="clang::Sema::CheckMemberAccess", NM="_ZN5clang4Sema17CheckMemberAccessENS_14SourceLocationEPNS_13CXXRecordDeclENS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema17CheckMemberAccessENS_14SourceLocationEPNS_13CXXRecordDeclENS_14DeclAccessPairE")
//</editor-fold>
public final Sema.AccessResult CheckMemberAccess(SourceLocation UseLoc, 
                 CXXRecordDecl /*P*/ NamingClass, 
                 DeclAccessPair Found) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || !(NamingClass != null)
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, NamingClass, 
        new DeclAccessPair(Found), new QualType());
    
    return CheckAccess(/*Deref*/$this(), new SourceLocation(UseLoc), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}


/// Checks access to an overloaded member operator, including
/// conversion operators.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMemberOperatorAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1732,
 FQN="clang::Sema::CheckMemberOperatorAccess", NM="_ZN5clang4Sema25CheckMemberOperatorAccessENS_14SourceLocationEPNS_4ExprES3_NS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema25CheckMemberOperatorAccessENS_14SourceLocationEPNS_4ExprES3_NS_14DeclAccessPairE")
//</editor-fold>
public final Sema.AccessResult CheckMemberOperatorAccess(SourceLocation OpLoc, 
                         Expr /*P*/ ObjectExpr, 
                         Expr /*P*/ ArgExpr, 
                         DeclAccessPair Found) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    /*const*/ RecordType /*P*/ RT = ObjectExpr.getType().$arrow().castAs$RecordType();
    CXXRecordDecl /*P*/ NamingClass = cast_CXXRecordDecl(RT.getDecl());
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, NamingClass, new DeclAccessPair(Found), 
        ObjectExpr.getType());
    $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange(Entity.setDiag(diag.err_access), 
            ObjectExpr.getSourceRange()), 
        ((ArgExpr != null) ? ArgExpr.getSourceRange() : new SourceRange()));
    
    return CheckAccess(/*Deref*/$this(), new SourceLocation(OpLoc), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAddressOfMemberAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1784,
 FQN="clang::Sema::CheckAddressOfMemberAccess", NM="_ZN5clang4Sema26CheckAddressOfMemberAccessEPNS_4ExprENS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema26CheckAddressOfMemberAccessEPNS_4ExprENS_14DeclAccessPairE")
//</editor-fold>
public final Sema.AccessResult CheckAddressOfMemberAccess(Expr /*P*/ OvlExpr, 
                          DeclAccessPair Found) {
  AccessTarget Entity = null;
  try {
    if (!$this().getLangOpts().AccessControl
       || Found.getAccess() == AccessSpecifier.AS_none
       || Found.getAccess() == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    OverloadExpr /*P*/ Ovl = OverloadExpr.find(OvlExpr).Expression;
    CXXRecordDecl /*P*/ NamingClass = Ovl.getNamingClass();
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, NamingClass, new DeclAccessPair(Found), 
        /*no instance context*/ new QualType());
    $out_PartialDiagnostic$C_SourceRange(Entity.setDiag(diag.err_access), 
        Ovl.getSourceRange());
    
    return CheckAccess(/*Deref*/$this(), Ovl.getNameLoc(), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}


/// Checks access for a hierarchy conversion.
///
/// \param ForceCheck true if this check should be performed even if access
///     control is disabled;  some things rely on this for semantics
/// \param ForceUnprivileged true if this check should proceed as if the
///     context had no special privileges
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBaseClassAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1808,
 FQN="clang::Sema::CheckBaseClassAccess", NM="_ZN5clang4Sema20CheckBaseClassAccessENS_14SourceLocationENS_8QualTypeES2_RKNS_11CXXBasePathEjbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema20CheckBaseClassAccessENS_14SourceLocationENS_8QualTypeES2_RKNS_11CXXBasePathEjbb")
//</editor-fold>
public final Sema.AccessResult CheckBaseClassAccess(SourceLocation AccessLoc, 
                    QualType Base, 
                    QualType Derived, 
                    final /*const*/ CXXBasePath /*&*/ Path, 
                    /*uint*/int DiagID) {
  return CheckBaseClassAccess(AccessLoc, 
                    Base, 
                    Derived, 
                    Path, 
                    DiagID, 
                    false, 
                    false);
}
public final Sema.AccessResult CheckBaseClassAccess(SourceLocation AccessLoc, 
                    QualType Base, 
                    QualType Derived, 
                    final /*const*/ CXXBasePath /*&*/ Path, 
                    /*uint*/int DiagID, 
                    boolean ForceCheck/*= false*/) {
  return CheckBaseClassAccess(AccessLoc, 
                    Base, 
                    Derived, 
                    Path, 
                    DiagID, 
                    ForceCheck, 
                    false);
}
public final Sema.AccessResult CheckBaseClassAccess(SourceLocation AccessLoc, 
                    QualType Base, 
                    QualType Derived, 
                    final /*const*/ CXXBasePath /*&*/ Path, 
                    /*uint*/int DiagID, 
                    boolean ForceCheck/*= false*/, 
                    boolean ForceUnprivileged/*= false*/) {
  AccessTarget Entity = null;
  try {
    if (!ForceCheck && !$this().getLangOpts().AccessControl) {
      return AccessResult.AR_accessible;
    }
    if (Path.Access == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    
    CXXRecordDecl /*P*/ BaseD;
    CXXRecordDecl /*P*/ DerivedD;
    BaseD = cast_CXXRecordDecl(Base.$arrow().getAs$RecordType().getDecl());
    DerivedD = cast_CXXRecordDecl(Derived.$arrow().getAs$RecordType().getDecl());
    
    Entity/*J*/= new AccessTarget($this().Context, AccessTarget.BaseNonce.Base, BaseD, DerivedD, 
        Path.Access);
    if ((DiagID != 0)) {
      $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType(Entity.setDiag(DiagID), /*NO_COPY*/Derived), /*NO_COPY*/Base);
    }
    if (ForceUnprivileged) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        switch (AccessResult.valueOf($c$.clean(CheckEffectiveAccess(/*Deref*/$this(), $c$.track(new EffectiveContext()), 
            new SourceLocation(AccessLoc), Entity).getValue()))) {
         case AR_accessible:
          return Sema.AccessResult.AR_accessible;
         case AR_inaccessible:
          return Sema.AccessResult.AR_inaccessible;
         case AR_dependent:
          return Sema.AccessResult.AR_dependent;
        }
        throw new llvm_unreachable("unexpected result from CheckEffectiveAccess");
      } finally {
        $c$.$destroy();
      }
    }
    return CheckAccess(/*Deref*/$this(), new SourceLocation(AccessLoc), Entity);
  } finally {
    if (Entity != null) { Entity.$destroy(); }
  }
}


/// Checks access to all the declarations in the given result set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckLookupAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1843,
 FQN="clang::Sema::CheckLookupAccess", NM="_ZN5clang4Sema17CheckLookupAccessERKNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema17CheckLookupAccessERKNS_12LookupResultE")
//</editor-fold>
public final void CheckLookupAccess(final /*const*/ LookupResult /*&*/ R) {
  assert ($this().getLangOpts().AccessControl) : "performing access check without access control";
  assert ((R.getNamingClass() != null)) : "performing access check without naming class";
  
  for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
    if (I.getAccess() != AccessSpecifier.AS_public) {
      AccessTarget Entity = null;
      try {
        Entity/*J*/= new AccessTarget($this().Context, AccessedEntity.MemberNonce.Member, 
            R.getNamingClass(), new DeclAccessPair(I.getPair()), 
            R.getBaseObjectType());
        Entity.setDiag(diag.err_access);
        CheckAccess(/*Deref*/$this(), R.getNameLoc(), Entity);
      } finally {
        if (Entity != null) { Entity.$destroy(); }
      }
    }
  }
}


/// Checks access to Decl from the given class. The check will take access
/// specifiers into account, but no member access expressions and such.
///
/// \param Decl the declaration to check if it can be accessed
/// \param Ctx the class/context from which to start the search
/// \return true if the Decl is accessible from the Class, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsSimplyAccessible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1865,
 FQN="clang::Sema::IsSimplyAccessible", NM="_ZN5clang4Sema18IsSimplyAccessibleEPNS_9NamedDeclEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema18IsSimplyAccessibleEPNS_9NamedDeclEPNS_11DeclContextE")
//</editor-fold>
public final boolean IsSimplyAccessible(NamedDecl /*P*/ Decl, DeclContext /*P*/ Ctx) {
  {
    CXXRecordDecl /*P*/ Class = dyn_cast_CXXRecordDecl(Ctx);
    if ((Class != null)) {
      AccessTarget Entity = null;
      EffectiveContext EC = null;
      try {
        if (!Decl.isCXXClassMember()) {
          return true;
        }
        
        QualType qType = Class.getTypeForDecl().getCanonicalTypeInternal();
        Entity/*J*/= new AccessTarget($this().Context, AccessedEntity.MemberNonce.Member, Class, 
            DeclAccessPair.make(Decl, Decl.getAccess()), 
            new QualType(qType));
        if (Entity.getAccess() == AccessSpecifier.AS_public) {
          return true;
        }
        
        EC/*J*/= new EffectiveContext($this().CurContext);
        return /*::*/IsAccessible(/*Deref*/$this(), EC, Entity) != /*::*/org.clang.sema.impl.AccessResult.AR_inaccessible;
      } finally {
        if (EC != null) { EC.$destroy(); }
        if (Entity != null) { Entity.$destroy(); }
      }
    }
  }
  {
    
    ObjCIvarDecl /*P*/ Ivar = dyn_cast_ObjCIvarDecl(Decl);
    if ((Ivar != null)) {
      // @public and @package ivars are always accessible.
      if (Ivar.getCanonicalAccessControl() == ObjCIvarDecl.AccessControl.Public
         || Ivar.getCanonicalAccessControl() == ObjCIvarDecl.AccessControl.Package) {
        return true;
      }
      
      // If we are inside a class or category implementation, determine the
      // interface we're in.
      ObjCInterfaceDecl /*P*/ ClassOfMethodDecl = null;
      {
        ObjCMethodDecl /*P*/ MD = $this().getCurMethodDecl();
        if ((MD != null)) {
          ClassOfMethodDecl = MD.getClassInterface();
        } else {
          FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
          if ((FD != null)) {
            {
              ObjCImplDecl /*P*/ Impl = dyn_cast_ObjCImplDecl(FD.getLexicalDeclContext());
              if ((Impl != null)) {
                {
                  ObjCImplementationDecl /*P*/ IMPD = dyn_cast_ObjCImplementationDecl(Impl);
                  if ((IMPD != null)) {
                    ClassOfMethodDecl = IMPD.getClassInterface();
                  } else {
                    ObjCCategoryImplDecl /*P*/ CatImplClass = dyn_cast_ObjCCategoryImplDecl(Impl);
                    if ((CatImplClass != null)) {
                      ClassOfMethodDecl = CatImplClass.getClassInterface();
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      // If we're not in an interface, this ivar is inaccessible.
      if (!(ClassOfMethodDecl != null)) {
        return false;
      }
      
      // If we're inside the same interface that owns the ivar, we're fine.
      if (declaresSameEntity(ClassOfMethodDecl, Ivar.getContainingInterface())) {
        return true;
      }
      
      // If the ivar is private, it's inaccessible.
      if (Ivar.getCanonicalAccessControl() == ObjCIvarDecl.AccessControl.Private) {
        return false;
      }
      
      return Ivar.getContainingInterface().isSuperClassOf(ClassOfMethodDecl);
    }
  }
  
  return true;
}


/// Is the given special member function accessible for the purposes of
/// deciding whether to define a special member function as deleted?
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isSpecialMemberAccessibleForDeletion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1566,
 FQN="clang::Sema::isSpecialMemberAccessibleForDeletion", NM="_ZN5clang4Sema36isSpecialMemberAccessibleForDeletionEPNS_13CXXMethodDeclENS_15AccessSpecifierENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema36isSpecialMemberAccessibleForDeletionEPNS_13CXXMethodDeclENS_15AccessSpecifierENS_8QualTypeE")
//</editor-fold>
public final boolean isSpecialMemberAccessibleForDeletion(CXXMethodDecl /*P*/ decl, 
                                    AccessSpecifier access, 
                                    QualType objectType) {
  AccessTarget entity = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Fast path.
    if (access == AccessSpecifier.AS_public || !$this().getLangOpts().AccessControl) {
      return true;
    }
    
    entity/*J*/= new AccessTarget($this().Context, AccessTarget.MemberNonce.Member, decl.getParent(), 
        DeclAccessPair.make(decl, access), new QualType(objectType));
    
    // Suppress diagnostics.
    entity.setDiag($c$.track($this().PDiag())); $c$.clean();
    switch (CheckAccess(/*Deref*/$this(), new SourceLocation(), entity)) {
     case AR_accessible:
      return true;
     case AR_inaccessible:
      return false;
     case AR_dependent:
      throw new llvm_unreachable("dependent for =delete computation");
     case AR_delayed:
      throw new llvm_unreachable("cannot delay =delete computation");
    }
    throw new llvm_unreachable("bad access result");
  } finally {
    if (entity != null) { entity.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleDependentAccessCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1491,
 FQN="clang::Sema::HandleDependentAccessCheck", NM="_ZN5clang4Sema26HandleDependentAccessCheckERKNS_19DependentDiagnosticERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema26HandleDependentAccessCheckERKNS_19DependentDiagnosticERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public final void HandleDependentAccessCheck(final /*const*/ DependentDiagnostic /*&*/ DD, 
                          final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  SourceLocation Loc = DD.getAccessLoc();
  AccessSpecifier Access = DD.getAccess();
  
  Decl /*P*/ NamingD = $this().FindInstantiatedDecl(new SourceLocation(Loc), DD.getAccessNamingClass(), 
      TemplateArgs);
  if (!(NamingD != null)) {
    return;
  }
  Decl /*P*/ TargetD = $this().FindInstantiatedDecl(new SourceLocation(Loc), DD.getAccessTarget(), 
      TemplateArgs);
  if (!(TargetD != null)) {
    return;
  }
  if (DD.isAccessToMember()) {
    AccessTarget Entity = null;
    try {
      CXXRecordDecl /*P*/ NamingClass = cast_CXXRecordDecl(NamingD);
      NamedDecl /*P*/ TargetDecl = cast_NamedDecl(TargetD);
      QualType BaseObjectType = DD.getAccessBaseObjectType();
      if (!BaseObjectType.isNull()) {
        BaseObjectType.$assignMove($this().SubstType(new QualType(BaseObjectType), TemplateArgs, new SourceLocation(Loc), 
                new DeclarationName()));
        if (BaseObjectType.isNull()) {
          return;
        }
      }
      
      Entity/*J*/= new AccessTarget($this().Context, 
          AccessTarget.MemberNonce.Member, 
          NamingClass, 
          DeclAccessPair.make(TargetDecl, Access), 
          new QualType(BaseObjectType));
      Entity.setDiag(DD.getDiagnostic());
      CheckAccess(/*Deref*/$this(), new SourceLocation(Loc), Entity);
    } finally {
      if (Entity != null) { Entity.$destroy(); }
    }
  } else {
    AccessTarget Entity = null;
    try {
      Entity/*J*/= new AccessTarget($this().Context, 
          AccessTarget.BaseNonce.Base, 
          cast_CXXRecordDecl(TargetD), 
          cast_CXXRecordDecl(NamingD), 
          Access);
      Entity.setDiag(DD.getDiagnostic());
      CheckAccess(/*Deref*/$this(), new SourceLocation(Loc), Entity);
    } finally {
      if (Entity != null) { Entity.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleDelayedAccessCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1468,
 FQN="clang::Sema::HandleDelayedAccessCheck", NM="_ZN5clang4Sema24HandleDelayedAccessCheckERNS_4sema17DelayedDiagnosticEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4Sema24HandleDelayedAccessCheckERNS_4sema17DelayedDiagnosticEPNS_4DeclE")
//</editor-fold>
public final void HandleDelayedAccessCheck(final DelayedDiagnostic /*&*/ DD, Decl /*P*/ D) {
  EffectiveContext EC = null;
  AccessTarget Target = null;
  try {
    // Access control for names used in the declarations of functions
    // and function templates should normally be evaluated in the context
    // of the declaration, just in case it's a friend of something.
    // However, this does not apply to local extern declarations.
    DeclContext /*P*/ DC = D.getDeclContext();
    if (D.isLocalExternDecl()) {
      DC = D.getLexicalDeclContext();
    } else {
      FunctionDecl /*P*/ FN = dyn_cast_FunctionDecl(D);
      if ((FN != null)) {
        DC = FN;
      } else {
        TemplateDecl /*P*/ TD = dyn_cast_TemplateDecl(D);
        if ((TD != null)) {
          DC = cast_DeclContext(TD.getTemplatedDecl());
        }
      }
    }
    
    EC/*J*/= new EffectiveContext(DC);
    
    Target/*J*/= new AccessTarget(DD.getAccessData());
    if (CheckEffectiveAccess(/*Deref*/$this(), EC, new SourceLocation(DD.Loc), Target) == /*::*/org.clang.sema.impl.AccessResult.AR_inaccessible) {
      DD.Triggered = true;
    }
  } finally {
    if (Target != null) { Target.$destroy(); }
    if (EC != null) { EC.$destroy(); }
  }
}

} // END OF class Sema_SemaAccess
