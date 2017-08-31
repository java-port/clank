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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.sema.impl.SemaTemplateInstantiateDeclStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 371,
 FQN="clang::TemplateDeclInstantiator", NM="_ZN5clang24TemplateDeclInstantiatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiatorE")
//</editor-fold>
public class TemplateDeclInstantiator implements /*public*/ DeclVisitor<TemplateDeclInstantiator, Decl /*P*/ >, Destructors.ClassWithDestructor {
  private final Sema /*&*/ SemaRef;
  private Sema.ArgumentPackSubstitutionIndexRAII SubstIndex;
  private DeclContext /*P*/ Owner;
  private final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs;
  private SmallVector<LateInstantiatedAttribute> /*P*/ LateAttrs;
  private LocalInstantiationScope /*P*/ StartingScope;
  
  /// \brief A list of out-of-line class template partial
  /// specializations that will need to be instantiated after the
  /// enclosing class's instantiation is complete.
  private SmallVector<std.pair<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ >> OutOfLinePartialSpecs;
  
  /// \brief A list of out-of-line variable template partial
  /// specializations that will need to be instantiated after the
  /// enclosing variable's instantiation is complete.
  /// FIXME: Verify that this is needed.
  private SmallVector<std.pair<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ >> OutOfLineVarPartialSpecs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::TemplateDeclInstantiator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 397,
   FQN="clang::TemplateDeclInstantiator::TemplateDeclInstantiator", NM="_ZN5clang24TemplateDeclInstantiatorC1ERNS_4SemaEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiatorC1ERNS_4SemaEPNS_11DeclContextERKNS_30MultiLevelTemplateArgumentListE")
  //</editor-fold>
  public TemplateDeclInstantiator(final Sema /*&*/ SemaRef, DeclContext /*P*/ Owner, 
      final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
    // : DeclVisitor<TemplateDeclInstantiator, Decl * >(), SemaRef(SemaRef), SubstIndex(SemaRef, SemaRef.ArgumentPackSubstitutionIndex), Owner(Owner), TemplateArgs(TemplateArgs), LateAttrs(null), StartingScope(null), OutOfLinePartialSpecs(), OutOfLineVarPartialSpecs() 
    //START JInit
    $DeclVisitor();
    this./*&*/SemaRef=/*&*/SemaRef;
    this.SubstIndex = new Sema.ArgumentPackSubstitutionIndexRAII(SemaRef, SemaRef.ArgumentPackSubstitutionIndex);
    this.Owner = Owner;
    this./*&*/TemplateArgs=/*&*/TemplateArgs;
    this.LateAttrs = null;
    this.StartingScope = null;
    this.OutOfLinePartialSpecs = new SmallVector<std.pair<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ >>(4, new std.pairPtrPtr<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ >());
    this.OutOfLineVarPartialSpecs = new SmallVector<std.pair<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ >>(4, new std.pairPtrPtr<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ >());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitAccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 654,
   FQN="clang::TemplateDeclInstantiator::VisitAccessSpecDecl", NM="_ZN5clang24TemplateDeclInstantiator19VisitAccessSpecDeclEPNS_14AccessSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator19VisitAccessSpecDeclEPNS_14AccessSpecDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitAccessSpecDecl(AccessSpecDecl /*P*/ D) {
    AccessSpecDecl /*P*/ AD = AccessSpecDecl.Create(SemaRef.Context, D.getAccess(), Owner, 
        D.getAccessSpecifierLoc(), D.getColonLoc());
    Owner.addHiddenDecl(AD);
    return AD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2515,
   FQN="clang::TemplateDeclInstantiator::VisitClassScopeFunctionSpecializationDecl", NM="_ZN5clang24TemplateDeclInstantiator41VisitClassScopeFunctionSpecializationDeclEPNS_36ClassScopeFunctionSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator41VisitClassScopeFunctionSpecializationDeclEPNS_36ClassScopeFunctionSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitClassScopeFunctionSpecializationDecl(ClassScopeFunctionSpecializationDecl /*P*/ Decl) {
    LookupResult Previous = null;
    TemplateArgumentListInfo TemplateArgs = null;
    try {
      CXXMethodDecl /*P*/ OldFD = Decl.getSpecialization();
      CXXMethodDecl /*P*/ NewFD = cast_or_null_CXXMethodDecl(VisitCXXMethodDecl(OldFD, (TemplateParameterList /*P*/ )null, true));
      if (!(NewFD != null)) {
        return null;
      }
      
      Previous/*J*/= new LookupResult(SemaRef, NewFD.getNameInfo(), Sema.LookupNameKind.LookupOrdinaryName, 
          Sema.RedeclarationKind.ForRedeclaration);
      
      TemplateArgs/*J*/= new TemplateArgumentListInfo();
      TemplateArgumentListInfo /*P*/ TemplateArgsPtr = null;
      if (Decl.hasExplicitTemplateArgs()) {
        TemplateArgs.$assign(Decl.templateArgs());
        TemplateArgsPtr = $AddrOf(TemplateArgs);
      }
      
      SemaRef.LookupQualifiedName(Previous, SemaRef.CurContext);
      if (SemaRef.CheckFunctionTemplateSpecialization(NewFD, TemplateArgsPtr, 
          Previous)) {
        NewFD.setInvalidDecl();
        return NewFD;
      }
      
      // Associate the specialization with the pattern.
      FunctionDecl /*P*/ Specialization = cast_FunctionDecl(Previous.getFoundDecl());
      assert ((Specialization != null)) : "Class scope Specialization is null";
      SemaRef.Context.setClassScopeSpecializationPattern(Specialization, OldFD);
      
      return NewFD;
    } finally {
      if (TemplateArgs != null) { TemplateArgs.$destroy(); }
      if (Previous != null) { Previous.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitExternCContextDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 437,
   FQN="clang::TemplateDeclInstantiator::VisitExternCContextDecl", NM="_ZN5clang24TemplateDeclInstantiator23VisitExternCContextDeclEPNS_18ExternCContextDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator23VisitExternCContextDeclEPNS_18ExternCContextDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitExternCContextDecl(ExternCContextDecl /*P*/ D) {
    throw new llvm_unreachable("extern \"C\" context cannot be instantiated");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 817,
   FQN="clang::TemplateDeclInstantiator::VisitFriendDecl", NM="_ZN5clang24TemplateDeclInstantiator15VisitFriendDeclEPNS_10FriendDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator15VisitFriendDeclEPNS_10FriendDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFriendDecl(FriendDecl /*P*/ D) {
    {
      // Handle friend type expressions by simply substituting template
      // parameters into the pattern type and checking the result.
      TypeSourceInfo /*P*/ Ty = D.getFriendType();
      if ((Ty != null)) {
        TypeSourceInfo /*P*/ InstTy;
        // If this is an unsupported friend, don't bother substituting template
        // arguments into it. The actual type referred to won't be used by any
        // parts of Clang, and may not be valid for instantiating. Just use the
        // same info for the instantiated friend.
        if (D.isUnsupportedFriend()) {
          InstTy = Ty;
        } else {
          InstTy = SemaRef.SubstType(Ty, TemplateArgs, 
              D.getLocation(), new DeclarationName());
        }
        if (!(InstTy != null)) {
          return null;
        }
        
        FriendDecl /*P*/ FD = SemaRef.CheckFriendTypeDecl(D.getLocStart(), 
            D.getFriendLoc(), InstTy);
        if (!(FD != null)) {
          return null;
        }
        
        FD.setAccess(AccessSpecifier.AS_public);
        FD.setUnsupportedFriend(D.isUnsupportedFriend());
        Owner.addDecl(FD);
        return FD;
      }
    }
    
    NamedDecl /*P*/ ND = D.getFriendDecl();
    assert ((ND != null)) : "friend decl must be a decl or a type!";
    
    // All of the Visit implementations for the various potential friend
    // declarations have to be carefully written to work for friend
    // objects, with the most important detail being that the target
    // decl should almost certainly not be placed in Owner.
    Decl /*P*/ NewND = Visit(ND);
    if (!(NewND != null)) {
      return null;
    }
    
    FriendDecl /*P*/ FD = FriendDecl.Create(SemaRef.Context, Owner, D.getLocation(), 
        new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T.INSTANCE, NamedDecl /*P*/ .class, cast_NamedDecl(NewND)), D.getFriendLoc());
    FD.setAccess(AccessSpecifier.AS_public);
    FD.setUnsupportedFriend(D.isUnsupportedFriend());
    Owner.addDecl(FD);
    return FD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitFriendTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2876,
   FQN="clang::TemplateDeclInstantiator::VisitFriendTemplateDecl", NM="_ZN5clang24TemplateDeclInstantiator23VisitFriendTemplateDeclEPNS_18FriendTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator23VisitFriendTemplateDeclEPNS_18FriendTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFriendTemplateDecl(FriendTemplateDecl /*P*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: We need to be able to instantiate FriendTemplateDecls.
      /*uint*/int DiagID = SemaRef.getDiagnostics().getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot instantiate %0 yet");
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), DiagID)), 
          D.getDeclKindName()));
      
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitLabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 442,
   FQN="clang::TemplateDeclInstantiator::VisitLabelDecl", NM="_ZN5clang24TemplateDeclInstantiator14VisitLabelDeclEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator14VisitLabelDeclEPNS_9LabelDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitLabelDecl(LabelDecl /*P*/ D) {
    LabelDecl /*P*/ Inst = LabelDecl.Create(SemaRef.Context, Owner, D.getLocation(), 
        D.getIdentifier());
    Owner.addDecl(Inst);
    return Inst;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 450,
   FQN="clang::TemplateDeclInstantiator::VisitNamespaceDecl", NM="_ZN5clang24TemplateDeclInstantiator18VisitNamespaceDeclEPNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator18VisitNamespaceDeclEPNS_13NamespaceDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitNamespaceDecl(NamespaceDecl /*P*/ D) {
    throw new llvm_unreachable("Namespaces cannot be instantiated");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitNamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 455,
   FQN="clang::TemplateDeclInstantiator::VisitNamespaceAliasDecl", NM="_ZN5clang24TemplateDeclInstantiator23VisitNamespaceAliasDeclEPNS_18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator23VisitNamespaceAliasDeclEPNS_18NamespaceAliasDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitNamespaceAliasDecl(NamespaceAliasDecl /*P*/ D) {
    NamespaceAliasDecl /*P*/ Inst = NamespaceAliasDecl.Create(SemaRef.Context, Owner, 
        D.getNamespaceLoc(), 
        D.getAliasLoc(), 
        D.getIdentifier(), 
        D.getQualifierLoc(), 
        D.getTargetNameLoc(), 
        D.getNamespace());
    Owner.addDecl(Inst);
    return Inst;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitBuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1030,
   FQN="clang::TemplateDeclInstantiator::VisitBuiltinTemplateDecl", NM="_ZN5clang24TemplateDeclInstantiator24VisitBuiltinTemplateDeclEPNS_19BuiltinTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator24VisitBuiltinTemplateDeclEPNS_19BuiltinTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitBuiltinTemplateDecl(BuiltinTemplateDecl /*P*/ D) {
    throw new llvm_unreachable("BuiltinTemplateDecls cannot be instantiated.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1035,
   FQN="clang::TemplateDeclInstantiator::VisitClassTemplateDecl", NM="_ZN5clang24TemplateDeclInstantiator22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitClassTemplateDecl(ClassTemplateDecl /*P*/ D) {
    LocalInstantiationScope Scope = null;
    try {
      boolean isFriend = (D.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
      
      // Create a local instantiation scope for this class template, which
      // will contain the instantiations of the template parameters.
      Scope/*J*/= new LocalInstantiationScope(SemaRef);
      TemplateParameterList /*P*/ TempParams = D.getTemplateParameters();
      TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
      if (!(InstParams != null)) {
        return null;
      }
      
      CXXRecordDecl /*P*/ Pattern = D.getTemplatedDecl();
      
      // Instantiate the qualifier.  We have to do this first in case
      // we're a friend declaration, because if we are then we need to put
      // the new declaration in the appropriate context.
      NestedNameSpecifierLoc QualifierLoc = Pattern.getQualifierLoc();
      if (QualifierLoc.$bool()) {
        QualifierLoc.$assignMove(SemaRef.SubstNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc), 
                TemplateArgs));
        if (!QualifierLoc.$bool()) {
          return null;
        }
      }
      
      CXXRecordDecl /*P*/ PrevDecl = null;
      ClassTemplateDecl /*P*/ PrevClassTemplate = null;
      if (!isFriend && (getPreviousDeclForInstantiation(Pattern) != null)) {
        DeclContextLookupResult Found = Owner.lookup(Pattern.getDeclName());
        if (!Found.empty()) {
          PrevClassTemplate = dyn_cast_ClassTemplateDecl(Found.front());
          if ((PrevClassTemplate != null)) {
            PrevDecl = PrevClassTemplate.getTemplatedDecl();
          }
        }
      }
      
      // If this isn't a friend, then it's a member template, in which
      // case we just want to build the instantiation in the
      // specialization.  If it is a friend, we want to build it in
      // the appropriate context.
      DeclContext /*P*/ DC = Owner;
      if (isFriend) {
        LookupResult R = null;
        try {
          if (QualifierLoc.$bool()) {
            CXXScopeSpec SS = null;
            try {
              SS/*J*/= new CXXScopeSpec();
              SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
              DC = SemaRef.computeDeclContext(SS);
              if (!(DC != null)) {
                return null;
              }
            } finally {
              if (SS != null) { SS.$destroy(); }
            }
          } else {
            DC = SemaRef.FindInstantiatedContext(Pattern.getLocation(), 
                Pattern.getDeclContext(), 
                TemplateArgs);
          }
          
          // Look for a previous declaration of the template in the owning
          // context.
          R/*J*/= new LookupResult(SemaRef, Pattern.getDeclName(), Pattern.getLocation(), 
              Sema.LookupNameKind.LookupOrdinaryName, Sema.RedeclarationKind.ForRedeclaration);
          SemaRef.LookupQualifiedName(R, DC);
          if (R.isSingleResult()) {
            PrevClassTemplate = R.<ClassTemplateDecl>getAsSingle(ClassTemplateDecl.class);
            if ((PrevClassTemplate != null)) {
              PrevDecl = PrevClassTemplate.getTemplatedDecl();
            }
          }
          if (!(PrevClassTemplate != null) && QualifierLoc.$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Pattern.getLocation(), diag.err_not_tag_in_scope)), 
                              D.getTemplatedDecl().getTagKind()), Pattern.getDeclName()), DC), 
                  QualifierLoc.getSourceRange()));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          
          boolean AdoptedPreviousTemplateParams = false;
          if ((PrevClassTemplate != null)) {
            boolean Complain = true;
            
            // HACK: libstdc++ 4.2.1 contains an ill-formed friend class
            // template for struct std::tr1::__detail::_Map_base, where the
            // template parameters of the friend declaration don't match the
            // template parameters of the original declaration. In this one
            // case, we don't complain about the ill-formed friend
            // declaration.
            if (isFriend && (Pattern.getIdentifier() != null)
               && Pattern.getIdentifier().isStr(/*KEEP_STR*/"_Map_base")
               && DC.isNamespace()
               && (cast_NamespaceDecl(DC).getIdentifier() != null)
               && cast_NamespaceDecl(DC).getIdentifier().isStr(/*KEEP_STR*/"__detail")) {
              DeclContext /*P*/ DCParent = DC.getParent();
              if (DCParent.isNamespace()
                 && (cast_NamespaceDecl(DCParent).getIdentifier() != null)
                 && cast_NamespaceDecl(DCParent).getIdentifier().isStr(/*KEEP_STR*/"tr1")) {
                if (cast_Decl(DCParent).isInStdNamespace()) {
                  Complain = false;
                }
              }
            }
            
            TemplateParameterList /*P*/ PrevParams = PrevClassTemplate.getTemplateParameters();
            
            // Make sure the parameter lists match.
            if (!SemaRef.TemplateParameterListsAreEqual(InstParams, PrevParams, 
                Complain, 
                Sema.TemplateParameterListEqualKind.TPL_TemplateMatch)) {
              if (Complain) {
                return null;
              }
              
              AdoptedPreviousTemplateParams = true;
              InstParams = PrevParams;
            }
            
            // Do some additional validation, then merge default arguments
            // from the existing declarations.
            if (!AdoptedPreviousTemplateParams
               && SemaRef.CheckTemplateParameterList(InstParams, PrevParams, 
                Sema.TemplateParamListContext.TPC_ClassTemplate)) {
              return null;
            }
          }
        } finally {
          if (R != null) { R.$destroy(); }
        }
      }
      
      CXXRecordDecl /*P*/ RecordInst = CXXRecordDecl.Create(SemaRef.Context, Pattern.getTagKind(), DC, 
          Pattern.getLocStart(), Pattern.getLocation(), 
          Pattern.getIdentifier(), PrevDecl, 
          /*DelayTypeCreation=*/ true);
      if (QualifierLoc.$bool()) {
        RecordInst.setQualifierInfo(new NestedNameSpecifierLoc(QualifierLoc));
      }
      
      ClassTemplateDecl /*P*/ Inst = ClassTemplateDecl.Create(SemaRef.Context, DC, D.getLocation(), 
          new DeclarationName(D.getIdentifier()), InstParams, RecordInst, 
          PrevClassTemplate);
      RecordInst.setDescribedClassTemplate(Inst);
      if (isFriend) {
        if ((PrevClassTemplate != null)) {
          Inst.setAccess(PrevClassTemplate.getAccess());
        } else {
          Inst.setAccess(D.getAccess());
        }
        
        Inst.setObjectOfFriendDecl();
        // TODO: do we want to track the instantiation progeny of this
        // friend target decl?
      } else {
        Inst.setAccess(D.getAccess());
        if (!(PrevClassTemplate != null)) {
          Inst.setInstantiatedFromMemberTemplate(D);
        }
      }
      
      // Trigger creation of the type for the instantiation.
      SemaRef.Context.getInjectedClassNameType(RecordInst, 
          Inst.getInjectedClassNameSpecialization());
      
      // Finish handling of friends.
      if (isFriend) {
        DC.makeDeclVisibleInContext(Inst);
        Inst.setLexicalDeclContext(Owner);
        RecordInst.setLexicalDeclContext(Owner);
        return Inst;
      }
      if (D.isOutOfLine()) {
        Inst.setLexicalDeclContext(D.getLexicalDeclContext());
        RecordInst.setLexicalDeclContext(D.getLexicalDeclContext());
      }
      
      Owner.addDecl(Inst);
      if (!(PrevClassTemplate != null)) {
        // Queue up any out-of-line partial specializations of this member
        // class template; the client will force their instantiation once
        // the enclosing class has been instantiated.
        SmallVector<ClassTemplatePartialSpecializationDecl /*P*/ > PartialSpecs/*J*/= new SmallVector<ClassTemplatePartialSpecializationDecl /*P*/ >(4, (ClassTemplatePartialSpecializationDecl /*P*/ )null);
        D.getPartialSpecializations(PartialSpecs);
        for (/*uint*/int I = 0, N = PartialSpecs.size(); I != N; ++I)  {
          if (PartialSpecs.$at(I).getFirstDecl().isOutOfLine()) {
            OutOfLinePartialSpecs.push_back(std.make_pair_Ptr_Ptr(Inst, PartialSpecs.$at(I)));
          }
        }
      }
      
      return Inst;
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1322,
   FQN="clang::TemplateDeclInstantiator::VisitFunctionTemplateDecl", NM="_ZN5clang24TemplateDeclInstantiator25VisitFunctionTemplateDeclEPNS_20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator25VisitFunctionTemplateDeclEPNS_20FunctionTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFunctionTemplateDecl(FunctionTemplateDecl /*P*/ D) {
    LocalInstantiationScope Scope = null;
    try {
      // Create a local instantiation scope for this function template, which
      // will contain the instantiations of the template parameters and then get
      // merged with the local instantiation scope for the function template
      // itself.
      Scope/*J*/= new LocalInstantiationScope(SemaRef);
      
      TemplateParameterList /*P*/ TempParams = D.getTemplateParameters();
      TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
      if (!(InstParams != null)) {
        return null;
      }
      
      FunctionDecl /*P*/ Instantiated = null;
      {
        CXXMethodDecl /*P*/ DMethod = dyn_cast_CXXMethodDecl(D.getTemplatedDecl());
        if ((DMethod != null)) {
          Instantiated = cast_or_null_FunctionDecl(VisitCXXMethodDecl(DMethod, 
    InstParams));
        } else {
          Instantiated = cast_or_null_FunctionDecl(VisitFunctionDecl(D.getTemplatedDecl(), 
    InstParams));
        }
      }
      if (!(Instantiated != null)) {
        return null;
      }
      
      // Link the instantiated function template declaration to the function
      // template from which it was instantiated.
      FunctionTemplateDecl /*P*/ InstTemplate = Instantiated.getDescribedFunctionTemplate();
      InstTemplate.setAccess(D.getAccess());
      assert ((InstTemplate != null)) : "VisitFunctionDecl/CXXMethodDecl didn't create a template!";
      
      boolean isFriend = (InstTemplate.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
      
      // Link the instantiation back to the pattern *unless* this is a
      // non-definition friend declaration.
      if (!(InstTemplate.getInstantiatedFromMemberTemplate() != null)
         && !(isFriend && !D.getTemplatedDecl().isThisDeclarationADefinition())) {
        InstTemplate.setInstantiatedFromMemberTemplate(D);
      }
      
      // Make declarations visible in the appropriate context.
      if (!isFriend) {
        Owner.addDecl(InstTemplate);
      } else if (InstTemplate.getDeclContext().isRecord()
         && !(getPreviousDeclForInstantiation(D) != null)) {
        SemaRef.CheckFriendAccess(InstTemplate);
      }
      
      return InstTemplate;
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitTypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 558,
   FQN="clang::TemplateDeclInstantiator::VisitTypeAliasTemplateDecl", NM="_ZN5clang24TemplateDeclInstantiator26VisitTypeAliasTemplateDeclEPNS_21TypeAliasTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator26VisitTypeAliasTemplateDeclEPNS_21TypeAliasTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTypeAliasTemplateDecl(TypeAliasTemplateDecl /*P*/ D) {
    LocalInstantiationScope Scope = null;
    try {
      // Create a local instantiation scope for this type alias template, which
      // will contain the instantiations of the template parameters.
      Scope/*J*/= new LocalInstantiationScope(SemaRef);
      
      TemplateParameterList /*P*/ TempParams = D.getTemplateParameters();
      TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
      if (!(InstParams != null)) {
        return null;
      }
      
      TypeAliasDecl /*P*/ Pattern = D.getTemplatedDecl();
      
      TypeAliasTemplateDecl /*P*/ PrevAliasTemplate = null;
      if ((SemaTemplateInstantiateDeclStatics.<TypedefNameDecl>getPreviousDeclForInstantiation(Pattern) != null)) {
        DeclContextLookupResult Found = Owner.lookup(Pattern.getDeclName());
        if (!Found.empty()) {
          PrevAliasTemplate = dyn_cast_TypeAliasTemplateDecl(Found.front());
        }
      }
      
      TypeAliasDecl /*P*/ AliasInst = cast_or_null_TypeAliasDecl(InstantiateTypedefNameDecl(Pattern, /*IsTypeAlias=*/ true));
      if (!(AliasInst != null)) {
        return null;
      }
      
      TypeAliasTemplateDecl /*P*/ Inst = TypeAliasTemplateDecl.Create(SemaRef.Context, Owner, D.getLocation(), 
          D.getDeclName(), InstParams, AliasInst);
      AliasInst.setDescribedAliasTemplate(Inst);
      if ((PrevAliasTemplate != null)) {
        Inst.setPreviousDecl(PrevAliasTemplate);
      }
      
      Inst.setAccess(D.getAccess());
      if (!(PrevAliasTemplate != null)) {
        Inst.setInstantiatedFromMemberTemplate(D);
      }
      
      Owner.addDecl(Inst);
      
      return Inst;
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitVarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1241,
   FQN="clang::TemplateDeclInstantiator::VisitVarTemplateDecl", NM="_ZN5clang24TemplateDeclInstantiator20VisitVarTemplateDeclEPNS_15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator20VisitVarTemplateDeclEPNS_15VarTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarTemplateDecl(VarTemplateDecl /*P*/ D) {
    LocalInstantiationScope Scope = null;
    try {
      assert (D.getTemplatedDecl().isStaticDataMember()) : "Only static data member templates are allowed.";
      
      // Create a local instantiation scope for this variable template, which
      // will contain the instantiations of the template parameters.
      Scope/*J*/= new LocalInstantiationScope(SemaRef);
      TemplateParameterList /*P*/ TempParams = D.getTemplateParameters();
      TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
      if (!(InstParams != null)) {
        return null;
      }
      
      VarDecl /*P*/ Pattern = D.getTemplatedDecl();
      VarTemplateDecl /*P*/ PrevVarTemplate = null;
      if ((getPreviousDeclForInstantiation(Pattern) != null)) {
        DeclContextLookupResult Found = Owner.lookup(Pattern.getDeclName());
        if (!Found.empty()) {
          PrevVarTemplate = dyn_cast_VarTemplateDecl(Found.front());
        }
      }
      
      VarDecl /*P*/ VarInst = cast_or_null_VarDecl(VisitVarDecl(Pattern, 
    /*InstantiatingVarTemplate=*/ true));
      if (!(VarInst != null)) {
        return null;
      }
      
      DeclContext /*P*/ DC = Owner;
      
      VarTemplateDecl /*P*/ Inst = VarTemplateDecl.Create(SemaRef.Context, DC, D.getLocation(), new DeclarationName(D.getIdentifier()), InstParams, 
          VarInst);
      VarInst.setDescribedVarTemplate(Inst);
      Inst.setPreviousDecl(PrevVarTemplate);
      
      Inst.setAccess(D.getAccess());
      if (!(PrevVarTemplate != null)) {
        Inst.setInstantiatedFromMemberTemplate(D);
      }
      if (D.isOutOfLine()) {
        Inst.setLexicalDeclContext(D.getLexicalDeclContext());
        VarInst.setLexicalDeclContext(D.getLexicalDeclContext());
      }
      
      Owner.addDecl(Inst);
      if (!(PrevVarTemplate != null)) {
        // Queue up any out-of-line partial specializations of this member
        // variable template; the client will force their instantiation once
        // the enclosing class has been instantiated.
        SmallVector<VarTemplatePartialSpecializationDecl /*P*/ > PartialSpecs/*J*/= new SmallVector<VarTemplatePartialSpecializationDecl /*P*/ >(4, (VarTemplatePartialSpecializationDecl /*P*/ )null);
        D.getPartialSpecializations(PartialSpecs);
        for (/*uint*/int I = 0, N = PartialSpecs.size(); I != N; ++I)  {
          if (PartialSpecs.$at(I).getFirstDecl().isOutOfLine()) {
            OutOfLineVarPartialSpecs.push_back(std.make_pair_Ptr_Ptr(Inst, PartialSpecs.$at(I)));
          }
        }
      }
      
      return Inst;
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2204,
   FQN="clang::TemplateDeclInstantiator::VisitTemplateTemplateParmDecl", NM="_ZN5clang24TemplateDeclInstantiator29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTemplateTemplateParmDecl(TemplateTemplateParmDecl /*P*/ D) {
    // Instantiate the template parameter list of the template template parameter.
    TemplateParameterList /*P*/ TempParams = D.getTemplateParameters();
    TemplateParameterList /*P*/ InstParams;
    SmallVector<TemplateParameterList /*P*/> ExpandedParams/*J*/= new SmallVector<TemplateParameterList /*P*/>(8, null);
    
    boolean IsExpandedParameterPack = false;
    if (D.isExpandedParameterPack()) {
      // The template template parameter pack is an already-expanded pack
      // expansion of template parameters. Substitute into each of the expanded
      // parameters.
      ExpandedParams.reserve(D.getNumExpansionTemplateParameters());
      for (/*uint*/int I = 0, N = D.getNumExpansionTemplateParameters();
           I != N; ++I) {
        LocalInstantiationScope Scope = null;
        try {
          Scope/*J*/= new LocalInstantiationScope(SemaRef);
          TemplateParameterList /*P*/ Expansion = SubstTemplateParams(D.getExpansionTemplateParameters(I));
          if (!(Expansion != null)) {
            return null;
          }
          ExpandedParams.push_back(Expansion);
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
      
      IsExpandedParameterPack = true;
      InstParams = TempParams;
    } else if (D.isPackExpansion()) {
      // The template template parameter pack expands to a pack of template
      // template parameters. Determine whether we need to expand this parameter
      // pack into separate parameters.
      SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
      collectUnexpandedParameterPacks(SemaRef, D.getTemplateParameters(), 
          Unexpanded);
      
      // Determine whether the set of unexpanded parameter packs can and should
      // be expanded.
      bool$ref Expand = create_bool$ref(true);
      bool$ref RetainExpansion = create_bool$ref(false);
      OptionalUInt NumExpansions/*J*/= new OptionalUInt();
      if (SemaRef.CheckParameterPacksForExpansion(D.getLocation(), 
          TempParams.getSourceRange(), 
          new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
          TemplateArgs, 
          Expand, RetainExpansion, 
          NumExpansions)) {
        return null;
      }
      if (Expand.$deref()) {
        for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          LocalInstantiationScope Scope = null;
          try {
            SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(SemaRef, I);
            Scope/*J*/= new LocalInstantiationScope(SemaRef);
            TemplateParameterList /*P*/ Expansion = SubstTemplateParams(TempParams);
            if (!(Expansion != null)) {
              return null;
            }
            ExpandedParams.push_back(Expansion);
          } finally {
            if (Scope != null) { Scope.$destroy(); }
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        }
        
        // Note that we have an expanded parameter pack. The "type" of this
        // expanded parameter pack is the original expansion type, but callers
        // will end up using the expanded parameter pack types for type-checking.
        IsExpandedParameterPack = true;
        InstParams = TempParams;
      } else {
        Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
        LocalInstantiationScope Scope = null;
        try {
          // We cannot fully expand the pack expansion now, so just substitute
          // into the pattern.
          SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(SemaRef, -1);
          
          Scope/*J*/= new LocalInstantiationScope(SemaRef);
          InstParams = SubstTemplateParams(TempParams);
          if (!(InstParams != null)) {
            return null;
          }
        } finally {
          if (Scope != null) { Scope.$destroy(); }
          if (SubstIndex != null) { SubstIndex.$destroy(); }
        }
      }
    } else {
      LocalInstantiationScope Scope = null;
      try {
        // Perform the actual substitution of template parameters within a new,
        // local instantiation scope.
        Scope/*J*/= new LocalInstantiationScope(SemaRef);
        InstParams = SubstTemplateParams(TempParams);
        if (!(InstParams != null)) {
          return null;
        }
      } finally {
        if (Scope != null) { Scope.$destroy(); }
      }
    }
    
    // Build the template template parameter.
    TemplateTemplateParmDecl /*P*/ Param;
    if (IsExpandedParameterPack) {
      Param = TemplateTemplateParmDecl.Create(SemaRef.Context, Owner, 
          D.getLocation(), 
          D.getDepth() - TemplateArgs.getNumLevels(), 
          D.getPosition(), 
          D.getIdentifier(), InstParams, 
          new ArrayRef<TemplateParameterList /*P*/ >(ExpandedParams, true));
    } else {
      Param = TemplateTemplateParmDecl.Create(SemaRef.Context, Owner, 
          D.getLocation(), 
          D.getDepth() - TemplateArgs.getNumLevels(), 
          D.getPosition(), 
          D.isParameterPack(), 
          D.getIdentifier(), InstParams);
    }
    if (D.hasDefaultArgument() && !D.defaultArgumentWasInherited()) {
      NestedNameSpecifierLoc QualifierLoc = D.getDefaultArgument().getTemplateQualifierLoc();
      QualifierLoc.$assignMove(
          SemaRef.SubstNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc), TemplateArgs)
      );
      TemplateName TName = SemaRef.SubstTemplateName(new NestedNameSpecifierLoc(QualifierLoc), D.getDefaultArgument().getArgument().getAsTemplate(), 
          D.getDefaultArgument().getTemplateNameLoc(), TemplateArgs);
      if (!TName.isNull()) {
        Param.setDefaultArgument(SemaRef.Context, 
            new TemplateArgumentLoc(new TemplateArgument(new TemplateName(TName)), 
                D.getDefaultArgument().getTemplateQualifierLoc(), 
                D.getDefaultArgument().getTemplateNameLoc()));
      }
    }
    Param.setAccess(AccessSpecifier.AS_public);
    
    // Introduce this template parameter's instantiation into the instantiation
    // scope.
    SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, Param);
    
    return Param;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitEnumDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 884,
   FQN="clang::TemplateDeclInstantiator::VisitEnumDecl", NM="_ZN5clang24TemplateDeclInstantiator13VisitEnumDeclEPNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator13VisitEnumDeclEPNS_8EnumDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitEnumDecl(EnumDecl /*P*/ D) {
    EnumDecl /*P*/ PrevDecl = null;
    {
      EnumDecl /*P*/ PatternPrev = getPreviousDeclForInstantiation(D);
      if ((PatternPrev != null)) {
        NamedDecl /*P*/ Prev = SemaRef.FindInstantiatedDecl(D.getLocation(), 
            PatternPrev, 
            TemplateArgs);
        if (!(Prev != null)) {
          return null;
        }
        PrevDecl = cast_EnumDecl(Prev);
      }
    }
    
    EnumDecl /*P*/ Enum = EnumDecl.Create(SemaRef.Context, Owner, D.getLocStart(), 
        D.getLocation(), D.getIdentifier(), 
        PrevDecl, D.isScoped(), 
        D.isScopedUsingClassTag(), D.isFixed());
    if (D.isFixed()) {
      {
        TypeSourceInfo /*P*/ TI = D.getIntegerTypeSourceInfo();
        if ((TI != null)) {
          // If we have type source information for the underlying type, it means it
          // has been explicitly set by the user. Perform substitution on it before
          // moving on.
          SourceLocation UnderlyingLoc = TI.getTypeLoc().getBeginLoc();
          TypeSourceInfo /*P*/ NewTI = SemaRef.SubstType(TI, TemplateArgs, new SourceLocation(UnderlyingLoc), 
              new DeclarationName());
          if (!(NewTI != null) || SemaRef.CheckEnumUnderlyingType(NewTI)) {
            Enum.setIntegerType(SemaRef.Context.IntTy.$QualType());
          } else {
            Enum.setIntegerTypeSourceInfo(NewTI);
          }
        } else {
          assert (!D.getIntegerType().$arrow().isDependentType()) : "Dependent type without type source info";
          Enum.setIntegerType(D.getIntegerType());
        }
      }
    }
    
    SemaRef.InstantiateAttrs(TemplateArgs, D, Enum);
    
    Enum.setInstantiationOfMemberEnum(D, TemplateSpecializationKind.TSK_ImplicitInstantiation);
    Enum.setAccess(D.getAccess());
    // Forward the mangling number from the template to the instantiated decl.
    SemaRef.Context.setManglingNumber(Enum, SemaRef.Context.getManglingNumber(D));
    {
      // See if the old tag was defined along with a declarator.
      // If it did, mark the new tag as being associated with that declarator.
      DeclaratorDecl /*P*/ DD = SemaRef.Context.getDeclaratorForUnnamedTagDecl(D);
      if ((DD != null)) {
        SemaRef.Context.addDeclaratorForUnnamedTagDecl(Enum, DD);
      }
    }
    {
      // See if the old tag was defined along with a typedef.
      // If it did, mark the new tag as being associated with that typedef.
      TypedefNameDecl /*P*/ TND = SemaRef.Context.getTypedefNameForUnnamedTagDecl(D);
      if ((TND != null)) {
        SemaRef.Context.addTypedefNameForUnnamedTagDecl(Enum, TND);
      }
    }
    if (SubstQualifier(D, Enum)) {
      return null;
    }
    Owner.addDecl(Enum);
    
    EnumDecl /*P*/ Def = D.getDefinition();
    if ((Def != null) && Def != D) {
      {
        // If this is an out-of-line definition of an enum member template, check
        // that the underlying types match in the instantiation of both
        // declarations.
        TypeSourceInfo /*P*/ TI = Def.getIntegerTypeSourceInfo();
        if ((TI != null)) {
          SourceLocation UnderlyingLoc = TI.getTypeLoc().getBeginLoc();
          QualType DefnUnderlying = SemaRef.SubstType(TI.getType(), TemplateArgs, 
              new SourceLocation(UnderlyingLoc), new DeclarationName());
          SemaRef.CheckEnumRedeclaration(Def.getLocation(), Def.isScoped(), 
              new QualType(DefnUnderlying), 
              /*EnumUnderlyingIsImplicit=*/ false, Enum);
        }
      }
    }
    
    // C++11 [temp.inst]p1: The implicit instantiation of a class template
    // specialization causes the implicit instantiation of the declarations, but
    // not the definitions of scoped member enumerations.
    //
    // DR1484 clarifies that enumeration definitions inside of a template
    // declaration aren't considered entities that can be separately instantiated
    // from the rest of the entity they are declared inside of.
    if (isDeclWithinFunction(D) ? D == Def : (Def != null) && !Enum.isScoped()) {
      SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, Enum);
      InstantiateEnumDefinition(Enum, Def);
    }
    
    return Enum;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2654,
   FQN="clang::TemplateDeclInstantiator::VisitRecordDecl", NM="_ZN5clang24TemplateDeclInstantiator15VisitRecordDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator15VisitRecordDeclEPNS_10RecordDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitRecordDecl(RecordDecl /*P*/ D) {
    throw new llvm_unreachable("There are only CXXRecordDecls in C++");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1374,
   FQN="clang::TemplateDeclInstantiator::VisitCXXRecordDecl", NM="_ZN5clang24TemplateDeclInstantiator18VisitCXXRecordDeclEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator18VisitCXXRecordDeclEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXRecordDecl(CXXRecordDecl /*P*/ D) {
    CXXRecordDecl /*P*/ PrevDecl = null;
    if (D.isInjectedClassName()) {
      PrevDecl = cast_CXXRecordDecl(Owner);
    } else {
      CXXRecordDecl /*P*/ PatternPrev = getPreviousDeclForInstantiation(D);
      if ((PatternPrev != null)) {
        NamedDecl /*P*/ Prev = SemaRef.FindInstantiatedDecl(D.getLocation(), 
            PatternPrev, 
            TemplateArgs);
        if (!(Prev != null)) {
          return null;
        }
        PrevDecl = cast_CXXRecordDecl(Prev);
      }
    }
    
    CXXRecordDecl /*P*/ Record = CXXRecordDecl.Create(SemaRef.Context, D.getTagKind(), Owner, 
        D.getLocStart(), D.getLocation(), 
        D.getIdentifier(), PrevDecl);
    
    // Substitute the nested name specifier, if any.
    if (SubstQualifier(D, Record)) {
      return null;
    }
    
    Record.setImplicit(D.isImplicit());
    // FIXME: Check against AS_none is an ugly hack to work around the issue that
    // the tag decls introduced by friend class declarations don't have an access
    // specifier. Remove once this area of the code gets sorted out.
    if (D.getAccess() != AccessSpecifier.AS_none) {
      Record.setAccess(D.getAccess());
    }
    if (!D.isInjectedClassName()) {
      Record.setInstantiationOfMemberClass(D, TemplateSpecializationKind.TSK_ImplicitInstantiation);
    }
    
    // If the original function was part of a friend declaration,
    // inherit its namespace state.
    if ((D.getFriendObjectKind().getValue() != 0)) {
      Record.setObjectOfFriendDecl();
    }
    
    // Make sure that anonymous structs and unions are recorded.
    if (D.isAnonymousStructOrUnion()) {
      Record.setAnonymousStructOrUnion(true);
    }
    if ((D.isLocalClass() != null)) {
      SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, Record);
    }
    
    // Forward the mangling number from the template to the instantiated decl.
    SemaRef.Context.setManglingNumber(Record, 
        SemaRef.Context.getManglingNumber(D));
    {
      
      // See if the old tag was defined along with a declarator.
      // If it did, mark the new tag as being associated with that declarator.
      DeclaratorDecl /*P*/ DD = SemaRef.Context.getDeclaratorForUnnamedTagDecl(D);
      if ((DD != null)) {
        SemaRef.Context.addDeclaratorForUnnamedTagDecl(Record, DD);
      }
    }
    {
      
      // See if the old tag was defined along with a typedef.
      // If it did, mark the new tag as being associated with that typedef.
      TypedefNameDecl /*P*/ TND = SemaRef.Context.getTypedefNameForUnnamedTagDecl(D);
      if ((TND != null)) {
        SemaRef.Context.addTypedefNameForUnnamedTagDecl(Record, TND);
      }
    }
    
    Owner.addDecl(Record);
    
    // DR1484 clarifies that the members of a local class are instantiated as part
    // of the instantiation of their enclosing entity.
    if (D.isCompleteDefinition() && (D.isLocalClass() != null)) {
      Sema.SavePendingLocalImplicitInstantiationsRAII SavedPendingLocalImplicitInstantiations = null;
      try {
        SavedPendingLocalImplicitInstantiations/*J*/= new Sema.SavePendingLocalImplicitInstantiationsRAII(SemaRef);
        
        SemaRef.InstantiateClass(D.getLocation(), Record, D, TemplateArgs, 
            TemplateSpecializationKind.TSK_ImplicitInstantiation, 
            /*Complain=*/ true);
        
        SemaRef.InstantiateClassMembers(D.getLocation(), Record, TemplateArgs, 
            TemplateSpecializationKind.TSK_ImplicitInstantiation);
        
        // This class may have local implicit instantiations that need to be
        // performed within this scope.
        SemaRef.PerformPendingInstantiations(/*LocalOnly=*/ true);
      } finally {
        if (SavedPendingLocalImplicitInstantiations != null) { SavedPendingLocalImplicitInstantiations.$destroy(); }
      }
    }
    
    SemaRef.DiagnoseUnusedNestedTypedefs(Record);
    
    return Record;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2658,
   FQN="clang::TemplateDeclInstantiator::VisitClassTemplateSpecializationDecl", NM="_ZN5clang24TemplateDeclInstantiator36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitClassTemplateSpecializationDecl(ClassTemplateSpecializationDecl /*P*/ D) {
    TemplateArgumentListInfo InstTemplateArgs = null;
    try {
      // As a MS extension, we permit class-scope explicit specialization
      // of member class templates.
      ClassTemplateDecl /*P*/ ClassTemplate = D.getSpecializedTemplate();
      assert (ClassTemplate.getDeclContext().isRecord() && D.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization) : "can only instantiate an explicit specialization for a member class template";
      
      // Lookup the already-instantiated declaration in the instantiation
      // of the class template. FIXME: Diagnose or assert if this fails?
      DeclContextLookupResult Found = Owner.lookup(ClassTemplate.getDeclName());
      if (Found.empty()) {
        return null;
      }
      ClassTemplateDecl /*P*/ InstClassTemplate = dyn_cast_ClassTemplateDecl(Found.front());
      if (!(InstClassTemplate != null)) {
        return null;
      }
      
      // Substitute into the template arguments of the class template explicit
      // specialization.
      TemplateSpecializationTypeLoc Loc = D.getTypeAsWritten().getTypeLoc().castAs(TemplateSpecializationTypeLoc.class);
      InstTemplateArgs/*J*/= new TemplateArgumentListInfo(Loc.getLAngleLoc(), 
          Loc.getRAngleLoc());
      SmallVector<TemplateArgumentLoc> ArgLocs/*J*/= new SmallVector<TemplateArgumentLoc>(4, new TemplateArgumentLoc());
      for (/*uint*/int I = 0; I != Loc.getNumArgs(); ++I)  {
        ArgLocs.push_back(Loc.getArgLoc(I));
      }
      if (SemaRef.Subst(ArgLocs.data(), ArgLocs.size(), 
          InstTemplateArgs, TemplateArgs)) {
        return null;
      }
      
      // Check that the template argument list is well-formed for this
      // class template.
      SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
      if (SemaRef.CheckTemplateArgumentList(InstClassTemplate, 
          D.getLocation(), 
          InstTemplateArgs, 
          false, 
          _Converted)) {
        return null;
      }
      
      // Figure out where to insert this class template explicit specialization
      // in the member template's set of class template explicit specializations.
      final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      ClassTemplateSpecializationDecl /*P*/ PrevDecl = InstClassTemplate.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
      
      // Check whether we've already seen a conflicting instantiation of this
      // declaration (for instance, if there was a prior implicit instantiation).
      bool$ref Ignored = create_bool$ref();
      if ((PrevDecl != null)
         && SemaRef.CheckSpecializationInstantiationRedecl(D.getLocation(), 
          D.getSpecializationKind(), 
          PrevDecl, 
          PrevDecl.getSpecializationKind(), 
          PrevDecl.getPointOfInstantiation(), 
          Ignored)) {
        return null;
      }
      
      // If PrevDecl was a definition and D is also a definition, diagnose.
      // This happens in cases like:
      //
      //   template<typename T, typename U>
      //   struct Outer {
      //     template<typename X> struct Inner;
      //     template<> struct Inner<T> {};
      //     template<> struct Inner<U> {};
      //   };
      //
      //   Outer<int, int> outer; // error: the explicit specializations of Inner
      //                          // have the same signature.
      if ((PrevDecl != null) && (PrevDecl.getDefinition() != null)
         && D.isThisDeclarationADefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), diag.err_redefinition)), PrevDecl));
          $c$.clean($c$.track(SemaRef.Diag(PrevDecl.getDefinition().getLocation(), 
              diag.note_previous_definition)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Create the class template partial specialization declaration.
      ClassTemplateSpecializationDecl /*P*/ InstD = ClassTemplateSpecializationDecl.Create(SemaRef.Context, 
          D.getTagKind(), 
          Owner, 
          D.getLocStart(), 
          D.getLocation(), 
          InstClassTemplate, 
          new ArrayRef<TemplateArgument>(_Converted, false), 
          PrevDecl);
      
      // Add this partial specialization to the set of class template partial
      // specializations.
      if (!(PrevDecl != null)) {
        InstClassTemplate.AddSpecialization(InstD, InsertPos.$deref());
      }
      
      // Substitute the nested name specifier, if any.
      if (SubstQualifier(D, InstD)) {
        return null;
      }
      
      // Build the canonical type that describes the converted template
      // arguments of the class template explicit specialization.
      QualType CanonType = SemaRef.Context.getTemplateSpecializationType(new TemplateName(InstClassTemplate), new ArrayRef<TemplateArgument>(_Converted, false), 
          SemaRef.Context.getRecordType(InstD));
      
      // Build the fully-sugared type for this class template
      // specialization as the user wrote in the specialization
      // itself. This means that we'll pretty-print the type retrieved
      // from the specialization's declaration the way that the user
      // actually wrote the specialization, rather than formatting the
      // name based on the "canonical" representation used to store the
      // template arguments in the specialization.
      TypeSourceInfo /*P*/ WrittenTy = SemaRef.Context.getTemplateSpecializationTypeInfo(new TemplateName(InstClassTemplate), D.getLocation(), InstTemplateArgs, 
          new QualType(CanonType));
      
      InstD.setAccess(D.getAccess());
      InstD.setInstantiationOfMemberClass(D, TemplateSpecializationKind.TSK_ImplicitInstantiation);
      InstD.setSpecializationKind(D.getSpecializationKind());
      InstD.setTypeAsWritten(WrittenTy);
      InstD.setExternLoc(D.getExternLoc());
      InstD.setTemplateKeywordLoc(D.getTemplateKeywordLoc());
      
      Owner.addDecl(InstD);
      
      // Instantiate the members of the class-scope explicit specialization eagerly.
      // We don't have support for lazy instantiation of an explicit specialization
      // yet, and MSVC eagerly instantiates in this case.
      if (D.isThisDeclarationADefinition()
         && SemaRef.InstantiateClass(D.getLocation(), InstD, D, TemplateArgs, 
          TemplateSpecializationKind.TSK_ImplicitInstantiation, 
          /*Complain=*/ true)) {
        return null;
      }
      
      return InstD;
    } finally {
      if (InstTemplateArgs != null) { InstTemplateArgs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1217,
   FQN="clang::TemplateDeclInstantiator::VisitClassTemplatePartialSpecializationDecl", NM="_ZN5clang24TemplateDeclInstantiator43VisitClassTemplatePartialSpecializationDeclEPNS_38ClassTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator43VisitClassTemplatePartialSpecializationDeclEPNS_38ClassTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitClassTemplatePartialSpecializationDecl(ClassTemplatePartialSpecializationDecl /*P*/ D) {
    ClassTemplateDecl /*P*/ ClassTemplate = D.getSpecializedTemplate();
    
    // Lookup the already-instantiated declaration in the instantiation
    // of the class template and return that.
    DeclContextLookupResult Found = Owner.lookup(ClassTemplate.getDeclName());
    if (Found.empty()) {
      return null;
    }
    
    ClassTemplateDecl /*P*/ InstClassTemplate = dyn_cast_ClassTemplateDecl(Found.front());
    if (!(InstClassTemplate != null)) {
      return null;
    }
    {
      
      ClassTemplatePartialSpecializationDecl /*P*/ Result = InstClassTemplate.findPartialSpecInstantiatedFromMember(D);
      if ((Result != null)) {
        return Result;
      }
    }
    
    return InstantiateClassTemplatePartialSpecialization(InstClassTemplate, D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitTemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2009,
   FQN="clang::TemplateDeclInstantiator::VisitTemplateTypeParmDecl", NM="_ZN5clang24TemplateDeclInstantiator25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTemplateTypeParmDecl(TemplateTypeParmDecl /*P*/ D) {
    // TODO: don't always clone when decls are refcounted.
    assert (D.getTypeForDecl().isTemplateTypeParmType());
    
    TemplateTypeParmDecl /*P*/ Inst = TemplateTypeParmDecl.Create(SemaRef.Context, Owner, 
        D.getLocStart(), D.getLocation(), 
        D.getDepth() - TemplateArgs.getNumLevels(), 
        D.getIndex(), D.getIdentifier(), 
        D.wasDeclaredWithTypename(), 
        D.isParameterPack());
    Inst.setAccess(AccessSpecifier.AS_public);
    if (D.hasDefaultArgument() && !D.defaultArgumentWasInherited()) {
      TypeSourceInfo /*P*/ InstantiatedDefaultArg = SemaRef.SubstType(D.getDefaultArgumentInfo(), TemplateArgs, 
          D.getDefaultArgumentLoc(), D.getDeclName());
      if ((InstantiatedDefaultArg != null)) {
        Inst.setDefaultArgument(InstantiatedDefaultArg);
      }
    }
    
    // Introduce this template parameter's instantiation into the instantiation
    // scope.
    SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, Inst);
    
    return Inst;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 551,
   FQN="clang::TemplateDeclInstantiator::VisitTypeAliasDecl", NM="_ZN5clang24TemplateDeclInstantiator18VisitTypeAliasDeclEPNS_13TypeAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator18VisitTypeAliasDeclEPNS_13TypeAliasDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTypeAliasDecl(TypeAliasDecl /*P*/ D) {
    Decl /*P*/ Typedef = InstantiateTypedefNameDecl(D, /*IsTypeAlias=*/ true);
    if ((Typedef != null)) {
      Owner.addDecl(Typedef);
    }
    return Typedef;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 544,
   FQN="clang::TemplateDeclInstantiator::VisitTypedefDecl", NM="_ZN5clang24TemplateDeclInstantiator16VisitTypedefDeclEPNS_11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator16VisitTypedefDeclEPNS_11TypedefDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTypedefDecl(TypedefDecl /*P*/ D) {
    Decl /*P*/ Typedef = InstantiateTypedefNameDecl(D, /*IsTypeAlias=*/ false);
    if ((Typedef != null)) {
      Owner.addDecl(Typedef);
    }
    return Typedef;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitUnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2465,
   FQN="clang::TemplateDeclInstantiator::VisitUnresolvedUsingTypenameDecl", NM="_ZN5clang24TemplateDeclInstantiator32VisitUnresolvedUsingTypenameDeclEPNS_27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator32VisitUnresolvedUsingTypenameDeclEPNS_27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitUnresolvedUsingTypenameDecl(UnresolvedUsingTypenameDecl /*P*/ D) {
    CXXScopeSpec SS = null;
    try {
      NestedNameSpecifierLoc QualifierLoc = SemaRef.SubstNestedNameSpecifierLoc(D.getQualifierLoc(), 
          TemplateArgs);
      if (!QualifierLoc.$bool()) {
        return null;
      }
      
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      // Since NameInfo refers to a typename, it cannot be a C++ special name.
      // Hence, no transformation is required for it.
      DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(D.getDeclName(), D.getLocation());
      NamedDecl /*P*/ UD = SemaRef.BuildUsingDeclaration(/*Scope*/ (Scope /*P*/ )null, D.getAccess(), 
          D.getUsingLoc(), SS, new DeclarationNameInfo(NameInfo), (AttributeList /*P*/ )null, 
          /*instantiation*/ true, 
          /*typename*/ true, D.getTypenameLoc());
      if ((UD != null)) {
        SemaRef.Context.setInstantiatedFromUsingDecl(cast_UsingDecl(UD), D);
      }
      
      return UD;
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitUsingDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2346,
   FQN="clang::TemplateDeclInstantiator::VisitUsingDecl", NM="_ZN5clang24TemplateDeclInstantiator14VisitUsingDeclEPNS_9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator14VisitUsingDeclEPNS_9UsingDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitUsingDecl(UsingDecl /*P*/ D) {
    LookupResult Prev = null;
    CXXScopeSpec SS = null;
    try {
      
      // The nested name specifier may be dependent, for example
      //     template <typename T> struct t {
      //       struct s1 { T f1(); };
      //       struct s2 : s1 { using s1::f1; };
      //     };
      //     template struct t<int>;
      // Here, in using s1::f1, s1 refers to t<T>::s1;
      // we need to substitute for t<int>::s1.
      NestedNameSpecifierLoc QualifierLoc = SemaRef.SubstNestedNameSpecifierLoc(D.getQualifierLoc(), 
          TemplateArgs);
      if (!QualifierLoc.$bool()) {
        return null;
      }
      
      // For an inheriting constructor declaration, the name of the using
      // declaration is the name of a constructor in this class, not in the
      // base class.
      DeclarationNameInfo NameInfo = D.getNameInfo();
      if (NameInfo.getName().getNameKind() == DeclarationName.NameKind.CXXConstructorName) {
        {
          CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(SemaRef.CurContext);
          if ((RD != null)) {
            NameInfo.setName(SemaRef.Context.DeclarationNames.getCXXConstructorName(SemaRef.Context.getCanonicalType(SemaRef.Context.getRecordType(RD))));
          }
        }
      }
      
      // We only need to do redeclaration lookups if we're in a class
      // scope (in fact, it's not really even possible in non-class
      // scopes).
      boolean CheckRedeclaration = Owner.isRecord();
      
      Prev/*J*/= new LookupResult(SemaRef, NameInfo, Sema.LookupNameKind.LookupUsingDeclName, 
          Sema.RedeclarationKind.ForRedeclaration);
      
      UsingDecl /*P*/ NewUD = UsingDecl.Create(SemaRef.Context, Owner, 
          D.getUsingLoc(), 
          new NestedNameSpecifierLoc(QualifierLoc), 
          NameInfo, 
          D.hasTypename());
      
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      if (CheckRedeclaration) {
        Prev.setHideTags(false);
        SemaRef.LookupQualifiedName(Prev, Owner);
        
        // Check for invalid redeclarations.
        if (SemaRef.CheckUsingDeclRedeclaration(D.getUsingLoc(), 
            D.hasTypename(), SS, 
            D.getLocation(), Prev)) {
          NewUD.setInvalidDecl();
        }
      }
      if (!NewUD.isInvalidDecl()
         && SemaRef.CheckUsingDeclQualifier(D.getUsingLoc(), SS, NameInfo, 
          D.getLocation())) {
        NewUD.setInvalidDecl();
      }
      
      SemaRef.Context.setInstantiatedFromUsingDecl(NewUD, D);
      NewUD.setAccess(D.getAccess());
      Owner.addDecl(NewUD);
      
      // Don't process the shadow decls for an invalid decl.
      if (NewUD.isInvalidDecl()) {
        return NewUD;
      }
      if (NameInfo.getName().getNameKind() == DeclarationName.NameKind.CXXConstructorName) {
        SemaRef.CheckInheritingConstructorUsingDecl(NewUD);
      }
      
      boolean isFunctionScope = Owner.isFunctionOrMethod();
      
      // Process the shadow decls.
      for (UsingShadowDecl /*P*/ Shadow : D.shadows()) {
        // FIXME: UsingShadowDecl doesn't preserve its immediate target, so
        // reconstruct it in the case where it matters.
        NamedDecl /*P*/ OldTarget = Shadow.getTargetDecl();
        {
          ConstructorUsingShadowDecl /*P*/ CUSD = dyn_cast_ConstructorUsingShadowDecl(Shadow);
          if ((CUSD != null)) {
            {
              ConstructorUsingShadowDecl /*P*/ BaseShadow = CUSD.getNominatedBaseClassShadowDecl();
              if ((BaseShadow != null)) {
                OldTarget = BaseShadow;
              }
            }
          }
        }
        
        NamedDecl /*P*/ InstTarget = cast_or_null_NamedDecl(SemaRef.FindInstantiatedDecl(Shadow.getLocation(), OldTarget, TemplateArgs));
        if (!(InstTarget != null)) {
          return null;
        }
        
        type$ref<UsingShadowDecl /*P*/ > PrevDecl = create_type$ref(null);
        if (CheckRedeclaration) {
          if (SemaRef.CheckUsingShadowDecl(NewUD, InstTarget, Prev, PrevDecl)) {
            continue;
          }
        } else {
          UsingShadowDecl /*P*/ OldPrev = getPreviousDeclForInstantiation(Shadow);
          if ((OldPrev != null)) {
            PrevDecl.$set(cast_or_null_UsingShadowDecl(SemaRef.FindInstantiatedDecl(Shadow.getLocation(), OldPrev, TemplateArgs)));
          }
        }
        
        UsingShadowDecl /*P*/ InstShadow = SemaRef.BuildUsingShadowDecl(/*Scope*/ (Scope /*P*/ )null, NewUD, InstTarget, 
            PrevDecl.$deref());
        SemaRef.Context.setInstantiatedFromUsingShadowDecl(InstShadow, Shadow);
        if (isFunctionScope) {
          SemaRef.CurrentInstantiationScope.InstantiatedLocal(Shadow, InstShadow);
        }
      }
      
      return NewUD;
    } finally {
      if (SS != null) { SS.$destroy(); }
      if (Prev != null) { Prev.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitUsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2326,
   FQN="clang::TemplateDeclInstantiator::VisitUsingDirectiveDecl", NM="_ZN5clang24TemplateDeclInstantiator23VisitUsingDirectiveDeclEPNS_18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator23VisitUsingDirectiveDeclEPNS_18UsingDirectiveDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitUsingDirectiveDecl(UsingDirectiveDecl /*P*/ D) {
    // Using directives are never dependent (and never contain any types or
    // expressions), so they require no explicit instantiation work.
    UsingDirectiveDecl /*P*/ Inst = UsingDirectiveDecl.Create(SemaRef.Context, Owner, D.getLocation(), 
        D.getNamespaceKeyLocation(), 
        D.getQualifierLoc(), 
        D.getIdentLocation(), 
        D.getNominatedNamespace(), 
        D.getCommonAncestor());
    
    // Add the using directive to its declaration context
    // only if this is not a function or method.
    if (!Owner.isFunctionOrMethod()) {
      Owner.addDecl(Inst);
    }
    
    return Inst;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2454,
   FQN="clang::TemplateDeclInstantiator::VisitUsingShadowDecl", NM="_ZN5clang24TemplateDeclInstantiator20VisitUsingShadowDeclEPNS_15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator20VisitUsingShadowDeclEPNS_15UsingShadowDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitUsingShadowDecl(UsingShadowDecl /*P*/ D) {
    // Ignore these;  we handle them in bulk when processing the UsingDecl.
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2459,
   FQN="clang::TemplateDeclInstantiator::VisitConstructorUsingShadowDecl", NM="_ZN5clang24TemplateDeclInstantiator31VisitConstructorUsingShadowDeclEPNS_26ConstructorUsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator31VisitConstructorUsingShadowDeclEPNS_26ConstructorUsingShadowDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitConstructorUsingShadowDecl(ConstructorUsingShadowDecl /*P*/ D) {
    // Ignore these;  we handle them in bulk when processing the UsingDecl.
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 662,
   FQN="clang::TemplateDeclInstantiator::VisitFieldDecl", NM="_ZN5clang24TemplateDeclInstantiator14VisitFieldDeclEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator14VisitFieldDeclEPNS_9FieldDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFieldDecl(FieldDecl /*P*/ D) {
    boolean Invalid = false;
    TypeSourceInfo /*P*/ DI = D.getTypeSourceInfo();
    if (DI.getType().$arrow().isInstantiationDependentType()
       || DI.getType().$arrow().isVariablyModifiedType()) {
      DI = SemaRef.SubstType(DI, TemplateArgs, 
          D.getLocation(), D.getDeclName());
      if (!(DI != null)) {
        DI = D.getTypeSourceInfo();
        Invalid = true;
      } else if (DI.getType().$arrow().isFunctionType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [temp.arg.type]p3:
          //   If a declaration acquires a function type through a type
          //   dependent on a template-parameter and this causes a
          //   declaration that does not use the syntactic form of a
          //   function declarator to have function type, the program is
          //   ill-formed.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), diag.err_field_instantiates_to_function)), 
              DI.getType()));
          Invalid = true;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      SemaRef.MarkDeclarationsReferencedInType(D.getLocation(), DI.getType());
    }
    
    Expr /*P*/ BitWidth = D.getBitWidth();
    if (Invalid) {
      BitWidth = null;
    } else if ((BitWidth != null)) {
      EnterExpressionEvaluationContext Unevaluated = null;
      try {
        // The bit-width expression is a constant expression.
        Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
            Sema.ExpressionEvaluationContext.ConstantEvaluated);
        
        ActionResultTTrue<Expr /*P*/ > InstantiatedBitWidth = SemaRef.SubstExpr(BitWidth, TemplateArgs);
        if (InstantiatedBitWidth.isInvalid()) {
          Invalid = true;
          BitWidth = null;
        } else {
          BitWidth = InstantiatedBitWidth.getAs(Expr.class);
        }
      } finally {
        if (Unevaluated != null) { Unevaluated.$destroy(); }
      }
    }
    
    FieldDecl /*P*/ Field = SemaRef.CheckFieldDecl(D.getDeclName(), 
        DI.getType(), DI, 
        cast_RecordDecl(Owner), 
        D.getLocation(), 
        D.isMutable(), 
        BitWidth, 
        D.getInClassInitStyle(), 
        D.getInnerLocStart(), 
        D.getAccess(), 
        (NamedDecl /*P*/ )null);
    if (!(Field != null)) {
      cast_Decl(Owner).setInvalidDecl();
      return null;
    }
    
    SemaRef.InstantiateAttrs(TemplateArgs, D, Field, LateAttrs, StartingScope);
    if (Field.hasAttrs()) {
      SemaRef.CheckAlignasUnderalignment(Field);
    }
    if (Invalid) {
      Field.setInvalidDecl();
    }
    if (!Field.getDeclName().$bool()) {
      // Keep track of where this decl came from.
      SemaRef.Context.setInstantiatedFromUnnamedFieldDecl(Field, D);
    }
    {
      CXXRecordDecl /*P*/ Parent = dyn_cast_CXXRecordDecl(Field.getDeclContext());
      if ((Parent != null)) {
        if (Parent.isAnonymousStructOrUnion()
           && Parent.getRedeclContext().isFunctionOrMethod()) {
          SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, Field);
        }
      }
    }
    
    Field.setImplicit(D.isImplicit());
    Field.setAccess(D.getAccess());
    Owner.addDecl(Field);
    
    return Field;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitObjCAtDefsFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2872,
   FQN="clang::TemplateDeclInstantiator::VisitObjCAtDefsFieldDecl", NM="_ZN5clang24TemplateDeclInstantiator24VisitObjCAtDefsFieldDeclEPNS_19ObjCAtDefsFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator24VisitObjCAtDefsFieldDeclEPNS_19ObjCAtDefsFieldDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCAtDefsFieldDecl(ObjCAtDefsFieldDecl /*P*/ D) {
    throw new llvm_unreachable("@defs is not supported in Objective-C++");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2646,
   FQN="clang::TemplateDeclInstantiator::VisitFunctionDecl", NM="_ZN5clang24TemplateDeclInstantiator17VisitFunctionDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator17VisitFunctionDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFunctionDecl(FunctionDecl /*P*/ D) {
    return VisitFunctionDecl(D, (TemplateParameterList /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitCXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2650,
   FQN="clang::TemplateDeclInstantiator::VisitCXXMethodDecl", NM="_ZN5clang24TemplateDeclInstantiator18VisitCXXMethodDeclEPNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator18VisitCXXMethodDeclEPNS_13CXXMethodDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXMethodDecl(CXXMethodDecl /*P*/ D) {
    return VisitCXXMethodDecl(D, (TemplateParameterList /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitCXXConstructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1992,
   FQN="clang::TemplateDeclInstantiator::VisitCXXConstructorDecl", NM="_ZN5clang24TemplateDeclInstantiator23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXConstructorDecl(CXXConstructorDecl /*P*/ D) {
    return VisitCXXMethodDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitCXXConversionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2000,
   FQN="clang::TemplateDeclInstantiator::VisitCXXConversionDecl", NM="_ZN5clang24TemplateDeclInstantiator22VisitCXXConversionDeclEPNS_17CXXConversionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator22VisitCXXConversionDeclEPNS_17CXXConversionDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXConversionDecl(CXXConversionDecl /*P*/ D) {
    return VisitCXXMethodDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitCXXDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1996,
   FQN="clang::TemplateDeclInstantiator::VisitCXXDestructorDecl", NM="_ZN5clang24TemplateDeclInstantiator22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXDestructorDecl(CXXDestructorDecl /*P*/ D) {
    return VisitCXXMethodDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitMSPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 744,
   FQN="clang::TemplateDeclInstantiator::VisitMSPropertyDecl", NM="_ZN5clang24TemplateDeclInstantiator19VisitMSPropertyDeclEPNS_14MSPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator19VisitMSPropertyDeclEPNS_14MSPropertyDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitMSPropertyDecl(MSPropertyDecl /*P*/ D) {
    boolean Invalid = false;
    TypeSourceInfo /*P*/ DI = D.getTypeSourceInfo();
    if (DI.getType().$arrow().isVariablyModifiedType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), diag.err_property_is_variably_modified)), 
            D));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    } else if (DI.getType().$arrow().isInstantiationDependentType()) {
      DI = SemaRef.SubstType(DI, TemplateArgs, 
          D.getLocation(), D.getDeclName());
      if (!(DI != null)) {
        DI = D.getTypeSourceInfo();
        Invalid = true;
      } else if (DI.getType().$arrow().isFunctionType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [temp.arg.type]p3:
          //   If a declaration acquires a function type through a type
          //   dependent on a template-parameter and this causes a
          //   declaration that does not use the syntactic form of a
          //   function declarator to have function type, the program is
          //   ill-formed.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), diag.err_field_instantiates_to_function)), 
              DI.getType()));
          Invalid = true;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      SemaRef.MarkDeclarationsReferencedInType(D.getLocation(), DI.getType());
    }
    
    MSPropertyDecl /*P*/ Property = MSPropertyDecl.Create(SemaRef.Context, Owner, D.getLocation(), D.getDeclName(), DI.getType(), 
        DI, D.getLocStart(), D.getGetterId(), D.getSetterId());
    
    SemaRef.InstantiateAttrs(TemplateArgs, D, Property, LateAttrs, 
        StartingScope);
    if (Invalid) {
      Property.setInvalidDecl();
    }
    
    Property.setAccess(D.getAccess());
    Owner.addDecl(Property);
    
    return Property;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitNonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2038,
   FQN="clang::TemplateDeclInstantiator::VisitNonTypeTemplateParmDecl", NM="_ZN5clang24TemplateDeclInstantiator28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitNonTypeTemplateParmDecl(NonTypeTemplateParmDecl /*P*/ D) {
    // Substitute into the type of the non-type template parameter.
    TypeLoc TL = D.getTypeSourceInfo().getTypeLoc();
    SmallVector<TypeSourceInfo /*P*/ > ExpandedParameterPackTypesAsWritten/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(4, (TypeSourceInfo /*P*/ )null);
    SmallVector<QualType> ExpandedParameterPackTypes/*J*/= new SmallVector<QualType>(4, new QualType());
    boolean IsExpandedParameterPack = false;
    TypeSourceInfo /*P*/ DI;
    QualType T/*J*/= new QualType();
    boolean Invalid = false;
    if (D.isExpandedParameterPack()) {
      // The non-type template parameter pack is an already-expanded pack
      // expansion of types. Substitute into each of the expanded types.
      ExpandedParameterPackTypes.reserve(D.getNumExpansionTypes());
      ExpandedParameterPackTypesAsWritten.reserve(D.getNumExpansionTypes());
      for (/*uint*/int I = 0, N = D.getNumExpansionTypes(); I != N; ++I) {
        TypeSourceInfo /*P*/ NewDI = SemaRef.SubstType(D.getExpansionTypeSourceInfo(I), 
            TemplateArgs, 
            D.getLocation(), 
            D.getDeclName());
        if (!(NewDI != null)) {
          return null;
        }
        
        ExpandedParameterPackTypesAsWritten.push_back(NewDI);
        QualType NewT = SemaRef.CheckNonTypeTemplateParameterType(NewDI.getType(), 
            D.getLocation());
        if (NewT.isNull()) {
          return null;
        }
        ExpandedParameterPackTypes.push_back(NewT);
      }
      
      IsExpandedParameterPack = true;
      DI = D.getTypeSourceInfo();
      T.$assignMove(DI.getType());
    } else if (D.isPackExpansion()) {
      // The non-type template parameter pack's type is a pack expansion of types.
      // Determine whether we need to expand this parameter pack into separate
      // types.
      PackExpansionTypeLoc Expansion = TL.castAs(PackExpansionTypeLoc.class);
      TypeLoc Pattern = Expansion.getPatternLoc();
      SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
      SemaRef.collectUnexpandedParameterPacks_TypeLoc(new TypeLoc(Pattern), Unexpanded);
      
      // Determine whether the set of unexpanded parameter packs can and should
      // be expanded.
      bool$ref Expand = create_bool$ref(true);
      bool$ref RetainExpansion = create_bool$ref(false);
      OptionalUInt OrigNumExpansions = Expansion.getTypePtr().getNumExpansions();
      OptionalUInt NumExpansions = new OptionalUInt(OrigNumExpansions);
      if (SemaRef.CheckParameterPacksForExpansion(Expansion.getEllipsisLoc(), 
          Pattern.getSourceRange(), 
          new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false), 
          TemplateArgs, 
          Expand, RetainExpansion, 
          NumExpansions)) {
        return null;
      }
      if (Expand.$deref()) {
        for (/*uint*/int I = 0; I != NumExpansions.$star(); ++I) {
          Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
          try {
            SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(SemaRef, I);
            TypeSourceInfo /*P*/ NewDI = SemaRef.SubstType(new TypeLoc(Pattern), TemplateArgs, 
                D.getLocation(), 
                D.getDeclName());
            if (!(NewDI != null)) {
              return null;
            }
            
            ExpandedParameterPackTypesAsWritten.push_back(NewDI);
            QualType NewT = SemaRef.CheckNonTypeTemplateParameterType(NewDI.getType(), 
                D.getLocation());
            if (NewT.isNull()) {
              return null;
            }
            ExpandedParameterPackTypes.push_back(NewT);
          } finally {
            if (SubstIndex != null) { SubstIndex.$destroy(); }
          }
        }
        
        // Note that we have an expanded parameter pack. The "type" of this
        // expanded parameter pack is the original expansion type, but callers
        // will end up using the expanded parameter pack types for type-checking.
        IsExpandedParameterPack = true;
        DI = D.getTypeSourceInfo();
        T.$assignMove(DI.getType());
      } else {
        Sema.ArgumentPackSubstitutionIndexRAII SubstIndex = null;
        try {
          // We cannot fully expand the pack expansion now, so substitute into the
          // pattern and create a new pack expansion type.
          SubstIndex/*J*/= new Sema.ArgumentPackSubstitutionIndexRAII(SemaRef, -1);
          TypeSourceInfo /*P*/ NewPattern = SemaRef.SubstType(new TypeLoc(Pattern), TemplateArgs, 
              D.getLocation(), 
              D.getDeclName());
          if (!(NewPattern != null)) {
            return null;
          }
          
          DI = SemaRef.CheckPackExpansion_TypeSourceInfo$P_SourceLocation_OptionalUInt(NewPattern, Expansion.getEllipsisLoc(), 
              new OptionalUInt(NumExpansions));
          if (!(DI != null)) {
            return null;
          }
          
          T.$assignMove(DI.getType());
        } finally {
          if (SubstIndex != null) { SubstIndex.$destroy(); }
        }
      }
    } else {
      // Simple case: substitution into a parameter that is not a parameter pack.
      DI = SemaRef.SubstType(D.getTypeSourceInfo(), TemplateArgs, 
          D.getLocation(), D.getDeclName());
      if (!(DI != null)) {
        return null;
      }
      
      // Check that this type is acceptable for a non-type template parameter.
      T.$assignMove(SemaRef.CheckNonTypeTemplateParameterType(DI.getType(), 
              D.getLocation()));
      if (T.isNull()) {
        T.$assignMove(SemaRef.Context.IntTy.$QualType());
        Invalid = true;
      }
    }
    
    NonTypeTemplateParmDecl /*P*/ Param;
    if (IsExpandedParameterPack) {
      Param = NonTypeTemplateParmDecl.Create(SemaRef.Context, Owner, D.getInnerLocStart(), D.getLocation(), 
          D.getDepth() - TemplateArgs.getNumLevels(), D.getPosition(), 
          D.getIdentifier(), new QualType(T), DI, new ArrayRef<QualType>(ExpandedParameterPackTypes, false), 
          new ArrayRef<TypeSourceInfo /*P*/ >(ExpandedParameterPackTypesAsWritten, true));
    } else {
      Param = NonTypeTemplateParmDecl.Create(SemaRef.Context, Owner, 
          D.getInnerLocStart(), 
          D.getLocation(), 
          D.getDepth() - TemplateArgs.getNumLevels(), 
          D.getPosition(), 
          D.getIdentifier(), new QualType(T), 
          D.isParameterPack(), DI);
    }
    
    Param.setAccess(AccessSpecifier.AS_public);
    if (Invalid) {
      Param.setInvalidDecl();
    }
    if (D.hasDefaultArgument() && !D.defaultArgumentWasInherited()) {
      EnterExpressionEvaluationContext ConstantEvaluated = null;
      try {
        ConstantEvaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
            Sema.ExpressionEvaluationContext.ConstantEvaluated);
        ActionResultTTrue<Expr /*P*/ > Value = SemaRef.SubstExpr(D.getDefaultArgument(), TemplateArgs);
        if (!Value.isInvalid()) {
          Param.setDefaultArgument(Value.get());
        }
      } finally {
        if (ConstantEvaluated != null) { ConstantEvaluated.$destroy(); }
      }
    }
    
    // Introduce this template parameter's instantiation into the instantiation
    // scope.
    SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, Param);
    return Param;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 601,
   FQN="clang::TemplateDeclInstantiator::VisitVarDecl", NM="_ZN5clang24TemplateDeclInstantiator12VisitVarDeclEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator12VisitVarDeclEPNS_7VarDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarDecl(VarDecl /*P*/ D) {
    return VisitVarDecl(D, /*InstantiatingVarTemplate=*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitOMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2641,
   FQN="clang::TemplateDeclInstantiator::VisitOMPCapturedExprDecl", NM="_ZN5clang24TemplateDeclInstantiator24VisitOMPCapturedExprDeclEPNS_19OMPCapturedExprDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator24VisitOMPCapturedExprDeclEPNS_19OMPCapturedExprDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitOMPCapturedExprDecl(OMPCapturedExprDecl /*P*/ $Prm0/*D*/) {
    throw new llvm_unreachable("Should not be met in templates");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2004,
   FQN="clang::TemplateDeclInstantiator::VisitParmVarDecl", NM="_ZN5clang24TemplateDeclInstantiator16VisitParmVarDeclEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator16VisitParmVarDeclEPNS_11ParmVarDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitParmVarDecl(ParmVarDecl /*P*/ D) {
    return SemaRef.SubstParmVarDecl(D, TemplateArgs, /*indexAdjustment*/ 0, new OptionalUInt(None), 
        /*ExpectParameterPack=*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2799,
   FQN="clang::TemplateDeclInstantiator::VisitVarTemplateSpecializationDecl", NM="_ZN5clang24TemplateDeclInstantiator34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarTemplateSpecializationDecl(VarTemplateSpecializationDecl /*P*/ D) {
    TemplateArgumentListInfo VarTemplateArgsInfo = null;
    try {
      
      VarTemplateArgsInfo/*J*/= new TemplateArgumentListInfo();
      VarTemplateDecl /*P*/ VarTemplate = D.getSpecializedTemplate();
      assert ((VarTemplate != null)) : "A template specialization without specialized template?";
      
      // Substitute the current template arguments.
      final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgsInfo = D.getTemplateArgsInfo();
      VarTemplateArgsInfo.setLAngleLoc(TemplateArgsInfo.getLAngleLoc());
      VarTemplateArgsInfo.setRAngleLoc(TemplateArgsInfo.getRAngleLoc());
      if (SemaRef.Subst(TemplateArgsInfo.getArgumentArray(), 
          TemplateArgsInfo.size(), VarTemplateArgsInfo, TemplateArgs)) {
        return null;
      }
      
      // Check that the template argument list is well-formed for this template.
      SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
      if (SemaRef.CheckTemplateArgumentList(VarTemplate, VarTemplate.getLocStart(), 
          ((/*const_cast*/TemplateArgumentListInfo /*&*/ )(VarTemplateArgsInfo)), false, 
          _Converted)) {
        return null;
      }
      
      // Find the variable template specialization declaration that
      // corresponds to these arguments.
      final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      {
        VarTemplateSpecializationDecl /*P*/ VarSpec = VarTemplate.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
        if ((VarSpec != null)) {
          // If we already have a variable template specialization, return it.
          return VarSpec;
        }
      }
      
      return VisitVarTemplateSpecializationDecl(VarTemplate, D, InsertPos.$deref(), 
          VarTemplateArgsInfo, new ArrayRef<TemplateArgument>(_Converted, false));
    } finally {
      if (VarTemplateArgsInfo != null) { VarTemplateArgsInfo.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitVarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1301,
   FQN="clang::TemplateDeclInstantiator::VisitVarTemplatePartialSpecializationDecl", NM="_ZN5clang24TemplateDeclInstantiator41VisitVarTemplatePartialSpecializationDeclEPNS_36VarTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator41VisitVarTemplatePartialSpecializationDeclEPNS_36VarTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarTemplatePartialSpecializationDecl(VarTemplatePartialSpecializationDecl /*P*/ D) {
    assert (D.isStaticDataMember()) : "Only static data member templates are allowed.";
    
    VarTemplateDecl /*P*/ VarTemplate = D.getSpecializedTemplate();
    
    // Lookup the already-instantiated declaration and return that.
    DeclContextLookupResult Found = Owner.lookup(VarTemplate.getDeclName());
    assert (!Found.empty()) : "Instantiation found nothing?";
    
    VarTemplateDecl /*P*/ InstVarTemplate = dyn_cast_VarTemplateDecl(Found.front());
    assert ((InstVarTemplate != null)) : "Instantiation did not find a variable template?";
    {
      
      VarTemplatePartialSpecializationDecl /*P*/ Result = InstVarTemplate.findPartialSpecInstantiatedFromMember(D);
      if ((Result != null)) {
        return Result;
      }
    }
    
    return InstantiateVarTemplatePartialSpecialization(InstVarTemplate, D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1026,
   FQN="clang::TemplateDeclInstantiator::VisitEnumConstantDecl", NM="_ZN5clang24TemplateDeclInstantiator21VisitEnumConstantDeclEPNS_16EnumConstantDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator21VisitEnumConstantDeclEPNS_16EnumConstantDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitEnumConstantDecl(EnumConstantDecl /*P*/ D) {
    throw new llvm_unreachable("EnumConstantDecls can only occur within EnumDecls.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitIndirectFieldDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 789,
   FQN="clang::TemplateDeclInstantiator::VisitIndirectFieldDecl", NM="_ZN5clang24TemplateDeclInstantiator22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitIndirectFieldDecl(IndirectFieldDecl /*P*/ D) {
    type$ptr<NamedDecl /*P*/ /*P*/> NamedChain = (/*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ create_type$ptr(new NamedDecl /*P*/ [D.getChainingSize()]));
    
    int i = 0;
    for (NamedDecl /*P*/ PI : D.chain()) {
      NamedDecl /*P*/ Next = SemaRef.FindInstantiatedDecl(D.getLocation(), PI, 
          TemplateArgs);
      if (!(Next != null)) {
        return null;
      }
      
      NamedChain.$set(i++, Next);
    }
    
    QualType T = cast_FieldDecl(NamedChain.$at(i - 1)).getType();
    IndirectFieldDecl /*P*/ IndirectField = IndirectFieldDecl.Create(SemaRef.Context, Owner, D.getLocation(), D.getIdentifier(), new QualType(T), 
        /*{ */new MutableArrayRef<NamedDecl /*P*/ >(NamedChain, D.getChainingSize(), true)/* }*/);
    
    for (/*const*/ Attr /*P*/ $Attr : D.attrs())  {
      IndirectField.addAttr($Attr.clone(SemaRef.Context));
    }
    
    IndirectField.setImplicit(D.isImplicit());
    IndirectField.setAccess(D.getAccess());
    Owner.addDecl(IndirectField);
    return IndirectField;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitOMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2566,
   FQN="clang::TemplateDeclInstantiator::VisitOMPDeclareReductionDecl", NM="_ZN5clang24TemplateDeclInstantiator28VisitOMPDeclareReductionDeclEPNS_23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator28VisitOMPDeclareReductionDeclEPNS_23OMPDeclareReductionDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitOMPDeclareReductionDecl(OMPDeclareReductionDecl /*P*/ D) {
    // Instantiate type and check if it is allowed.
    QualType SubstReductionType = SemaRef.ActOnOpenMPDeclareReductionType(D.getLocation(), 
        new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, OpaquePtr.<QualType>make(SemaRef.SubstType(D.getType(), TemplateArgs, 
                    D.getLocation(), new DeclarationName()))));
    if (SubstReductionType.isNull()) {
      return null;
    }
    boolean IsCorrect = !SubstReductionType.isNull();
    // Create instantiated copy.
    std.pair<QualType, SourceLocation> ReductionTypes[/*1*/] = new std.pair [/*1*/] {std.make_pair_T_T(SubstReductionType, D.getLocation())};
    OMPDeclareReductionDecl /*P*/ PrevDeclInScope = D.getPrevDeclInScope();
    if ((PrevDeclInScope != null) && !PrevDeclInScope.isInvalidDecl()) {
      PrevDeclInScope = cast_OMPDeclareReductionDecl(SemaRef.CurrentInstantiationScope.findInstantiationOf(PrevDeclInScope).get(Decl /*P*/.class));
    }
    OpaquePtr<DeclGroupRef> DRD = SemaRef.ActOnOpenMPDeclareReductionDirectiveStart(/*S=*/ (Scope /*P*/ )null, Owner, D.getDeclName(), new ArrayRef<std.pair<QualType, SourceLocation>>(ReductionTypes, false), D.getAccess(), 
        PrevDeclInScope);
    OMPDeclareReductionDecl /*P*/ NewDRD = cast_OMPDeclareReductionDecl(DRD.getDeclGroupRef().getSingleDecl());
    if (isDeclWithinFunction(NewDRD)) {
      SemaRef.CurrentInstantiationScope.InstantiatedLocal(D, NewDRD);
    }
    Expr /*P*/ SubstCombiner = null;
    Expr /*P*/ SubstInitializer = null;
    // Combiners instantiation sequence.
    if ((D.getCombiner() != null)) {
      SemaRef.ActOnOpenMPDeclareReductionCombinerStart(/*S=*/ (Scope /*P*/ )null, NewDRD);
      /*const*/char$ptr/*char P*/ Names[/*2*/] = (new /*const*/char$ptr/*char P*/ [/*2*/] {$("omp_in"), $("omp_out")});
      for (final char$ptr/*const char P &*/ Name : Names) {
        DeclarationName DN/*J*/= new DeclarationName($AddrOf(SemaRef.Context.Idents.get(new StringRef(Name))));
        DeclContextLookupResult OldLookup = D.lookup(new DeclarationName(DN));
        DeclContextLookupResult Lookup = NewDRD.lookup(new DeclarationName(DN));
        if (!OldLookup.empty() && !Lookup.empty()) {
          assert (Lookup.size() == 1 && OldLookup.size() == 1);
          SemaRef.CurrentInstantiationScope.InstantiatedLocal(OldLookup.front(), 
              Lookup.front());
        }
      }
      SubstCombiner = SemaRef.SubstExpr(D.getCombiner(), TemplateArgs).get();
      SemaRef.ActOnOpenMPDeclareReductionCombinerEnd(NewDRD, SubstCombiner);
      // Initializers instantiation sequence.
      if ((D.getInitializer() != null)) {
        SemaRef.ActOnOpenMPDeclareReductionInitializerStart(/*S=*/ (Scope /*P*/ )null, NewDRD);
        /*const*/char$ptr/*char P*/ Names$1[/*2*/] = (new /*const*/char$ptr/*char P*/ [/*2*/] {$("omp_orig"), $("omp_priv")});
        for (final char$ptr/*const char P &*/ Name : Names$1) {
          DeclarationName DN/*J*/= new DeclarationName($AddrOf(SemaRef.Context.Idents.get(new StringRef(Name))));
          DeclContextLookupResult OldLookup = D.lookup(new DeclarationName(DN));
          DeclContextLookupResult Lookup = NewDRD.lookup(new DeclarationName(DN));
          if (!OldLookup.empty() && !Lookup.empty()) {
            assert (Lookup.size() == 1 && OldLookup.size() == 1);
            SemaRef.CurrentInstantiationScope.InstantiatedLocal(OldLookup.front(), Lookup.front());
          }
        }
        SubstInitializer
           = SemaRef.SubstExpr(D.getInitializer(), TemplateArgs).get();
        SemaRef.ActOnOpenMPDeclareReductionInitializerEnd(NewDRD, 
            SubstInitializer);
      }
      IsCorrect = IsCorrect && (SubstCombiner != null)
         && (!(D.getInitializer() != null) || (SubstInitializer != null));
    } else {
      IsCorrect = false;
    }
    
    /*J:(void)*/SemaRef.ActOnOpenMPDeclareReductionDirectiveEnd(/*S=*/ (Scope /*P*/ )null, new OpaquePtr<DeclGroupRef>(DRD), 
        IsCorrect);
    
    return NewDRD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitUnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2490,
   FQN="clang::TemplateDeclInstantiator::VisitUnresolvedUsingValueDecl", NM="_ZN5clang24TemplateDeclInstantiator29VisitUnresolvedUsingValueDeclEPNS_24UnresolvedUsingValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator29VisitUnresolvedUsingValueDeclEPNS_24UnresolvedUsingValueDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitUnresolvedUsingValueDecl(UnresolvedUsingValueDecl /*P*/ D) {
    CXXScopeSpec SS = null;
    try {
      NestedNameSpecifierLoc QualifierLoc = SemaRef.SubstNestedNameSpecifierLoc(D.getQualifierLoc(), TemplateArgs);
      if (!QualifierLoc.$bool()) {
        return null;
      }
      
      SS/*J*/= new CXXScopeSpec();
      SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
      
      DeclarationNameInfo NameInfo = SemaRef.SubstDeclarationNameInfo(D.getNameInfo(), TemplateArgs);
      
      NamedDecl /*P*/ UD = SemaRef.BuildUsingDeclaration(/*Scope*/ (Scope /*P*/ )null, D.getAccess(), 
          D.getUsingLoc(), SS, new DeclarationNameInfo(NameInfo), (AttributeList /*P*/ )null, 
          /*instantiation*/ true, 
          /*typename*/ false, new SourceLocation());
      if ((UD != null)) {
        SemaRef.Context.setInstantiatedFromUsingDecl(cast_UsingDecl(UD), D);
      }
      
      return UD;
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitOMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2548,
   FQN="clang::TemplateDeclInstantiator::VisitOMPThreadPrivateDecl", NM="_ZN5clang24TemplateDeclInstantiator25VisitOMPThreadPrivateDeclEPNS_20OMPThreadPrivateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator25VisitOMPThreadPrivateDeclEPNS_20OMPThreadPrivateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitOMPThreadPrivateDecl(OMPThreadPrivateDecl /*P*/ D) {
    SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(5, (Expr /*P*/ )null);
    for (Expr /*P*/ I : D.varlists()) {
      Expr /*P*/ Var = SemaRef.SubstExpr(I, TemplateArgs).get();
      assert (isa_DeclRefExpr(Var)) : "threadprivate arg is not a DeclRefExpr";
      Vars.push_back(Var);
    }
    
    OMPThreadPrivateDecl /*P*/ TD = SemaRef.CheckOMPThreadPrivateDecl(D.getLocation(), new ArrayRef<Expr /*P*/ >(Vars, true));
    
    TD.setAccess(AccessSpecifier.AS_public);
    Owner.addDecl(TD);
    
    return TD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitPragmaCommentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 427,
   FQN="clang::TemplateDeclInstantiator::VisitPragmaCommentDecl", NM="_ZN5clang24TemplateDeclInstantiator22VisitPragmaCommentDeclEPNS_17PragmaCommentDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator22VisitPragmaCommentDeclEPNS_17PragmaCommentDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitPragmaCommentDecl(PragmaCommentDecl /*P*/ D) {
    throw new llvm_unreachable("pragma comment cannot be instantiated");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitPragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 432,
   FQN="clang::TemplateDeclInstantiator::VisitPragmaDetectMismatchDecl", NM="_ZN5clang24TemplateDeclInstantiator29VisitPragmaDetectMismatchDeclEPNS_24PragmaDetectMismatchDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator29VisitPragmaDetectMismatchDeclEPNS_24PragmaDetectMismatchDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitPragmaDetectMismatchDecl(PragmaDetectMismatchDecl /*P*/ D) {
    throw new llvm_unreachable("pragma comment cannot be instantiated");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitStaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 865,
   FQN="clang::TemplateDeclInstantiator::VisitStaticAssertDecl", NM="_ZN5clang24TemplateDeclInstantiator21VisitStaticAssertDeclEPNS_16StaticAssertDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator21VisitStaticAssertDeclEPNS_16StaticAssertDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitStaticAssertDecl(StaticAssertDecl /*P*/ D) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      Expr /*P*/ AssertExpr = D.getAssertExpr();
      
      // The expression in a static assertion is a constant expression.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
          Sema.ExpressionEvaluationContext.ConstantEvaluated);
      
      ActionResultTTrue<Expr /*P*/ > InstantiatedAssertExpr = SemaRef.SubstExpr(AssertExpr, TemplateArgs);
      if (InstantiatedAssertExpr.isInvalid()) {
        return null;
      }
      
      return SemaRef.BuildStaticAssertDeclaration(D.getLocation(), 
          InstantiatedAssertExpr.get(), 
          D.getMessage(), 
          D.getRParenLoc(), 
          D.isFailed());
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 422,
   FQN="clang::TemplateDeclInstantiator::VisitTranslationUnitDecl", NM="_ZN5clang24TemplateDeclInstantiator24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTranslationUnitDecl(TranslationUnitDecl /*P*/ D) {
    throw new llvm_unreachable("Translation units cannot be instantiated");
  }

  
  // A few supplemental visitor functions.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitCXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1754,
   FQN="clang::TemplateDeclInstantiator::VisitCXXMethodDecl", NM="_ZN5clang24TemplateDeclInstantiator18VisitCXXMethodDeclEPNS_13CXXMethodDeclEPNS_21TemplateParameterListEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator18VisitCXXMethodDeclEPNS_13CXXMethodDeclEPNS_21TemplateParameterListEb")
  //</editor-fold>
  public Decl /*P*/ VisitCXXMethodDecl(CXXMethodDecl /*P*/ D, 
                    TemplateParameterList /*P*/ TemplateParams) {
    return VisitCXXMethodDecl(D, 
                    TemplateParams, 
                    false);
  }
  public Decl /*P*/ VisitCXXMethodDecl(CXXMethodDecl /*P*/ D, 
                    TemplateParameterList /*P*/ TemplateParams, 
                    boolean IsClassScopeSpecialization/*= false*/) {
    LocalInstantiationScope Scope = null;
    LookupResult Previous = null;
    try {
      FunctionTemplateDecl /*P*/ FunctionTemplate = D.getDescribedFunctionTemplate();
      if ((FunctionTemplate != null) && !(TemplateParams != null)) {
        // We are creating a function template specialization from a function
        // template. Check whether there is already a function template
        // specialization for this particular set of template arguments.
        ArrayRef<TemplateArgument> Innermost = new ArrayRef<TemplateArgument>(TemplateArgs.getInnermost());
        
        final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
        FunctionDecl /*P*/ SpecFunc = FunctionTemplate.findSpecialization(new ArrayRef<TemplateArgument>(Innermost), InsertPos);
        
        // If we already have a function template specialization, return it.
        if ((SpecFunc != null)) {
          return SpecFunc;
        }
      }
      
      boolean isFriend;
      if ((FunctionTemplate != null)) {
        isFriend = (FunctionTemplate.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
      } else {
        isFriend = (D.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
      }
      
      boolean MergeWithParentScope = (TemplateParams != null)
         || !(isa_Decl(Owner)
         && cast_Decl(Owner).isDefinedOutsideFunctionOrMethod());
      Scope/*J*/= new LocalInstantiationScope(SemaRef, MergeWithParentScope);
      
      // Instantiate enclosing template arguments for friends.
      SmallVector<TemplateParameterList /*P*/> TempParamLists/*J*/= new SmallVector<TemplateParameterList /*P*/>(4, null);
      /*uint*/int NumTempParamLists = 0;
      if (isFriend && ((NumTempParamLists = D.getNumTemplateParameterLists()) != 0)) {
        TempParamLists.resize(NumTempParamLists);
        for (/*uint*/int I = 0; I != NumTempParamLists; ++I) {
          TemplateParameterList /*P*/ TempParams = D.getTemplateParameterList(I);
          TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
          if (!(InstParams != null)) {
            return null;
          }
          TempParamLists.$set(I, InstParams);
        }
      }
      
      SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
      TypeSourceInfo /*P*/ TInfo = SubstFunctionType(D, Params);
      if (!(TInfo != null)) {
        return null;
      }
      QualType T = adjustFunctionTypeForInstantiation(SemaRef.Context, D, TInfo);
      
      NestedNameSpecifierLoc QualifierLoc = D.getQualifierLoc();
      if (QualifierLoc.$bool()) {
        QualifierLoc.$assignMove(SemaRef.SubstNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc), 
                TemplateArgs));
        if (!QualifierLoc.$bool()) {
          return null;
        }
      }
      
      DeclContext /*P*/ DC = Owner;
      if (isFriend) {
        if (QualifierLoc.$bool()) {
          CXXScopeSpec SS = null;
          try {
            SS/*J*/= new CXXScopeSpec();
            SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
            DC = SemaRef.computeDeclContext(SS);
            if ((DC != null) && SemaRef.RequireCompleteDeclContext(SS, DC)) {
              return null;
            }
          } finally {
            if (SS != null) { SS.$destroy(); }
          }
        } else {
          DC = SemaRef.FindInstantiatedContext(D.getLocation(), 
              D.getDeclContext(), 
              TemplateArgs);
        }
        if (!(DC != null)) {
          return null;
        }
      }
      
      // Build the instantiated method declaration.
      CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(DC);
      CXXMethodDecl /*P*/ Method = null;
      
      SourceLocation StartLoc = D.getInnerLocStart();
      DeclarationNameInfo NameInfo = SemaRef.SubstDeclarationNameInfo(D.getNameInfo(), TemplateArgs);
      {
        CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(D);
        if ((Constructor != null)) {
          Method = CXXConstructorDecl.Create(SemaRef.Context, Record, 
              new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
              Constructor.isExplicit(), 
              Constructor.isInlineSpecified(), 
              false, Constructor.isConstexpr());
        } else {
          CXXDestructorDecl /*P*/ Destructor = dyn_cast_CXXDestructorDecl(D);
          if ((Destructor != null)) {
            Method = CXXDestructorDecl.Create(SemaRef.Context, Record, 
                new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
                Destructor.isInlineSpecified(), 
                false);
          } else {
            CXXConversionDecl /*P*/ Conversion = dyn_cast_CXXConversionDecl(D);
            if ((Conversion != null)) {
              Method = CXXConversionDecl.Create(SemaRef.Context, Record, 
                  new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
                  Conversion.isInlineSpecified(), 
                  Conversion.isExplicit(), 
                  Conversion.isConstexpr(), 
                  Conversion.getLocEnd());
            } else {
              StorageClass SC = D.isStatic() ? StorageClass.SC_Static : StorageClass.SC_None;
              Method = CXXMethodDecl.Create(SemaRef.Context, Record, 
                  new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
                  SC, D.isInlineSpecified(), 
                  D.isConstexpr(), D.getLocEnd());
            }
          }
        }
      }
      if (D.isInlined()) {
        Method.setImplicitlyInline();
      }
      if (QualifierLoc.$bool()) {
        Method.setQualifierInfo(new NestedNameSpecifierLoc(QualifierLoc));
      }
      if ((TemplateParams != null)) {
        // Our resulting instantiation is actually a function template, since we
        // are substituting only the outer template parameters. For example, given
        //
        //   template<typename T>
        //   struct X {
        //     template<typename U> void f(T, U);
        //   };
        //
        //   X<int> x;
        //
        // We are instantiating the member template "f" within X<int>, which means
        // substituting int for T, but leaving "f" as a member function template.
        // Build the function template itself.
        FunctionTemplate = FunctionTemplateDecl.Create(SemaRef.Context, Record, 
            Method.getLocation(), 
            Method.getDeclName(), 
            TemplateParams, Method);
        if (isFriend) {
          FunctionTemplate.setLexicalDeclContext(Owner);
          FunctionTemplate.setObjectOfFriendDecl();
        } else if (D.isOutOfLine()) {
          FunctionTemplate.setLexicalDeclContext(D.getLexicalDeclContext());
        }
        Method.setDescribedFunctionTemplate(FunctionTemplate);
      } else if ((FunctionTemplate != null)) {
        // Record this function template specialization.
        ArrayRef<TemplateArgument> Innermost = new ArrayRef<TemplateArgument>(TemplateArgs.getInnermost());
        Method.setFunctionTemplateSpecialization(FunctionTemplate, 
            TemplateArgumentList.CreateCopy(SemaRef.Context, 
                new ArrayRef<TemplateArgument>(Innermost)), 
            /*InsertPos=*/ (type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ )null);
      } else if (!isFriend) {
        // Record that this is an instantiation of a member function.
        Method.setInstantiationOfMemberFunction(D, TemplateSpecializationKind.TSK_ImplicitInstantiation);
      }
      
      // If we are instantiating a member function defined
      // out-of-line, the instantiation will have the same lexical
      // context (which will be a namespace scope) as the template.
      if (isFriend) {
        if ((NumTempParamLists != 0)) {
          Method.setTemplateParameterListsInfo(SemaRef.Context, 
              llvm.makeArrayRef(TempParamLists.data(), NumTempParamLists));
        }
        
        Method.setLexicalDeclContext(Owner);
        Method.setObjectOfFriendDecl();
      } else if (D.isOutOfLine()) {
        Method.setLexicalDeclContext(D.getLexicalDeclContext());
      }
      
      // Attach the parameters
      for (/*uint*/int P = 0; $less_uint(P, Params.size()); ++P)  {
        Params.$at(P).setOwningFunction(Method);
      }
      Method.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
      if (InitMethodInstantiation(Method, D)) {
        Method.setInvalidDecl();
      }
      
      Previous/*J*/= new LookupResult(SemaRef, NameInfo, Sema.LookupNameKind.LookupOrdinaryName, 
          Sema.RedeclarationKind.ForRedeclaration);
      if (!(FunctionTemplate != null) || (TemplateParams != null) || isFriend) {
        SemaRef.LookupQualifiedName(Previous, Record);
        
        // In C++, the previous declaration we find might be a tag type
        // (class or enum). In this case, the new declaration will hide the
        // tag type. Note that this does does not apply if we're declaring a
        // typedef (C++ [dcl.typedef]p4).
        if (Previous.isSingleTagDecl()) {
          Previous.clear();
        }
      }
      if (!IsClassScopeSpecialization) {
        SemaRef.CheckFunctionDeclaration((Scope /*P*/ )null, Method, Previous, false);
      }
      if (D.isPure()) {
        SemaRef.CheckPureMethod(Method, new SourceRange());
      }
      
      // Propagate access.  For a non-friend declaration, the access is
      // whatever we're propagating from.  For a friend, it should be the
      // previous declaration we just found.
      if (isFriend && (Method.getPreviousDecl() != null)) {
        Method.setAccess(Method.getPreviousDecl().getAccess());
      } else {
        Method.setAccess(D.getAccess());
      }
      if ((FunctionTemplate != null)) {
        FunctionTemplate.setAccess(Method.getAccess());
      }
      
      SemaRef.CheckOverrideControl(Method);
      
      // If a function is defined as defaulted or deleted, mark it as such now.
      if (D.isExplicitlyDefaulted()) {
        SemaRef.SetDeclDefaulted(Method, Method.getLocation());
      }
      if (D.isDeletedAsWritten()) {
        SemaRef.SetDeclDeleted(Method, Method.getLocation());
      }
      
      // If there's a function template, let our caller handle it.
      if ((FunctionTemplate != null)) {

        // do nothing

        // Don't hide a (potentially) valid declaration with an invalid one.
      } else if (Method.isInvalidDecl() && !Previous.empty()) {

        // do nothing

        // Otherwise, check access to friends and make them visible.
      } else if (isFriend) {
        // We only need to re-check access for methods which we didn't
        // manage to match during parsing.
        if (!(D.getPreviousDecl() != null)) {
          SemaRef.CheckFriendAccess(Method);
        }
        
        Record.makeDeclVisibleInContext(Method);
        // Otherwise, add the declaration.  We don't need to do this for
        // class-scope specializations because we'll have matched them with
        // the appropriate template.
      } else if (!IsClassScopeSpecialization) {
        Owner.addDecl(Method);
      }
      
      return Method;
    } finally {
      if (Previous != null) { Previous.$destroy(); }
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  
  /// Normal class members are of more specific types and therefore
  /// don't make it here.  This function serves two purposes:
  ///   1) instantiating function templates
  ///   2) substituting friend declarations
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 1481,
   FQN="clang::TemplateDeclInstantiator::VisitFunctionDecl", NM="_ZN5clang24TemplateDeclInstantiator17VisitFunctionDeclEPNS_12FunctionDeclEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator17VisitFunctionDeclEPNS_12FunctionDeclEPNS_21TemplateParameterListE")
  //</editor-fold>
  public Decl /*P*/ VisitFunctionDecl(FunctionDecl /*P*/ D, 
                   TemplateParameterList /*P*/ TemplateParams) {
    LocalInstantiationScope Scope = null;
    LookupResult Previous = null;
    try {
      // Check whether there is already a function template specialization for
      // this declaration.
      FunctionTemplateDecl /*P*/ FunctionTemplate = D.getDescribedFunctionTemplate();
      if ((FunctionTemplate != null) && !(TemplateParams != null)) {
        ArrayRef<TemplateArgument> Innermost = new ArrayRef<TemplateArgument>(TemplateArgs.getInnermost());
        
        final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
        FunctionDecl /*P*/ SpecFunc = FunctionTemplate.findSpecialization(new ArrayRef<TemplateArgument>(Innermost), InsertPos);
        
        // If we already have a function template specialization, return it.
        if ((SpecFunc != null)) {
          return SpecFunc;
        }
      }
      
      boolean isFriend;
      if ((FunctionTemplate != null)) {
        isFriend = (FunctionTemplate.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
      } else {
        isFriend = (D.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
      }
      
      boolean MergeWithParentScope = (TemplateParams != null)
         || Owner.isFunctionOrMethod()
         || !(isa_Decl(Owner)
         && cast_Decl(Owner).isDefinedOutsideFunctionOrMethod());
      Scope/*J*/= new LocalInstantiationScope(SemaRef, MergeWithParentScope);
      
      SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(4, (ParmVarDecl /*P*/ )null);
      TypeSourceInfo /*P*/ TInfo = SubstFunctionType(D, Params);
      if (!(TInfo != null)) {
        return null;
      }
      QualType T = adjustFunctionTypeForInstantiation(SemaRef.Context, D, TInfo);
      
      NestedNameSpecifierLoc QualifierLoc = D.getQualifierLoc();
      if (QualifierLoc.$bool()) {
        QualifierLoc.$assignMove(SemaRef.SubstNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc), 
                TemplateArgs));
        if (!QualifierLoc.$bool()) {
          return null;
        }
      }
      
      // If we're instantiating a local function declaration, put the result
      // in the enclosing namespace; otherwise we need to find the instantiated
      // context.
      type$ref<DeclContext /*P*/ > DC = create_type$null$ref();
      if (D.isLocalExternDecl()) {
        DC.$set(Owner);
        SemaRef.adjustContextForLocalExternDecl(DC);
      } else if (isFriend && QualifierLoc.$bool()) {
        CXXScopeSpec SS = null;
        try {
          SS/*J*/= new CXXScopeSpec();
          SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
          DC.$set(SemaRef.computeDeclContext(SS));
          if (!(DC.$deref() != null)) {
            return null;
          }
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      } else {
        DC.$set(SemaRef.FindInstantiatedContext(D.getLocation(), D.getDeclContext(), 
            TemplateArgs));
      }
      
      FunctionDecl /*P*/ Function = FunctionDecl.Create(SemaRef.Context, DC.$deref(), D.getInnerLocStart(), 
          D.getNameInfo(), new QualType(T), TInfo, 
          D.getCanonicalDecl().getStorageClass(), 
          D.isInlineSpecified(), D.hasWrittenPrototype(), 
          D.isConstexpr());
      Function.setRangeEnd(D.getSourceRange().getEnd());
      if (D.isInlined()) {
        Function.setImplicitlyInline();
      }
      if (QualifierLoc.$bool()) {
        Function.setQualifierInfo(new NestedNameSpecifierLoc(QualifierLoc));
      }
      if (D.isLocalExternDecl()) {
        Function.setLocalExternDecl();
      }
      
      DeclContext /*P*/ LexicalDC = Owner;
      if (!isFriend && D.isOutOfLine() && !D.isLocalExternDecl()) {
        assert (D.getDeclContext().isFileContext());
        LexicalDC = D.getDeclContext();
      }
      
      Function.setLexicalDeclContext(LexicalDC);
      
      // Attach the parameters
      for (/*uint*/int P = 0; $less_uint(P, Params.size()); ++P)  {
        if ((Params.$at(P) != null)) {
          Params.$at(P).setOwningFunction(Function);
        }
      }
      Function.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
      
      SourceLocation InstantiateAtPOI/*J*/= new SourceLocation();
      if ((TemplateParams != null)) {
        // Our resulting instantiation is actually a function template, since we
        // are substituting only the outer template parameters. For example, given
        //
        //   template<typename T>
        //   struct X {
        //     template<typename U> friend void f(T, U);
        //   };
        //
        //   X<int> x;
        //
        // We are instantiating the friend function template "f" within X<int>,
        // which means substituting int for T, but leaving "f" as a friend function
        // template.
        // Build the function template itself.
        FunctionTemplate = FunctionTemplateDecl.Create(SemaRef.Context, DC.$deref(), 
            Function.getLocation(), 
            Function.getDeclName(), 
            TemplateParams, Function);
        Function.setDescribedFunctionTemplate(FunctionTemplate);
        
        FunctionTemplate.setLexicalDeclContext(LexicalDC);
        if (isFriend && D.isThisDeclarationADefinition()) {
          // TODO: should we remember this connection regardless of whether
          // the friend declaration provided a body?
          FunctionTemplate.setInstantiatedFromMemberTemplate(D.getDescribedFunctionTemplate());
        }
      } else if ((FunctionTemplate != null)) {
        // Record this function template specialization.
        ArrayRef<TemplateArgument> Innermost = new ArrayRef<TemplateArgument>(TemplateArgs.getInnermost());
        Function.setFunctionTemplateSpecialization(FunctionTemplate, 
            TemplateArgumentList.CreateCopy(SemaRef.Context, 
                new ArrayRef<TemplateArgument>(Innermost)), 
            /*InsertPos=*/ (type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ )null);
      } else if (isFriend) {
        // Note, we need this connection even if the friend doesn't have a body.
        // Its body may exist but not have been attached yet due to deferred
        // parsing.
        // FIXME: It might be cleaner to set this when attaching the body to the
        // friend function declaration, however that would require finding all the
        // instantiations and modifying them.
        Function.setInstantiationOfMemberFunction(D, TemplateSpecializationKind.TSK_ImplicitInstantiation);
      }
      if (InitFunctionInstantiation(Function, D)) {
        Function.setInvalidDecl();
      }
      
      boolean isExplicitSpecialization = false;
      
      Previous/*J*/= new LookupResult(SemaRef, Function.getDeclName(), new SourceLocation(), 
          D.isLocalExternDecl() ? Sema.LookupNameKind.LookupRedeclarationWithLinkage : Sema.LookupNameKind.LookupOrdinaryName, 
          Sema.RedeclarationKind.ForRedeclaration);
      {
        
        DependentFunctionTemplateSpecializationInfo /*P*/ Info = D.getDependentSpecializationInfo();
        if ((Info != null)) {
          TemplateArgumentListInfo ExplicitArgs = null;
          try {
            assert (isFriend) : "non-friend has dependent specialization info?";
            
            // This needs to be set now for future sanity.
            Function.setObjectOfFriendDecl();
            
            // Instantiate the explicit template arguments.
            ExplicitArgs/*J*/= new TemplateArgumentListInfo(Info.getLAngleLoc(), 
                Info.getRAngleLoc());
            if (SemaRef.Subst(Info.getTemplateArgs(), Info.getNumTemplateArgs(), 
                ExplicitArgs, TemplateArgs)) {
              return null;
            }
            
            // Map the candidate templates to their instantiations.
            for (/*uint*/int I = 0, E = Info.getNumTemplates(); I != E; ++I) {
              Decl /*P*/ Temp = SemaRef.FindInstantiatedDecl(D.getLocation(), 
                  Info.getTemplate(I), 
                  TemplateArgs);
              if (!(Temp != null)) {
                return null;
              }
              
              Previous.addDecl(cast_FunctionTemplateDecl(Temp));
            }
            if (SemaRef.CheckFunctionTemplateSpecialization(Function, 
                $AddrOf(ExplicitArgs), 
                Previous)) {
              Function.setInvalidDecl();
            }
            
            isExplicitSpecialization = true;
          } finally {
            if (ExplicitArgs != null) { ExplicitArgs.$destroy(); }
          }
        } else if ((TemplateParams != null) || !(FunctionTemplate != null)) {
          // Look only into the namespace where the friend would be declared to
          // find a previous declaration. This is the innermost enclosing namespace,
          // as described in ActOnFriendFunctionDecl.
          SemaRef.LookupQualifiedName(Previous, DC.$deref());
          
          // In C++, the previous declaration we find might be a tag type
          // (class or enum). In this case, the new declaration will hide the
          // tag type. Note that this does does not apply if we're declaring a
          // typedef (C++ [dcl.typedef]p4).
          if (Previous.isSingleTagDecl()) {
            Previous.clear();
          }
        }
      }
      
      SemaRef.CheckFunctionDeclaration(/*Scope*/ (Scope /*P*/ )null, Function, Previous, 
          isExplicitSpecialization);
      
      NamedDecl /*P*/ PrincipalDecl = ((TemplateParams != null) ? cast_NamedDecl(FunctionTemplate) : Function);
      
      // If the original function was part of a friend declaration,
      // inherit its namespace state and add it to the owner.
      if (isFriend) {
        PrincipalDecl.setObjectOfFriendDecl();
        DC.$deref().makeDeclVisibleInContext(PrincipalDecl);
        
        boolean QueuedInstantiation = false;
        
        // C++11 [temp.friend]p4 (DR329):
        //   When a function is defined in a friend function declaration in a class
        //   template, the function is instantiated when the function is odr-used.
        //   The same restrictions on multiple declarations and definitions that
        //   apply to non-template function declarations and definitions also apply
        //   to these implicit definitions.
        if (D.isThisDeclarationADefinition()) {
          // Check for a function body.
          type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$null$ref(null);
          if (Function.isDefined(Definition)
             && Definition.$deref().getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_Undeclared) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Function.getLocation(), diag.err_redefinition)), 
                  Function.getDeclName()));
              $c$.clean($c$.track(SemaRef.Diag(Definition.$deref().getLocation(), diag.note_previous_definition)));
            } finally {
              $c$.$destroy();
            }
          } else {
            // Check for redefinitions due to other instantiations of this or
            // a similar friend function.
            for (FunctionDecl /*P*/ R : Function.redeclarable_redecls()) {
              if (R == Function) {
                continue;
              }
              
              // If some prior declaration of this function has been used, we need
              // to instantiate its definition.
              if (!QueuedInstantiation && R.isUsed(false)) {
                {
                  MemberSpecializationInfo /*P*/ MSInfo = Function.getMemberSpecializationInfo();
                  if ((MSInfo != null)) {
                    if (MSInfo.getPointOfInstantiation().isInvalid()) {
                      SourceLocation Loc = R.getLocation(); // FIXME
                      MSInfo.setPointOfInstantiation(new SourceLocation(Loc));
                      SemaRef.PendingLocalImplicitInstantiations.push_back_T$RR(std.make_pair_Ptr_T((ValueDecl /*P*/)Function, new SourceLocation(Loc)));
                      QueuedInstantiation = true;
                    }
                  }
                }
              }
              
              // If some prior declaration of this function was a friend with an
              // uninstantiated definition, reject it.
              if ((R.getFriendObjectKind().getValue() != 0)) {
                {
                  type$ref</*const*/ FunctionDecl /*P*/ > RPattern = create_type$ref(R.getTemplateInstantiationPattern());
                  if ((RPattern.$deref() != null)) {
                    if (RPattern.$deref().isDefined(RPattern)) {
                      JavaCleaner $c$ = $createJavaCleaner();
                      try {
                        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Function.getLocation(), diag.err_redefinition)), 
                            Function.getDeclName()));
                        $c$.clean($c$.track(SemaRef.Diag(R.getLocation(), diag.note_previous_definition)));
                        break;
                      } finally {
                        $c$.$destroy();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (Function.isLocalExternDecl() && !(Function.getPreviousDecl() != null)) {
        DC.$deref().makeDeclVisibleInContext(PrincipalDecl);
      }
      if (Function.isOverloadedOperator() && !DC.$deref().isRecord()
         && PrincipalDecl.isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_Ordinary)) {
        PrincipalDecl.setNonMemberOperator();
      }
      assert (!D.isDefaulted()) : "only methods should be defaulted";
      return Function;
    } finally {
      if (Previous != null) { Previous.$destroy(); }
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2887,
   FQN="clang::TemplateDeclInstantiator::VisitDecl", NM="_ZN5clang24TemplateDeclInstantiator9VisitDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator9VisitDeclEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ VisitDecl(Decl /*P*/ D) {
    throw new llvm_unreachable("Unexpected decl");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 605,
   FQN="clang::TemplateDeclInstantiator::VisitVarDecl", NM="_ZN5clang24TemplateDeclInstantiator12VisitVarDeclEPNS_7VarDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator12VisitVarDeclEPNS_7VarDeclEb")
  //</editor-fold>
  public Decl /*P*/ VisitVarDecl(VarDecl /*P*/ D, 
              boolean InstantiatingVarTemplate) {
    
    // Do substitution on the type of the declaration
    TypeSourceInfo /*P*/ DI = SemaRef.SubstType(D.getTypeSourceInfo(), 
        TemplateArgs, 
        D.getTypeSpecStartLoc(), 
        D.getDeclName());
    if (!(DI != null)) {
      return null;
    }
    if (DI.getType().$arrow().isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), diag.err_variable_instantiates_to_function)), 
                D.isStaticDataMember()), DI.getType()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    type$ref<DeclContext /*P*/ > DC = create_type$ref(Owner);
    if (D.isLocalExternDecl()) {
      SemaRef.adjustContextForLocalExternDecl(DC);
    }
    
    // Build the instantiated declaration.
    VarDecl /*P*/ Var = VarDecl.Create(SemaRef.Context, DC.$deref(), D.getInnerLocStart(), 
        D.getLocation(), D.getIdentifier(), 
        DI.getType(), DI, D.getStorageClass());
    
    // In ARC, infer 'retaining' for variables of retainable type.
    if (SemaRef.getLangOpts().ObjCAutoRefCount
       && SemaRef.inferObjCARCLifetime(Var)) {
      Var.setInvalidDecl();
    }
    
    // Substitute the nested name specifier, if any.
    if (SubstQualifier(D, Var)) {
      return null;
    }
    
    SemaRef.BuildVariableInstantiation(Var, D, TemplateArgs, LateAttrs, Owner, 
        StartingScope, InstantiatingVarTemplate);
    if (D.isNRVOVariable()) {
      QualType ReturnType = cast_FunctionDecl(DC.$deref()).getReturnType();
      if (SemaRef.isCopyElisionCandidate(new QualType(ReturnType), Var, false)) {
        Var.setNRVOVariable(true);
      }
    }
    
    Var.setImplicit(D.isImplicit());
    
    return Var;
  }

  
  // Enable late instantiation of attributes.  Late instantiated attributes
  // will be stored in LA.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::enableLateAttributeInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 440,
   FQN="clang::TemplateDeclInstantiator::enableLateAttributeInstantiation", NM="_ZN5clang24TemplateDeclInstantiator32enableLateAttributeInstantiationEPN4llvm11SmallVectorINS_4Sema25LateInstantiatedAttributeELj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator32enableLateAttributeInstantiationEPN4llvm11SmallVectorINS_4Sema25LateInstantiatedAttributeELj16EEE")
  //</editor-fold>
  public void enableLateAttributeInstantiation(SmallVector<LateInstantiatedAttribute> /*P*/ LA) {
    LateAttrs = LA;
    StartingScope = SemaRef.CurrentInstantiationScope;
  }

  
  // Disable late instantiation of attributes.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::disableLateAttributeInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 446,
   FQN="clang::TemplateDeclInstantiator::disableLateAttributeInstantiation", NM="_ZN5clang24TemplateDeclInstantiator33disableLateAttributeInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator33disableLateAttributeInstantiationEv")
  //</editor-fold>
  public void disableLateAttributeInstantiation() {
    LateAttrs = null;
    StartingScope = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::getStartingScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 451,
   FQN="clang::TemplateDeclInstantiator::getStartingScope", NM="_ZNK5clang24TemplateDeclInstantiator16getStartingScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZNK5clang24TemplateDeclInstantiator16getStartingScopeEv")
  //</editor-fold>
  public LocalInstantiationScope /*P*/ getStartingScope() /*const*/ {
    return StartingScope;
  }

  
  /*typedef SmallVectorImpl<std::pair<ClassTemplateDecl *, ClassTemplatePartialSpecializationDecl *> >::iterator delayed_partial_spec_iterator*/
//  public final class delayed_partial_spec_iterator extends type$ptr<std.pair<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/>>{ };
  
  /*typedef SmallVectorImpl<std::pair<VarTemplateDecl *, VarTemplatePartialSpecializationDecl *> >::iterator delayed_var_partial_spec_iterator*/
//  public final class delayed_var_partial_spec_iterator extends type$ptr<std.pair<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/>>{ };
  
  /// \brief Return an iterator to the beginning of the set of
  /// "delayed" partial specializations, which must be passed to
  /// InstantiateClassTemplatePartialSpecialization once the class
  /// definition has been completed.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::delayed_partial_spec_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 467,
   FQN="clang::TemplateDeclInstantiator::delayed_partial_spec_begin", NM="_ZN5clang24TemplateDeclInstantiator26delayed_partial_spec_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator26delayed_partial_spec_beginEv")
  //</editor-fold>
  public type$ptr<std.pair<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/>> delayed_partial_spec_begin() {
    return OutOfLinePartialSpecs.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::delayed_var_partial_spec_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 471,
   FQN="clang::TemplateDeclInstantiator::delayed_var_partial_spec_begin", NM="_ZN5clang24TemplateDeclInstantiator30delayed_var_partial_spec_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator30delayed_var_partial_spec_beginEv")
  //</editor-fold>
  public type$ptr<std.pair<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/>> delayed_var_partial_spec_begin() {
    return OutOfLineVarPartialSpecs.begin();
  }

  
  /// \brief Return an iterator to the end of the set of
  /// "delayed" partial specializations, which must be passed to
  /// InstantiateClassTemplatePartialSpecialization once the class
  /// definition has been completed.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::delayed_partial_spec_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 479,
   FQN="clang::TemplateDeclInstantiator::delayed_partial_spec_end", NM="_ZN5clang24TemplateDeclInstantiator24delayed_partial_spec_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator24delayed_partial_spec_endEv")
  //</editor-fold>
  public type$ptr<std.pair<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/>> delayed_partial_spec_end() {
    return OutOfLinePartialSpecs.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::delayed_var_partial_spec_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 483,
   FQN="clang::TemplateDeclInstantiator::delayed_var_partial_spec_end", NM="_ZN5clang24TemplateDeclInstantiator28delayed_var_partial_spec_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator28delayed_var_partial_spec_endEv")
  //</editor-fold>
  public type$ptr<std.pair<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/>> delayed_var_partial_spec_end() {
    return OutOfLineVarPartialSpecs.end();
  }

  
  // Helper functions for instantiating methods.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::SubstFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3186,
   FQN="clang::TemplateDeclInstantiator::SubstFunctionType", NM="_ZN5clang24TemplateDeclInstantiator17SubstFunctionTypeEPNS_12FunctionDeclERN4llvm15SmallVectorImplIPNS_11ParmVarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator17SubstFunctionTypeEPNS_12FunctionDeclERN4llvm15SmallVectorImplIPNS_11ParmVarDeclEEE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ SubstFunctionType(FunctionDecl /*P*/ D, 
                   final SmallVectorImpl<ParmVarDecl /*P*/ > /*&*/ Params) {
    TypeSourceInfo /*P*/ OldTInfo = D.getTypeSourceInfo();
    assert ((OldTInfo != null)) : "substituting function without type source info";
    assert (Params.empty()) : "parameter vector is non-empty at start";
    
    CXXRecordDecl /*P*/ ThisContext = null;
    /*uint*/int ThisTypeQuals = 0;
    {
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
      if ((Method != null)) {
        ThisContext = cast_CXXRecordDecl(Owner);
        ThisTypeQuals = Method.getTypeQualifiers();
      }
    }
    
    TypeSourceInfo /*P*/ NewTInfo = SemaRef.SubstFunctionDeclType(OldTInfo, TemplateArgs, 
        D.getTypeSpecStartLoc(), 
        D.getDeclName(), 
        ThisContext, ThisTypeQuals);
    if (!(NewTInfo != null)) {
      return null;
    }
    
    TypeLoc OldTL = OldTInfo.getTypeLoc().IgnoreParens();
    {
      FunctionProtoTypeLoc OldProtoLoc = OldTL.getAs(FunctionProtoTypeLoc.class);
      if (OldProtoLoc.$bool()) {
        if (NewTInfo != OldTInfo) {
          // Get parameters from the new type info.
          TypeLoc NewTL = NewTInfo.getTypeLoc().IgnoreParens();
          FunctionProtoTypeLoc NewProtoLoc = NewTL.castAs(FunctionProtoTypeLoc.class);
          /*uint*/int NewIdx = 0;
          for (/*uint*/int OldIdx = 0, NumOldParams = OldProtoLoc.getNumParams();
               OldIdx != NumOldParams; ++OldIdx) {
            ParmVarDecl /*P*/ OldParam = OldProtoLoc.getParam(OldIdx);
            LocalInstantiationScope /*P*/ Scope = SemaRef.CurrentInstantiationScope;
            
            OptionalUInt NumArgumentsInExpansion/*J*/= new OptionalUInt();
            if (OldParam.isParameterPack()) {
              NumArgumentsInExpansion.$assignMove(
                  SemaRef.getNumArgumentsInExpansion(OldParam.getType(), 
                      TemplateArgs)
              );
            }
            if (!NumArgumentsInExpansion.$bool()) {
              // Simple case: normal parameter, or a parameter pack that's
              // instantiated to a (still-dependent) parameter pack.
              ParmVarDecl /*P*/ NewParam = NewProtoLoc.getParam(NewIdx++);
              Params.push_back(NewParam);
              Scope.InstantiatedLocal(OldParam, NewParam);
            } else {
              // Parameter pack expansion: make the instantiation an argument pack.
              Scope.MakeInstantiatedLocalArgPack(OldParam);
              for (/*uint*/int I = 0; I != NumArgumentsInExpansion.$star(); ++I) {
                ParmVarDecl /*P*/ NewParam = NewProtoLoc.getParam(NewIdx++);
                Params.push_back(NewParam);
                Scope.InstantiatedLocalPackArg(OldParam, NewParam);
              }
            }
          }
        } else {
          // The function type itself was not dependent and therefore no
          // substitution occurred. However, we still need to instantiate
          // the function parameters themselves.
          /*const*/ FunctionProtoType /*P*/ OldProto = cast_FunctionProtoType(OldProtoLoc.getType());
          for (/*uint*/int i = 0, i_end = OldProtoLoc.getNumParams(); i != i_end;
               ++i) {
            ParmVarDecl /*P*/ OldParam = OldProtoLoc.getParam(i);
            if (!(OldParam != null)) {
              Params.push_back(SemaRef.BuildParmVarDeclForTypedef(D, D.getLocation(), OldProto.getParamType(i)));
              continue;
            }
            
            ParmVarDecl /*P*/ Parm = cast_or_null_ParmVarDecl(VisitParmVarDecl(OldParam));
            if (!(Parm != null)) {
              return null;
            }
            Params.push_back(Parm);
          }
        }
      } else {
        Sema.ExtParameterInfoBuilder ExtParamInfos = null;
        try {
          // If the type of this function, after ignoring parentheses, is not
          // *directly* a function type, then we're instantiating a function that
          // was declared via a typedef or with attributes, e.g.,
          //
          //   typedef int functype(int, int);
          //   functype func;
          //   int __cdecl meth(int, int);
          //
          // In this case, we'll just go instantiate the ParmVarDecls that we
          // synthesized in the method declaration.
          SmallVector<QualType> ParamTypes/*J*/= new SmallVector<QualType>(4, new QualType());
          ExtParamInfos/*J*/= new Sema.ExtParameterInfoBuilder();
          if (SemaRef.SubstParmTypes(D.getLocation(), new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, D.parameters()), (/*const*/ type$ptr<FunctionProtoType.ExtParameterInfo /*P*/> )null, 
              TemplateArgs, ParamTypes, $AddrOf(Params), 
              ExtParamInfos)) {
            return null;
          }
        } finally {
          if (ExtParamInfos != null) { ExtParamInfos.$destroy(); }
        }
      }
    }
    
    return NewTInfo;
  }

  
  /// \brief Initializes the common fields of an instantiation function
  /// declaration (New) from the corresponding fields of its template (Tmpl).
  ///
  /// \returns true if there was an error
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::InitFunctionInstantiation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3387,
   FQN="clang::TemplateDeclInstantiator::InitFunctionInstantiation", NM="_ZN5clang24TemplateDeclInstantiator25InitFunctionInstantiationEPNS_12FunctionDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator25InitFunctionInstantiationEPNS_12FunctionDeclES2_")
  //</editor-fold>
  public boolean InitFunctionInstantiation(FunctionDecl /*P*/ New, 
                           FunctionDecl /*P*/ Tmpl) {
    if (Tmpl.isDeleted()) {
      New.setDeletedAsWritten();
    }
    
    // Forward the mangling number from the template to the instantiated decl.
    SemaRef.Context.setManglingNumber(New, 
        SemaRef.Context.getManglingNumber(Tmpl));
    
    // If we are performing substituting explicitly-specified template arguments
    // or deduced template arguments into a function template and we reach this
    // point, we are now past the point where SFINAE applies and have committed
    // to keeping the new function template specialization. We therefore
    // convert the active template instantiation for the function template
    // into a template instantiation for this specific function template
    // specialization, which is not a SFINAE context, so that we diagnose any
    // further errors in the declaration itself.
    /*typedef Sema::ActiveTemplateInstantiation ActiveInstType*/
//    final class ActiveInstType extends Sema.ActiveTemplateInstantiation{ };
    final Sema.ActiveTemplateInstantiation /*&*/ ActiveInst = SemaRef.ActiveTemplateInstantiations.back();
    if (ActiveInst.Kind == Sema.ActiveTemplateInstantiation.InstantiationKind.ExplicitTemplateArgumentSubstitution
       || ActiveInst.Kind == Sema.ActiveTemplateInstantiation.InstantiationKind.DeducedTemplateArgumentSubstitution) {
      {
        FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(ActiveInst.Entity);
        if ((FunTmpl != null)) {
          assert (FunTmpl.getTemplatedDecl() == Tmpl) : "Deduction from the wrong function template?";
          ///*J:(void)*/FunTmpl;
          ActiveInst.Kind = Sema.ActiveTemplateInstantiation.InstantiationKind.TemplateInstantiation;
          ActiveInst.Entity = New;
        }
      }
    }
    
    /*const*/ FunctionProtoType /*P*/ Proto = Tmpl.getType().$arrow().getAs(FunctionProtoType.class);
    assert ((Proto != null)) : "Function template without prototype?";
    if (Proto.hasExceptionSpec() || Proto.getNoReturnAttr()) {
      FunctionProtoType.ExtProtoInfo EPI = Proto.getExtProtoInfo();
      
      // DR1330: In C++11, defer instantiation of a non-trivial
      // exception specification.
      // DR1484: Local classes and their members are instantiated along with the
      // containing function.
      if (SemaRef.getLangOpts().CPlusPlus11
         && EPI.ExceptionSpec.Type != ExceptionSpecificationType.EST_None
         && EPI.ExceptionSpec.Type != ExceptionSpecificationType.EST_DynamicNone
         && EPI.ExceptionSpec.Type != ExceptionSpecificationType.EST_BasicNoexcept
         && !Tmpl.isLexicallyWithinFunctionOrMethod()) {
        FunctionDecl /*P*/ ExceptionSpecTemplate = Tmpl;
        if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Uninstantiated) {
          ExceptionSpecTemplate = EPI.ExceptionSpec.SourceTemplate;
        }
        ExceptionSpecificationType NewEST = ExceptionSpecificationType.EST_Uninstantiated;
        if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Unevaluated) {
          NewEST = ExceptionSpecificationType.EST_Unevaluated;
        }
        
        // Mark the function has having an uninstantiated exception specification.
        /*const*/ FunctionProtoType /*P*/ NewProto = New.getType().$arrow().getAs(FunctionProtoType.class);
        assert ((NewProto != null)) : "Template instantiation without function prototype?";
        EPI.$assignMove(NewProto.getExtProtoInfo());
        EPI.ExceptionSpec.Type = NewEST;
        EPI.ExceptionSpec.SourceDecl = New;
        EPI.ExceptionSpec.SourceTemplate = ExceptionSpecTemplate;
        New.setType(SemaRef.Context.getFunctionType(NewProto.getReturnType(), NewProto.getParamTypes(), EPI));
      } else {
        SemaRef.SubstExceptionSpec(New, Proto, TemplateArgs);
      }
    }
    
    // Get the definition. Leaves the variable unchanged if undefined.
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref(Tmpl);
    Tmpl.isDefined(Definition);
    
    SemaRef.InstantiateAttrs(TemplateArgs, Definition.$deref(), New, 
        LateAttrs, StartingScope);
    
    return false;
  }

  
  /// \brief Initializes common fields of an instantiated method
  /// declaration (New) from the corresponding fields of its template
  /// (Tmpl).
  ///
  /// \returns true if there was an error
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::InitMethodInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3471,
   FQN="clang::TemplateDeclInstantiator::InitMethodInstantiation", NM="_ZN5clang24TemplateDeclInstantiator23InitMethodInstantiationEPNS_13CXXMethodDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator23InitMethodInstantiationEPNS_13CXXMethodDeclES2_")
  //</editor-fold>
  public boolean InitMethodInstantiation(CXXMethodDecl /*P*/ New, 
                         CXXMethodDecl /*P*/ Tmpl) {
    if (InitFunctionInstantiation(New, Tmpl)) {
      return true;
    }
    
    New.setAccess(Tmpl.getAccess());
    if (Tmpl.isVirtualAsWritten()) {
      New.setVirtualAsWritten(true);
    }
    
    // FIXME: New needs a pointer to Tmpl
    return false;
  }

  
  
  /// \brief Instantiates a nested template parameter list in the current
  /// instantiation context.
  ///
  /// \param L The parameter list to instantiate
  ///
  /// \returns NULL if there was an error
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::SubstTemplateParams">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2906,
   FQN="clang::TemplateDeclInstantiator::SubstTemplateParams", NM="_ZN5clang24TemplateDeclInstantiator19SubstTemplateParamsEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator19SubstTemplateParamsEPNS_21TemplateParameterListE")
  //</editor-fold>
  public TemplateParameterList /*P*/ SubstTemplateParams(TemplateParameterList /*P*/ L) {
    // Get errors for all the parameters before bailing out.
    boolean Invalid = false;
    
    /*uint*/int N = L.size();
    /*typedef SmallVector<NamedDecl *, 8> ParamVector*/
//    final class ParamVector extends SmallVector<NamedDecl /*P*/ >{ };
    SmallVector<NamedDecl /*P*/ > Params/*J*/= new SmallVector<NamedDecl /*P*/ >(8, (NamedDecl /*P*/ )null);
    Params.reserve(N);
    for (final NamedDecl /*P*/ P : $Deref(L)) {
      NamedDecl /*P*/ D = cast_or_null_NamedDecl(Visit(P));
      Params.push_back(D);
      Invalid = Invalid || !(D != null) || D.isInvalidDecl();
    }
    
    // Clean up if we had an error.
    if (Invalid) {
      return null;
    }
    
    TemplateParameterList /*P*/ InstL = TemplateParameterList.Create(SemaRef.Context, L.getTemplateLoc(), 
        L.getLAngleLoc(), new ArrayRef<NamedDecl /*P*/ >(Params, true), 
        L.getRAngleLoc());
    return InstL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::SubstQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 65,
   FQN="clang::TemplateDeclInstantiator::SubstQualifier", NM="_ZN5clang24TemplateDeclInstantiator14SubstQualifierEPKNS_14DeclaratorDeclEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator14SubstQualifierEPKNS_14DeclaratorDeclEPS1_")
  //</editor-fold>
  public boolean SubstQualifier(/*const*/ DeclaratorDecl /*P*/ OldDecl, 
                DeclaratorDecl /*P*/ NewDecl) {
    return /*::*/SubstQualifier$T(SemaRef, OldDecl, NewDecl, TemplateArgs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::SubstQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 70,
   FQN="clang::TemplateDeclInstantiator::SubstQualifier", NM="_ZN5clang24TemplateDeclInstantiator14SubstQualifierEPKNS_7TagDeclEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator14SubstQualifierEPKNS_7TagDeclEPS1_")
  //</editor-fold>
  public boolean SubstQualifier(/*const*/ TagDecl /*P*/ OldDecl, 
                TagDecl /*P*/ NewDecl) {
    return /*::*/SubstQualifier$T(SemaRef, OldDecl, NewDecl, TemplateArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2836,
   FQN="clang::TemplateDeclInstantiator::VisitVarTemplateSpecializationDecl", NM="_ZN5clang24TemplateDeclInstantiator34VisitVarTemplateSpecializationDeclEPNS_15VarTemplateDeclEPNS_7VarDeclEPvRKNS_24TemplateArgumentListInfoEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator34VisitVarTemplateSpecializationDeclEPNS_15VarTemplateDeclEPNS_7VarDeclEPvRKNS_24TemplateArgumentListInfoEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public Decl /*P*/ VisitVarTemplateSpecializationDecl(VarTemplateDecl /*P*/ VarTemplate, VarDecl /*P*/ D, type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos, 
                                    final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgsInfo, 
                                    ArrayRef<TemplateArgument> _Converted) {
    
    // Do substitution on the type of the declaration
    TypeSourceInfo /*P*/ DI = SemaRef.SubstType(D.getTypeSourceInfo(), TemplateArgs, 
        D.getTypeSpecStartLoc(), D.getDeclName());
    if (!(DI != null)) {
      return null;
    }
    if (DI.getType().$arrow().isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getLocation(), diag.err_variable_instantiates_to_function)), 
                D.isStaticDataMember()), DI.getType()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Build the instantiated declaration
    VarTemplateSpecializationDecl /*P*/ Var = VarTemplateSpecializationDecl.Create(SemaRef.Context, Owner, D.getInnerLocStart(), D.getLocation(), 
        VarTemplate, DI.getType(), DI, D.getStorageClass(), new ArrayRef<TemplateArgument>(_Converted));
    Var.setTemplateArgsInfo(TemplateArgsInfo);
    if ((InsertPos != null)) {
      VarTemplate.AddSpecialization(Var, InsertPos);
    }
    
    // Substitute the nested name specifier, if any.
    if (SubstQualifier(D, Var)) {
      return null;
    }
    
    SemaRef.BuildVariableInstantiation(Var, D, TemplateArgs, LateAttrs, 
        Owner, StartingScope);
    
    return Var;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::InstantiateTypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 469,
   FQN="clang::TemplateDeclInstantiator::InstantiateTypedefNameDecl", NM="_ZN5clang24TemplateDeclInstantiator26InstantiateTypedefNameDeclEPNS_15TypedefNameDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator26InstantiateTypedefNameDeclEPNS_15TypedefNameDeclEb")
  //</editor-fold>
  public Decl /*P*/ InstantiateTypedefNameDecl(TypedefNameDecl /*P*/ D, 
                            boolean IsTypeAlias) {
    boolean Invalid = false;
    TypeSourceInfo /*P*/ DI = D.getTypeSourceInfo();
    if (DI.getType().$arrow().isInstantiationDependentType()
       || DI.getType().$arrow().isVariablyModifiedType()) {
      DI = SemaRef.SubstType(DI, TemplateArgs, 
          D.getLocation(), D.getDeclName());
      if (!(DI != null)) {
        Invalid = true;
        DI = SemaRef.Context.getTrivialTypeSourceInfo(SemaRef.Context.IntTy.$QualType());
      }
    } else {
      SemaRef.MarkDeclarationsReferencedInType(D.getLocation(), DI.getType());
    }
    
    // HACK: g++ has a bug where it gets the value kind of ?: wrong.
    // libstdc++ relies upon this bug in its implementation of common_type.
    // If we happen to be processing that implementation, fake up the g++ ?:
    // semantics. See LWG issue 2141 for more information on the bug.
    /*const*/ DecltypeType /*P*/ DT = DI.getType().$arrow().getAs(DecltypeType.class);
    CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D.getDeclContext());
    if ((DT != null) && (RD != null) && isa_ConditionalOperator(DT.getUnderlyingExpr())
       && DT.isReferenceType()
       && RD.getEnclosingNamespaceContext() == SemaRef.getStdNamespace()
       && (RD.getIdentifier() != null) && RD.getIdentifier().isStr(/*KEEP_STR*/"common_type")
       && (D.getIdentifier() != null) && D.getIdentifier().isStr(/*KEEP_STR*/"type")
       && SemaRef.getSourceManager().isInSystemHeader(D.getLocStart())) {
      // Fold it to the (non-reference) type which g++ would have produced.
      DI = SemaRef.Context.getTrivialTypeSourceInfo(DI.getType().getNonReferenceType());
    }
    
    // Create the new typedef
    TypedefNameDecl /*P*/ Typedef;
    if (IsTypeAlias) {
      Typedef = TypeAliasDecl.Create(SemaRef.Context, Owner, D.getLocStart(), 
          D.getLocation(), D.getIdentifier(), DI);
    } else {
      Typedef = TypedefDecl.Create(SemaRef.Context, Owner, D.getLocStart(), 
          D.getLocation(), D.getIdentifier(), DI);
    }
    if (Invalid) {
      Typedef.setInvalidDecl();
    }
    {
      
      // If the old typedef was the name for linkage purposes of an anonymous
      // tag decl, re-establish that relationship for the new typedef.
      /*const*/ TagType /*P*/ oldTagType = D.getUnderlyingType().$arrow().getAs(TagType.class);
      if ((oldTagType != null)) {
        TagDecl /*P*/ oldTag = oldTagType.getDecl();
        if (oldTag.getTypedefNameForAnonDecl() == D && !Invalid) {
          TagDecl /*P*/ newTag = DI.getType().$arrow().castAs(TagType.class).getDecl();
          assert (!newTag.hasNameForLinkage());
          newTag.setTypedefNameForAnonDecl(Typedef);
        }
      }
    }
    {
      
      TypedefNameDecl /*P*/ Prev = getPreviousDeclForInstantiation(D);
      if ((Prev != null)) {
        NamedDecl /*P*/ InstPrev = SemaRef.FindInstantiatedDecl(D.getLocation(), Prev, 
            TemplateArgs);
        if (!(InstPrev != null)) {
          return null;
        }
        
        TypedefNameDecl /*P*/ InstPrevTypedef = cast_TypedefNameDecl(InstPrev);
        
        // If the typedef types are not identical, reject them.
        SemaRef.isIncompatibleTypedef(InstPrevTypedef, Typedef);
        
        Typedef.setPreviousDecl(InstPrevTypedef);
      }
    }
    
    SemaRef.InstantiateAttrs(TemplateArgs, D, Typedef);
    
    Typedef.setAccess(D.getAccess());
    
    return Typedef;
  }

  
  /// \brief Instantiate the declaration of a class template partial
  /// specialization.
  ///
  /// \param ClassTemplate the (instantiated) class template that is partially
  // specialized by the instantiation of \p PartialSpec.
  ///
  /// \param PartialSpec the (uninstantiated) class template partial
  /// specialization that we are instantiating.
  ///
  /// \returns The instantiated partial specialization, if successful; otherwise,
  /// NULL to indicate an error.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::InstantiateClassTemplatePartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 2943,
   FQN="clang::TemplateDeclInstantiator::InstantiateClassTemplatePartialSpecialization", NM="_ZN5clang24TemplateDeclInstantiator45InstantiateClassTemplatePartialSpecializationEPNS_17ClassTemplateDeclEPNS_38ClassTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator45InstantiateClassTemplatePartialSpecializationEPNS_17ClassTemplateDeclEPNS_38ClassTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ InstantiateClassTemplatePartialSpecialization(ClassTemplateDecl /*P*/ ClassTemplate, 
                                               ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec) {
    LocalInstantiationScope Scope = null;
    TemplateArgumentListInfo InstTemplateArgs = null;
    try {
      // Create a local instantiation scope for this class template partial
      // specialization, which will contain the instantiations of the template
      // parameters.
      Scope/*J*/= new LocalInstantiationScope(SemaRef);
      
      // Substitute into the template parameters of the class template partial
      // specialization.
      TemplateParameterList /*P*/ TempParams = PartialSpec.getTemplateParameters();
      TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
      if (!(InstParams != null)) {
        return null;
      }
      
      // Substitute into the template arguments of the class template partial
      // specialization.
      /*const*/ ASTTemplateArgumentListInfo /*P*/ TemplArgInfo = PartialSpec.getTemplateArgsAsWritten();
      InstTemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(TemplArgInfo.LAngleLoc), 
          new SourceLocation(TemplArgInfo.RAngleLoc));
      if (SemaRef.Subst(TemplArgInfo.getTemplateArgs(), 
          TemplArgInfo.NumTemplateArgs, 
          InstTemplateArgs, TemplateArgs)) {
        return null;
      }
      
      // Check that the template argument list is well-formed for this
      // class template.
      SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
      if (SemaRef.CheckTemplateArgumentList(ClassTemplate, 
          PartialSpec.getLocation(), 
          InstTemplateArgs, 
          false, 
          _Converted)) {
        return null;
      }
      
      // Figure out where to insert this class template partial specialization
      // in the member template's set of class template partial specializations.
      final type$ref<type$ptr<ClassTemplatePartialSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      ClassTemplateSpecializationDecl /*P*/ PrevDecl = ClassTemplate.findPartialSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
      
      // Build the canonical type that describes the converted template
      // arguments of the class template partial specialization.
      QualType CanonType = SemaRef.Context.getTemplateSpecializationType(new TemplateName(ClassTemplate), 
          new ArrayRef<TemplateArgument>(_Converted, false));
      
      // Build the fully-sugared type for this class template
      // specialization as the user wrote in the specialization
      // itself. This means that we'll pretty-print the type retrieved
      // from the specialization's declaration the way that the user
      // actually wrote the specialization, rather than formatting the
      // name based on the "canonical" representation used to store the
      // template arguments in the specialization.
      TypeSourceInfo /*P*/ WrittenTy = SemaRef.Context.getTemplateSpecializationTypeInfo(new TemplateName(ClassTemplate), 
          PartialSpec.getLocation(), 
          InstTemplateArgs, 
          new QualType(CanonType));
      if ((PrevDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We've already seen a partial specialization with the same template
          // parameters and template arguments. This can happen, for example, when
          // substituting the outer template arguments ends up causing two
          // class template partial specializations of a member class template
          // to have identical forms, e.g.,
          //
          //   template<typename T, typename U>
          //   struct Outer {
          //     template<typename X, typename Y> struct Inner;
          //     template<typename Y> struct Inner<T, Y>;
          //     template<typename Y> struct Inner<U, Y>;
          //   };
          //
          //   Outer<int, int> outer; // error: the partial specializations of Inner
          //                          // have the same signature.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(PartialSpec.getLocation(), diag.err_partial_spec_redeclared)), 
              WrittenTy.getType()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(PrevDecl.getLocation(), diag.note_prev_partial_spec_here)), 
              SemaRef.Context.getTypeDeclType(PrevDecl)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Create the class template partial specialization declaration.
      ClassTemplatePartialSpecializationDecl /*P*/ InstPartialSpec = ClassTemplatePartialSpecializationDecl.Create(SemaRef.Context, 
          PartialSpec.getTagKind(), 
          Owner, 
          PartialSpec.getLocStart(), 
          PartialSpec.getLocation(), 
          InstParams, 
          ClassTemplate, 
          new ArrayRef<TemplateArgument>(_Converted, false), 
          InstTemplateArgs, 
          new QualType(CanonType), 
          (ClassTemplatePartialSpecializationDecl /*P*/ )null);
      // Substitute the nested name specifier, if any.
      if (SubstQualifier(PartialSpec, InstPartialSpec)) {
        return null;
      }
      
      InstPartialSpec.setInstantiatedFromMember(PartialSpec);
      InstPartialSpec.setTypeAsWritten(WrittenTy);
      
      // Add this partial specialization to the set of class template partial
      // specializations.
      ClassTemplate.AddPartialSpecialization(InstPartialSpec, 
          /*InsertPos=*/ (type$ptr<ClassTemplatePartialSpecializationDecl /*P*/>/*void P*/ )null);
      return InstPartialSpec;
    } finally {
      if (InstTemplateArgs != null) { InstTemplateArgs.$destroy(); }
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  
  /// \brief Instantiate the declaration of a variable template partial
  /// specialization.
  ///
  /// \param VarTemplate the (instantiated) variable template that is partially
  /// specialized by the instantiation of \p PartialSpec.
  ///
  /// \param PartialSpec the (uninstantiated) variable template partial
  /// specialization that we are instantiating.
  ///
  /// \returns The instantiated partial specialization, if successful; otherwise,
  /// NULL to indicate an error.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::InstantiateVarTemplatePartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 3068,
   FQN="clang::TemplateDeclInstantiator::InstantiateVarTemplatePartialSpecialization", NM="_ZN5clang24TemplateDeclInstantiator43InstantiateVarTemplatePartialSpecializationEPNS_15VarTemplateDeclEPNS_36VarTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator43InstantiateVarTemplatePartialSpecializationEPNS_15VarTemplateDeclEPNS_36VarTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public VarTemplatePartialSpecializationDecl /*P*/ InstantiateVarTemplatePartialSpecialization(VarTemplateDecl /*P*/ VarTemplate, 
                                             VarTemplatePartialSpecializationDecl /*P*/ PartialSpec) {
    LocalInstantiationScope Scope = null;
    TemplateArgumentListInfo InstTemplateArgs = null;
    try {
      // Create a local instantiation scope for this variable template partial
      // specialization, which will contain the instantiations of the template
      // parameters.
      Scope/*J*/= new LocalInstantiationScope(SemaRef);
      
      // Substitute into the template parameters of the variable template partial
      // specialization.
      TemplateParameterList /*P*/ TempParams = PartialSpec.getTemplateParameters();
      TemplateParameterList /*P*/ InstParams = SubstTemplateParams(TempParams);
      if (!(InstParams != null)) {
        return null;
      }
      
      // Substitute into the template arguments of the variable template partial
      // specialization.
      /*const*/ ASTTemplateArgumentListInfo /*P*/ TemplArgInfo = PartialSpec.getTemplateArgsAsWritten();
      InstTemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(TemplArgInfo.LAngleLoc), 
          new SourceLocation(TemplArgInfo.RAngleLoc));
      if (SemaRef.Subst(TemplArgInfo.getTemplateArgs(), 
          TemplArgInfo.NumTemplateArgs, 
          InstTemplateArgs, TemplateArgs)) {
        return null;
      }
      
      // Check that the template argument list is well-formed for this
      // class template.
      SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
      if (SemaRef.CheckTemplateArgumentList(VarTemplate, PartialSpec.getLocation(), 
          InstTemplateArgs, false, _Converted)) {
        return null;
      }
      
      // Figure out where to insert this variable template partial specialization
      // in the member template's set of variable template partial specializations.
      final type$ref<type$ptr<VarTemplatePartialSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      VarTemplateSpecializationDecl /*P*/ PrevDecl = VarTemplate.findPartialSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
      
      // Build the canonical type that describes the converted template
      // arguments of the variable template partial specialization.
      QualType CanonType = SemaRef.Context.getTemplateSpecializationType(new TemplateName(VarTemplate), new ArrayRef<TemplateArgument>(_Converted, false));
      
      // Build the fully-sugared type for this variable template
      // specialization as the user wrote in the specialization
      // itself. This means that we'll pretty-print the type retrieved
      // from the specialization's declaration the way that the user
      // actually wrote the specialization, rather than formatting the
      // name based on the "canonical" representation used to store the
      // template arguments in the specialization.
      TypeSourceInfo /*P*/ WrittenTy = SemaRef.Context.getTemplateSpecializationTypeInfo(new TemplateName(VarTemplate), PartialSpec.getLocation(), InstTemplateArgs, 
          new QualType(CanonType));
      if ((PrevDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We've already seen a partial specialization with the same template
          // parameters and template arguments. This can happen, for example, when
          // substituting the outer template arguments ends up causing two
          // variable template partial specializations of a member variable template
          // to have identical forms, e.g.,
          //
          //   template<typename T, typename U>
          //   struct Outer {
          //     template<typename X, typename Y> pair<X,Y> p;
          //     template<typename Y> pair<T, Y> p;
          //     template<typename Y> pair<U, Y> p;
          //   };
          //
          //   Outer<int, int> outer; // error: the partial specializations of Inner
          //                          // have the same signature.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(PartialSpec.getLocation(), 
                  diag.err_var_partial_spec_redeclared)), 
              WrittenTy.getType()));
          $c$.clean($c$.track(SemaRef.Diag(PrevDecl.getLocation(), 
              diag.note_var_prev_partial_spec_here)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Do substitution on the type of the declaration
      TypeSourceInfo /*P*/ DI = SemaRef.SubstType(PartialSpec.getTypeSourceInfo(), TemplateArgs, 
          PartialSpec.getTypeSpecStartLoc(), PartialSpec.getDeclName());
      if (!(DI != null)) {
        return null;
      }
      if (DI.getType().$arrow().isFunctionType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(PartialSpec.getLocation(), 
                      diag.err_variable_instantiates_to_function)), 
                  PartialSpec.isStaticDataMember()), DI.getType()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Create the variable template partial specialization declaration.
      VarTemplatePartialSpecializationDecl /*P*/ InstPartialSpec = VarTemplatePartialSpecializationDecl.Create(SemaRef.Context, Owner, PartialSpec.getInnerLocStart(), 
          PartialSpec.getLocation(), InstParams, VarTemplate, DI.getType(), 
          DI, PartialSpec.getStorageClass(), new ArrayRef<TemplateArgument>(_Converted, false), InstTemplateArgs);
      
      // Substitute the nested name specifier, if any.
      if (SubstQualifier(PartialSpec, InstPartialSpec)) {
        return null;
      }
      
      InstPartialSpec.setInstantiatedFromMember(PartialSpec);
      InstPartialSpec.setTypeAsWritten(WrittenTy);
      
      // Add this partial specialization to the set of variable template partial
      // specializations. The instantiation of the initializer is not necessary.
      VarTemplate.AddPartialSpecialization(InstPartialSpec, /*InsertPos=*/ (type$ptr<VarTemplatePartialSpecializationDecl /*P*/>/*void P*/ )null);
      
      SemaRef.BuildVariableInstantiation(InstPartialSpec, PartialSpec, TemplateArgs, 
          LateAttrs, Owner, StartingScope);
      
      return InstPartialSpec;
    } finally {
      if (InstTemplateArgs != null) { InstTemplateArgs.$destroy(); }
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::InstantiateEnumDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp", line = 965,
   FQN="clang::TemplateDeclInstantiator::InstantiateEnumDefinition", NM="_ZN5clang24TemplateDeclInstantiator25InstantiateEnumDefinitionEPNS_8EnumDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiator25InstantiateEnumDefinitionEPNS_8EnumDeclES2_")
  //</editor-fold>
  public void InstantiateEnumDefinition(EnumDecl /*P*/ Enum, EnumDecl /*P*/ Pattern) {
    Enum.startDefinition();
    
    // Update the location to refer to the definition.
    Enum.setLocation(Pattern.getLocation());
    
    SmallVector<Decl /*P*/> Enumerators/*J*/= new SmallVector<Decl /*P*/>(4, null);
    
    EnumConstantDecl /*P*/ LastEnumConst = null;
    for (EnumConstantDecl /*P*/ EC : Pattern.enumerators()) {
      // The specified value for the enumerator.
      ActionResultTTrue<Expr /*P*/ > Value/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
      {
        Expr /*P*/ UninstValue = EC.getInitExpr();
        if ((UninstValue != null)) {
          EnterExpressionEvaluationContext Unevaluated = null;
          try {
            // The enumerator's value expression is a constant expression.
            Unevaluated/*J*/= new EnterExpressionEvaluationContext(SemaRef, 
                Sema.ExpressionEvaluationContext.ConstantEvaluated);
            
            Value.$assignMove(SemaRef.SubstExpr(UninstValue, TemplateArgs));
          } finally {
            if (Unevaluated != null) { Unevaluated.$destroy(); }
          }
        }
      }
      
      // Drop the initial value and continue.
      boolean isInvalid = false;
      if (Value.isInvalid()) {
        Value.$assign((Expr /*P*/ )null);
        isInvalid = true;
      }
      
      EnumConstantDecl /*P*/ EnumConst = SemaRef.CheckEnumConstant(Enum, LastEnumConst, 
          EC.getLocation(), EC.getIdentifier(), 
          Value.get());
      if (isInvalid) {
        if ((EnumConst != null)) {
          EnumConst.setInvalidDecl();
        }
        Enum.setInvalidDecl();
      }
      if ((EnumConst != null)) {
        SemaRef.InstantiateAttrs(TemplateArgs, EC, EnumConst);
        
        EnumConst.setAccess(Enum.getAccess());
        Enum.addDecl(EnumConst);
        Enumerators.push_back(EnumConst);
        LastEnumConst = EnumConst;
        if (Pattern.getDeclContext().isFunctionOrMethod()
           && !Enum.isScoped()) {
          // If the enumeration is within a function or method, record the enum
          // constant as a local.
          SemaRef.CurrentInstantiationScope.InstantiatedLocal(EC, EnumConst);
        }
      }
    }
    
    SemaRef.ActOnEnumBody(Enum.getLocation(), Enum.getBraceRange(), Enum, 
        new ArrayRef<Decl /*P*/ >(Enumerators, true), 
        (Scope /*P*/ )null, (AttributeList /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateDeclInstantiator::~TemplateDeclInstantiator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 371,
   FQN="clang::TemplateDeclInstantiator::~TemplateDeclInstantiator", NM="_ZN5clang24TemplateDeclInstantiatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang24TemplateDeclInstantiatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OutOfLineVarPartialSpecs.$destroy();
    OutOfLinePartialSpecs.$destroy();
    SubstIndex.$destroy();
    DeclVisitor.super.$destroy$DeclVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", SubstIndex=" + SubstIndex // NOI18N
              + ", Owner=" + "[DeclContext]" // NOI18N
              + ", TemplateArgs=" + TemplateArgs // NOI18N
              + ", LateAttrs=" + LateAttrs // NOI18N
              + ", StartingScope=" + StartingScope // NOI18N
              + ", OutOfLinePartialSpecs=" + OutOfLinePartialSpecs // NOI18N
              + ", OutOfLineVarPartialSpecs=" + OutOfLineVarPartialSpecs // NOI18N
              + super.toString(); // NOI18N
  }
}
