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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.DeclTemplateStatics.*;


/// Declaration of a class template.
//<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1935,
 FQN="clang::ClassTemplateDecl", NM="_ZN5clang17ClassTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDeclE")
//</editor-fold>
public class ClassTemplateDecl extends /*public*/ RedeclarableTemplateDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ClassTemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::DeallocateCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 319,
   FQN="clang::ClassTemplateDecl::DeallocateCommon", NM="_ZN5clang17ClassTemplateDecl16DeallocateCommonEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl16DeallocateCommonEPv")
  //</editor-fold>
  private static void DeallocateCommon(Object/*void P*/ Ptr) {
    ((/*static_cast*/Common /*P*/ )(Ptr)).$destroy();
  }

/*protected:*/
  /// \brief Data that is common to all of the declarations of a given
  /// class template.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::Common">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1941,
   FQN="clang::ClassTemplateDecl::Common", NM="_ZN5clang17ClassTemplateDecl6CommonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl6CommonE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ Common extends /**/ CommonBase implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::Common::Common">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1942,
     FQN="clang::ClassTemplateDecl::Common::Common", NM="_ZN5clang17ClassTemplateDecl6CommonC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl6CommonC1Ev")
    //</editor-fold>
    public Common() {
      // : CommonBase(), Specializations(), PartialSpecializations(), InjectedClassNameType(), LazySpecializations(implicit uint32_t * ()) 
      //START JInit
      super();
      this.Specializations = new FoldingSetVector<ClassTemplateSpecializationDecl>();
      this.PartialSpecializations = new FoldingSetVector<ClassTemplatePartialSpecializationDecl>();
      this.InjectedClassNameType = new QualType();
      this.LazySpecializations = $tryClone(/*implicit-init*/((/*uint32_t P*/uint$ptr )/*zero-init*/null));
      //END JInit
    }

    
    /// \brief The class template specializations for this class
    /// template, including explicit specializations and instantiations.
    public FoldingSetVector<ClassTemplateSpecializationDecl> Specializations;
    
    /// \brief The class template partial specializations for this class
    /// template.
    public FoldingSetVector<ClassTemplatePartialSpecializationDecl> PartialSpecializations;
    
    /// \brief The injected-class-name type for this class template.
    public QualType InjectedClassNameType;
    
    /// \brief If non-null, points to an array of specializations (including
    /// partial specializations) known only by their external declaration IDs.
    ///
    /// The first value in the array is the number of of specializations/
    /// partial specializations that follow.
    //JAVA moved field to super class
    //public /*uint32_t P*/uint$ptr LazySpecializations;
    //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::Common::~Common">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1941,
     FQN="clang::ClassTemplateDecl::Common::~Common", NM="_ZN5clang17ClassTemplateDecl6CommonD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl6CommonD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      PartialSpecializations.$destroy();
      Specializations.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Specializations=" + Specializations // NOI18N
                + ", PartialSpecializations=" + PartialSpecializations // NOI18N
                + ", InjectedClassNameType=" + InjectedClassNameType // NOI18N
                + ", LazySpecializations=" + LazySpecializations // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// \brief Retrieve the set of specializations of this class template.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getSpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 358,
   FQN="clang::ClassTemplateDecl::getSpecializations", NM="_ZNK5clang17ClassTemplateDecl18getSpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl18getSpecializationsEv")
  //</editor-fold>
  protected FoldingSetVector<ClassTemplateSpecializationDecl> /*&*/ getSpecializations() /*const*/ {
    LoadLazySpecializations();
    return getCommonPtr().Specializations;
  }

  
  /// \brief Retrieve the set of partial specializations of this class
  /// template.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getPartialSpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 364,
   FQN="clang::ClassTemplateDecl::getPartialSpecializations", NM="_ZN5clang17ClassTemplateDecl25getPartialSpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl25getPartialSpecializationsEv")
  //</editor-fold>
  protected FoldingSetVector<ClassTemplatePartialSpecializationDecl> /*&*/ getPartialSpecializations() {
    LoadLazySpecializations();
    return getCommonPtr().PartialSpecializations;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::ClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1973,
   FQN="clang::ClassTemplateDecl::ClassTemplateDecl", NM="_ZN5clang17ClassTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  protected ClassTemplateDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L, 
      DeclarationName Name, TemplateParameterList /*P*/ Params, 
      NamedDecl /*P*/ Decl) {
    // : RedeclarableTemplateDecl(ClassTemplate, C, DC, L, Name, Params, Decl) 
    //START JInit
    super(Kind.ClassTemplate, C, DC, new SourceLocation(L), new DeclarationName(Name), Params, Decl);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::newCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 370,
   FQN="clang::ClassTemplateDecl::newCommon", NM="_ZNK5clang17ClassTemplateDecl9newCommonERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl9newCommonERNS_10ASTContextE")
  //</editor-fold>
  @Override /*friend*/public RedeclarableTemplateDecl.CommonBase /*P*/ newCommon(final ASTContext /*&*/ C) /*const*//* override*/ {
    Common /*P*/ CommonPtr = /*FIXME:NEW_EXPR*//*new (C)*/ new Common();
    C.AddDeallocation(/*FuncRef*/ClassTemplateDecl::DeallocateCommon, CommonPtr);
    return CommonPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getCommonPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1980,
   FQN="clang::ClassTemplateDecl::getCommonPtr", NM="_ZNK5clang17ClassTemplateDecl12getCommonPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl12getCommonPtrEv")
  //</editor-fold>
  /*friend*/public Common /*P*/ getCommonPtr() /*const*/ {
    return ((/*static_cast*/Common /*P*/ )(super.getCommonPtr()));
  }

/*public:*/
  /// \brief Load any lazily-loaded specializations from the external source.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::LoadLazySpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 343,
   FQN="clang::ClassTemplateDecl::LoadLazySpecializations", NM="_ZNK5clang17ClassTemplateDecl23LoadLazySpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl23LoadLazySpecializationsEv")
  //</editor-fold>
  public void LoadLazySpecializations() /*const*/ {
    // Grab the most recent declaration to ensure we've loaded any lazy
    // redeclarations of this template.
    //
    // FIXME: Avoid walking the entire redeclaration chain here.
    Common /*P*/ CommonPtr = getMostRecentDecl$Const().getCommonPtr();
    if (Native.$bool(CommonPtr.LazySpecializations)) {
      final ASTContext /*&*/ Context = getASTContext();
      /*uint32_t P*/uint$ptr Specs = $tryClone(CommonPtr.LazySpecializations);
      CommonPtr.LazySpecializations = null;
      for (/*uint32_t*/int I = 0, N = Specs.$postInc().$star(); I != N; ++I)  {
        /*J:(void)*/Context.getExternalSource().GetExternalDecl(Specs.$at(I));
      }
    }
  }

  
  /// \brief Get the underlying class declarations of the template.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getTemplatedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1989,
   FQN="clang::ClassTemplateDecl::getTemplatedDecl", NM="_ZNK5clang17ClassTemplateDecl16getTemplatedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl16getTemplatedDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getTemplatedDecl() /*const*/ {
    return ((/*static_cast*/CXXRecordDecl /*P*/ )(TemplatedDecl.getPointer()));
  }

  
  /// \brief Returns whether this template declaration defines the primary
  /// class pattern.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1995,
   FQN="clang::ClassTemplateDecl::isThisDeclarationADefinition", NM="_ZNK5clang17ClassTemplateDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return getTemplatedDecl().isThisDeclarationADefinition();
  }

  
  /// \brief Create a class template node.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 323,
   FQN="clang::ClassTemplateDecl::Create", NM="_ZN5clang17ClassTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclEPS0_")
  //</editor-fold>
  public static ClassTemplateDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation L, 
        DeclarationName Name, 
        TemplateParameterList /*P*/ Params, 
        NamedDecl /*P*/ Decl, 
        ClassTemplateDecl /*P*/ PrevDecl) {
    AdoptTemplateParameterList(Params, cast_DeclContext(Decl));
    ClassTemplateDecl /*P*/ New = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ClassTemplateDecl(C, DC, new SourceLocation(L), new DeclarationName(Name), 
                Params, Decl);
     });
    New.setPreviousDecl(PrevDecl);
    return New;
  }

  
  /// \brief Create an empty class template node.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 337,
   FQN="clang::ClassTemplateDecl::CreateDeserialized", NM="_ZN5clang17ClassTemplateDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ClassTemplateDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ClassTemplateDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationName(), (TemplateParameterList /*P*/ )null, (NamedDecl /*P*/ )null);
     });
  }

  
  /// \brief Return the specialization with the provided arguments if it exists,
  /// otherwise return the insertion point.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::findSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 377,
   FQN="clang::ClassTemplateDecl::findSpecialization", NM="_ZN5clang17ClassTemplateDecl18findSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl18findSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  public ClassTemplateSpecializationDecl /*P*/ findSpecialization(ArrayRef<TemplateArgument> Args, 
                    final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    return findSpecializationImpl$ClassTemplateSpecializationDecl(getSpecializations(), new ArrayRef<TemplateArgument>(Args), InsertPos);
  }

  
  /// \brief Insert the specified specialization knowing that it is not already
  /// in. InsertPos must be obtained from findSpecialization.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::AddSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 383,
   FQN="clang::ClassTemplateDecl::AddSpecialization", NM="_ZN5clang17ClassTemplateDecl17AddSpecializationEPNS_31ClassTemplateSpecializationDeclEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl17AddSpecializationEPNS_31ClassTemplateSpecializationDeclEPv")
  //</editor-fold>
  public void AddSpecialization(ClassTemplateSpecializationDecl /*P*/ D, 
                   type$ptr<ClassTemplateSpecializationDecl/*P*/>/*void P*/ InsertPos) {
    addSpecializationImpl$ClassTemplateSpecializationDecl/*<ClassTemplateSpecializationDecl>*/(getSpecializations(), D, InsertPos);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2019,
   FQN="clang::ClassTemplateDecl::getCanonicalDecl", NM="_ZN5clang17ClassTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public ClassTemplateDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_ClassTemplateDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2023,
   FQN="clang::ClassTemplateDecl::getCanonicalDecl", NM="_ZNK5clang17ClassTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ ClassTemplateDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return cast_ClassTemplateDecl(super.getCanonicalDecl$Const());
  }

  
  /// \brief Retrieve the previous declaration of this class template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2030,
   FQN="clang::ClassTemplateDecl::getPreviousDecl", NM="_ZN5clang17ClassTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public ClassTemplateDecl /*P*/ getPreviousDecl() {
    return cast_or_null_ClassTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.getPreviousDecl$Redeclarable());
  }

  
  /// \brief Retrieve the previous declaration of this class template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2037,
   FQN="clang::ClassTemplateDecl::getPreviousDecl", NM="_ZNK5clang17ClassTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ ClassTemplateDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return cast_or_null_ClassTemplateDecl(/*JCast:const RedeclarableTemplateDecl * */super.getPreviousDecl$Redeclarable$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2043,
   FQN="clang::ClassTemplateDecl::getMostRecentDecl", NM="_ZN5clang17ClassTemplateDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl17getMostRecentDeclEv")
  //</editor-fold>
  public ClassTemplateDecl /*P*/ getMostRecentDecl() {
    return cast_ClassTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.getMostRecentDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2047,
   FQN="clang::ClassTemplateDecl::getMostRecentDecl", NM="_ZNK5clang17ClassTemplateDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ ClassTemplateDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/ClassTemplateDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2051,
   FQN="clang::ClassTemplateDecl::getInstantiatedFromMemberTemplate", NM="_ZNK5clang17ClassTemplateDecl33getInstantiatedFromMemberTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl33getInstantiatedFromMemberTemplateEv")
  //</editor-fold>
  public ClassTemplateDecl /*P*/ getInstantiatedFromMemberTemplate() /*const*/ {
    return cast_or_null_ClassTemplateDecl(super.getInstantiatedFromMemberTemplate());
  }

  
  /// \brief Return the partial specialization with the provided arguments if it
  /// exists, otherwise return the insertion point.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::findPartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 388,
   FQN="clang::ClassTemplateDecl::findPartialSpecialization", NM="_ZN5clang17ClassTemplateDecl25findPartialSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl25findPartialSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ findPartialSpecialization(ArrayRef<TemplateArgument> Args, 
                           final type$ref<type$ptr<ClassTemplatePartialSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    return findSpecializationImpl$ClassTemplatePartialSpecializationDecl(getPartialSpecializations(), new ArrayRef<TemplateArgument>(Args), InsertPos);
  }

  
  /// \brief Insert the specified partial specialization knowing that it is not
  /// already in. InsertPos must be obtained from findPartialSpecialization.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::AddPartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 394,
   FQN="clang::ClassTemplateDecl::AddPartialSpecialization", NM="_ZN5clang17ClassTemplateDecl24AddPartialSpecializationEPNS_38ClassTemplatePartialSpecializationDeclEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl24AddPartialSpecializationEPNS_38ClassTemplatePartialSpecializationDeclEPv")
  //</editor-fold>
  public void AddPartialSpecialization(ClassTemplatePartialSpecializationDecl /*P*/ D, 
                          type$ptr<ClassTemplatePartialSpecializationDecl /*P*/>/*void P*/ InsertPos) {
    if ((InsertPos != null)) {
      getPartialSpecializations().InsertNode(D, InsertPos);
    } else {
      ClassTemplatePartialSpecializationDecl /*P*/ Existing = getPartialSpecializations().GetOrInsertNode(D);
      ///*J:(void)*/Existing;
      assert (Existing.isCanonicalDecl()) : "Non-canonical specialization?";
    }
    {
      
      ASTMutationListener /*P*/ L = getASTMutationListener();
      if ((L != null)) {
        L.AddedCXXTemplateSpecialization(this, D);
      }
    }
  }

  
  /// \brief Retrieve the partial specializations as an ordered list.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getPartialSpecializations">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 410,
   FQN="clang::ClassTemplateDecl::getPartialSpecializations", NM="_ZN5clang17ClassTemplateDecl25getPartialSpecializationsERN4llvm15SmallVectorImplIPNS_38ClassTemplatePartialSpecializationDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl25getPartialSpecializationsERN4llvm15SmallVectorImplIPNS_38ClassTemplatePartialSpecializationDeclEEE")
  //</editor-fold>
  public void getPartialSpecializations(final SmallVectorImpl<ClassTemplatePartialSpecializationDecl /*P*/ > /*&*/ PS) {
    final FoldingSetVector<ClassTemplatePartialSpecializationDecl> /*&*/ PartialSpecs = getPartialSpecializations();
    PS.clear();
    PS.reserve(PartialSpecs.size());
    for (final ClassTemplatePartialSpecializationDecl /*&*/ P : PartialSpecs)  {
      PS.push_back(P.getMostRecentDecl());
    }
  }

  
  /// \brief Find a class template partial specialization with the given
  /// type T.
  ///
  /// \param T a dependent type that names a specialization of this class
  /// template.
  ///
  /// \returns the class template partial specialization that exactly matches
  /// the type \p T, or NULL if no such partial specialization exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::findPartialSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 420,
   FQN="clang::ClassTemplateDecl::findPartialSpecialization", NM="_ZN5clang17ClassTemplateDecl25findPartialSpecializationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl25findPartialSpecializationENS_8QualTypeE")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ findPartialSpecialization(QualType T) {
    final ASTContext /*&*/ Context = getASTContext();
    for (final ClassTemplatePartialSpecializationDecl /*&*/ P : getPartialSpecializations()) {
      if (Context.hasSameType(P.getInjectedSpecializationType(), new QualType(T))) {
        return P.getMostRecentDecl();
      }
    }
    
    return null;
  }

  
  /// \brief Find a class template partial specialization which was instantiated
  /// from the given member partial specialization.
  ///
  /// \param D a member class template partial specialization.
  ///
  /// \returns the class template partial specialization which was instantiated
  /// from the given member partial specialization, or NULL if no such partial
  /// specialization exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::findPartialSpecInstantiatedFromMember">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 432,
   FQN="clang::ClassTemplateDecl::findPartialSpecInstantiatedFromMember", NM="_ZN5clang17ClassTemplateDecl37findPartialSpecInstantiatedFromMemberEPNS_38ClassTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl37findPartialSpecInstantiatedFromMemberEPNS_38ClassTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ findPartialSpecInstantiatedFromMember(ClassTemplatePartialSpecializationDecl /*P*/ D) {
    Decl /*P*/ DCanon = D.getCanonicalDecl();
    for (final ClassTemplatePartialSpecializationDecl /*&*/ P : getPartialSpecializations()) {
      if (P.getInstantiatedFromMember().getCanonicalDecl() == DCanon) {
        return P.getMostRecentDecl();
      }
    }
    
    return null;
  }

  
  /// \brief Retrieve the template specialization type of the
  /// injected-class-name for this class template.
  ///
  /// The injected-class-name for a class template \c X is \c
  /// X<template-args>, where \c template-args is formed from the
  /// template arguments that correspond to the template parameters of
  /// \c X. For example:
  ///
  /// \code
  /// template<typename T, int N>
  /// struct array {
  ///   typedef array this_type; // "array" is equivalent to "array<T, N>"
  /// };
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::getInjectedClassNameSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 444,
   FQN="clang::ClassTemplateDecl::getInjectedClassNameSpecialization", NM="_ZN5clang17ClassTemplateDecl34getInjectedClassNameSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl34getInjectedClassNameSpecializationEv")
  //</editor-fold>
  public QualType getInjectedClassNameSpecialization() {
    Common /*P*/ CommonPtr = getCommonPtr();
    if (!CommonPtr.InjectedClassNameType.isNull()) {
      return new QualType(CommonPtr.InjectedClassNameType);
    }
    
    // C++0x [temp.dep.type]p2:
    //  The template argument list of a primary template is a template argument 
    //  list in which the nth template argument has the value of the nth template
    //  parameter of the class template. If the nth template parameter is a 
    //  template parameter pack (14.5.3), the nth template argument is a pack 
    //  expansion (14.5.3) whose pattern is the name of the template parameter 
    //  pack.
    final ASTContext /*&*/ Context = getASTContext();
    TemplateParameterList /*P*/ Params = getTemplateParameters();
    SmallVector<TemplateArgument> TemplateArgs/*J*/= new SmallVector<TemplateArgument>(16, new TemplateArgument());
    TemplateArgs.resize(Params.size());
    GenerateInjectedTemplateArgs(getASTContext(), Params, TemplateArgs.data());
    CommonPtr.InjectedClassNameType.$assignMove(
        Context.getTemplateSpecializationType(new TemplateName(this), 
            new ArrayRef<TemplateArgument>(TemplateArgs, false))
    );
    return new QualType(CommonPtr.InjectedClassNameType);
  }

  
  /*typedef SpecIterator<ClassTemplateSpecializationDecl> spec_iterator*/
//  public final class spec_iterator extends SpecIterator<ClassTemplateSpecializationDecl>{ };
  /*typedef llvm::iterator_range<spec_iterator> spec_range*/
//  public final class spec_range extends iterator_range<ClassTemplateSpecializationDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::specializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2111,
   FQN="clang::ClassTemplateDecl::specializations", NM="_ZNK5clang17ClassTemplateDecl15specializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl15specializationsEv")
  //</editor-fold>
  public iterator_range<ClassTemplateSpecializationDecl /*P*/ > specializations() /*const*/ {
    return new iterator_range<ClassTemplateSpecializationDecl /*P*/ >(spec_begin(), spec_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::spec_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2115,
   FQN="clang::ClassTemplateDecl::spec_begin", NM="_ZNK5clang17ClassTemplateDecl10spec_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl10spec_beginEv")
  //</editor-fold>
  public SpecIterator<ClassTemplateSpecializationDecl, /*SpecEntryTraits,*/ ClassTemplateSpecializationDecl> spec_begin() /*const*/ {
    return makeSpecIterator(getSpecializations(), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::spec_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2119,
   FQN="clang::ClassTemplateDecl::spec_end", NM="_ZNK5clang17ClassTemplateDecl8spec_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17ClassTemplateDecl8spec_endEv")
  //</editor-fold>
  public SpecIterator<ClassTemplateSpecializationDecl, /*SpecEntryTraits,*/ ClassTemplateSpecializationDecl> spec_end() /*const*/ {
    return makeSpecIterator(getSpecializations(), true);
  }

  
  // Implement isa/cast/dyncast support
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2124,
   FQN="clang::ClassTemplateDecl::classof", NM="_ZN5clang17ClassTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2125,
   FQN="clang::ClassTemplateDecl::classofKind", NM="_ZN5clang17ClassTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ClassTemplate;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplateDecl::~ClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1935,
   FQN="clang::ClassTemplateDecl::~ClassTemplateDecl", NM="_ZN5clang17ClassTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17ClassTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
