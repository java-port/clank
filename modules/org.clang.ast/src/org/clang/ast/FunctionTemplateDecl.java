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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.DeclTemplateStatics.*;


/// Declaration of a template function.
//<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 838,
 FQN="clang::FunctionTemplateDecl", NM="_ZN5clang20FunctionTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDeclE")
//</editor-fold>
public class FunctionTemplateDecl extends /*public*/ RedeclarableTemplateDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // FunctionTemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::DeallocateCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 242,
   FQN="clang::FunctionTemplateDecl::DeallocateCommon", NM="_ZN5clang20FunctionTemplateDecl16DeallocateCommonEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl16DeallocateCommonEPv")
  //</editor-fold>
  private static void DeallocateCommon(Object/*void P*/ Ptr) {
    ((/*static_cast*/Common /*P*/ )(Ptr)).$destroy();
  }

/*protected:*/
  /// \brief Data that is common to all of the declarations of a given
  /// function template.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::Common">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 844,
   FQN="clang::FunctionTemplateDecl::Common", NM="_ZN5clang20FunctionTemplateDecl6CommonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl6CommonE")
  //</editor-fold>
  public/*friend*//*protected*/ static class/*struct*/ Common extends /**/ CommonBase implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::Common::Common">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 845,
     FQN="clang::FunctionTemplateDecl::Common::Common", NM="_ZN5clang20FunctionTemplateDecl6CommonC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl6CommonC1Ev")
    //</editor-fold>
    public Common() {
      // : CommonBase(), Specializations(), InjectedArgs(implicit TemplateArgument * ()), LazySpecializations(implicit uint32_t * ()) 
      //START JInit
      super();
      this.Specializations = new FoldingSetVector<FunctionTemplateSpecializationInfo>();
      this.InjectedArgs = $tryClone(/*implicit-init*/((type$ptr<TemplateArgument/*P*/> )/*zero-init*/null));
      this.LazySpecializations = $tryClone(/*implicit-init*/((/*uint32_t P*/uint$ptr )/*zero-init*/null));
      //END JInit
    }

    
    /// \brief The function template specializations for this function
    /// template, including explicit specializations and instantiations.
    public FoldingSetVector<FunctionTemplateSpecializationInfo> Specializations;
    
    /// \brief The set of "injected" template arguments used within this
    /// function template.
    ///
    /// This pointer refers to the template arguments (there are as
    /// many template arguments as template parameaters) for the function
    /// template, and is allocated lazily, since most function templates do not
    /// require the use of this information.
    public type$ptr<TemplateArgument/*P*/> InjectedArgs;
    
    /// \brief If non-null, points to an array of specializations known only
    /// by their external declaration IDs.
    ///
    /// The first value in the array is the number of of specializations
    /// that follow.
    //JAVA moved field to super class
    //public /*uint32_t P*/uint$ptr LazySpecializations;
    //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::Common::~Common">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 844,
     FQN="clang::FunctionTemplateDecl::Common::~Common", NM="_ZN5clang20FunctionTemplateDecl6CommonD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl6CommonD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Specializations.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Specializations=" + Specializations // NOI18N
                + ", InjectedArgs=" + InjectedArgs // NOI18N
                + ", LazySpecializations=" + LazySpecializations // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::FunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 868,
   FQN="clang::FunctionTemplateDecl::FunctionTemplateDecl", NM="_ZN5clang20FunctionTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  protected FunctionTemplateDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L, 
      DeclarationName Name, TemplateParameterList /*P*/ Params, 
      NamedDecl /*P*/ Decl) {
    // : RedeclarableTemplateDecl(FunctionTemplate, C, DC, L, Name, Params, Decl) 
    //START JInit
    super(Kind.FunctionTemplate, C, DC, new SourceLocation(L), new DeclarationName(Name), Params, 
        Decl);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::newCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 262,
   FQN="clang::FunctionTemplateDecl::newCommon", NM="_ZNK5clang20FunctionTemplateDecl9newCommonERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl9newCommonERNS_10ASTContextE")
  //</editor-fold>
  @Override /*friend*/public RedeclarableTemplateDecl.CommonBase /*P*/ newCommon(final ASTContext /*&*/ C) /*const*//* override*/ {
    Common /*P*/ CommonPtr = /*FIXME:NEW_EXPR*//*new (C)*/ new Common();
    C.AddDeallocation(/*FuncRef*/FunctionTemplateDecl::DeallocateCommon, CommonPtr);
    return CommonPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getCommonPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 876,
   FQN="clang::FunctionTemplateDecl::getCommonPtr", NM="_ZNK5clang20FunctionTemplateDecl12getCommonPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl12getCommonPtrEv")
  //</editor-fold>
  /*friend*/public Common /*P*/ getCommonPtr() /*const*/ {
    return ((/*static_cast*/Common /*P*/ )(super.getCommonPtr()));
  }

  
  /*friend  class FunctionDecl*/
  
  /// \brief Retrieve the set of function template specializations of this
  /// function template.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getSpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 284,
   FQN="clang::FunctionTemplateDecl::getSpecializations", NM="_ZNK5clang20FunctionTemplateDecl18getSpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl18getSpecializationsEv")
  //</editor-fold>
  protected FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ getSpecializations() /*const*/ {
    LoadLazySpecializations();
    return getCommonPtr().Specializations;
  }

  
  /// \brief Add a specialization of this function template.
  ///
  /// \param InsertPos Insert position in the FoldingSetVector, must have been
  ///        retrieved by an earlier call to findSpecialization().
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::addSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 296,
   FQN="clang::FunctionTemplateDecl::addSpecialization", NM="_ZN5clang20FunctionTemplateDecl17addSpecializationEPNS_34FunctionTemplateSpecializationInfoEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl17addSpecializationEPNS_34FunctionTemplateSpecializationInfoEPv")
  //</editor-fold>
  protected void addSpecialization(FunctionTemplateSpecializationInfo /*P*/ Info, type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos) {
    addSpecializationImpl$FunctionTemplateSpecializationInfo/*<FunctionTemplateDecl>*/(getSpecializations(), Info, 
        InsertPos);
  }

/*public:*/
  /// \brief Load any lazily-loaded specializations from the external source.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::LoadLazySpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 269,
   FQN="clang::FunctionTemplateDecl::LoadLazySpecializations", NM="_ZNK5clang20FunctionTemplateDecl23LoadLazySpecializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl23LoadLazySpecializationsEv")
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

  
  /// Get the underlying function declaration of the template.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getTemplatedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 899,
   FQN="clang::FunctionTemplateDecl::getTemplatedDecl", NM="_ZNK5clang20FunctionTemplateDecl16getTemplatedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl16getTemplatedDeclEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getTemplatedDecl() /*const*/ {
    return ((/*static_cast*/FunctionDecl /*P*/ )(TemplatedDecl.getPointer()));
  }

  
  /// Returns whether this template declaration defines the primary
  /// pattern.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::isThisDeclarationADefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 905,
   FQN="clang::FunctionTemplateDecl::isThisDeclarationADefinition", NM="_ZNK5clang20FunctionTemplateDecl28isThisDeclarationADefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl28isThisDeclarationADefinitionEv")
  //</editor-fold>
  public boolean isThisDeclarationADefinition() /*const*/ {
    return getTemplatedDecl().isThisDeclarationADefinition();
  }

  
  /// \brief Return the specialization with the provided arguments if it exists,
  /// otherwise return the insertion point.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::findSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 290,
   FQN="clang::FunctionTemplateDecl::findSpecialization", NM="_ZN5clang20FunctionTemplateDecl18findSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl18findSpecializationEN4llvm8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  public FunctionDecl /*P*/ findSpecialization(ArrayRef<TemplateArgument> Args, 
                    final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>>/*void P&*/ InsertPos) {
    return findSpecializationImpl$FunctionTemplateSpecializationInfo(getSpecializations(), new ArrayRef<TemplateArgument>(Args), InsertPos);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 914,
   FQN="clang::FunctionTemplateDecl::getCanonicalDecl", NM="_ZN5clang20FunctionTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public FunctionTemplateDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_FunctionTemplateDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 918,
   FQN="clang::FunctionTemplateDecl::getCanonicalDecl", NM="_ZNK5clang20FunctionTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ FunctionTemplateDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return cast_FunctionTemplateDecl(super.getCanonicalDecl$Const());
  }

  
  /// \brief Retrieve the previous declaration of this function template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 925,
   FQN="clang::FunctionTemplateDecl::getPreviousDecl", NM="_ZN5clang20FunctionTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getPreviousDecl() {
    return cast_or_null_FunctionTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.getPreviousDecl$Redeclarable());
  }

  
  /// \brief Retrieve the previous declaration of this function template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 932,
   FQN="clang::FunctionTemplateDecl::getPreviousDecl", NM="_ZNK5clang20FunctionTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ FunctionTemplateDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return cast_or_null_FunctionTemplateDecl(/*JCast:const RedeclarableTemplateDecl * */super.getPreviousDecl$Redeclarable$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 937,
   FQN="clang::FunctionTemplateDecl::getMostRecentDecl", NM="_ZN5clang20FunctionTemplateDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl17getMostRecentDeclEv")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getMostRecentDecl() {
    return cast_FunctionTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.
      getMostRecentDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 942,
   FQN="clang::FunctionTemplateDecl::getMostRecentDecl", NM="_ZNK5clang20FunctionTemplateDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ FunctionTemplateDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/FunctionTemplateDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 946,
   FQN="clang::FunctionTemplateDecl::getInstantiatedFromMemberTemplate", NM="_ZNK5clang20FunctionTemplateDecl33getInstantiatedFromMemberTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl33getInstantiatedFromMemberTemplateEv")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getInstantiatedFromMemberTemplate() /*const*/ {
    return cast_or_null_FunctionTemplateDecl(super.getInstantiatedFromMemberTemplate());
  }

  
  /*typedef SpecIterator<FunctionTemplateSpecializationInfo> spec_iterator*/
//  public final class spec_iterator extends SpecIterator<FunctionTemplateSpecializationInfo>{ };
  /*typedef llvm::iterator_range<spec_iterator> spec_range*/
//  public final class spec_range extends iterator_range<FunctionDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::specializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 954,
   FQN="clang::FunctionTemplateDecl::specializations", NM="_ZNK5clang20FunctionTemplateDecl15specializationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl15specializationsEv")
  //</editor-fold>
  public iterator_range<FunctionDecl /*P*/ > specializations() /*const*/ {
    return new iterator_range<FunctionDecl /*P*/ >(spec_begin(), spec_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::spec_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 957,
   FQN="clang::FunctionTemplateDecl::spec_begin", NM="_ZNK5clang20FunctionTemplateDecl10spec_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl10spec_beginEv")
  //</editor-fold>
  public SpecIterator<FunctionTemplateSpecializationInfo, /*SpecEntryTraits,*/ FunctionDecl> spec_begin() /*const*/ {
    return makeSpecIterator(SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info(), getSpecializations(), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::spec_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 961,
   FQN="clang::FunctionTemplateDecl::spec_end", NM="_ZNK5clang20FunctionTemplateDecl8spec_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20FunctionTemplateDecl8spec_endEv")
  //</editor-fold>
  public SpecIterator<FunctionTemplateSpecializationInfo, /*SpecEntryTraits,*/ FunctionDecl> spec_end() /*const*/ {
    return makeSpecIterator(SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info(), getSpecializations(), true);
  }

  
  /// \brief Retrieve the "injected" template arguments that correspond to the
  /// template parameters of this function template.
  ///
  /// Although the C++ standard has no notion of the "injected" template
  /// arguments for a function template, the notion is convenient when
  /// we need to perform substitutions inside the definition of a function
  /// template.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::getInjectedTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 302,
   FQN="clang::FunctionTemplateDecl::getInjectedTemplateArgs", NM="_ZN5clang20FunctionTemplateDecl23getInjectedTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl23getInjectedTemplateArgsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgument> getInjectedTemplateArgs() {
    TemplateParameterList /*P*/ Params = getTemplateParameters();
    Common /*P*/ CommonPtr = getCommonPtr();
    if (!Native.$bool(CommonPtr.InjectedArgs)) {
      CommonPtr.InjectedArgs = create_type$ptr(/*FIXME:NEW_EXPR*//*new (getASTContext())*/ new TemplateArgument [Params.size()]);
      GenerateInjectedTemplateArgs(getASTContext(), Params, 
          CommonPtr.InjectedArgs);
    }
    
    return llvm.makeArrayRef(CommonPtr.InjectedArgs, Params.size());
  }

  
  /// \brief Create a function template node.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 246,
   FQN="clang::FunctionTemplateDecl::Create", NM="_ZN5clang20FunctionTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  public static FunctionTemplateDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation L, 
        DeclarationName Name, 
        TemplateParameterList /*P*/ Params, 
        NamedDecl /*P*/ Decl) {
    AdoptTemplateParameterList(Params, cast_DeclContext(Decl));
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new FunctionTemplateDecl(C, DC, new SourceLocation(L), new DeclarationName(Name), Params, Decl);
     });
  }

  
  /// \brief Create an empty function template node.
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 256,
   FQN="clang::FunctionTemplateDecl::CreateDeserialized", NM="_ZN5clang20FunctionTemplateDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static FunctionTemplateDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new FunctionTemplateDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationName(), (TemplateParameterList /*P*/ )null, (NamedDecl /*P*/ )null);
     });
  }

  
  // Implement isa/cast/dyncast support
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 985,
   FQN="clang::FunctionTemplateDecl::classof", NM="_ZN5clang20FunctionTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 986,
   FQN="clang::FunctionTemplateDecl::classofKind", NM="_ZN5clang20FunctionTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.FunctionTemplate;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionTemplateDecl::~FunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 838,
   FQN="clang::FunctionTemplateDecl::~FunctionTemplateDecl", NM="_ZN5clang20FunctionTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20FunctionTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
