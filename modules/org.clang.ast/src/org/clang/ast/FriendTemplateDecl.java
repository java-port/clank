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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Declaration of a friend template.
///
/// For example:
/// \code
/// template \<typename T> class A {
///   friend class MyVector<T>; // not a friend template
///   template \<typename U> friend class B; // not a friend template
///   template \<typename U> friend class Foo<T>::Nested; // friend template
/// };
/// \endcode
///
/// \note This class is not currently in use.  All of the above
/// will yield a FriendDecl, not a FriendTemplateDecl.
//<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2144,
 FQN="clang::FriendTemplateDecl", NM="_ZN5clang18FriendTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDeclE")
//</editor-fold>
public class FriendTemplateDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // FriendTemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 872,
   FQN="clang::FriendTemplateDecl::anchor", NM="_ZN5clang18FriendTemplateDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  /*typedef llvm::PointerUnion<NamedDecl *, TypeSourceInfo *> FriendUnion*/
//  public final class FriendUnion extends PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >{ };
/*private:*/
  // The number of template parameters;  always non-zero.
  /*friend*/public /*uint*/int NumParams;
  
  // The parameter list.
  /*friend*/public type$ptr<TemplateParameterList /*P*/ /*P*/> Params;
  
  // The declaration that's a friend of this class.
  /*friend*/public PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend;
  
  // Location of the 'friend' specifier.
  /*friend*/public SourceLocation FriendLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::FriendTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2162,
   FQN="clang::FriendTemplateDecl::FriendTemplateDecl", NM="_ZN5clang18FriendTemplateDeclC1EPNS_11DeclContextENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS4_12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDeclC1EPNS_11DeclContextENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS4_12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES3_")
  //</editor-fold>
  private FriendTemplateDecl(DeclContext /*P*/ DC, SourceLocation Loc, 
      MutableArrayRef<TemplateParameterList /*P*/ > Params, 
      PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend, SourceLocation FriendLoc) {
    // : Decl(Decl::FriendTemplate, DC, Loc), NumParams(Params.size()), Params(Params.data()), Friend(Friend), FriendLoc(FriendLoc) 
    //START JInit
    super(Decl.Kind.FriendTemplate, DC, new SourceLocation(Loc));
    this.NumParams = Params.size();
    this.Params = $tryClone(Params.data());
    this.Friend = new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(Friend);
    this.FriendLoc = new SourceLocation(FriendLoc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::FriendTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2168,
   FQN="clang::FriendTemplateDecl::FriendTemplateDecl", NM="_ZN5clang18FriendTemplateDeclC1ENS_4Decl10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDeclC1ENS_4Decl10EmptyShellE")
  //</editor-fold>
  private FriendTemplateDecl(EmptyShell Empty) {
    // : Decl(Decl::FriendTemplate, Empty), NumParams(0), Params(null), Friend(), FriendLoc() 
    //START JInit
    super(Decl.Kind.FriendTemplate, new EmptyShell(Empty));
    this.NumParams = 0;
    this.Params = null;
    this.Friend = new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(NamedDecl /*P*/ .class);
    this.FriendLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 874,
   FQN="clang::FriendTemplateDecl::Create", NM="_ZN5clang18FriendTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS6_12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS6_12PointerUnionIPNS_9NamedDeclEPNS_14TypeSourceInfoEEES5_")
  //</editor-fold>
  public static FriendTemplateDecl /*P*/ Create(final ASTContext /*&*/ Context, DeclContext /*P*/ DC, 
        SourceLocation L, 
        MutableArrayRef<TemplateParameterList /*P*/ > Params, 
        PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ > Friend, SourceLocation FLoc) {
    return /*NEW_EXPR [Decl::new]*//*new (Context, DC)*/ Decl.$new(Context, DC, (type$ptr<?> Mem)->{
        return new FriendTemplateDecl(DC, new SourceLocation(L), new MutableArrayRef<TemplateParameterList /*P*/ >(Params), new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(Friend), new SourceLocation(FLoc));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 882,
   FQN="clang::FriendTemplateDecl::CreateDeserialized", NM="_ZN5clang18FriendTemplateDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static FriendTemplateDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new FriendTemplateDecl(new EmptyShell());
     });
  }

  
  /// If this friend declaration names a templated type (or
  /// a dependent member type of a templated type), return that
  /// type;  otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::getFriendType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2185,
   FQN="clang::FriendTemplateDecl::getFriendType", NM="_ZNK5clang18FriendTemplateDecl13getFriendTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang18FriendTemplateDecl13getFriendTypeEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getFriendType() /*const*/ {
    return Friend.dyn_cast(TypeSourceInfo /*P*/.class);
  }

  
  /// If this friend declaration names a templated function (or
  /// a member function of a templated type), return that type;
  /// otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::getFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2192,
   FQN="clang::FriendTemplateDecl::getFriendDecl", NM="_ZNK5clang18FriendTemplateDecl13getFriendDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang18FriendTemplateDecl13getFriendDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getFriendDecl() /*const*/ {
    return Friend.dyn_cast(NamedDecl /*P*/.class);
  }

  
  /// \brief Retrieves the location of the 'friend' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::getFriendLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2197,
   FQN="clang::FriendTemplateDecl::getFriendLoc", NM="_ZNK5clang18FriendTemplateDecl12getFriendLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang18FriendTemplateDecl12getFriendLocEv")
  //</editor-fold>
  public SourceLocation getFriendLoc() /*const*/ {
    return new SourceLocation(FriendLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::getTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2201,
   FQN="clang::FriendTemplateDecl::getTemplateParameterList", NM="_ZNK5clang18FriendTemplateDecl24getTemplateParameterListEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang18FriendTemplateDecl24getTemplateParameterListEj")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameterList(/*uint*/int i) /*const*/ {
    assert ($lesseq_uint(i, NumParams));
    return Params.$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::getNumTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2206,
   FQN="clang::FriendTemplateDecl::getNumTemplateParameters", NM="_ZNK5clang18FriendTemplateDecl24getNumTemplateParametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang18FriendTemplateDecl24getNumTemplateParametersEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateParameters() /*const*/ {
    return NumParams;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2211,
   FQN="clang::FriendTemplateDecl::classof", NM="_ZN5clang18FriendTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2212,
   FQN="clang::FriendTemplateDecl::classofKind", NM="_ZN5clang18FriendTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Decl.Kind.FriendTemplate;
  }

  
  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::FriendTemplateDecl::~FriendTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 2144,
   FQN="clang::FriendTemplateDecl::~FriendTemplateDecl", NM="_ZN5clang18FriendTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang18FriendTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "NumParams=" + NumParams // NOI18N
              + ", Params=" + Params // NOI18N
              + ", Friend=" + Friend // NOI18N
              + ", FriendLoc=" + FriendLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
