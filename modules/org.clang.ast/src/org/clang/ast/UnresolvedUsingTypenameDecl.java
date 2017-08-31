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


/// \brief Represents a dependent using declaration which was marked with
/// \c typename.
///
/// \code
/// template \<class T> class A : public Base<T> {
///   using typename Base<T>::foo;
/// };
/// \endcode
///
/// The type associated with an unresolved using typename decl is
/// currently always a typename type.
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3268,
 FQN="clang::UnresolvedUsingTypenameDecl", NM="_ZN5clang27UnresolvedUsingTypenameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDeclE")
//</editor-fold>
public class UnresolvedUsingTypenameDecl extends /*public*/ TypeDecl implements /*public*/ Mergeable<UnresolvedUsingTypenameDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2281,
   FQN="clang::UnresolvedUsingTypenameDecl::anchor", NM="_ZN5clang27UnresolvedUsingTypenameDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The source location of the 'typename' keyword
  /*friend*/public SourceLocation TypenameLocation;
  
  /// \brief The nested-name-specifier that precedes the name.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::UnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3279,
   FQN="clang::UnresolvedUsingTypenameDecl::UnresolvedUsingTypenameDecl", NM="_ZN5clang27UnresolvedUsingTypenameDeclC1EPNS_11DeclContextENS_14SourceLocationES3_NS_22NestedNameSpecifierLocES3_PNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDeclC1EPNS_11DeclContextENS_14SourceLocationES3_NS_22NestedNameSpecifierLocES3_PNS_14IdentifierInfoE")
  //</editor-fold>
  private UnresolvedUsingTypenameDecl(DeclContext /*P*/ DC, SourceLocation UsingLoc, 
      SourceLocation TypenameLoc, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TargetNameLoc, 
      IdentifierInfo /*P*/ TargetName) {
    // : TypeDecl(UnresolvedUsingTypename, DC, TargetNameLoc, TargetName, UsingLoc), Mergeable<UnresolvedUsingTypenameDecl>(), TypenameLocation(TypenameLoc), QualifierLoc(QualifierLoc) 
    //START JInit
    super(Kind.UnresolvedUsingTypename, DC, new SourceLocation(TargetNameLoc), TargetName, 
        new SourceLocation(UsingLoc));
    $Mergeable();
    this.TypenameLocation = new SourceLocation(TypenameLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    //END JInit
  }

  
  /*friend  class ASTDeclReader*/
/*public:*/
  /// \brief Returns the source location of the 'using' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::getUsingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3292,
   FQN="clang::UnresolvedUsingTypenameDecl::getUsingLoc", NM="_ZNK5clang27UnresolvedUsingTypenameDecl11getUsingLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang27UnresolvedUsingTypenameDecl11getUsingLocEv")
  //</editor-fold>
  public SourceLocation getUsingLoc() /*const*/ {
    return getLocStart();
  }

  
  /// \brief Returns the source location of the 'typename' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::getTypenameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3295,
   FQN="clang::UnresolvedUsingTypenameDecl::getTypenameLoc", NM="_ZNK5clang27UnresolvedUsingTypenameDecl14getTypenameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang27UnresolvedUsingTypenameDecl14getTypenameLocEv")
  //</editor-fold>
  public SourceLocation getTypenameLoc() /*const*/ {
    return new SourceLocation(TypenameLocation);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name,
  /// with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3299,
   FQN="clang::UnresolvedUsingTypenameDecl::getQualifierLoc", NM="_ZNK5clang27UnresolvedUsingTypenameDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang27UnresolvedUsingTypenameDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3302,
   FQN="clang::UnresolvedUsingTypenameDecl::getQualifier", NM="_ZNK5clang27UnresolvedUsingTypenameDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang27UnresolvedUsingTypenameDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2283,
   FQN="clang::UnresolvedUsingTypenameDecl::Create", NM="_ZN5clang27UnresolvedUsingTypenameDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS_22NestedNameSpecifierLocES5_NS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS_22NestedNameSpecifierLocES5_NS_15DeclarationNameE")
  //</editor-fold>
  public static UnresolvedUsingTypenameDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation UsingLoc, 
        SourceLocation TypenameLoc, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TargetNameLoc, 
        DeclarationName TargetName) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new UnresolvedUsingTypenameDecl(DC, new SourceLocation(UsingLoc), new SourceLocation(TypenameLoc), new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TargetNameLoc), 
                TargetName.getAsIdentifierInfo());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2295,
   FQN="clang::UnresolvedUsingTypenameDecl::CreateDeserialized", NM="_ZN5clang27UnresolvedUsingTypenameDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static UnresolvedUsingTypenameDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new UnresolvedUsingTypenameDecl((DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), new NestedNameSpecifierLoc(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null);
     });
  }

  
  /// Retrieves the canonical declaration of this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3315,
   FQN="clang::UnresolvedUsingTypenameDecl::getCanonicalDecl", NM="_ZN5clang27UnresolvedUsingTypenameDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public UnresolvedUsingTypenameDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3318,
   FQN="clang::UnresolvedUsingTypenameDecl::getCanonicalDecl", NM="_ZNK5clang27UnresolvedUsingTypenameDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang27UnresolvedUsingTypenameDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ UnresolvedUsingTypenameDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3322,
   FQN="clang::UnresolvedUsingTypenameDecl::classof", NM="_ZN5clang27UnresolvedUsingTypenameDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3323,
   FQN="clang::UnresolvedUsingTypenameDecl::classofKind", NM="_ZN5clang27UnresolvedUsingTypenameDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.UnresolvedUsingTypename;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingTypenameDecl::~UnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3268,
   FQN="clang::UnresolvedUsingTypenameDecl::~UnresolvedUsingTypenameDecl", NM="_ZN5clang27UnresolvedUsingTypenameDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang27UnresolvedUsingTypenameDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Mergeable.super.$destroy$Mergeable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //public final UnresolvedUsingTypenameDecl /*P*/ getFirstDecl() { return Mergeable.super.getFirstDecl$Mergeable(); }
  
  //public final /*const*/ UnresolvedUsingTypenameDecl /*P*/ getFirstDecl$Const() /*const*/ { return Mergeable.super.getFirstDecl$Mergeable$Const(); }
  
  public final boolean isFirstDecl() /*const*/ { return Mergeable.super.isFirstDecl$Mergeable(); }
  
  public final Class<? extends UnresolvedUsingTypenameDecl> getDeclType$Mergeable() { return this.getClass(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "TypenameLocation=" + TypenameLocation // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
