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
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.DeclTemplateStatics.*;


/// \brief Declaration of an alias template.
///
/// For example:
/// \code
/// template \<typename T> using V = std::map<T*, int, MyCompare<T>>;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2223,
 FQN="clang::TypeAliasTemplateDecl", NM="_ZN5clang21TypeAliasTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDeclE")
//</editor-fold>
public class TypeAliasTemplateDecl extends /*public*/ RedeclarableTemplateDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::DeallocateCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 907,
   FQN="clang::TypeAliasTemplateDecl::DeallocateCommon", NM="_ZN5clang21TypeAliasTemplateDecl16DeallocateCommonEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl16DeallocateCommonEPv")
  //</editor-fold>
  private static void DeallocateCommon(Object/*void P*/ Ptr) {
    ((/*static_cast*/CommonBase /*P*/ )(Ptr)).$destroy();
  }

/*protected:*/
  /*typedef CommonBase Common*/
//  public final class Common extends CommonBase{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::TypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2229,
   FQN="clang::TypeAliasTemplateDecl::TypeAliasTemplateDecl", NM="_ZN5clang21TypeAliasTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  protected TypeAliasTemplateDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L, 
      DeclarationName Name, TemplateParameterList /*P*/ Params, 
      NamedDecl /*P*/ Decl) {
    // : RedeclarableTemplateDecl(TypeAliasTemplate, C, DC, L, Name, Params, Decl) 
    //START JInit
    super(Kind.TypeAliasTemplate, C, DC, new SourceLocation(L), new DeclarationName(Name), Params, 
        Decl);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::newCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 910,
   FQN="clang::TypeAliasTemplateDecl::newCommon", NM="_ZNK5clang21TypeAliasTemplateDecl9newCommonERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TypeAliasTemplateDecl9newCommonERNS_10ASTContextE")
  //</editor-fold>
  @Override /*friend*/public RedeclarableTemplateDecl.CommonBase /*P*/ newCommon(final ASTContext /*&*/ C) /*const*//* override*/ {
    CommonBase /*P*/ CommonPtr = /*FIXME:NEW_EXPR*//*new (C)*/ new CommonBase();
    C.AddDeallocation(/*FuncRef*/TypeAliasTemplateDecl::DeallocateCommon, CommonPtr);
    return CommonPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getCommonPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2237,
   FQN="clang::TypeAliasTemplateDecl::getCommonPtr", NM="_ZN5clang21TypeAliasTemplateDecl12getCommonPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl12getCommonPtrEv")
  //</editor-fold>
  /*friend*/public CommonBase /*P*/ getCommonPtr() {
    return ((/*static_cast*/CommonBase /*P*/ )(super.getCommonPtr()));
  }

/*public:*/
  /// Get the underlying function declaration of the template.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getTemplatedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2243,
   FQN="clang::TypeAliasTemplateDecl::getTemplatedDecl", NM="_ZNK5clang21TypeAliasTemplateDecl16getTemplatedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TypeAliasTemplateDecl16getTemplatedDeclEv")
  //</editor-fold>
  public TypeAliasDecl /*P*/ getTemplatedDecl() /*const*/ {
    return ((/*static_cast*/TypeAliasDecl /*P*/ )(TemplatedDecl.getPointer()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2248,
   FQN="clang::TypeAliasTemplateDecl::getCanonicalDecl", NM="_ZN5clang21TypeAliasTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public TypeAliasTemplateDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_TypeAliasTemplateDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2252,
   FQN="clang::TypeAliasTemplateDecl::getCanonicalDecl", NM="_ZNK5clang21TypeAliasTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TypeAliasTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ TypeAliasTemplateDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return cast_TypeAliasTemplateDecl(super.getCanonicalDecl$Const());
  }

  
  /// \brief Retrieve the previous declaration of this function template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2259,
   FQN="clang::TypeAliasTemplateDecl::getPreviousDecl", NM="_ZN5clang21TypeAliasTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public TypeAliasTemplateDecl /*P*/ getPreviousDecl() {
    return cast_or_null_TypeAliasTemplateDecl(/*JCast:RedeclarableTemplateDecl * */super.getPreviousDecl());
  }

  
  /// \brief Retrieve the previous declaration of this function template, or
  /// NULL if no such declaration exists.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2266,
   FQN="clang::TypeAliasTemplateDecl::getPreviousDecl", NM="_ZNK5clang21TypeAliasTemplateDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TypeAliasTemplateDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ TypeAliasTemplateDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return cast_or_null_TypeAliasTemplateDecl(/*JCast:const RedeclarableTemplateDecl * */super.getPreviousDecl$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::getInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2272,
   FQN="clang::TypeAliasTemplateDecl::getInstantiatedFromMemberTemplate", NM="_ZNK5clang21TypeAliasTemplateDecl33getInstantiatedFromMemberTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TypeAliasTemplateDecl33getInstantiatedFromMemberTemplateEv")
  //</editor-fold>
  public TypeAliasTemplateDecl /*P*/ getInstantiatedFromMemberTemplate() /*const*/ {
    return cast_or_null_TypeAliasTemplateDecl(super.getInstantiatedFromMemberTemplate());
  }

  
  /// \brief Create a function template node.
  
  /// \brief Create a function template node.

  //===----------------------------------------------------------------------===//
  // TypeAliasTemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 891,
   FQN="clang::TypeAliasTemplateDecl::Create", NM="_ZN5clang21TypeAliasTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  public static TypeAliasTemplateDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation L, 
        DeclarationName Name, 
        TemplateParameterList /*P*/ Params, 
        NamedDecl /*P*/ Decl) {
    AdoptTemplateParameterList(Params, DC);
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new TypeAliasTemplateDecl(C, DC, new SourceLocation(L), new DeclarationName(Name), Params, Decl);
     });
  }

  
  /// \brief Create an empty alias template node.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 901,
   FQN="clang::TypeAliasTemplateDecl::CreateDeserialized", NM="_ZN5clang21TypeAliasTemplateDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static TypeAliasTemplateDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new TypeAliasTemplateDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationName(), (TemplateParameterList /*P*/ )null, (NamedDecl /*P*/ )null);
     });
  }

  
  // Implement isa/cast/dyncast support
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2289,
   FQN="clang::TypeAliasTemplateDecl::classof", NM="_ZN5clang21TypeAliasTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2290,
   FQN="clang::TypeAliasTemplateDecl::classofKind", NM="_ZN5clang21TypeAliasTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.TypeAliasTemplate;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeAliasTemplateDecl::~TypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2223,
   FQN="clang::TypeAliasTemplateDecl::~TypeAliasTemplateDecl", NM="_ZN5clang21TypeAliasTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TypeAliasTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
