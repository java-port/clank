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
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// Declaration of a variable template.
//<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2749,
 FQN="clang::VarTemplateDecl", NM="_ZN5clang15VarTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDeclE")
//</editor-fold>
public class VarTemplateDecl extends /*public*/ RedeclarableTemplateDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // VarTemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::DeallocateCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 934,
   FQN="clang::VarTemplateDecl::DeallocateCommon", NM="_ZN5clang15VarTemplateDecl16DeallocateCommonEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl16DeallocateCommonEPv")
  //</editor-fold>
  private static void DeallocateCommon(Object/*void P*/ Ptr) {
    ((/*static_cast*/Common /*P*/ )(Ptr)).$destroy();
  }

/*protected:*/
  /// \brief Data that is common to all of the declarations of a given
  /// variable template.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::Common">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2755,
   FQN="clang::VarTemplateDecl::Common", NM="_ZN5clang15VarTemplateDecl6CommonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl6CommonE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ Common extends /**/ CommonBase implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::Common::Common">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2756,
     FQN="clang::VarTemplateDecl::Common::Common", NM="_ZN5clang15VarTemplateDecl6CommonC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl6CommonC1Ev")
    //</editor-fold>
    public Common() {
      // : CommonBase(), Specializations(), PartialSpecializations(), LazySpecializations(implicit uint32_t * ()) 
      //START JInit
      super();
      this.Specializations = new FoldingSetVector<VarTemplateSpecializationDecl>();
      this.PartialSpecializations = new FoldingSetVector<VarTemplatePartialSpecializationDecl>();
      this.LazySpecializations = $tryClone(/*implicit-init*/((/*uint32_t P*/uint$ptr )/*zero-init*/null));
      //END JInit
    }

    
    /// \brief The variable template specializations for this variable
    /// template, including explicit specializations and instantiations.
    public FoldingSetVector<VarTemplateSpecializationDecl> Specializations;
    
    /// \brief The variable template partial specializations for this variable
    /// template.
    public FoldingSetVector<VarTemplatePartialSpecializationDecl> PartialSpecializations;
    
    /// \brief If non-null, points to an array of specializations (including
    /// partial specializations) known ownly by their external declaration IDs.
    ///
    /// The first value in the array is the number of of specializations/
    /// partial specializations that follow.
    //JAVA moved field to super class
    //public /*uint32_t P*/uint$ptr LazySpecializations;
    //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::Common::~Common">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2755,
     FQN="clang::VarTemplateDecl::Common::~Common", NM="_ZN5clang15VarTemplateDecl6CommonD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl6CommonD0Ev")
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
                + ", LazySpecializations=" + LazySpecializations // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// \brief Retrieve the set of specializations of this variable template.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getSpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 978,
   FQN="clang::VarTemplateDecl::getSpecializations", NM="_ZNK5clang15VarTemplateDecl18getSpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl18getSpecializationsEv")
  //</editor-fold>
  protected FoldingSetVector<VarTemplateSpecializationDecl> /*&*/ getSpecializations() /*const*/ {
    LoadLazySpecializations();
    return getCommonPtr().Specializations;
  }

  
  /// \brief Retrieve the set of partial specializations of this class
  /// template.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getPartialSpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 984,
   FQN="clang::VarTemplateDecl::getPartialSpecializations", NM="_ZN5clang15VarTemplateDecl25getPartialSpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl25getPartialSpecializationsEv")
  //</editor-fold>
  protected FoldingSetVector<VarTemplatePartialSpecializationDecl> /*&*/ getPartialSpecializations() {
    LoadLazySpecializations();
    return getCommonPtr().PartialSpecializations;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::VarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2784,
   FQN="clang::VarTemplateDecl::VarTemplateDecl", NM="_ZN5clang15VarTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  protected VarTemplateDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L, 
      DeclarationName Name, TemplateParameterList /*P*/ Params, 
      NamedDecl /*P*/ Decl) {
    // : RedeclarableTemplateDecl(VarTemplate, C, DC, L, Name, Params, Decl) 
    //START JInit
    super(Kind.VarTemplate, C, DC, new SourceLocation(L), new DeclarationName(Name), Params, Decl);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::newCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 990,
   FQN="clang::VarTemplateDecl::newCommon", NM="_ZNK5clang15VarTemplateDecl9newCommonERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl9newCommonERNS_10ASTContextE")
  //</editor-fold>
  @Override /*friend*/public RedeclarableTemplateDecl.CommonBase /*P*/ newCommon(final ASTContext /*&*/ C) /*const*//* override*/ {
    Common /*P*/ CommonPtr = /*FIXME:NEW_EXPR*//*new (C)*/ new Common();
    C.AddDeallocation(/*FuncRef*/VarTemplateDecl::DeallocateCommon, CommonPtr);
    return CommonPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getCommonPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2791,
   FQN="clang::VarTemplateDecl::getCommonPtr", NM="_ZNK5clang15VarTemplateDecl12getCommonPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl12getCommonPtrEv")
  //</editor-fold>
  /*friend*/public Common /*P*/ getCommonPtr() /*const*/ {
    return ((/*static_cast*/Common /*P*/ )(super.getCommonPtr()));
  }

/*public:*/
  /// \brief Load any lazily-loaded specializations from the external source.
  
  // TODO: Unify across class, function and variable templates?
  //       May require moving this and Common to RedeclarableTemplateDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::LoadLazySpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 963,
   FQN="clang::VarTemplateDecl::LoadLazySpecializations", NM="_ZNK5clang15VarTemplateDecl23LoadLazySpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl23LoadLazySpecializationsEv")
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

  
  /// \brief Get the underlying variable declarations of the template.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getTemplatedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2800,
   FQN="clang::VarTemplateDecl::getTemplatedDecl", NM="_ZNK5clang15VarTemplateDecl16getTemplatedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl16getTemplatedDeclEv")
  //</editor-fold>
  public VarDecl /*P*/ getTemplatedDecl() /*const*/ {
    return ((/*static_cast*/VarDecl /*P*/ )(TemplatedDecl.getPointer()));
  }

  
  /// \brief Returns whether this template declaration defines the primary
  /// variable pattern.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2806,
   FQN="clang::VarTemplateDecl::isThisDeclarationADefinition", NM="_ZNK5clang15VarTemplateDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return (getTemplatedDecl().isThisDeclarationADefinition().getValue() != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 938,
   FQN="clang::VarTemplateDecl::getDefinition", NM="_ZN5clang15VarTemplateDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl13getDefinitionEv")
  //</editor-fold>
  public VarTemplateDecl /*P*/ getDefinition() {
    VarTemplateDecl /*P*/ CurD = this;
    while ((CurD != null)) {
      if (CurD.isThisDeclarationADefinition()) {
        return CurD;
      }
      CurD = CurD.getPreviousDecl();
    }
    return null;
  }

  
  /// \brief Create a variable template node.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 948,
   FQN="clang::VarTemplateDecl::Create", NM="_ZN5clang15VarTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_7VarDeclE")
  //</editor-fold>
  public static VarTemplateDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, DeclarationName Name, 
        TemplateParameterList /*P*/ Params, 
        VarDecl /*P*/ Decl) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new VarTemplateDecl(C, DC, new SourceLocation(L), new DeclarationName(Name), Params, Decl);
     });
  }

  
  /// \brief Create an empty variable template node.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 955,
   FQN="clang::VarTemplateDecl::CreateDeserialized", NM="_ZN5clang15VarTemplateDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static VarTemplateDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new VarTemplateDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationName(), (TemplateParameterList /*P*/ )null, (NamedDecl /*P*/ )null);
     });
  }

  
  /// \brief Return the specialization with the provided arguments if it exists,
  /// otherwise return the insertion point.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::findSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 997,
   FQN="clang::VarTemplateDecl::findSpecialization", NM="_ZN5clang15VarTemplateDecl18findSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl18findSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  public VarTemplateSpecializationDecl /*P*/ findSpecialization(ArrayRef<TemplateArgument> Args, 
                    final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    return findSpecializationImpl$VarTemplateSpecializationDecl(getSpecializations(), new ArrayRef<TemplateArgument>(Args), InsertPos);
  }

  
  /// \brief Insert the specified specialization knowing that it is not already
  /// in. InsertPos must be obtained from findSpecialization.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::AddSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1003,
   FQN="clang::VarTemplateDecl::AddSpecialization", NM="_ZN5clang15VarTemplateDecl17AddSpecializationEPNS_29VarTemplateSpecializationDeclEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl17AddSpecializationEPNS_29VarTemplateSpecializationDeclEPv")
  //</editor-fold>
  public void AddSpecialization(VarTemplateSpecializationDecl /*P*/ D, 
                   type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos) {
    addSpecializationImpl$VarTemplateSpecializationDecl/*<VarTemplateDecl>*/(getSpecializations(), D, InsertPos);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2830,
   FQN="clang::VarTemplateDecl::getCanonicalDecl", NM="_ZN5clang15VarTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public VarTemplateDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_VarTemplateDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2833,
   FQN="clang::VarTemplateDecl::getCanonicalDecl", NM="_ZNK5clang15VarTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ VarTemplateDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return cast_VarTemplateDecl(super.getCanonicalDecl$Const());
  }

  
  /// \brief Retrieve the previous declaration of this variable template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2839,
   FQN="clang::VarTemplateDecl::getPreviousDecl", NM="_ZN5clang15VarTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public VarTemplateDecl /*P*/ getPreviousDecl() {
    return cast_or_null_VarTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.getPreviousDecl$Redeclarable());
  }

  
  /// \brief Retrieve the previous declaration of this variable template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2846,
   FQN="clang::VarTemplateDecl::getPreviousDecl", NM="_ZNK5clang15VarTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ VarTemplateDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return cast_or_null_VarTemplateDecl(/*JCast:const RedeclarableTemplateDecl * */super.getPreviousDecl$Redeclarable$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2852,
   FQN="clang::VarTemplateDecl::getMostRecentDecl", NM="_ZN5clang15VarTemplateDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl17getMostRecentDeclEv")
  //</editor-fold>
  public VarTemplateDecl /*P*/ getMostRecentDecl() {
    return cast_VarTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.getMostRecentDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2856,
   FQN="clang::VarTemplateDecl::getMostRecentDecl", NM="_ZNK5clang15VarTemplateDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ VarTemplateDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/VarTemplateDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2860,
   FQN="clang::VarTemplateDecl::getInstantiatedFromMemberTemplate", NM="_ZNK5clang15VarTemplateDecl33getInstantiatedFromMemberTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl33getInstantiatedFromMemberTemplateEv")
  //</editor-fold>
  public VarTemplateDecl /*P*/ getInstantiatedFromMemberTemplate() /*const*/ {
    return cast_or_null_VarTemplateDecl(super.getInstantiatedFromMemberTemplate());
  }

  
  /// \brief Return the partial specialization with the provided arguments if it
  /// exists, otherwise return the insertion point.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::findPartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1008,
   FQN="clang::VarTemplateDecl::findPartialSpecialization", NM="_ZN5clang15VarTemplateDecl25findPartialSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl25findPartialSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  public VarTemplatePartialSpecializationDecl /*P*/ findPartialSpecialization(ArrayRef<TemplateArgument> Args, 
                           final type$ref<type$ptr<VarTemplatePartialSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    return findSpecializationImpl$VarTemplatePartialSpecializationDecl(getPartialSpecializations(), new ArrayRef<TemplateArgument>(Args), InsertPos);
  }

  
  /// \brief Insert the specified partial specialization knowing that it is not
  /// already in. InsertPos must be obtained from findPartialSpecialization.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::AddPartialSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1014,
   FQN="clang::VarTemplateDecl::AddPartialSpecialization", NM="_ZN5clang15VarTemplateDecl24AddPartialSpecializationEPNS_36VarTemplatePartialSpecializationDeclEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl24AddPartialSpecializationEPNS_36VarTemplatePartialSpecializationDeclEPv")
  //</editor-fold>
  public void AddPartialSpecialization(VarTemplatePartialSpecializationDecl /*P*/ D, final type$ptr<VarTemplatePartialSpecializationDecl /*P*/>/*void P&*/ InsertPos) {
    if ((InsertPos != null)) {
      getPartialSpecializations().InsertNode(D, InsertPos);
    } else {
      VarTemplatePartialSpecializationDecl /*P*/ Existing = getPartialSpecializations().GetOrInsertNode(D);
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
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::getPartialSpecializations">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1029,
   FQN="clang::VarTemplateDecl::getPartialSpecializations", NM="_ZN5clang15VarTemplateDecl25getPartialSpecializationsERN4llvm15SmallVectorImplIPNS_36VarTemplatePartialSpecializationDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl25getPartialSpecializationsERN4llvm15SmallVectorImplIPNS_36VarTemplatePartialSpecializationDeclEEE")
  //</editor-fold>
  public void getPartialSpecializations(final SmallVectorImpl<VarTemplatePartialSpecializationDecl /*P*/ > /*&*/ PS) {
    final FoldingSetVector<VarTemplatePartialSpecializationDecl> /*&*/ PartialSpecs = getPartialSpecializations();
    PS.clear();
    PS.reserve(PartialSpecs.size());
    for (final VarTemplatePartialSpecializationDecl /*&*/ P : PartialSpecs)  {
      PS.push_back(P.getMostRecentDecl());
    }
  }

  
  /// \brief Find a variable template partial specialization which was
  /// instantiated
  /// from the given member partial specialization.
  ///
  /// \param D a member variable template partial specialization.
  ///
  /// \returns the variable template partial specialization which was
  /// instantiated
  /// from the given member partial specialization, or NULL if no such partial
  /// specialization exists.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::findPartialSpecInstantiatedFromMember">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1039,
   FQN="clang::VarTemplateDecl::findPartialSpecInstantiatedFromMember", NM="_ZN5clang15VarTemplateDecl37findPartialSpecInstantiatedFromMemberEPNS_36VarTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl37findPartialSpecInstantiatedFromMemberEPNS_36VarTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public VarTemplatePartialSpecializationDecl /*P*/ findPartialSpecInstantiatedFromMember(VarTemplatePartialSpecializationDecl /*P*/ D) {
    Decl /*P*/ DCanon = D.getCanonicalDecl();
    for (final VarTemplatePartialSpecializationDecl /*&*/ P : getPartialSpecializations()) {
      if (P.getInstantiatedFromMember().getCanonicalDecl() == DCanon) {
        return P.getMostRecentDecl();
      }
    }
    
    return null;
  }

  
  /*typedef SpecIterator<VarTemplateSpecializationDecl> spec_iterator*/
//  public final class spec_iterator extends SpecIterator<VarTemplateSpecializationDecl, /*SpecEntryTraits,*/ VarTemplateSpecializationDecl>{ };
  /*typedef llvm::iterator_range<spec_iterator> spec_range*/
//  public final class spec_range extends iterator_range<VarTemplateSpecializationDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::specializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2895,
   FQN="clang::VarTemplateDecl::specializations", NM="_ZNK5clang15VarTemplateDecl15specializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl15specializationsEv")
  //</editor-fold>
  public iterator_range<VarTemplateSpecializationDecl /*P*/ > specializations() /*const*/ {
    return new iterator_range<VarTemplateSpecializationDecl /*P*/ >(spec_begin(), spec_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::spec_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2899,
   FQN="clang::VarTemplateDecl::spec_begin", NM="_ZNK5clang15VarTemplateDecl10spec_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl10spec_beginEv")
  //</editor-fold>
  public SpecIterator<VarTemplateSpecializationDecl, /*SpecEntryTraits,*/ VarTemplateSpecializationDecl> spec_begin() /*const*/ {
    return makeSpecIterator(getSpecializations(), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::spec_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2903,
   FQN="clang::VarTemplateDecl::spec_end", NM="_ZNK5clang15VarTemplateDecl8spec_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang15VarTemplateDecl8spec_endEv")
  //</editor-fold>
  public SpecIterator<VarTemplateSpecializationDecl, /*SpecEntryTraits,*/ VarTemplateSpecializationDecl> spec_end() /*const*/ {
    return makeSpecIterator(getSpecializations(), true);
  }

  
  // Implement isa/cast/dyncast support
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2908,
   FQN="clang::VarTemplateDecl::classof", NM="_ZN5clang15VarTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2909,
   FQN="clang::VarTemplateDecl::classofKind", NM="_ZN5clang15VarTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.VarTemplate;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplateDecl::~VarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2749,
   FQN="clang::VarTemplateDecl::~VarTemplateDecl", NM="_ZN5clang15VarTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang15VarTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
