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


/// \brief Represents a dependent using declaration which was not marked with
/// \c typename.
///
/// Unlike non-dependent using declarations, these *only* bring through
/// non-types; otherwise they would break two-phase lookup.
///
/// \code
/// template \<class T> class A : public Base<T> {
///   using Base<T>::foo;
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3185,
 FQN="clang::UnresolvedUsingValueDecl", NM="_ZN5clang24UnresolvedUsingValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDeclE")
//</editor-fold>
public class UnresolvedUsingValueDecl extends /*public*/ ValueDecl implements /*public*/ Mergeable<UnresolvedUsingValueDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2256,
   FQN="clang::UnresolvedUsingValueDecl::anchor", NM="_ZN5clang24UnresolvedUsingValueDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The source location of the 'using' keyword
  private SourceLocation UsingLocation;
  
  /// \brief The nested-name-specifier that precedes the name.
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  
  /// \brief Provides source/type location info for the declaration name
  /// embedded in the ValueDecl base class.
  /*friend*/public DeclarationNameLoc DNLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::UnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3199,
   FQN="clang::UnresolvedUsingValueDecl::UnresolvedUsingValueDecl", NM="_ZN5clang24UnresolvedUsingValueDeclC1EPNS_11DeclContextENS_8QualTypeENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDeclC1EPNS_11DeclContextENS_8QualTypeENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  private UnresolvedUsingValueDecl(DeclContext /*P*/ DC, QualType Ty, 
      SourceLocation UsingLoc, 
      NestedNameSpecifierLoc QualifierLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
    // : ValueDecl(UnresolvedUsingValue, DC, NameInfo.getLoc(), NameInfo.getName(), Ty), Mergeable<UnresolvedUsingValueDecl>(), UsingLocation(UsingLoc), QualifierLoc(QualifierLoc), DNLoc(NameInfo.getInfo()) 
    //START JInit
    super(Kind.UnresolvedUsingValue, DC, 
        NameInfo.getLoc(), NameInfo.getName(), new QualType(Ty));
    $Mergeable();
    this.UsingLocation = new SourceLocation(UsingLoc);
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.DNLoc = new DeclarationNameLoc(NameInfo.getInfo$Const());
    //END JInit
  }

/*public:*/
  /// \brief Returns the source location of the 'using' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getUsingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3211,
   FQN="clang::UnresolvedUsingValueDecl::getUsingLoc", NM="_ZNK5clang24UnresolvedUsingValueDecl11getUsingLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl11getUsingLocEv")
  //</editor-fold>
  public SourceLocation getUsingLoc() /*const*/ {
    return new SourceLocation(UsingLocation);
  }

  
  /// \brief Set the source location of the 'using' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::setUsingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3214,
   FQN="clang::UnresolvedUsingValueDecl::setUsingLoc", NM="_ZN5clang24UnresolvedUsingValueDecl11setUsingLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl11setUsingLocENS_14SourceLocationE")
  //</editor-fold>
  public void setUsingLoc(SourceLocation L) {
    UsingLocation.$assign(L);
  }

  
  /// \brief Return true if it is a C++03 access declaration (no 'using').
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::isAccessDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3217,
   FQN="clang::UnresolvedUsingValueDecl::isAccessDeclaration", NM="_ZNK5clang24UnresolvedUsingValueDecl19isAccessDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl19isAccessDeclarationEv")
  //</editor-fold>
  public boolean isAccessDeclaration() /*const*/ {
    return UsingLocation.isInvalid();
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name,
  /// with source-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3221,
   FQN="clang::UnresolvedUsingValueDecl::getQualifierLoc", NM="_ZNK5clang24UnresolvedUsingValueDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3224,
   FQN="clang::UnresolvedUsingValueDecl::getQualifier", NM="_ZNK5clang24UnresolvedUsingValueDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return QualifierLoc.getNestedNameSpecifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3228,
   FQN="clang::UnresolvedUsingValueDecl::getNameInfo", NM="_ZNK5clang24UnresolvedUsingValueDecl11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl11getNameInfoEv")
  //</editor-fold>
  public DeclarationNameInfo getNameInfo() /*const*/ {
    return new DeclarationNameInfo(getDeclName(), getLocation(), new DeclarationNameLoc(DNLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2258,
   FQN="clang::UnresolvedUsingValueDecl::Create", NM="_ZN5clang24UnresolvedUsingValueDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  public static UnresolvedUsingValueDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation UsingLoc, 
        NestedNameSpecifierLoc QualifierLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new UnresolvedUsingValueDecl(DC, C.DependentTy.$QualType(), new SourceLocation(UsingLoc), 
                new NestedNameSpecifierLoc(QualifierLoc), NameInfo);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2267,
   FQN="clang::UnresolvedUsingValueDecl::CreateDeserialized", NM="_ZN5clang24UnresolvedUsingValueDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static UnresolvedUsingValueDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new UnresolvedUsingValueDecl((DeclContext /*P*/ )null, new QualType(), 
                new SourceLocation(), 
                new NestedNameSpecifierLoc(), 
                new DeclarationNameInfo());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2275,
   FQN="clang::UnresolvedUsingValueDecl::getSourceRange", NM="_ZNK5clang24UnresolvedUsingValueDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation Begin = isAccessDeclaration() ? getQualifierLoc().getBeginLoc() : new SourceLocation(UsingLocation);
    return new SourceRange(/*NO_COPY*/Begin, getNameInfo().getEndLoc());
  }

  
  /// Retrieves the canonical declaration of this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3243,
   FQN="clang::UnresolvedUsingValueDecl::getCanonicalDecl", NM="_ZN5clang24UnresolvedUsingValueDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public UnresolvedUsingValueDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3246,
   FQN="clang::UnresolvedUsingValueDecl::getCanonicalDecl", NM="_ZNK5clang24UnresolvedUsingValueDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang24UnresolvedUsingValueDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ UnresolvedUsingValueDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3250,
   FQN="clang::UnresolvedUsingValueDecl::classof", NM="_ZN5clang24UnresolvedUsingValueDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3251,
   FQN="clang::UnresolvedUsingValueDecl::classofKind", NM="_ZN5clang24UnresolvedUsingValueDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.UnresolvedUsingValue;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingValueDecl::~UnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3185,
   FQN="clang::UnresolvedUsingValueDecl::~UnresolvedUsingValueDecl", NM="_ZN5clang24UnresolvedUsingValueDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang24UnresolvedUsingValueDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Mergeable.super.$destroy$Mergeable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //public final UnresolvedUsingValueDecl /*P*/ getFirstDecl() { return Mergeable.super.getFirstDecl$Mergeable(); }
  
  //public final /*const*/ UnresolvedUsingValueDecl /*P*/ getFirstDecl$Const() /*const*/ { return Mergeable.super.getFirstDecl$Mergeable$Const(); }
  
  public final boolean isFirstDecl() /*const*/ { return Mergeable.super.isFirstDecl$Mergeable(); }
  
  public final Class<? extends UnresolvedUsingValueDecl> getDeclType$Mergeable() { return this.getClass(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "UsingLocation=" + UsingLocation // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", DNLoc=" + DNLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
