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
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.impl.DeclTemplateStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1782,
 FQN="clang::ClassTemplatePartialSpecializationDecl", NM="_ZN5clang38ClassTemplatePartialSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDeclE")
//</editor-fold>
public class ClassTemplatePartialSpecializationDecl extends /*public*/ ClassTemplateSpecializationDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ClassTemplatePartialSpecializationDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 812,
   FQN="clang::ClassTemplatePartialSpecializationDecl::anchor", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The list of template parameters
  /*friend*/public TemplateParameterList /*P*/ TemplateParams;
  
  /// \brief The source info for the template arguments as written.
  /// FIXME: redundant with TypeAsWritten?
  /*friend*/public /*const*/ ASTTemplateArgumentListInfo /*P*/ ArgsAsWritten;
  
  /// \brief The class template partial specialization from which this
  /// class template partial specialization was instantiated.
  ///
  /// The boolean value will be true to indicate that this class template
  /// partial specialization was specialized at this level.
  /*friend*/public PointerBoolPair<ClassTemplatePartialSpecializationDecl /*P*/ > InstantiatedFromMember;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::ClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 814,
   FQN="clang::ClassTemplatePartialSpecializationDecl::ClassTemplatePartialSpecializationDecl", NM="_ZN5clang38ClassTemplatePartialSpecializationDeclC1ERNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES6_PNS_21TemplateParameterListEPNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPKNS_27ASTTemplateArgumentListInfoEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDeclC1ERNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES6_PNS_21TemplateParameterListEPNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEEPKNS_27ASTTemplateArgumentListInfoEPS0_")
  //</editor-fold>
  private ClassTemplatePartialSpecializationDecl(final ASTContext /*&*/ Context, TagTypeKind TK, 
      DeclContext /*P*/ DC, 
      SourceLocation StartLoc, 
      SourceLocation IdLoc, 
      TemplateParameterList /*P*/ Params, 
      ClassTemplateDecl /*P*/ SpecializedTemplate, 
      ArrayRef<TemplateArgument> Args, 
      /*const*/ ASTTemplateArgumentListInfo /*P*/ ArgInfos, 
      ClassTemplatePartialSpecializationDecl /*P*/ PrevDecl) {
    // : ClassTemplateSpecializationDecl(Context, ClassTemplatePartialSpecialization, TK, DC, StartLoc, IdLoc, SpecializedTemplate, Args, PrevDecl), TemplateParams(Params), ArgsAsWritten(ArgInfos), InstantiatedFromMember(null, false) 
    //START JInit
    super(Context, 
        Kind.ClassTemplatePartialSpecialization, 
        TK, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
        SpecializedTemplate, 
        new ArrayRef<TemplateArgument>(Args), PrevDecl);
    this.TemplateParams = Params;
    this.ArgsAsWritten = ArgInfos;
    this.InstantiatedFromMember = new PointerBoolPair<ClassTemplatePartialSpecializationDecl /*P*/ >((ClassTemplatePartialSpecializationDecl /*P*/ )null, false);
    //END JInit
    AdoptTemplateParameterList(Params, this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::ClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1811,
   FQN="clang::ClassTemplatePartialSpecializationDecl::ClassTemplatePartialSpecializationDecl", NM="_ZN5clang38ClassTemplatePartialSpecializationDeclC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDeclC1ERNS_10ASTContextE")
  //</editor-fold>
  private ClassTemplatePartialSpecializationDecl(final ASTContext /*&*/ C) {
    // : ClassTemplateSpecializationDecl(C, ClassTemplatePartialSpecialization), TemplateParams(null), ArgsAsWritten(null), InstantiatedFromMember(null, false) 
    //START JInit
    super(C, Kind.ClassTemplatePartialSpecialization);
    this.TemplateParams = null;
    this.ArgsAsWritten = null;
    this.InstantiatedFromMember = new PointerBoolPair<ClassTemplatePartialSpecializationDecl /*P*/ >((ClassTemplatePartialSpecializationDecl /*P*/ )null, false);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 835,
   FQN="clang::ClassTemplatePartialSpecializationDecl::Create", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl6CreateERNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES6_PNS_21TemplateParameterListEPNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEERKNS_24TemplateArgumentListInfoENS_8QualTypeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl6CreateERNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES6_PNS_21TemplateParameterListEPNS_17ClassTemplateDeclEN4llvm8ArrayRefINS_16TemplateArgumentEEERKNS_24TemplateArgumentListInfoENS_8QualTypeEPS0_")
  //</editor-fold>
  public static ClassTemplatePartialSpecializationDecl /*P*/ Create(final ASTContext /*&*/ Context, TagTypeKind TK, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation IdLoc, 
        TemplateParameterList /*P*/ Params, 
        ClassTemplateDecl /*P*/ SpecializedTemplate, 
        ArrayRef<TemplateArgument> Args, 
        final /*const*/ TemplateArgumentListInfo /*&*/ ArgInfos, 
        QualType CanonInjectedType, 
        ClassTemplatePartialSpecializationDecl /*P*/ PrevDecl) {
    /*const*/ ASTTemplateArgumentListInfo /*P*/ ASTArgInfos = ASTTemplateArgumentListInfo.Create(Context, ArgInfos);
    
    ClassTemplatePartialSpecializationDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (Context, DC)*/ Decl.$new(Context, DC, (type$ptr<?> Mem)->{
        return new ClassTemplatePartialSpecializationDecl(Context, TK, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
                Params, SpecializedTemplate, new ArrayRef<TemplateArgument>(Args), 
                ASTArgInfos, PrevDecl);
     });
    Result.setSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
    Result.MayHaveOutOfDateDef = false;
    
    Context.getInjectedClassNameType(Result, new QualType(CanonInjectedType));
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 859,
   FQN="clang::ClassTemplatePartialSpecializationDecl::CreateDeserialized", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ClassTemplatePartialSpecializationDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    ClassTemplatePartialSpecializationDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ClassTemplatePartialSpecializationDecl(C);
     });
    Result.MayHaveOutOfDateDef = false;
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1830,
   FQN="clang::ClassTemplatePartialSpecializationDecl::getMostRecentDecl", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl17getMostRecentDeclEv")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ getMostRecentDecl() {
    return cast_ClassTemplatePartialSpecializationDecl(/*J:cast-to-base*/super.getMostRecentDecl());
  }

  
  /// Get the list of template parameters
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::getTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1837,
   FQN="clang::ClassTemplatePartialSpecializationDecl::getTemplateParameters", NM="_ZNK5clang38ClassTemplatePartialSpecializationDecl21getTemplateParametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang38ClassTemplatePartialSpecializationDecl21getTemplateParametersEv")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameters() /*const*/ {
    return TemplateParams;
  }

  
  /// Get the template arguments as written.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::getTemplateArgsAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1842,
   FQN="clang::ClassTemplatePartialSpecializationDecl::getTemplateArgsAsWritten", NM="_ZNK5clang38ClassTemplatePartialSpecializationDecl24getTemplateArgsAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang38ClassTemplatePartialSpecializationDecl24getTemplateArgsAsWrittenEv")
  //</editor-fold>
  public /*const*/ ASTTemplateArgumentListInfo /*P*/ getTemplateArgsAsWritten() /*const*/ {
    return ArgsAsWritten;
  }

  
  /// \brief Retrieve the member class template partial specialization from
  /// which this particular class template partial specialization was
  /// instantiated.
  ///
  /// \code
  /// template<typename T>
  /// struct Outer {
  ///   template<typename U> struct Inner;
  ///   template<typename U> struct Inner<U*> { }; // #1
  /// };
  ///
  /// Outer<float>::Inner<int*> ii;
  /// \endcode
  ///
  /// In this example, the instantiation of \c Outer<float>::Inner<int*> will
  /// end up instantiating the partial specialization
  /// \c Outer<float>::Inner<U*>, which itself was instantiated from the class
  /// template partial specialization \c Outer<T>::Inner<U*>. Given
  /// \c Outer<float>::Inner<U*>, this function would return
  /// \c Outer<T>::Inner<U*>.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::getInstantiatedFromMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1866,
   FQN="clang::ClassTemplatePartialSpecializationDecl::getInstantiatedFromMember", NM="_ZNK5clang38ClassTemplatePartialSpecializationDecl25getInstantiatedFromMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang38ClassTemplatePartialSpecializationDecl25getInstantiatedFromMemberEv")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ getInstantiatedFromMember() /*const*/ {
    /*const*/ ClassTemplatePartialSpecializationDecl /*P*/ First = cast_ClassTemplatePartialSpecializationDecl(getFirstDecl$Const());
    return First.InstantiatedFromMember.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::getInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1871,
   FQN="clang::ClassTemplatePartialSpecializationDecl::getInstantiatedFromMemberTemplate", NM="_ZNK5clang38ClassTemplatePartialSpecializationDecl33getInstantiatedFromMemberTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang38ClassTemplatePartialSpecializationDecl33getInstantiatedFromMemberTemplateEv")
  //</editor-fold>
  public ClassTemplatePartialSpecializationDecl /*P*/ getInstantiatedFromMemberTemplate() /*const*/ {
    return getInstantiatedFromMember();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::setInstantiatedFromMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1876,
   FQN="clang::ClassTemplatePartialSpecializationDecl::setInstantiatedFromMember", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl25setInstantiatedFromMemberEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl25setInstantiatedFromMemberEPS0_")
  //</editor-fold>
  public void setInstantiatedFromMember(ClassTemplatePartialSpecializationDecl /*P*/ PartialSpec) {
    ClassTemplatePartialSpecializationDecl /*P*/ First = cast_ClassTemplatePartialSpecializationDecl(getFirstDecl());
    First.InstantiatedFromMember.setPointer(PartialSpec);
  }

  
  /// \brief Determines whether this class template partial specialization
  /// template was a specialization of a member partial specialization.
  ///
  /// In the following example, the member template partial specialization
  /// \c X<int>::Inner<T*> is a member specialization.
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   template<typename U> struct Inner;
  ///   template<typename U> struct Inner<U*>;
  /// };
  ///
  /// template<> template<typename T>
  /// struct X<int>::Inner<T*> { /* ... */ };
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::isMemberSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1899,
   FQN="clang::ClassTemplatePartialSpecializationDecl::isMemberSpecialization", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl22isMemberSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl22isMemberSpecializationEv")
  //</editor-fold>
  public boolean isMemberSpecialization() {
    ClassTemplatePartialSpecializationDecl /*P*/ First = cast_ClassTemplatePartialSpecializationDecl(getFirstDecl());
    return First.InstantiatedFromMember.getInt();
  }

  
  /// \brief Note that this member template is a specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::setMemberSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1906,
   FQN="clang::ClassTemplatePartialSpecializationDecl::setMemberSpecialization", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl23setMemberSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl23setMemberSpecializationEv")
  //</editor-fold>
  public void setMemberSpecialization() {
    ClassTemplatePartialSpecializationDecl /*P*/ First = cast_ClassTemplatePartialSpecializationDecl(getFirstDecl());
    assert ((First.InstantiatedFromMember.getPointer() != null)) : "Only member templates can be member template specializations";
    First.InstantiatedFromMember.setInt(true);
    /*JAVA:return*/return;
  }

  
  /// Retrieves the injected specialization type for this partial
  /// specialization.  This is not the same as the type-decl-type for
  /// this partial specialization, which is an InjectedClassNameType.
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::getInjectedSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1917,
   FQN="clang::ClassTemplatePartialSpecializationDecl::getInjectedSpecializationType", NM="_ZNK5clang38ClassTemplatePartialSpecializationDecl29getInjectedSpecializationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang38ClassTemplatePartialSpecializationDecl29getInjectedSpecializationTypeEv")
  //</editor-fold>
  public QualType getInjectedSpecializationType() /*const*/ {
    assert ((getTypeForDecl() != null)) : "partial specialization has no type set!";
    return cast_InjectedClassNameType(getTypeForDecl()).
        getInjectedSpecializationType();
  }

  
  // FIXME: Add Profile support!
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1925,
   FQN="clang::ClassTemplatePartialSpecializationDecl::classof", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1926,
   FQN="clang::ClassTemplatePartialSpecializationDecl::classofKind", NM="_ZN5clang38ClassTemplatePartialSpecializationDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ClassTemplatePartialSpecialization;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ClassTemplatePartialSpecializationDecl::~ClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1782,
   FQN="clang::ClassTemplatePartialSpecializationDecl::~ClassTemplatePartialSpecializationDecl", NM="_ZN5clang38ClassTemplatePartialSpecializationDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang38ClassTemplatePartialSpecializationDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TemplateParams=" + TemplateParams // NOI18N
              + ", ArgsAsWritten=" + ArgsAsWritten // NOI18N
              + ", InstantiatedFromMember=" + InstantiatedFromMember // NOI18N
              + super.toString(); // NOI18N
  }
}
