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
import static org.clang.ast.java.AstDeclarationsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2617,
 FQN="clang::VarTemplatePartialSpecializationDecl", NM="_ZN5clang36VarTemplatePartialSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDeclE")
//</editor-fold>
public class VarTemplatePartialSpecializationDecl extends /*public*/ VarTemplateSpecializationDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // VarTemplatePartialSpecializationDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1112,
   FQN="clang::VarTemplatePartialSpecializationDecl::anchor", NM="_ZN5clang36VarTemplatePartialSpecializationDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The list of template parameters
  /*friend*/public TemplateParameterList /*P*/ TemplateParams;
  
  /// \brief The source info for the template arguments as written.
  /// FIXME: redundant with TypeAsWritten?
  /*friend*/public /*const*/ ASTTemplateArgumentListInfo /*P*/ ArgsAsWritten;
  
  /// \brief The variable template partial specialization from which this
  /// variable template partial specialization was instantiated.
  ///
  /// The boolean value will be true to indicate that this variable template
  /// partial specialization was specialized at this level.
  /*friend*/public PointerBoolPair<VarTemplatePartialSpecializationDecl /*P*/ > InstantiatedFromMember;
  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::VarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1114,
   FQN="clang::VarTemplatePartialSpecializationDecl::VarTemplatePartialSpecializationDecl", NM="_ZN5clang36VarTemplatePartialSpecializationDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_21TemplateParameterListEPNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEEPKNS_27ASTTemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_21TemplateParameterListEPNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEEPKNS_27ASTTemplateArgumentListInfoE")
  //</editor-fold>
  private VarTemplatePartialSpecializationDecl(final ASTContext /*&*/ Context, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, TemplateParameterList /*P*/ Params, 
      VarTemplateDecl /*P*/ SpecializedTemplate, QualType T, TypeSourceInfo /*P*/ TInfo, 
      StorageClass S, ArrayRef<TemplateArgument> Args, 
      /*const*/ ASTTemplateArgumentListInfo /*P*/ ArgInfos) {
    // : VarTemplateSpecializationDecl(VarTemplatePartialSpecialization, Context, DC, StartLoc, IdLoc, SpecializedTemplate, T, TInfo, S, Args), TemplateParams(Params), ArgsAsWritten(ArgInfos), InstantiatedFromMember(null, false) 
    //START JInit
    super(Kind.VarTemplatePartialSpecialization, Context, 
        DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), SpecializedTemplate, new QualType(T), 
        TInfo, S, new ArrayRef<TemplateArgument>(Args));
    this.TemplateParams = Params;
    this.ArgsAsWritten = ArgInfos;
    this.InstantiatedFromMember = new PointerBoolPair<VarTemplatePartialSpecializationDecl /*P*/ >((VarTemplatePartialSpecializationDecl /*P*/ )null, false);
    //END JInit
    // TODO: The template parameters should be in DC by now. Verify.
    // AdoptTemplateParameterList(Params, DC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::VarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2643,
   FQN="clang::VarTemplatePartialSpecializationDecl::VarTemplatePartialSpecializationDecl", NM="_ZN5clang36VarTemplatePartialSpecializationDeclC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDeclC1ERNS_10ASTContextE")
  //</editor-fold>
  private VarTemplatePartialSpecializationDecl(final ASTContext /*&*/ Context) {
    // : VarTemplateSpecializationDecl(VarTemplatePartialSpecialization, Context), TemplateParams(null), ArgsAsWritten(null), InstantiatedFromMember(null, false) 
    //START JInit
    super(Kind.VarTemplatePartialSpecialization, Context);
    this.TemplateParams = null;
    this.ArgsAsWritten = null;
    this.InstantiatedFromMember = new PointerBoolPair<VarTemplatePartialSpecializationDecl /*P*/ >((VarTemplatePartialSpecializationDecl /*P*/ )null, false);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1129,
   FQN="clang::VarTemplatePartialSpecializationDecl::Create", NM="_ZN5clang36VarTemplatePartialSpecializationDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_21TemplateParameterListEPNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_21TemplateParameterListEPNS_15VarTemplateDeclENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEN4llvm8ArrayRefINS_16TemplateArgumentEEERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static VarTemplatePartialSpecializationDecl /*P*/ Create(final ASTContext /*&*/ Context, DeclContext /*P*/ DC, SourceLocation StartLoc, 
        SourceLocation IdLoc, TemplateParameterList /*P*/ Params, 
        VarTemplateDecl /*P*/ SpecializedTemplate, QualType T, TypeSourceInfo /*P*/ TInfo, 
        StorageClass S, ArrayRef<TemplateArgument> Args, 
        final /*const*/ TemplateArgumentListInfo /*&*/ ArgInfos) {
    /*const*/ ASTTemplateArgumentListInfo /*P*/ ASTArgInfos = ASTTemplateArgumentListInfo.Create(Context, ArgInfos);
    
    VarTemplatePartialSpecializationDecl /*P*/ Result = /*NEW_EXPR [Decl::new]*//*new (Context, DC)*/ Decl.$new(Context, DC, (type$ptr<?> Mem)->{
        return new VarTemplatePartialSpecializationDecl(Context, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Params, SpecializedTemplate, new QualType(T), TInfo, 
                S, new ArrayRef<TemplateArgument>(Args), ASTArgInfos);
     });
    Result.setSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 1147,
   FQN="clang::VarTemplatePartialSpecializationDecl::CreateDeserialized", NM="_ZN5clang36VarTemplatePartialSpecializationDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static VarTemplatePartialSpecializationDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new VarTemplatePartialSpecializationDecl(C);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2659,
   FQN="clang::VarTemplatePartialSpecializationDecl::getMostRecentDecl", NM="_ZN5clang36VarTemplatePartialSpecializationDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl17getMostRecentDeclEv")
  //</editor-fold>
  public VarTemplatePartialSpecializationDecl /*P*/ getMostRecentDecl() {
    return cast_VarTemplatePartialSpecializationDecl(/*JCast:VarTemplateSpecializationDecl * */super.getMostRecentDecl());
  }

  
  /// Get the list of template parameters
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::getTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2666,
   FQN="clang::VarTemplatePartialSpecializationDecl::getTemplateParameters", NM="_ZNK5clang36VarTemplatePartialSpecializationDecl21getTemplateParametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang36VarTemplatePartialSpecializationDecl21getTemplateParametersEv")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameters() /*const*/ {
    return TemplateParams;
  }

  
  /// Get the template arguments as written.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::getTemplateArgsAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2671,
   FQN="clang::VarTemplatePartialSpecializationDecl::getTemplateArgsAsWritten", NM="_ZNK5clang36VarTemplatePartialSpecializationDecl24getTemplateArgsAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang36VarTemplatePartialSpecializationDecl24getTemplateArgsAsWrittenEv")
  //</editor-fold>
  public /*const*/ ASTTemplateArgumentListInfo /*P*/ getTemplateArgsAsWritten() /*const*/ {
    return ArgsAsWritten;
  }

  
  /// \brief Retrieve the member variable template partial specialization from
  /// which this particular variable template partial specialization was
  /// instantiated.
  ///
  /// \code
  /// template<typename T>
  /// struct Outer {
  ///   template<typename U> U Inner;
  ///   template<typename U> U* Inner<U*> = (U*)(0); // #1
  /// };
  ///
  /// template int* Outer<float>::Inner<int*>;
  /// \endcode
  ///
  /// In this example, the instantiation of \c Outer<float>::Inner<int*> will
  /// end up instantiating the partial specialization
  /// \c Outer<float>::Inner<U*>, which itself was instantiated from the
  /// variable template partial specialization \c Outer<T>::Inner<U*>. Given
  /// \c Outer<float>::Inner<U*>, this function would return
  /// \c Outer<T>::Inner<U*>.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::getInstantiatedFromMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2695,
   FQN="clang::VarTemplatePartialSpecializationDecl::getInstantiatedFromMember", NM="_ZNK5clang36VarTemplatePartialSpecializationDecl25getInstantiatedFromMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang36VarTemplatePartialSpecializationDecl25getInstantiatedFromMemberEv")
  //</editor-fold>
  public VarTemplatePartialSpecializationDecl /*P*/ getInstantiatedFromMember() /*const*/ {
    /*const*/ VarTemplatePartialSpecializationDecl /*P*/ First = cast_VarTemplatePartialSpecializationDecl(getFirstDecl$Const());
    return First.InstantiatedFromMember.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::setInstantiatedFromMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2701,
   FQN="clang::VarTemplatePartialSpecializationDecl::setInstantiatedFromMember", NM="_ZN5clang36VarTemplatePartialSpecializationDecl25setInstantiatedFromMemberEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl25setInstantiatedFromMemberEPS0_")
  //</editor-fold>
  public void setInstantiatedFromMember(VarTemplatePartialSpecializationDecl /*P*/ PartialSpec) {
    VarTemplatePartialSpecializationDecl /*P*/ First = cast_VarTemplatePartialSpecializationDecl(getFirstDecl());
    First.InstantiatedFromMember.setPointer(PartialSpec);
  }

  
  /// \brief Determines whether this variable template partial specialization
  /// was a specialization of a member partial specialization.
  ///
  /// In the following example, the member template partial specialization
  /// \c X<int>::Inner<T*> is a member specialization.
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   template<typename U> U Inner;
  ///   template<typename U> U* Inner<U*> = (U*)(0);
  /// };
  ///
  /// template<> template<typename T>
  /// U* X<int>::Inner<T*> = (T*)(0) + 1;
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::isMemberSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2724,
   FQN="clang::VarTemplatePartialSpecializationDecl::isMemberSpecialization", NM="_ZN5clang36VarTemplatePartialSpecializationDecl22isMemberSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl22isMemberSpecializationEv")
  //</editor-fold>
  public boolean isMemberSpecialization() {
    VarTemplatePartialSpecializationDecl /*P*/ First = cast_VarTemplatePartialSpecializationDecl(getFirstDecl());
    return First.InstantiatedFromMember.getInt();
  }

  
  /// \brief Note that this member template is a specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::setMemberSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2731,
   FQN="clang::VarTemplatePartialSpecializationDecl::setMemberSpecialization", NM="_ZN5clang36VarTemplatePartialSpecializationDecl23setMemberSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl23setMemberSpecializationEv")
  //</editor-fold>
  public void setMemberSpecialization() {
    VarTemplatePartialSpecializationDecl /*P*/ First = cast_VarTemplatePartialSpecializationDecl(getFirstDecl());
    assert ((First.InstantiatedFromMember.getPointer() != null)) : "Only member templates can be member template specializations";
    First.InstantiatedFromMember.setInt(true);
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2739,
   FQN="clang::VarTemplatePartialSpecializationDecl::classof", NM="_ZN5clang36VarTemplatePartialSpecializationDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2740,
   FQN="clang::VarTemplatePartialSpecializationDecl::classofKind", NM="_ZN5clang36VarTemplatePartialSpecializationDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.VarTemplatePartialSpecialization;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::VarTemplatePartialSpecializationDecl::~VarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2617,
   FQN="clang::VarTemplatePartialSpecializationDecl::~VarTemplatePartialSpecializationDecl", NM="_ZN5clang36VarTemplatePartialSpecializationDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang36VarTemplatePartialSpecializationDeclD0Ev")
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
